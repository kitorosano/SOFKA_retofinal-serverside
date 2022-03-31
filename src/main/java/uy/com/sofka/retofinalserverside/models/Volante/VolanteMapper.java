package uy.com.sofka.retofinalserverside.models.Volante;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VolanteMapper {
  
  public Volante fromDTO(VolanteDTO dto) {
    Volante factura = new Volante();
    factura.setNombreProveedor(dto.getNombreProveedor());
    factura.setProductosIngresar(dto.getProductosIngresar());
    factura.setFecha(dto.getFecha());
    factura.setDocumentoProveedor(dto.getDocumentoProveedor());
    return factura;
  }

  public VolanteDTO fromCollection(Volante collection) {
      VolanteDTO facturaDTO = new VolanteDTO();
      facturaDTO.setNroVolante(collection.getNroVolante());
      facturaDTO.setNombreProveedor(collection.getNombreProveedor());
      facturaDTO.setProductosIngresar(collection.getProductosIngresar());
      facturaDTO.setFecha(collection.getFecha());
      facturaDTO.setDocumentoProveedor(collection.getDocumentoProveedor());
      return facturaDTO;
  }

  public List<VolanteDTO> fromCollectionList(List<Volante> collection) {
    if (collection == null) return null;
    
    List<VolanteDTO> list = new ArrayList<VolanteDTO>(collection.size());
    Iterator<Volante> listTracks = collection.iterator();

    while(listTracks.hasNext()) {
      Volante factura = (Volante)listTracks.next();
      list.add(fromCollection(factura));
    }

    return list;
  }
}
