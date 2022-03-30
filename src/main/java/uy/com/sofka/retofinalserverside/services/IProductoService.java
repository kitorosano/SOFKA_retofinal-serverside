package uy.com.sofka.retofinalserverside.services;

import reactor.core.publisher.Mono;
import uy.com.sofka.retofinalserverside.models.ProductoDTO;

public interface IProductoService {

  Mono<ProductoDTO> save(ProductoDTO productoDTO);
}