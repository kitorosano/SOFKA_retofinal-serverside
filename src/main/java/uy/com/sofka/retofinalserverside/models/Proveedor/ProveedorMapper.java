package uy.com.sofka.retofinalserverside.models.Proveedor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProveedorMapper {
  
  public Proveedor fromDTO(ProveedorDTO dto) {
    Proveedor proveedor = new Proveedor();
    proveedor.setNombre(dto.getNombre());
    proveedor.setCelular(dto.getCelular());
    return proveedor;
  }

  public ProveedorDTO fromCollection(Proveedor collection) {
      ProveedorDTO proveedorDTO = new ProveedorDTO();
      proveedorDTO.setCodigo(collection.getCodigo());
      proveedorDTO.setNombre(collection.getNombre());
      proveedorDTO.setCelular(collection.getCelular());
      return proveedorDTO;
  }

  public List<ProveedorDTO> fromCollectionList(List<Proveedor> collection) {
    if (collection == null) return null;
    
    List<ProveedorDTO> list = new ArrayList<ProveedorDTO>(collection.size());
    Iterator<Proveedor> listTracks = collection.iterator();

    while(listTracks.hasNext()) {
      Proveedor proveedor = (Proveedor)listTracks.next();
      list.add(fromCollection(proveedor));
    }

    return list;
  }
}
