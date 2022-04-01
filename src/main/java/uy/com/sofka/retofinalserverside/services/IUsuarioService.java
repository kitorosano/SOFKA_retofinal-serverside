package uy.com.sofka.retofinalserverside.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.retofinalserverside.dto.UsuarioDTO;

public interface IUsuarioService {
  Mono<UsuarioDTO> save(UsuarioDTO usuarioDTO);
  Mono<UsuarioDTO> findByDocumento(String uid);
  Flux<UsuarioDTO> findAll();
  Mono<UsuarioDTO> update(String uid, UsuarioDTO usuarioDTO);
  Mono<Void> delete(String uid);
  Mono<Void> deleteAll();
}
