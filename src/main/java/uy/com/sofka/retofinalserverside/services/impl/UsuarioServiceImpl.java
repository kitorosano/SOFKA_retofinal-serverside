package uy.com.sofka.retofinalserverside.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.retofinalserverside.dto.UsuarioDTO;
import uy.com.sofka.retofinalserverside.mappers.UsuarioMapper;
import uy.com.sofka.retofinalserverside.repositories.IUsuarioRepository;
import uy.com.sofka.retofinalserverside.services.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

  @Autowired
  private IUsuarioRepository repository;
  
  UsuarioMapper mapper = new UsuarioMapper();
  
  @Override
  public Mono<UsuarioDTO> save(UsuarioDTO usuarioDTO) {
    return mapper.fromMonoEntity2MonoDTO(repository.save(
                                  mapper.fromDTO2Entity(usuarioDTO))
                                );
  } // DTO -> ENTITY -> SAVE -> MONO<ENTITY> -> MONO<DTO> -> RETURN

  @Override
  public Mono<UsuarioDTO> findByDocumento(String uid) {
    return mapper.fromMonoEntity2MonoDTO(repository.findById(uid));
  }

  @Override
  public Flux<UsuarioDTO> findAll() {
    return mapper.fromFluxEntity2FluxDTO(repository.findAll()
                                          .buffer(100)
                                          .flatMap(usuario -> 
                                            Flux.fromStream(usuario.parallelStream())
                                          ));
  }

  @Override
  public Mono<UsuarioDTO> update(String uid, UsuarioDTO usuarioDTO) {
    return mapper.fromMonoEntity2MonoDTO(repository.findById(uid)
                                          .flatMap(usuario -> 
                                            repository.save(mapper.fromDTO2Entity(usuarioDTO, usuario))
                                          ));
  }

  @Override
  public Mono<Void> delete(String uid) {
    return repository.deleteById(uid);
  }

  @Override
  public Mono<Void> deleteAll() {
    return repository.deleteAll();
  }
}
