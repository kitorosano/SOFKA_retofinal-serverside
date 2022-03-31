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
import uy.com.sofka.retofinalserverside.models.Factura.Factura;
import uy.com.sofka.retofinalserverside.models.Factura.FacturaDTO;
import uy.com.sofka.retofinalserverside.models.Factura.FacturaMapper;
import uy.com.sofka.retofinalserverside.repositories.IFacturaRepository;
import uy.com.sofka.retofinalserverside.services.IFacturaService;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
public class FacturaServiceImpl implements IFacturaService {

  @Autowired
  private IFacturaRepository repository;
  
  @Autowired
  private MongoOperations mongoOperations;

  FacturaMapper mapper = new FacturaMapper();
  
  @Override
  public Mono<FacturaDTO> save(FacturaDTO facturaDTO) {
    Mono<Factura> factura = repository.save(mapper.fromDTO(facturaDTO));
    return Mono.just(mapper.fromCollection(factura.block()));
  }

  public Long generateSequence(String seqName) {
    DatabaseSequence counter = mongoOperations
                              .findAndModify(
                                query(where("_id").is(seqName)),
                                new Update().inc("seq",1), options().returnNew(true).upsert(true),
                                DatabaseSequence.class)
                              ;
    return !Objects.isNull(counter) ? counter.getSeq() : 1;
  }

  @Override
  public Mono<FacturaDTO> findById(Long id) {
    Mono<Factura> factura = repository.findById(id);
    return Mono.just(mapper.fromCollection(factura.block()));
  }

  @Override
  public Flux<FacturaDTO> findAll() {
    Flux<Factura> facturas = repository.findAll();
    return Flux.fromIterable(mapper.fromCollectionList(facturas.collectList().block()));
  }

  @Override
  public Mono<FacturaDTO> update(Long id, FacturaDTO facturaDTO) {
    Mono<Factura> factura = repository.findById(id)
                                        .flatMap(p -> {
                                          p.setFecha(facturaDTO.getFecha());
                                          p.setNombreCliente(facturaDTO.getNombreCliente());
                                          p.setAtendedor(facturaDTO.getAtendedor());
                                          p.setProductosComprados(facturaDTO.getProductosComprados());
                                          p.setTotal(facturaDTO.getTotal());
                                          return repository.save(p);
                                        });
    return Mono.just(mapper.fromCollection(factura.block()));
  }

  @Override
  public Mono<Void> delete(Long id) {
    return repository.deleteById(id);
  }

  @Override
  public Mono<Void> deleteAll() {
    return repository.deleteAll();
  }
}