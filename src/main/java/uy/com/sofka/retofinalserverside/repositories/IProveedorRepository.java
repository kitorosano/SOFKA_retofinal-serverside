package uy.com.sofka.retofinalserverside.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import uy.com.sofka.retofinalserverside.models.Proveedor;

@Repository
public interface IProveedorRepository extends ReactiveMongoRepository<Proveedor, String> {

}