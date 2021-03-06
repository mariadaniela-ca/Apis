package ar.com.ada.api.inmobiliaria.repositorys.inmobiliaria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.inmobiliaria.entities.inmobiliaria.Inmobiliaria;

/**
 * InmobiliariaRepository
 */
@Repository
public interface InmobiliariaRepository extends JpaRepository <Inmobiliaria, Integer>{ 

    Inmobiliaria findById (int id);
}