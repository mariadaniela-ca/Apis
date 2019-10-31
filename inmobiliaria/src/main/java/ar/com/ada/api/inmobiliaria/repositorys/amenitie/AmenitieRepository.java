package ar.com.ada.api.inmobiliaria.repositorys.amenitie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.inmobiliaria.entities.amenitie.AmenitieDeInmueble;

/**
 * AmenitieRepository
 */
@Repository
public interface AmenitieRepository extends JpaRepository<AmenitieDeInmueble , Integer>{

    
}