package uy.com.sofka.retofinalserverside.mappers;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;
import uy.com.sofka.retofinalserverside.dto.UsuarioDTO;
import uy.com.sofka.retofinalserverside.models.Usuario;

public class UsuarioMapper {
  
  public Usuario fromDTO(UsuarioDTO dto) {
    Usuario usuario = new Usuario();
    usuario.setUid(dto.getUid());
    usuario.setEmail(dto.getEmail());
    usuario.setUsername(dto.getUsername());
    return usuario;
  }

  //  ======= DTO -> ENTITY ======== //
  public Usuario fromDTO2Entity(UsuarioDTO dto) {
    Usuario usuario = new Usuario();
    usuario.setUid(dto.getUid());
    usuario.setEmail(dto.getEmail());
    usuario.setUsername(dto.getUsername());
    return usuario;
  }

  public Usuario fromDTO2Entity(UsuarioDTO dto, Usuario usuario) {
    usuario.setUid(dto.getUid());
    usuario.setEmail(dto.getEmail());
    usuario.setUsername(dto.getUsername());
    return usuario;
  }

  public Mono<Usuario> fromMonoDTO2MonoEntity(Mono<UsuarioDTO> dto) {
    return dto.map(usuarioDTO -> {
      Usuario usuario = new Usuario();
      usuario.setUid(usuarioDTO.getUid());
      usuario.setEmail(usuarioDTO.getEmail());
      usuario.setUsername(usuarioDTO.getUsername());
      return usuario;
    });
  }

  public Mono<Usuario> fromMonoDTO2MonoEntity(Mono<UsuarioDTO> dto, Usuario usuario) {
    return dto.map(usuarioDTO -> {
      usuario.setUid(usuarioDTO.getUid());
      usuario.setEmail(usuarioDTO.getEmail());
      usuario.setUsername(usuarioDTO.getUsername());
      return usuario;
    });
  }

  //  ======= ENTITY -> DTO ======== //
  public UsuarioDTO fromEntity2DTO(Usuario entity) {
    UsuarioDTO usuarioDTO = new UsuarioDTO();
    usuarioDTO.setUid(entity.getUid());
    usuarioDTO.setEmail(entity.getEmail());
    usuarioDTO.setUsername(entity.getUsername());
    return usuarioDTO;
  }

  public Mono<UsuarioDTO> fromMonoEntity2MonoDTO(Mono<Usuario> entity) {
    return entity.map(usuario -> {
      UsuarioDTO dto = new UsuarioDTO();
      dto.setUid(usuario.getUid());
      dto.setEmail(usuario.getEmail());
      dto.setUsername(usuario.getUsername());
      return dto;
    });
  }

  public Flux<UsuarioDTO> fromFluxEntity2FluxDTO(Flux<Usuario> entity) {   
    return entity.map(usuario -> {
      UsuarioDTO dto = new UsuarioDTO();
      dto.setUid(usuario.getUid());
      dto.setEmail(usuario.getEmail());
      dto.setUsername(usuario.getUsername());
      return dto;
    });
  }
}
