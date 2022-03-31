package uy.com.sofka.retofinalserverside.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.retofinalserverside.models.Factura.FacturaDTO;

public interface IFacturaService {
  Mono<FacturaDTO> save(FacturaDTO facturaDTO);
  Mono<FacturaDTO> findById(Long id);
  Flux<FacturaDTO> findAll();
  Mono<FacturaDTO> update(Long id, FacturaDTO facturaDTO);
  Mono<Void> delete(Long id);
  Mono<Void> deleteAll();
  Long generateSequence(String seqName);
}
