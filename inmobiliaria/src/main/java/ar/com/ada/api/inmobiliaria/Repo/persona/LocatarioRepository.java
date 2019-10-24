package ar.com.ada.api.inmobiliaria.Repo.persona;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.inmobiliaria.entities.persona.Locatario;

/**
 * LocatarioRepository
 */
@Repository
public interface LocatarioRepository extends JpaRepository <Locatario , Integer> {

    
}