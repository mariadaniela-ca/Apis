package ar.com.ada.api.inmobiliaria.services.caracteristica;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.inmobiliaria.entities.caracteristica.Caracteristica;
import ar.com.ada.api.inmobiliaria.repositorys.caracteristica.CaracteristicaRepository;

/**
 * CaracteristicaService
 */
@Service
public class CaracteristicaService {

    @Autowired
    CaracteristicaRepository repoCaracteristica;

    public void guardarCaracteristica(Caracteristica c) {
        repoCaracteristica.save(c);
    }

    public Caracteristica registrarCaracteristica(String descripcion) {
        Caracteristica c = new Caracteristica();

        c.setDescripcion(descripcion);

        repoCaracteristica.save(c);
        return c;

    }

    public List<Caracteristica> getCaracteristicas() {

        return repoCaracteristica.findAll();
    }

    public Caracteristica buscarCaracteristicaPorId(int id) {

        Optional<Caracteristica> c = repoCaracteristica.findById(id);
        if (c.isPresent())
            return c.get();
        return null;

    }
}