package uy.com.sofka.retofinalserverside.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import uy.com.sofka.retofinalserverside.models.Factura;

public interface IFacturaRepository extends ReactiveMongoRepository<Factura, Long> {

}