package uy.com.sofka.retofinalserverside.services.impl;

import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.query.Query.query;
import java.util.Objects;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.retofinalserverside.dto.VolanteDTO;
import uy.com.sofka.retofinalserverside.mappers.VolanteMapper;
import uy.com.sofka.retofinalserverside.models.DatabaseSequence;
import uy.com.sofka.retofinalserverside.repositories.IVolanteRepository;
import uy.com.sofka.retofinalserverside.services.IVolanteService;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
public class VolanteServiceImpl implements IVolanteService {

  @Autowired
  private IVolanteRepository repository;
  
  @Autowired
  private MongoOperations mongoOperations;

  VolanteMapper mapper = new VolanteMapper();
  
  @Override
  public Mono<VolanteDTO> save(VolanteDTO volanteDTO) {
    return mapper.fromMonoEntity2MonoDTO(repository.save(
                                  mapper.fromDTO2Entity(volanteDTO))
                                );
  } // DTO -> ENTITY -> SAVE -> MONO<ENTITY> -> MONO<DTO> -> RETURN

  @Override
  public Mono<VolanteDTO> findById(Long id) {
    return mapper.fromMonoEntity2MonoDTO(repository.findById(id));
  }

  @Override
  public Flux<VolanteDTO> findAll() {
    return mapper.fromFluxEntity2FluxDTO(repository.findAll()
                                          .buffer(100)
                                          .flatMap(volante -> 
                                            Flux.fromStream(volante.parallelStream())
                                          ));
  }

  @Override
  public Mono<VolanteDTO> update(Long id, VolanteDTO volanteDTO) {
    return mapper.fromMonoEntity2MonoDTO(repository.findById(id)
                                          .flatMap(volante -> 
                                            repository.save(mapper.fromDTO2Entity(volanteDTO, volante))
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
  public Long generateSequence(String seqName) {
    DatabaseSequence counter = mongoOperations
                              .findAndModify(
                                query(where("_id").is(seqName)),
                                new Update().inc("volanteSeq",1), options().returnNew(true).upsert(true),
                                DatabaseSequence.class)
                              ;
    return !Objects.isNull(counter) ? counter.getVolanteSeq() : 1;
  }
}
