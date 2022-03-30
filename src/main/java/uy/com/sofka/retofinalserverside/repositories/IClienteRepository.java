package uy.com.sofka.retofinalserverside.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import uy.com.sofka.retofinalserverside.models.Cliente;

@Repository
public interface IClienteRepository extends ReactiveMongoRepository<Cliente, String> {

}