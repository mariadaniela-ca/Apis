package ar.com.ada.api.simulacrochallenge.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.simulacrochallenge.entities.Categoria;

/**
 * CategoriaRepository
 */
@Repository
public interface CategoriaRepository extends JpaRepository <Categoria, Integer> {

    Categoria findByNombre(String nombre);
    
}