package ar.com.ada.api.pootflix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.pootflix.models.request.ContenidoRequest;
import ar.com.ada.api.pootflix.models.response.ContenidoResponse;
import ar.com.ada.api.pootflix.services.TemporadaService;

/**
 * TemporadaController
 */
@RestController
public class TemporadaController {

    @Autowired
    TemporadaService temporadaService;

    @PostMapping("/temporadas")
    public ContenidoResponse postRegistrarTemporada(@RequestBody ContenidoRequest req) {

        ContenidoResponse s = new ContenidoResponse();

        temporadaService.registrarTemporada(req.numeroTemporada);

        s.message = "Temporada registrada con exito";

        return s;
    }

    @PostMapping("/temporadas/episodios")
    public ContenidoResponse postRegistrarEpisodio(@RequestBody ContenidoRequest req) {

        ContenidoResponse s = new ContenidoResponse();

        temporadaService.registarEpisodio(req.numeroTemporada, req.numeroEpisodio, req.titulo, req.duracion);

        s.message = "Episodio registrado con exito";

        return s;
    }

    

}