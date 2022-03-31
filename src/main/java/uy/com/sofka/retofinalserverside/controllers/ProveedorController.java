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
import uy.com.sofka.retofinalserverside.models.Proveedor.ProveedorDTO;
import uy.com.sofka.retofinalserverside.services.IProveedorService;

@RestController
@CrossOrigin("*")
@RequestMapping("/proveedor")
public class ProveedorController {
  
  @Autowired
  private IProveedorService service;

  // ============ POST ===================
  @PostMapping("")
  public Mono<ProveedorDTO> create(@RequestBody ProveedorDTO proveedor) {
    return service.save(proveedor);
  }

  // ============ GET ===================
  @GetMapping("")
  public Flux<ProveedorDTO> findAll() {
    return service.findAll();
  }
    
  @GetMapping("/{id}")
  public Mono<ProveedorDTO> findById(@PathVariable("id") String id) {
    return service.findById(id);
  }
  
  // ============ PUT ===================
  @PutMapping("/{id}")
  public Mono<ProveedorDTO> update(@PathVariable("id") String id, @RequestBody ProveedorDTO proveedor) {
    return service.update(id, proveedor);
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
