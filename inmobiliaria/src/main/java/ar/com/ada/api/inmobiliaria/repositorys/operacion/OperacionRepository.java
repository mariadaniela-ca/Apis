package ar.com.ada.api.inmobiliaria.repositorys.operacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.inmobiliaria.entities.operacion.Operacion;

/**
 * OperacionRepository
 */
@Repository
public interface OperacionRepository extends JpaRepository<Operacion , Integer> {

}