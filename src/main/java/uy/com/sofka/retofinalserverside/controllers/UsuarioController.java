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
import uy.com.sofka.retofinalserverside.dto.UsuarioDTO;
import uy.com.sofka.retofinalserverside.services.IUsuarioService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/usuarios")
public class UsuarioController {
   
  @Autowired
  private IUsuarioService service;

  // ============ POST ===================
  @PostMapping("")
  public Mono<UsuarioDTO> create(@RequestBody UsuarioDTO usuario) {
    return service.save(usuario);
  }

  // ============ GET ===================
  @GetMapping("")
  public Flux<UsuarioDTO> findAll() {
    return service.findAll();
  }
    
  @GetMapping("/{uid}")
  public Mono<UsuarioDTO> findById(@PathVariable("uid") String uid) {
    return service.findById(uid);
  }
  
  // ============ PUT ===================
  @PutMapping("/{uid}")
  public Mono<UsuarioDTO> update(@PathVariable("uid") String uid, @RequestBody UsuarioDTO usuario) {
    return service.update(uid, usuario);
  }

  // ============ DELETE ===================
  @DeleteMapping("/{uid}")
  public Mono<Void> delete(@PathVariable("uid") String uid) {
    return service.delete(uid);
  }

  @DeleteMapping("")
  public Mono<Void> deleteAll() {
    return service.deleteAll();
  }
}
