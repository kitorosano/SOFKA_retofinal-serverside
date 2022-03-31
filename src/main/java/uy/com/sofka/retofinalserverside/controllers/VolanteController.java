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
import uy.com.sofka.retofinalserverside.dto.VolanteDTO;
import uy.com.sofka.retofinalserverside.services.IVolanteService;

@RestController
@CrossOrigin("*")
@RequestMapping("/volante")
public class VolanteController {
  
  @Autowired
  private IVolanteService service;

  // ============ POST ===================
  @PostMapping("")
  public Mono<VolanteDTO> create(@RequestBody VolanteDTO volante) {
    return service.save(volante);
  }

  // ============ GET ===================
  @GetMapping("")
  public Flux<VolanteDTO> findAll() {
    return service.findAll();
  }
    
  @GetMapping("/{id}")
  public Mono<VolanteDTO> findById(@PathVariable("id") Long id) {
    return service.findById(id);
  }
  
  // ============ PUT ===================
  @PutMapping("/{id}")
  public Mono<VolanteDTO> update(@PathVariable("id") Long id, @RequestBody VolanteDTO volante) {
    return service.update(id, volante);
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
