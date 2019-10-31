package ar.com.ada.api.inmobiliaria.controllers.caracteristica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.inmobiliaria.entities.caracteristica.CaracteristicaDeInmueble;
import ar.com.ada.api.inmobiliaria.models.request.CaracteristicaRequest;
import ar.com.ada.api.inmobiliaria.models.response.PostResponse;
import ar.com.ada.api.inmobiliaria.services.caracteristica.CaracteristicaService;

/**
 * CaracteristicaController
 */
@RestController
public class CaracteristicaController {

    @Autowired
    CaracteristicaService caracteristicaService;

    @PostMapping("caracteristicas")
    public PostResponse postRegistrarCaracteristica(@RequestBody CaracteristicaRequest req ){
        PostResponse c = new PostResponse();
        caracteristicaService.registrarCaracteristica(req.inmuebleId, req.ambientes, req.balcon, req.baños, req.cochera, req.patio, req.terraza);

        
        c.isOk = true;
        c.message = "Caracteristica registrada con éxito";
        
        return c;
    }

    @GetMapping("caracteristicas")
    public List<CaracteristicaDeInmueble> getCaracteristicas(){

        List<CaracteristicaDeInmueble> listaCaracteristicas = caracteristicaService.getCaracteristicas();

        return listaCaracteristicas;

    }

    @GetMapping("caracteristicas/{id}")
    public CaracteristicaDeInmueble getCaracteristicaById(@PathVariable int id){

        CaracteristicaDeInmueble c = caracteristicaService.buscarCaracteristicaPorId(id);

        return c;

    }

    

    
}