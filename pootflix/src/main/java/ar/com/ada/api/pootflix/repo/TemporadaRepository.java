package ar.com.ada.api.pootflix.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.pootflix.entities.Temporada;

/**
 * TemporadaRepository
 */
@Repository
public interface TemporadaRepository extends MongoRepository<Temporada , Integer> {

    
    Temporada findBy_id(ObjectId _id);

    Temporada findByNumeroTemporada(int numeroTemporada);
    
}