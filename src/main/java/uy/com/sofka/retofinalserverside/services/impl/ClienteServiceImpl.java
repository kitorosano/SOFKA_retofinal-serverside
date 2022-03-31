package uy.com.sofka.retofinalserverside.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.retofinalserverside.models.Cliente.Cliente;
import uy.com.sofka.retofinalserverside.models.Cliente.ClienteDTO;
import uy.com.sofka.retofinalserverside.models.Cliente.ClienteMapper;
import uy.com.sofka.retofinalserverside.repositories.IClienteRepository;
import uy.com.sofka.retofinalserverside.services.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService {

  @Autowired
  private IClienteRepository repository;
  
  ClienteMapper mapper = new ClienteMapper();
  
  @Override
  public Mono<ClienteDTO> save(ClienteDTO clienteDTO) {
    Mono<Cliente> cliente = repository.save(mapper.fromDTO(clienteDTO));
    return Mono.just(mapper.fromCollection(cliente.block()));
  }

  @Override
  public Mono<ClienteDTO> findById(String id) {
    Mono<Cliente> cliente = repository.findById(id);
    return Mono.just(mapper.fromCollection(cliente.block()));
  }

  @Override
  public Flux<ClienteDTO> findAll() {
    Flux<Cliente> clientes = repository.findAll();
    return Flux.fromIterable(mapper.fromCollectionList(clientes.collectList().block()));
  }

  @Override
  public Mono<ClienteDTO> update(String id, ClienteDTO clienteDTO) {
    Mono<Cliente> cliente = repository.findById(id)
                                        .flatMap(p -> {
                                          p.setNombre(clienteDTO.getNombre());
                                          p.setCelular(clienteDTO.getCelular());
                                          return repository.save(p);
                                        });
    return Mono.just(mapper.fromCollection(cliente.block()));
  }

  @Override
  public Mono<Void> delete(String id) {
    return repository.deleteById(id);
  }

  @Override
  public Mono<Void> deleteAll() {
    return repository.deleteAll();
  }
}
