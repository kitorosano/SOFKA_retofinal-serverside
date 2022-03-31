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
import uy.com.sofka.retofinalserverside.models.Cliente.ClienteDTO;
import uy.com.sofka.retofinalserverside.services.IClienteService;

@RestController
@CrossOrigin("*")
@RequestMapping("/cliente")
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
    
  @GetMapping("/{id}")
  public Mono<ClienteDTO> findById(@PathVariable("id") String id) {
    return service.findById(id);
  }
  
  // ============ PUT ===================
  @PutMapping("/{id}")
  public Mono<ClienteDTO> update(@PathVariable("id") String id, @RequestBody ClienteDTO cliente) {
    return service.update(id, cliente);
  }

  // ============ DELETE ===================
  @DeleteMapping("/{id}")
  public Mono<Void> delete(@PathVariable("id") String id) {
    return service.delete(id);
  }

  @DeleteMapping("")
  public Mono<Void> deleteAll() {
    return service.deleteAll();
  }
}
