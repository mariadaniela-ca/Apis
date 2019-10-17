package ar.com.ada.api.climatechangerecords.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.climatechangerecords.entities.Pais;
import ar.com.ada.api.climatechangerecords.models.request.PaisRequest;
import ar.com.ada.api.climatechangerecords.models.response.PaisResponse;
import ar.com.ada.api.climatechangerecords.services.PaisService;

/**
 * PaisController
 */
@RestController
public class PaisController {

    @Autowired
    PaisService paisService;

    @PostMapping("/paises")
    public PaisResponse postRegistroPais(@RequestBody PaisRequest req){


        PaisResponse response= new PaisResponse();
        paisService.registrarPais(req.codigoPais, req.nombre);

        response.message = "País registrado con exito";

        return response;
        
    }

    @GetMapping("/paises")
    public List<Pais> getPaises() {

        List<Pais> listaPaises = paisService.getPaises();

        return listaPaises;
    }  

      @GetMapping("/paises/{id}")
    public Pais getPaisById(@PathVariable int id) {

        Pais p = paisService.buscarCodigoId(id);
        return p;
    }

     @PutMapping("paises/{id}")
    public PaisResponse putActualizarDatosPais(@PathVariable int id, @RequestBody PaisRequest req) {

         PaisResponse response = new  PaisResponse();

        paisService.actualizarNombrePaisporId(id, req.nombre);
        response.message = "Pais actualizado con éxito";

        return response;

    }
}