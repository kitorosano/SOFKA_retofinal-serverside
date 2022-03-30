package uy.com.sofka.retofinalserverside.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import uy.com.sofka.retofinalserverside.models.Factura;

@Repository
public interface IFacturaRepository extends ReactiveMongoRepository<Factura, Long> {

}