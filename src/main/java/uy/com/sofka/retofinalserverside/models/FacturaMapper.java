package uy.com.sofka.retofinalserverside.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FacturaMapper {
  
  public Factura fromDTO(FacturaDTO dto) {
    Factura factura = new Factura();
    factura.setFecha(dto.getFecha());
    factura.setNombreCliente(dto.getNombreCliente());
    factura.setAtendedor(dto.getAtendedor());
    factura.setProductosComprados(dto.getProductosComprados());
    factura.setTotal(dto.getTotal());
    return factura;
  }

  public FacturaDTO fromCollection(Factura collection) {
      FacturaDTO facturaDTO = new FacturaDTO();
      facturaDTO.setConsecutivo(collection.getConsecutivo());
      facturaDTO.setFecha(collection.getFecha());
      facturaDTO.setNombreCliente(collection.getNombreCliente());
      facturaDTO.setAtendedor(collection.getAtendedor());
      facturaDTO.setProductosComprados(collection.getProductosComprados());
      facturaDTO.setTotal(collection.getTotal());
      return facturaDTO;
  }

  public List<FacturaDTO> fromCollectionList(List<Factura> collection) {
    if (collection == null) return null;
    
    List<FacturaDTO> list = new ArrayList<FacturaDTO>(collection.size());
    Iterator<Factura> listTracks = collection.iterator();

    while(listTracks.hasNext()) {
      Factura factura = (Factura)listTracks.next();
      list.add(fromCollection(factura));
    }

    return list;
  }
}
