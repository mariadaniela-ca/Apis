package ar.com.ada.api.inmobiliaria.Repo.amenitie;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ada.api.inmobiliaria.entities.amenitie.Amenitie;

/**
 * AmenitieRepository
 */
public interface AmenitieRepository extends JpaRepository<Amenitie , Integer>{

    
}