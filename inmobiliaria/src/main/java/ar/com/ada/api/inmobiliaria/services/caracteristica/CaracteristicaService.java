package ar.com.ada.api.inmobiliaria.services.caracteristica;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.inmobiliaria.entities.caracteristica.CaracteristicaDeInmueble;
import ar.com.ada.api.inmobiliaria.entities.inmueble.Inmueble;
import ar.com.ada.api.inmobiliaria.repositorys.caracteristica.CaracteristicaRepository;
import ar.com.ada.api.inmobiliaria.services.inmueble.InmuebleService;

/**
 * CaracteristicaService
 */
@Service
public class CaracteristicaService {

    @Autowired
    InmuebleService inmuebleService;
    @Autowired
    CaracteristicaRepository repoCaracteristica;

    public void guardarCaracteristica(CaracteristicaDeInmueble c) {
        repoCaracteristica.save(c);
    }

    public CaracteristicaDeInmueble registrarCaracteristica(int inmuebleId, int ambiente, int baño, int balcon, int patio, int cochera, int terraza) {
        CaracteristicaDeInmueble c = new CaracteristicaDeInmueble();
        Inmueble i = inmuebleService.buscarInmueblePorId(inmuebleId);

        c.setAmbientes(ambiente);
        c.setBaños(baño);
        c.setBalcon(balcon);
        c.setPatio(patio);
        c.setCochera(cochera);
        c.setTerraza(terraza);
        c.setInmueble(i);

        repoCaracteristica.save(c);
        return c;

    }

    public List<CaracteristicaDeInmueble> getCaracteristicas() {

        return repoCaracteristica.findAll();
    }

    public CaracteristicaDeInmueble buscarCaracteristicaPorId(int id) {

        Optional<CaracteristicaDeInmueble> c = repoCaracteristica.findById(id);
        if (c.isPresent())
            return c.get();
        return null;

    }
}