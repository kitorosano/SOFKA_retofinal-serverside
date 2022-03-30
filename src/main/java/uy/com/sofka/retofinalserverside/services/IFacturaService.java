package uy.com.sofka.retofinalserverside.services;

import reactor.core.publisher.Mono;
import uy.com.sofka.retofinalserverside.models.FacturaDTO;

public interface IFacturaService {

  Mono<FacturaDTO> save(FacturaDTO facturaDTO);
  Long generateSequence(String seqName);
}
