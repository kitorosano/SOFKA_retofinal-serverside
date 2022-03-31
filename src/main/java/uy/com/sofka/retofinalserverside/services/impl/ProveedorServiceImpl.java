package uy.com.sofka.retofinalserverside.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.retofinalserverside.models.Proveedor.Proveedor;
import uy.com.sofka.retofinalserverside.models.Proveedor.ProveedorDTO;
import uy.com.sofka.retofinalserverside.models.Proveedor.ProveedorMapper;
import uy.com.sofka.retofinalserverside.repositories.IProveedorRepository;
import uy.com.sofka.retofinalserverside.services.IProveedorService;

@Service
public class ProveedorServiceImpl implements IProveedorService {

  @Autowired
  private IProveedorRepository repository;
  
  ProveedorMapper mapper = new ProveedorMapper();
  
  @Override
  public Mono<ProveedorDTO> save(ProveedorDTO proveedorDTO) {
    Mono<Proveedor> proveedor = repository.save(mapper.fromDTO(proveedorDTO));
    return Mono.just(mapper.fromCollection(proveedor.block()));
  }

  @Override
  public Mono<ProveedorDTO> findById(String id) {
    Mono<Proveedor> proveedor = repository.findById(id);
    return Mono.just(mapper.fromCollection(proveedor.block()));
  }

  @Override
  public Flux<ProveedorDTO> findAll() {
    Flux<Proveedor> proveedors = repository.findAll();
    return Flux.fromIterable(mapper.fromCollectionList(proveedors.collectList().block()));
  }

  @Override
  public Mono<ProveedorDTO> update(String id, ProveedorDTO proveedorDTO) {
    Mono<Proveedor> proveedor = repository.findById(id)
                                        .flatMap(p -> {
                                          p.setNombre(proveedorDTO.getNombre());
                                          p.setCelular(proveedorDTO.getCelular());
                                          return repository.save(p);
                                        });
    return Mono.just(mapper.fromCollection(proveedor.block()));
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
