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
import uy.com.sofka.retofinalserverside.dto.ClienteDTO;
import uy.com.sofka.retofinalserverside.services.IClienteService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/clientes")
public class ClienteController {
   
  @Autowired
  private IClienteService service;

  // ============ POST ===================
  @PostMapping("")
  public Mono<ClienteDTO> create(@RequestBody ClienteDTO cliente) {
    return service.save(cliente);
  }

  // ============ GET ===================
  @GetMapping("")
  public Flux<ClienteDTO> findAll() {
    return service.findAll();
  }
    
  @GetMapping("/{documento}")
  public Mono<ClienteDTO> findById(@PathVariable("documento") String documento) {
    return service.findById(documento);
  }
  
  // ============ PUT ===================
  @PutMapping("/{documento}")
  public Mono<ClienteDTO> update(@PathVariable("documento") String documento, @RequestBody ClienteDTO cliente) {
    return service.update(documento, cliente);
  }

  // ============ DELETE ===================
  @DeleteMapping("/{documento}")
  public Mono<Void> delete(@PathVariable("documento") String documento) {
    return service.delete(documento);
  }

  @DeleteMapping("")
  public Mono<Void> deleteAll() {
    return service.deleteAll();
  }
}
