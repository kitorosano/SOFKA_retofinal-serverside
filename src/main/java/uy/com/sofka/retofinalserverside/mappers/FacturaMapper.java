package uy.com.sofka.retofinalserverside.mappers;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.retofinalserverside.dto.FacturaDTO;
import uy.com.sofka.retofinalserverside.models.Factura;

public class FacturaMapper {

  //  ======= DTO -> ENTITY ======== //
  public Factura fromDTO2Entity(FacturaDTO dto){
    Factura factura = new Factura();
    factura.setConsecutivo(dto.getConsecutivo());    
    factura.setFecha(dto.getFecha());
    factura.setNombreCliente(dto.getNombreCliente());
    factura.setAtendedor(dto.getAtendedor());
    factura.setProductosComprados(dto.getProductosComprados());
    factura.setTotal(dto.getTotal());
    return factura;
  }

  public Factura fromDTO2Entity(FacturaDTO dto, Factura factura){
    factura.setConsecutivo(dto.getConsecutivo());    
    factura.setFecha(dto.getFecha());
    factura.setNombreCliente(dto.getNombreCliente());
    factura.setAtendedor(dto.getAtendedor());
    factura.setProductosComprados(dto.getProductosComprados());
    factura.setTotal(dto.getTotal());
    return factura;
  }
  
  public Mono<Factura> fromMonoDTO2MonoEntity(Mono<FacturaDTO> dto) {
    return dto.map(facturaDTO -> {
      Factura factura = new Factura();
      factura.setConsecutivo(facturaDTO.getConsecutivo());    
      factura.setFecha(facturaDTO.getFecha());
      factura.setNombreCliente(facturaDTO.getNombreCliente());
      factura.setAtendedor(facturaDTO.getAtendedor());
      factura.setProductosComprados(facturaDTO.getProductosComprados());
      factura.setTotal(facturaDTO.getTotal());
      return factura;
    });
  }

  public Mono<Factura> fromMonoDTO2MonoEntity(Mono<FacturaDTO> dto, Factura factura) {
    return dto.map(facturaDTO -> {
      factura.setConsecutivo(facturaDTO.getConsecutivo());      
      factura.setFecha(facturaDTO.getFecha());
      factura.setNombreCliente(facturaDTO.getNombreCliente());
      factura.setAtendedor(facturaDTO.getAtendedor());
      factura.setProductosComprados(facturaDTO.getProductosComprados());
      factura.setTotal(facturaDTO.getTotal());
      return factura;
    });
  }

  //  ======= ENTITY -> DTO ======== //
  public FacturaDTO fromEntity2DTO(Factura entity){
    FacturaDTO facturaDTO = new FacturaDTO();
    facturaDTO.setConsecutivo(entity.getConsecutivo());
    facturaDTO.setFecha(entity.getFecha());
    facturaDTO.setNombreCliente(entity.getNombreCliente());
    facturaDTO.setAtendedor(entity.getAtendedor());
    facturaDTO.setProductosComprados(entity.getProductosComprados());
    facturaDTO.setTotal(entity.getTotal());
    return facturaDTO;
  }

  public Mono<FacturaDTO> fromMonoEntity2MonoDTO(Mono<Factura> entity) {
    return entity.map(factura -> {
      FacturaDTO dto = new FacturaDTO();
      dto.setConsecutivo(factura.getConsecutivo());
      dto.setFecha(factura.getFecha());
      dto.setNombreCliente(factura.getNombreCliente());
      dto.setAtendedor(factura.getAtendedor());
      dto.setProductosComprados(factura.getProductosComprados());
      dto.setTotal(factura.getTotal());
      return dto;
    });
  }

  public Flux<FacturaDTO> fromFluxEntity2FluxDTO(Flux<Factura> entity) {   
    return entity.map(factura -> {
      FacturaDTO dto = new FacturaDTO();
      dto.setConsecutivo(factura.getConsecutivo());
      System.out.println(factura.getFecha());
      dto.setFecha(factura.getFecha());
      dto.setNombreCliente(factura.getNombreCliente());
      dto.setAtendedor(factura.getAtendedor());
      dto.setProductosComprados(factura.getProductosComprados());
      dto.setTotal(factura.getTotal());
      return dto;
    });
  }
}
