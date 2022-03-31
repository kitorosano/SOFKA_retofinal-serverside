package uy.com.sofka.retofinalserverside.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import uy.com.sofka.retofinalserverside.models.Cliente.Cliente;

public interface IClienteRepository extends ReactiveMongoRepository<Cliente, String> {

}