package ar.com.ada.api.inmobiliaria.repositorys.caracteristica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.inmobiliaria.entities.caracteristica.CaracteristicaDeInmueble;



/**
 * CaracteristicaRepository
 */
@Repository
public interface CaracteristicaRepository extends JpaRepository<CaracteristicaDeInmueble,Integer>{

    
}