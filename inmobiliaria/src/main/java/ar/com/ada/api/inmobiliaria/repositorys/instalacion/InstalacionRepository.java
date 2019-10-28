package ar.com.ada.api.inmobiliaria.repositorys.instalacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.inmobiliaria.entities.instalacion.Instalacion;

/**
 * InstalacionRepository
 */
@Repository
public interface InstalacionRepository extends JpaRepository<Instalacion , Integer> {

    
}