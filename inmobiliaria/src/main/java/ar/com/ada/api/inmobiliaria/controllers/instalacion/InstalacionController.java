package ar.com.ada.api.inmobiliaria.controllers.instalacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.inmobiliaria.entities.instalacion.InstalacionDeInmueble;
import ar.com.ada.api.inmobiliaria.models.request.InstalacionRequest;
import ar.com.ada.api.inmobiliaria.models.response.PostResponse;
import ar.com.ada.api.inmobiliaria.services.instalacion.InstalacionService;

/**
 * InstalacionController
 */
@RestController
public class InstalacionController {

    @Autowired
    InstalacionService instalacionService;
    
    @PostMapping("/instalaciones")
    public PostResponse postRegistrarAmenitie(@RequestBody InstalacionRequest req) {

        PostResponse a = new PostResponse();
        instalacionService.registrarInstalacion(req.inmuebleId, req.luz, req.aguaCorriente, req.gas);
        
        a.isOk = true;
        a.message = "Instalacion registrada con éxito";
        return a;

    }

    @GetMapping("/instalaciones")
    public List<InstalacionDeInmueble> getInstalaciones() {

        List<InstalacionDeInmueble> listaInstalaciones = instalacionService.getInstalaciones();

        return listaInstalaciones;
    }

    @GetMapping("/instalaciones/{id}")
    public InstalacionDeInmueble getInstalacionById(@PathVariable int id) {

        InstalacionDeInmueble instalacion = instalacionService.buscarInstalacionPorId(id);
        return instalacion;

    }
    
}