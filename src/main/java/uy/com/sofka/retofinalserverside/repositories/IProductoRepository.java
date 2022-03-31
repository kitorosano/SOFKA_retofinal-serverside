package uy.com.sofka.retofinalserverside.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import uy.com.sofka.retofinalserverside.models.Producto;

public interface IProductoRepository extends ReactiveMongoRepository<Producto, String> {

}