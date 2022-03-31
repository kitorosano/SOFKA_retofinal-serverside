package uy.com.sofka.retofinalserverside.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.retofinalserverside.dto.ProveedorDTO;

public interface IProveedorService {
  Mono<ProveedorDTO> save(ProveedorDTO proveedorDTO);
  Mono<ProveedorDTO> findByDocumento(String documento);
  Flux<ProveedorDTO> findAll();
  Mono<ProveedorDTO> update(String documento, ProveedorDTO proveedorDTO);
  Mono<Void> delete(String documento);
  Mono<Void> deleteAll();
}
