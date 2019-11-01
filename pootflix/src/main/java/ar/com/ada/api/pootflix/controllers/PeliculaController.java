package ar.com.ada.api.pootflix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.pootflix.models.request.PeliculaRequest;
import ar.com.ada.api.pootflix.models.response.PeliculaResponse;
import ar.com.ada.api.pootflix.services.PeliculaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * PeliculaController
 */
@RestController
public class PeliculaController {

    
    @Autowired 
    PeliculaService peliculaService;

    @PostMapping("/peliculas")
    public PeliculaResponse postRegistrarPelicula(@RequestBody PeliculaRequest req) {

        PeliculaResponse p = new PeliculaResponse();

        peliculaService.registrarPelicula(req.titulo, req.genero, req.director, req.anio, req.ganoOscar);

        p.message= "Pelicula registrada con exito";

        return p;
    }
    

    

}