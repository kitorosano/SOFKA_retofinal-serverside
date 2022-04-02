package uy.com.sofka.retofinalserverside.mappers;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.retofinalserverside.dto.ProductoDTO;
import uy.com.sofka.retofinalserverside.models.Producto;

public class ProductoMapper {

  //  ======= DTO -> ENTITY ======== //
  public Producto fromDTO2Entity(ProductoDTO dto) {
    Producto producto = new Producto();
    producto.setId(dto.getId());
    producto.setNombre(dto.getNombre());
    producto.setDescripcion(dto.getDescripcion());
    producto.setCategoria(dto.getCategoria());
    producto.setStock(dto.getStock());
    producto.setMinStock(dto.getMinStock());
    producto.setMaxStock(dto.getMaxStock());
    producto.setPrecio(dto.getPrecio());
    return producto;
  }

  public Producto fromDTO2Entity(ProductoDTO dto, Producto producto) {
    producto.setId(dto.getId());
    producto.setNombre(dto.getNombre());
    producto.setDescripcion(dto.getDescripcion());
    producto.setCategoria(dto.getCategoria());
    producto.setStock(dto.getStock());
    producto.setMinStock(dto.getMinStock());
    producto.setMaxStock(dto.getMaxStock());
    producto.setPrecio(dto.getPrecio());
    return producto;
  }

  public Mono<Producto> fromMonoDTO2MonoEntity(Mono<ProductoDTO> dto) {
    return dto.map(productoDTO -> {
      Producto producto = new Producto();
      producto.setId(productoDTO.getId());
      producto.setNombre(productoDTO.getNombre());
      producto.setDescripcion(productoDTO.getDescripcion());
      producto.setCategoria(productoDTO.getCategoria());
      producto.setStock(productoDTO.getStock());
      producto.setMinStock(productoDTO.getMinStock());
      producto.setMaxStock(productoDTO.getMaxStock());
      producto.setPrecio(productoDTO.getPrecio());
      return producto;
    });
  }

  public Mono<Producto> fromMonoDTO2MonoEntity(Mono<ProductoDTO> dto, Producto producto) {
    return dto.map(productoDTO -> {
      producto.setId(productoDTO.getId());
      producto.setNombre(productoDTO.getNombre());
      producto.setDescripcion(productoDTO.getDescripcion());
      producto.setCategoria(productoDTO.getCategoria());
      producto.setStock(productoDTO.getStock());
      producto.setMinStock(productoDTO.getMinStock());
      producto.setMaxStock(productoDTO.getMaxStock());
      producto.setPrecio(productoDTO.getPrecio());
      return producto;
    });
  }

  //  ======= ENTITY -> DTO ======== //
  public ProductoDTO fromEntity2DTO(Producto entity) {
    ProductoDTO productoDTO = new ProductoDTO();
    productoDTO.setId(entity.getId());
    productoDTO.setNombre(entity.getNombre());
    productoDTO.setDescripcion(entity.getDescripcion());
    productoDTO.setCategoria(entity.getCategoria());
    productoDTO.setStock(entity.getStock());
    productoDTO.setMinStock(entity.getMinStock());
    productoDTO.setMaxStock(entity.getMaxStock());
    productoDTO.setPrecio(entity.getPrecio());
    return productoDTO;
  }

  public Mono<ProductoDTO> fromMonoEntity2MonoDTO(Mono<Producto> entity) {
    return entity.map(producto -> {
      ProductoDTO dto = new ProductoDTO();
      dto.setId(producto.getId());
      dto.setNombre(producto.getNombre());
      dto.setDescripcion(producto.getDescripcion());
      dto.setCategoria(producto.getCategoria());
      dto.setStock(producto.getStock());
      dto.setMinStock(producto.getMinStock());
      dto.setMaxStock(producto.getMaxStock());
      dto.setPrecio(producto.getPrecio());
      return dto;
    });
  }

  public Flux<ProductoDTO> fromFluxEntity2FluxDTO(Flux<Producto> entity) { 
    return entity.map(producto -> {
      ProductoDTO dto = new ProductoDTO();
      dto.setId(producto.getId());
      dto.setNombre(producto.getNombre());
      dto.setDescripcion(producto.getDescripcion());
      dto.setCategoria(producto.getCategoria());
      dto.setStock(producto.getStock());
      dto.setMinStock(producto.getMinStock());
      dto.setMaxStock(producto.getMaxStock());
      dto.setPrecio(producto.getPrecio());
      return dto;
    });
  }

}
