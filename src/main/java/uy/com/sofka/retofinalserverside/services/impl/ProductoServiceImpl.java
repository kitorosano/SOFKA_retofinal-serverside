package uy.com.sofka.retofinalserverside.services.impl;

import static org.springframework.data.mongodb.core.query.Query.query;
import java.util.Objects;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;
import uy.com.sofka.retofinalserverside.models.DatabaseSequence;
import uy.com.sofka.retofinalserverside.models.Producto;
import uy.com.sofka.retofinalserverside.models.ProductoDTO;
import uy.com.sofka.retofinalserverside.models.ProductoMapper;
import uy.com.sofka.retofinalserverside.repositories.IProductoRepository;
import uy.com.sofka.retofinalserverside.services.IProductoService;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
public class ProductoServiceImpl implements IProductoService {

  @Autowired
  private IProductoRepository repository;
  
  @Autowired
  private ProductoMapper mapper;

  @Autowired
  private MongoOperations mongoOperations;

  public Long generateSequence(String seqName) {
    DatabaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
            new Update().inc("seq",1), options().returnNew(true).upsert(true),
            DatabaseSequence.class);
    return !Objects.isNull(counter) ? counter.getSeq() : 1;
  }
}
