package ar.com.ada.api.inmobiliaria.services.instalacion;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.inmobiliaria.entities.inmueble.Inmueble;
import ar.com.ada.api.inmobiliaria.entities.instalacion.InstalacionDeInmueble;
import ar.com.ada.api.inmobiliaria.repositorys.instalacion.InstalacionRepository;
import ar.com.ada.api.inmobiliaria.services.inmueble.InmuebleService;

/**
 * InstalacionService
 */
@Service
public class InstalacionService {

    @Autowired
    InstalacionRepository repoInstalacion;

    @Autowired
    InmuebleService inmuebleService;

    public void guardarInstalacion(InstalacionDeInmueble instalacion) {
        repoInstalacion.save(instalacion);
    }

    public InstalacionDeInmueble registrarInstalacion(int inmuebleId, String luz, String aguaCorriente, String gas) {

        Inmueble i = inmuebleService.buscarInmueblePorId(inmuebleId);
        InstalacionDeInmueble instalacion = new InstalacionDeInmueble();

        instalacion.setLuz(luz);
        instalacion.setAguaCorriente(aguaCorriente);
        instalacion.setGas(gas);
        instalacion.setInmueble(i);

        repoInstalacion.save(instalacion);
        return instalacion;
    }

    public List<InstalacionDeInmueble> getInstalaciones() {

        return repoInstalacion.findAll();
    }

    public InstalacionDeInmueble buscarInstalacionPorId(int id) {
        Optional<InstalacionDeInmueble> instalacion = repoInstalacion.findById(id);

        if (instalacion.isPresent())
            return instalacion.get();
        return null;

    }

    

}