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
@RequestMapping("/cliente")
public class ProveedorController {
  
  @Autowired
  private IProveedorService proveedor;

  // ============ POST ===================
  @PostMapping("")
  public Mono<ProveedorDTO> create(@RequestBody ProveedorDTO cliente) {
    return proveedor.save(cliente);
  }

  // ============ GET ===================
  @GetMapping("")
  public Flux<ProveedorDTO> findAll() {
    return proveedor.findAll();
  }
    
  @GetMapping("/{id}")
  public Mono<ProveedorDTO> findById(String id) {
    return proveedor.findById(id);
  }
  
  // ============ PUT ===================
  @PutMapping("/{id}")
  public Mono<ProveedorDTO> update(@PathVariable("id") String id, @RequestBody ProveedorDTO cliente) {
    return proveedor.update(id, cliente);
  }

  // ============ DELETE ===================
  @DeleteMapping("/{id}")
  public Mono<Void> delete(@PathVariable("id") String id) {
    return proveedor.delete(id);
  }

  @DeleteMapping("")
  public Mono<Void> deleteAll() {
    return proveedor.deleteAll();
  }
}
