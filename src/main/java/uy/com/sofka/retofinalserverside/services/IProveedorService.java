package uy.com.sofka.retofinalserverside.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.retofinalserverside.models.Proveedor.ProveedorDTO;

public interface IProveedorService {
  Mono<ProveedorDTO> save(ProveedorDTO proveedorDTO);
  Mono<ProveedorDTO> findById(String id);
  Flux<ProveedorDTO> findAll();
  Mono<ProveedorDTO> update(String id, ProveedorDTO proveedorDTO);
  Mono<Void> delete(String id);
  Mono<Void> deleteAll();
}
