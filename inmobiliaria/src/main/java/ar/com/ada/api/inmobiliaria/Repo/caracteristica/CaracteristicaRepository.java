package ar.com.ada.api.inmobiliaria.Repo.caracteristica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.inmobiliaria.entities.caracteristica.Caracteristica;

/**
 * CaracteristicaRepository
 */
@Repository
public interface CaracteristicaRepository extends JpaRepository<Caracteristica,Integer>{

    
}