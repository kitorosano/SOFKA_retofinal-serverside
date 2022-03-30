package uy.com.sofka.retofinalserverside.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import uy.com.sofka.retofinalserverside.models.Volante;

@Repository
public interface IVolanteRepository extends ReactiveMongoRepository<Volante, Long> {

}