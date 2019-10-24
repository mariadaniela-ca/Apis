package ar.com.ada.api.inmobiliaria.Repo.operacion;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ada.api.inmobiliaria.entities.operacion.Operacion;

/**
 * OperacionRepository
 */
public interface OperacionRepository extends JpaRepository <Operacion , Integer> {

    
}