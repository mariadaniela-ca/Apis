package ar.com.ada.api.inmobiliaria.repositorys.inmueble;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.inmobiliaria.entities.inmueble.Inmueble;

/**
 * InmuebleRepository
 */
@Repository
public interface InmuebleRepository extends JpaRepository < Inmueble , Integer> {

    @Query ("FROM Inmueble WHERE estado = ?1")
    List <Inmueble> findByEstado (String estado);
    
}