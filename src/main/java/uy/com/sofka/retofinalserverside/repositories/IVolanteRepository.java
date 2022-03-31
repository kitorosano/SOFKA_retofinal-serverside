package uy.com.sofka.retofinalserverside.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import uy.com.sofka.retofinalserverside.models.Volante.Volante;

public interface IVolanteRepository extends ReactiveMongoRepository<Volante, Long> {

}