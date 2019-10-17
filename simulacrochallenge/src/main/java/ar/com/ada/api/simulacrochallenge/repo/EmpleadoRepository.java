package ar.com.ada.api.simulacrochallenge.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.simulacrochallenge.entities.Empleado;

/**
 * EmpleadoRepository
 */
@Repository
public interface EmpleadoRepository extends JpaRepository <Empleado , Integer> {


}