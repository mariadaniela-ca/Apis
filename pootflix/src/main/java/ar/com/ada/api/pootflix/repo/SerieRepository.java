package ar.com.ada.api.pootflix.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.pootflix.entities.Serie;

/**
 * SerieRepository
 */
@Repository
public interface SerieRepository extends MongoRepository<Serie,Integer>{

    Serie findBy_id(ObjectId _id);

    Serie findByTitulo(String titulo);

    Serie findByGenero(String genero);

}