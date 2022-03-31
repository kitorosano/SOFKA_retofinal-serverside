package uy.com.sofka.retofinalserverside.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.retofinalserverside.models.Cliente.ClienteDTO;

public interface IClienteService {
  Mono<ClienteDTO> save(ClienteDTO clienteDTO);
  Mono<ClienteDTO> findById(String id);
  Flux<ClienteDTO> findAll();
  Mono<ClienteDTO> update(String id, ClienteDTO clienteDTO);
  Mono<Void> delete(String id);
  Mono<Void> deleteAll();
}
