package uy.com.sofka.retofinalserverside.models.Producto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
      Producto factura = (Producto)listTracks.next();
      list.add(fromCollection(factura));
    }

    return list;
  }

  public Map<Producto,Integer> fromDTOMap(Map<ProductoDTO,Integer> dto) {
    if (dto == null) return null;
    
    Map<Producto,Integer> map = new HashMap<Producto,Integer>(dto.size());

    dto.forEach((producto, cantidad) -> map.put(fromDTO(producto), cantidad));

    return map;
  }

  public Map<ProductoDTO, Integer> fromCollectionMap(Map<Producto, Integer> collection) {
    if (collection == null) return null;

    Map<ProductoDTO,Integer> map = new HashMap<ProductoDTO,Integer>(collection.size());

    collection.forEach((producto, cantidad) -> map.put(fromCollection(producto), cantidad));

    return map;
  }

}
