package uy.com.sofka.retofinalserverside.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;
import uy.com.sofka.retofinalserverside.models.Producto;
import uy.com.sofka.retofinalserverside.models.ProductoDTO;
import uy.com.sofka.retofinalserverside.models.ProductoMapper;
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
}
