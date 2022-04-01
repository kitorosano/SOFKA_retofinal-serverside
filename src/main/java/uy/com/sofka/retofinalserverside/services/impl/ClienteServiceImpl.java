package uy.com.sofka.retofinalserverside.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.retofinalserverside.dto.ClienteDTO;
import uy.com.sofka.retofinalserverside.mappers.ClienteMapper;
import uy.com.sofka.retofinalserverside.repositories.IClienteRepository;
import uy.com.sofka.retofinalserverside.services.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService {

  @Autowired
  private IClienteRepository repository;
  
  ClienteMapper mapper = new ClienteMapper();
  
  @Override
  public Mono<ClienteDTO> save(ClienteDTO clienteDTO) {
    return mapper.fromMonoEntity2MonoDTO(repository.save(
                                  mapper.fromDTO2Entity(clienteDTO))
                                );
  } // DTO -> ENTITY -> SAVE -> MONO<ENTITY> -> MONO<DTO> -> RETURN

  @Override
  public Mono<ClienteDTO> findById(String documento) {
    return mapper.fromMonoEntity2MonoDTO(repository.findById(documento));
  }

  @Override
  public Flux<ClienteDTO> findAll() {
    return mapper.fromFluxEntity2FluxDTO(repository.findAll()
                                          .buffer(100)
                                          .flatMap(cliente -> 
                                            Flux.fromStream(cliente.parallelStream())
                                          ));
  }

  @Override
  public Mono<ClienteDTO> update(String documento, ClienteDTO clienteDTO) {
    return mapper.fromMonoEntity2MonoDTO(repository.findById(documento)
                                          .flatMap(cliente -> 
                                            repository.save(mapper.fromDTO2Entity(clienteDTO, cliente))
                                          ));
  }

  @Override
  public Mono<Void> delete(String documento) {
    return repository.deleteById(documento);
  }

  @Override
  public Mono<Void> deleteAll() {
    return repository.deleteAll();
  }
}
