package ar.com.ada.api.billeteravirtual.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ada.api.billeteravirtual.entities.Persona;

/**
 * PersonaRepository
 */
public interface PersonaRepository extends JpaRepository<Persona , Integer> {
    
    Persona findByNombre(String nombre);

    Persona findByDni(String dni);

}