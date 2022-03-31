package uy.com.sofka.retofinalserverside.models.Volante;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VolanteMapper {
  
  public Volante fromDTO(VolanteDTO dto) {
    Volante volante = new Volante();
    volante.setNombreProveedor(dto.getNombreProveedor());
    volante.setProductosIngresar(dto.getProductosIngresar());
    volante.setFecha(dto.getFecha());
    volante.setDocumentoProveedor(dto.getDocumentoProveedor());
    return volante;
  }

  public VolanteDTO fromCollection(Volante collection) {
      VolanteDTO volanteDTO = new VolanteDTO();
      volanteDTO.setNroVolante(collection.getNroVolante());
      volanteDTO.setNombreProveedor(collection.getNombreProveedor());
      volanteDTO.setProductosIngresar(collection.getProductosIngresar());
      volanteDTO.setFecha(collection.getFecha());
      volanteDTO.setDocumentoProveedor(collection.getDocumentoProveedor());
      return volanteDTO;
  }

  public List<VolanteDTO> fromCollectionList(List<Volante> collection) {
    if (collection == null) return null;
    
    List<VolanteDTO> list = new ArrayList<VolanteDTO>(collection.size());
    Iterator<Volante> listTracks = collection.iterator();

    while(listTracks.hasNext()) {
      Volante volante = (Volante)listTracks.next();
      list.add(fromCollection(volante));
    }

    return list;
  }
}
