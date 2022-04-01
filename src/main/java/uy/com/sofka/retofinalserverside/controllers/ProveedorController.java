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
import uy.com.sofka.retofinalserverside.dto.ProveedorDTO;
import uy.com.sofka.retofinalserverside.services.IProveedorService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/proveedores")
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
    
  @GetMapping("/{documento}")
  public Mono<ProveedorDTO> findById(@PathVariable("documento") String documento) {
    return service.findById(documento);
  }
  
  // ============ PUT ===================
  @PutMapping("/{documento}")
  public Mono<ProveedorDTO> update(@PathVariable("documento") String documento, @RequestBody ProveedorDTO proveedor) {
    return service.update(documento, proveedor);
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
