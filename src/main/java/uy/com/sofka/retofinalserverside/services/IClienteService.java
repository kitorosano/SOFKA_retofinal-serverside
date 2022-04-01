package uy.com.sofka.retofinalserverside.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.retofinalserverside.dto.ClienteDTO;

public interface IClienteService {
  Mono<ClienteDTO> save(ClienteDTO clienteDTO);
  Mono<ClienteDTO> findById(String documento);
  Flux<ClienteDTO> findAll();
  Mono<ClienteDTO> update(String documento, ClienteDTO clienteDTO);
  Mono<Void> delete(String documento);
  Mono<Void> deleteAll();
}
