package uy.com.sofka.retofinalserverside.models.Producto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductoMapper {

  public Producto fromDTO(ProductoDTO dto) {
      Producto producto = new Producto();
      producto.setNombre(dto.getNombre());
      producto.setDescripcion(dto.getDescripcion());
      producto.setCategoria(dto.getCategoria());
      producto.setStock(dto.getStock());
      producto.setMinStock(dto.getMinStock());
      producto.setMaxStock(dto.getMaxStock());
      producto.setPrecio(dto.getPrecio());
      return producto;
  }

  public ProductoDTO fromCollection(Producto collection) {
      ProductoDTO productoDTO = new ProductoDTO();
      productoDTO.setId(collection.getId());
      productoDTO.setNombre(collection.getNombre());
      productoDTO.setDescripcion(collection.getDescripcion());
      productoDTO.setCategoria(collection.getCategoria());
      productoDTO.setStock(collection.getStock());
      productoDTO.setMinStock(collection.getMinStock());
      productoDTO.setMaxStock(collection.getMaxStock());
      productoDTO.setPrecio(collection.getPrecio());
      return productoDTO;
  }

  public List<ProductoDTO> fromCollectionList(List<Producto> collection) {
      if (collection == null) return null;
      
      List<ProductoDTO> list = new ArrayList<ProductoDTO>(collection.size());
      Iterator<Producto> listTracks = collection.iterator();

      while(listTracks.hasNext()) {
        Producto producto = (Producto)listTracks.next();
        list.add(fromCollection(producto));
      }

      return list;
  }
}
