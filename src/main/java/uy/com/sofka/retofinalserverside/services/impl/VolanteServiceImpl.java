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
import uy.com.sofka.retofinalserverside.models.DatabaseSequence;
import uy.com.sofka.retofinalserverside.models.Volante.Volante;
import uy.com.sofka.retofinalserverside.models.Volante.VolanteDTO;
import uy.com.sofka.retofinalserverside.models.Volante.VolanteMapper;
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
    Mono<Volante> volante = repository.save(mapper.fromDTO(volanteDTO));
    return Mono.just(mapper.fromCollection(volante.block()));
  }

  public Long generateSequence(String seqName) {
    DatabaseSequence counter = mongoOperations
                              .findAndModify(
                                query(where("_id").is(seqName)),
                                new Update().inc("seq",1), options().returnNew(true).upsert(true),
                                DatabaseSequence.class)
                              ;
    return !Objects.isNull(counter) ? counter.getFacturaSeq() : 1;
  }

  @Override
  public Mono<VolanteDTO> findById(Long id) {
    Mono<Volante> volante = repository.findById(id);
    return Mono.just(mapper.fromCollection(volante.block()));
  }

  @Override
  public Flux<VolanteDTO> findAll() {
    Flux<Volante> volantes = repository.findAll();
    return Flux.fromIterable(mapper.fromCollectionList(volantes.collectList().block()));
  }

  @Override
  public Mono<VolanteDTO> update(Long id, VolanteDTO volanteDTO) {
    Mono<Volante> volante = repository.findById(id)
                                        .flatMap(p -> {
                                          p.setNombreProveedor(volanteDTO.getNombreProveedor());
                                          p.setProductosIngresar(volanteDTO.getProductosIngresar());
                                          p.setFecha(volanteDTO.getFecha());
                                          p.setDocumentoProveedor(volanteDTO.getDocumentoProveedor());
                                          return repository.save(p);
                                        });
    return Mono.just(mapper.fromCollection(volante.block()));
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
