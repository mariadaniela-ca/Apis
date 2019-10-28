package ar.com.ada.api.inmobiliaria.controllers.caracteristica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import ar.com.ada.api.inmobiliaria.entities.caracteristica.Caracteristica;
import ar.com.ada.api.inmobiliaria.models.request.DescripcionRequest;
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
    public PostResponse postRegistrarCaracteristica(@RequestBody DescripcionRequest req ){
        PostResponse c = new PostResponse();
        caracteristicaService.registrarCaracteristica(req.descripcion);

        c.isOk = true;
        c.message = "Caracteristica registrada con éxito";
        
        return c;
    }

    @GetMapping("caracteristicas")
    public List<Caracteristica> getCaracteristicas(){

        List<Caracteristica> listaCaracteristicas = caracteristicaService.getCaracteristicas();

        return listaCaracteristicas;

    }

    @GetMapping("caracteristicas/{id}")
    public Caracteristica getCaracteristicaById(@PathVariable int id){

        Caracteristica c = caracteristicaService.buscarCaracteristicaPorId(id);

        return c;

    }

    

    
}