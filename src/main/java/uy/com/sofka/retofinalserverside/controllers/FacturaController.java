package uy.com.sofka.retofinalserverside.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.retofinalserverside.dto.FacturaDTO;
import uy.com.sofka.retofinalserverside.services.IFacturaService;

@RestController
@CrossOrigin("*")
@RequestMapping("/factura")
public class FacturaController {
  
  @Autowired
  private IFacturaService service;

  // ============ POST ===================
  @PostMapping("")
  public Mono<FacturaDTO> create(@RequestBody FacturaDTO factura) {
    return service.save(factura);
  }

  // ============ GET ===================
  @GetMapping("")
  public Flux<FacturaDTO> findAll() {
    return service.findAll();
  }
    
  @GetMapping("/{id}")
  public Mono<FacturaDTO> findById(@PathVariable("id") Long id) {
    return service.findById(id);
  }
  
  // ============ PUT ===================
  @PutMapping("/{id}")
  public Mono<FacturaDTO> update(@PathVariable("id") Long id, @RequestBody FacturaDTO factura) {
    return service.update(id, factura);
  }

  // ============ DELETE ===================
  @DeleteMapping("/{id}")
  public Mono<Void> delete(@PathVariable("id") Long id) {
    return service.delete(id);
  }

  @DeleteMapping("")
  public Mono<Void> deleteAll() {
    return service.deleteAll();
  }
}
