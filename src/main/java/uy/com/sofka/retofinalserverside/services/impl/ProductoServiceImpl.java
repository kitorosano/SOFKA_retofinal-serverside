package uy.com.sofka.retofinalserverside.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.retofinalserverside.dto.ProductoDTO;
import uy.com.sofka.retofinalserverside.mappers.ProductoMapper;
import uy.com.sofka.retofinalserverside.repositories.IProductoRepository;
import uy.com.sofka.retofinalserverside.services.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService {

  @Autowired
  private IProductoRepository repository;
  
  ProductoMapper mapper = new ProductoMapper();
  
  @Override
  public Mono<ProductoDTO> save(ProductoDTO productoDTO) {
    return mapper.fromMonoEntity2MonoDTO(repository.save(
                                  mapper.fromDTO2Entity(productoDTO))
                                );
  } // DTO -> ENTITY -> SAVE -> MONO<ENTITY> -> MONO<DTO> -> RETURN

  @Override
  public Mono<ProductoDTO> findById(String id) {
    return mapper.fromMonoEntity2MonoDTO(repository.findById(id));
  }

  @Override
  public Flux<ProductoDTO> findAll() {
    return mapper.fromFluxEntity2FluxDTO(repository.findAll()
                                          .buffer(100)
                                          .flatMap(producto -> 
                                            Flux.fromStream(producto.parallelStream())
                                          ));
  }

  @Override
  public Mono<ProductoDTO> update(String id, ProductoDTO productoDTO) {
    return mapper.fromMonoEntity2MonoDTO(repository.findById(id)
                                          .flatMap(producto -> 
                                            repository.save(mapper.fromDTO2Entity(productoDTO, producto))
                                          ));
  }

  @Override
  public Mono<Void> delete(String id) {
    return repository.deleteById(id);
  }

  @Override
  public Mono<Void> deleteAll() {
    return repository.deleteAll();
  }
}
