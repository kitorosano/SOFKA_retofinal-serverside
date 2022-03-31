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
import uy.com.sofka.retofinalserverside.models.Producto.ProductoDTO;
import uy.com.sofka.retofinalserverside.services.IProductoService;

@RestController
@CrossOrigin("*")
@RequestMapping("/producto")
public class ProductoController {
  
  @Autowired
  private IProductoService service;

  // ============ POST ===================
  @PostMapping("")
  public Mono<ProductoDTO> create(@RequestBody ProductoDTO producto) {
    return service.save(producto);
  }

  // ============ GET ===================
  @GetMapping("")
  public Flux<ProductoDTO> findAll() {
    return service.findAll();
  }
    
  @GetMapping("/{id}")
  public Mono<ProductoDTO> findById(@PathVariable("id") String id) {
    return service.findById(id);
  }
  
  // ============ PUT ===================
  @PutMapping("/{id}")
  public Mono<ProductoDTO> update(@PathVariable("id") String id, @RequestBody ProductoDTO producto) {
    return service.update(id, producto);
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
