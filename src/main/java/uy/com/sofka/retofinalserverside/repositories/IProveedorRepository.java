package uy.com.sofka.retofinalserverside.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import uy.com.sofka.retofinalserverside.models.Proveedor.Proveedor;

public interface IProveedorRepository extends ReactiveMongoRepository<Proveedor, String> {

}