package uy.com.sofka.retofinalserverside.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import uy.com.sofka.retofinalserverside.models.Producto;


@Repository
public interface IProductoRepository extends ReactiveMongoRepository<Producto, String> {

}