package uy.com.sofka.retofinalserverside.services.impl;


import static org.springframework.data.mongodb.core.query.Query.query;
import java.util.Objects;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;
import uy.com.sofka.retofinalserverside.models.DatabaseSequence;
import uy.com.sofka.retofinalserverside.models.Factura;
import uy.com.sofka.retofinalserverside.models.FacturaDTO;
import uy.com.sofka.retofinalserverside.models.FacturaMapper;
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
  public Mono<FacturaDTO> save(FacturaDTO productoDTO) {
    Mono<Factura> producto = repository.save(mapper.fromDTO(productoDTO));
    return Mono.just(mapper.fromCollection(producto.block()));
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
}