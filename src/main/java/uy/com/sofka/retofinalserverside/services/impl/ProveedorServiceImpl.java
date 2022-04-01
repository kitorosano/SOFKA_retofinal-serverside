package uy.com.sofka.retofinalserverside.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.retofinalserverside.dto.ProveedorDTO;
import uy.com.sofka.retofinalserverside.mappers.ProveedorMapper;
import uy.com.sofka.retofinalserverside.repositories.IProveedorRepository;
import uy.com.sofka.retofinalserverside.services.IProveedorService;

@Service
public class ProveedorServiceImpl implements IProveedorService {

  @Autowired
  private IProveedorRepository repository;
  
  ProveedorMapper mapper = new ProveedorMapper();
  
  @Override
  public Mono<ProveedorDTO> save(ProveedorDTO proveedorDTO) {
    return mapper.fromMonoEntity2MonoDTO(repository.save(
                                  mapper.fromDTO2Entity(proveedorDTO))
                                );
  } // DTO -> ENTITY -> SAVE -> MONO<ENTITY> -> MONO<DTO> -> RETURN

  @Override
  public Mono<ProveedorDTO> findById(String documento) {
    return mapper.fromMonoEntity2MonoDTO(repository.findById(documento));
  }

  @Override
  public Flux<ProveedorDTO> findAll() {
    return mapper.fromFluxEntity2FluxDTO(repository.findAll()
                                          .buffer(100)
                                          .flatMap(proveedor -> 
                                            Flux.fromStream(proveedor.parallelStream())
                                          ));
  }

  @Override
  public Mono<ProveedorDTO> update(String documento, ProveedorDTO proveedorDTO) {
    return mapper.fromMonoEntity2MonoDTO(repository.findById(documento)
                                          .flatMap(proveedor -> 
                                            repository.save(mapper.fromDTO2Entity(proveedorDTO, proveedor))
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
