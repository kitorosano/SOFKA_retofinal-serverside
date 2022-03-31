package uy.com.sofka.retofinalserverside.models.Factura;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FacturaMapper {

  //  ======= DTO -> ENTITY ======== //
  public Factura fromDTO(FacturaDTO dto){
    Factura factura = new Factura();
    factura.setFecha(dto.getFecha());
    factura.setNombreCliente(dto.getNombreCliente());
    factura.setAtendedor(dto.getAtendedor());
    factura.setProductosComprados(dto.getProductosComprados());
    factura.setTotal(dto.getTotal());
    return factura;
  }

  public Factura fromDTO(FacturaDTO dto, Factura factura){
    factura.setFecha(dto.getFecha());
    factura.setNombreCliente(dto.getNombreCliente());
    factura.setAtendedor(dto.getAtendedor());
    factura.setProductosComprados(dto.getProductosComprados());
    factura.setTotal(dto.getTotal());
    return factura;
  }
  
  public Mono<Factura> fromDTOMono(Mono<FacturaDTO> dto) {
    return dto.map(facturaDTO -> {
      Factura factura = new Factura();
      factura.setFecha(facturaDTO.getFecha());
      factura.setNombreCliente(facturaDTO.getNombreCliente());
      factura.setAtendedor(facturaDTO.getAtendedor());
      factura.setProductosComprados(facturaDTO.getProductosComprados());
      factura.setTotal(facturaDTO.getTotal());
      return factura;
    });
  }

  public Mono<Factura> fromDTOMono(Mono<FacturaDTO> dto, Factura factura) {
    return dto.map(facturaDTO -> {
      factura.setFecha(facturaDTO.getFecha());
      factura.setNombreCliente(facturaDTO.getNombreCliente());
      factura.setAtendedor(facturaDTO.getAtendedor());
      factura.setProductosComprados(facturaDTO.getProductosComprados());
      factura.setTotal(facturaDTO.getTotal());
      return factura;
    });
  }

  //  ======= ENTITY -> DTO ======== //
  public FacturaDTO fromEntity(Factura entity){
    FacturaDTO facturaDTO = new FacturaDTO();
    facturaDTO.setConsecutivo(entity.getConsecutivo());
    facturaDTO.setFecha(entity.getFecha());
    facturaDTO.setNombreCliente(entity.getNombreCliente());
    facturaDTO.setAtendedor(entity.getAtendedor());
    facturaDTO.setProductosComprados(entity.getProductosComprados());
    facturaDTO.setTotal(entity.getTotal());
    return facturaDTO;
  }

  public Mono<FacturaDTO> fromEntityMono(Mono<Factura> entity) {
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

  public Flux<FacturaDTO> fromEntityFlux(Flux<Factura> entity) {   
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
}
