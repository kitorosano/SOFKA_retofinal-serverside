package uy.com.sofka.retofinalserverside.services.impl;


import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.retofinalserverside.models.DatabaseSequence;
import uy.com.sofka.retofinalserverside.models.Factura.FacturaDTO;
import uy.com.sofka.retofinalserverside.models.Factura.FacturaMapper;
import uy.com.sofka.retofinalserverside.repositories.IFacturaRepository;
import uy.com.sofka.retofinalserverside.services.IFacturaService;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
public class FacturaServiceImpl implements IFacturaService {

  @Autowired
  private IFacturaRepository repository;

  FacturaMapper mapper = new FacturaMapper();
  
  @Override
  public Mono<FacturaDTO> save(FacturaDTO facturaDTO) {
    return mapper.fromEntityMono(repository.save(
                                  mapper.fromDTO(facturaDTO))
                                );
  } // DTO -> ENTITY -> SAVE -> MONO<ENTITY> -> MONO<DTO> -> RETURN

  @Override
  public Mono<FacturaDTO> findById(Long id) {
    return mapper.fromEntityMono(repository.findById(id));
  }

  @Override
  public Flux<FacturaDTO> findAll() {
    return mapper.fromEntityFlux(repository.findAll()
                                          .buffer(100)
                                          .flatMap(factura -> 
                                            Flux.fromStream(factura.parallelStream())
                                          ));
  }

  @Override
  public Mono<FacturaDTO> update(Long id, FacturaDTO facturaDTO) {
    return mapper.fromEntityMono(repository.findById(id)
                                          .flatMap(factura -> 
                                            repository.save(mapper.fromDTO(facturaDTO, factura))
                                          ));
  }

  @Override
  public Mono<Void> delete(Long id) {
    return repository.deleteById(id);
  }

  @Override
  public Mono<Void> deleteAll() {
    return repository.deleteAll();
  }

  // AUTO GENERATE ID
  
  @Autowired
  private MongoOperations mongoOperations;

  public Long generateSequence(String seqName) {
    DatabaseSequence counter = mongoOperations
                              .findAndModify(
                                query(where("_id").is(seqName)),
                                new Update().inc("facturaSeq",1), options().returnNew(true).upsert(true),
                                DatabaseSequence.class)
                              ;
    return !Objects.isNull(counter) ? counter.getFacturaSeq() : 1;
  }
}