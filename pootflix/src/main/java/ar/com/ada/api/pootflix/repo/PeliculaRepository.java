package ar.com.ada.api.pootflix.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.pootflix.entities.Pelicula;

/**
 * PeliculaRepository
 */
@Repository
public interface PeliculaRepository extends MongoRepository<Pelicula, Integer>{

    Pelicula findByTitulo(String titulo);

    Pelicula findByGenero(String genero);

    
}