package uy.com.sofka.retofinalserverside.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;
import uy.com.sofka.retofinalserverside.models.ProductoDTO;
import uy.com.sofka.retofinalserverside.services.IProductoService;

@RestController
@CrossOrigin("*")
@RequestMapping("/producto")
public class ProductoController {
  
  @Autowired
  private IProductoService service;

  @PostMapping("")
  public Mono<ProductoDTO> create(@RequestBody ProductoDTO producto) {
    return service.save(producto);
  }
}
