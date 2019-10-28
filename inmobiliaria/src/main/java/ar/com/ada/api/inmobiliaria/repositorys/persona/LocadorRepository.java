package ar.com.ada.api.inmobiliaria.repositorys.persona;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.inmobiliaria.entities.persona.Locador;

/**
 * LocadorRepository
 */
@Repository
public interface LocadorRepository extends JpaRepository<Locador, Integer>{

    Locador findByDni(String dni);
}