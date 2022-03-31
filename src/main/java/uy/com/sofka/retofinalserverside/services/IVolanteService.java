package uy.com.sofka.retofinalserverside.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.retofinalserverside.dto.VolanteDTO;

public interface IVolanteService {
  Mono<VolanteDTO> save(VolanteDTO volanteDTO);
  Mono<VolanteDTO> findById(Long id);
  Flux<VolanteDTO> findAll();
  Mono<VolanteDTO> update(Long id, VolanteDTO volanteDTO);
  Mono<Void> delete(Long id);
  Mono<Void> deleteAll();
  Long generateSequence(String seqName);
}
