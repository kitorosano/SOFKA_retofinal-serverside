package uy.com.sofka.retofinalserverside.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.retofinalserverside.models.Producto.Producto;
import uy.com.sofka.retofinalserverside.models.Producto.ProductoDTO;
import uy.com.sofka.retofinalserverside.models.Producto.ProductoMapper;
import uy.com.sofka.retofinalserverside.repositories.IProductoRepository;
import uy.com.sofka.retofinalserverside.services.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService {

  @Autowired
  private IProductoRepository repository;
  
  ProductoMapper mapper = new ProductoMapper();
  
  @Override
  public Mono<ProductoDTO> save(ProductoDTO productoDTO) {
    Mono<Producto> producto = repository.save(mapper.fromDTO(productoDTO));
    return Mono.just(mapper.fromCollection(producto.block()));
  }

  @Override
  public Mono<ProductoDTO> findById(String id) {
    Mono<Producto> producto = repository.findById(id);
    return Mono.just(mapper.fromCollection(producto.block()));
  }

  @Override
  public Flux<ProductoDTO> findAll() {
    Flux<Producto> productos = repository.findAll();
    return Flux.fromIterable(mapper.fromCollectionList(productos.collectList().block()));
  }

  @Override
  public Mono<ProductoDTO> update(String id, ProductoDTO productoDTO) {
    Mono<Producto> producto = repository.findById(id)
                                        .flatMap(p -> {
                                          p.setNombre(productoDTO.getNombre());
                                          p.setDescripcion(productoDTO.getDescripcion());
                                          p.setCategoria(productoDTO.getCategoria());
                                          p.setStock(productoDTO.getStock());
                                          p.setMinStock(productoDTO.getMinStock());
                                          p.setMaxStock(productoDTO.getMaxStock());
                                          p.setPrecio(productoDTO.getPrecio());
                                          return repository.save(p);
                                        });
    return Mono.just(mapper.fromCollection(producto.block()));
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
