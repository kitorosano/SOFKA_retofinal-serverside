package uy.com.sofka.retofinalserverside.mappers;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.retofinalserverside.dto.VolanteDTO;
import uy.com.sofka.retofinalserverside.models.Volante;

public class VolanteMapper {

  //  ======= DTO -> ENTITY ======== //
  public Volante fromDTO2Entity(VolanteDTO dto) {
    Volante volante = new Volante();
    volante.setNroVolante(dto.getNroVolante());
    volante.setNombreProveedor(dto.getNombreProveedor());
    volante.setProductosIngresar(dto.getProductosIngresar());
    volante.setFecha(dto.getFecha());
    volante.setDocumentoProveedor(dto.getDocumentoProveedor());
    return volante;
  }

  public Volante fromDTO2Entity(VolanteDTO dto, Volante volante) {
    volante.setNroVolante(dto.getNroVolante());
    volante.setNombreProveedor(dto.getNombreProveedor());
    volante.setProductosIngresar(dto.getProductosIngresar());
    volante.setFecha(dto.getFecha());
    volante.setDocumentoProveedor(dto.getDocumentoProveedor());
    return volante;
  }

  public Mono<Volante> fromMonoDTO2MonoEntity(Mono<VolanteDTO> dto) {
    return dto.map(volanteDTO -> {
      Volante volante = new Volante();
      volante.setNroVolante(volanteDTO.getNroVolante());
      volante.setNombreProveedor(volanteDTO.getNombreProveedor());
      volante.setProductosIngresar(volanteDTO.getProductosIngresar());
      volante.setFecha(volanteDTO.getFecha());
      volante.setDocumentoProveedor(volanteDTO.getDocumentoProveedor());
      return volante;
    });
  }

  public Mono<Volante> fromMonoDTO2MonoEntity(Mono<VolanteDTO> dto, Volante volante) {
    return dto.map(volanteDTO -> {
      volante.setNroVolante(volanteDTO.getNroVolante());
      volante.setNombreProveedor(volanteDTO.getNombreProveedor());
      volante.setProductosIngresar(volanteDTO.getProductosIngresar());
      volante.setFecha(volanteDTO.getFecha());
      volante.setDocumentoProveedor(volanteDTO.getDocumentoProveedor());
      return volante;
    });
  }

  //  ======= ENTITY -> DTO ======== //
  public VolanteDTO fromEntity2DTO(Volante entity) {
    VolanteDTO volanteDTO = new VolanteDTO();
    volanteDTO.setNroVolante(entity.getNroVolante());
    volanteDTO.setNombreProveedor(entity.getNombreProveedor());
    volanteDTO.setProductosIngresar(entity.getProductosIngresar());
    volanteDTO.setFecha(entity.getFecha());
    volanteDTO.setDocumentoProveedor(entity.getDocumentoProveedor());
    return volanteDTO;
  }

  public Mono<VolanteDTO> fromMonoEntity2MonoDTO(Mono<Volante> entity) {
    return entity.map(volante -> {
      VolanteDTO dto = new VolanteDTO();
      dto.setNroVolante(volante.getNroVolante());
      dto.setNombreProveedor(volante.getNombreProveedor());
      dto.setProductosIngresar(volante.getProductosIngresar());
      dto.setFecha(volante.getFecha());
      dto.setDocumentoProveedor(volante.getDocumentoProveedor());
      return dto;
    });
  }

  public Flux<VolanteDTO> fromFluxEntity2FluxDTO(Flux<Volante> entity) {   
    return entity.map(volante -> {
      VolanteDTO dto = new VolanteDTO();
      dto.setNroVolante(volante.getNroVolante());
      dto.setNombreProveedor(volante.getNombreProveedor());
      dto.setProductosIngresar(volante.getProductosIngresar());
      dto.setFecha(volante.getFecha());
      dto.setDocumentoProveedor(volante.getDocumentoProveedor());
      return dto;
    });
  }

}
