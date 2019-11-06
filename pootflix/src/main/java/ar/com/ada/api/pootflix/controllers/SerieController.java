package ar.com.ada.api.pootflix.controllers;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.pootflix.models.request.ContenidoRequest;
import ar.com.ada.api.pootflix.models.response.ContenidoResponse;
import ar.com.ada.api.pootflix.services.SerieService;

/**
 * SerieController
 */
@RestController
public class SerieController {


    @Autowired
    SerieService serieService;

    @PostMapping("/series")
    public ContenidoResponse postRegistrarSerie(@RequestBody ContenidoRequest req) {

        ContenidoResponse s = new ContenidoResponse();

        serieService.registrarSerie(req.titulo, req.genero, req.anio);

        s.message = "Serie registrada con exito";

        return s;
    }

}