package uy.com.sofka.retofinalserverside.mappers;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import uy.com.sofka.retofinalserverside.dto.ProveedorDTO;
import uy.com.sofka.retofinalserverside.models.Proveedor;

public class ProveedorMapper {
  
  //  ======= DTO -> ENTITY ======== //
  public Proveedor fromDTO2Entity(ProveedorDTO dto) {
    Proveedor proveedor = new Proveedor();
    proveedor.setDocumento(dto.getDocumento());
    proveedor.setNombre(dto.getNombre());
    proveedor.setCelular(dto.getCelular());
    return proveedor;
  }

  public Proveedor fromDTO2Entity(ProveedorDTO dto, Proveedor proveedor) {
    proveedor.setDocumento(dto.getDocumento());
    proveedor.setNombre(dto.getNombre());
    proveedor.setCelular(dto.getCelular());
    return proveedor;
  }

  public Mono<Proveedor> fromMonoDTO2MonoEntity(Mono<ProveedorDTO> dto) {
    return dto.map(proveedorDTO -> {
      Proveedor proveedor = new Proveedor();
      proveedor.setDocumento(proveedorDTO.getDocumento());
      proveedor.setNombre(proveedorDTO.getNombre());
      proveedor.setCelular(proveedorDTO.getCelular());
      return proveedor;
    });
  }

  public Mono<Proveedor> fromMonoDTO2MonoEntity(Mono<ProveedorDTO> dto, Proveedor proveedor) {
    return dto.map(proveedorDTO -> {
      proveedor.setDocumento(proveedorDTO.getDocumento());
      proveedor.setNombre(proveedorDTO.getNombre());
      proveedor.setCelular(proveedorDTO.getCelular());
      return proveedor;
    });
  }

  //  ======= ENTITY -> DTO ======== //
  public ProveedorDTO fromEntity2DTO(Proveedor entity) {
    ProveedorDTO proveedorDTO = new ProveedorDTO();
    proveedorDTO.setDocumento(entity.getDocumento());
    proveedorDTO.setNombre(entity.getNombre());
    proveedorDTO.setCelular(entity.getCelular());
    return proveedorDTO;
  }

  public Mono<ProveedorDTO> fromMonoEntity2MonoDTO(Mono<Proveedor> entity) {
    return entity.map(proveedor -> {
      ProveedorDTO dto = new ProveedorDTO();
      dto.setDocumento(proveedor.getDocumento());
      dto.setNombre(proveedor.getNombre());
      dto.setCelular(proveedor.getCelular());
      return dto;
    });
  }

  public Flux<ProveedorDTO> fromFluxEntity2FluxDTO(Flux<Proveedor> entity) {   
    return entity.map(proveedor -> {
      ProveedorDTO dto = new ProveedorDTO();
      dto.setDocumento(proveedor.getDocumento());
      dto.setNombre(proveedor.getNombre());
      dto.setCelular(proveedor.getCelular());
      return dto;
    });
  }

}
