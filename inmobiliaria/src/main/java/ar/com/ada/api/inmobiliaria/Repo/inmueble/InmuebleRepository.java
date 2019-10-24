package ar.com.ada.api.inmobiliaria.Repo.inmueble;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.inmobiliaria.entities.inmueble.Inmueble;

/**
 * InmuebleRepository
 */
@Repository
public interface InmuebleRepository extends JpaRepository < Inmueble , Integer> {

    
}