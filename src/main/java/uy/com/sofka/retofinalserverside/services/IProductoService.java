package uy.com.sofka.retofinalserverside.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.retofinalserverside.models.Producto.ProductoDTO;

public interface IProductoService {

  Mono<ProductoDTO> save(ProductoDTO productoDTO);
  Mono<ProductoDTO> findById(String id);
  Flux<ProductoDTO> findAll();
  Mono<ProductoDTO> update(String id, ProductoDTO productoDTO);
  Mono<Void> delete(String id);
  Mono<Void> deleteAll();
}
