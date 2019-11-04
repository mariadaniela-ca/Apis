package ar.com.ada.api.pootflix.controllers;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.pootflix.entities.Pelicula;
import ar.com.ada.api.pootflix.models.request.ContenidoRequest;
import ar.com.ada.api.pootflix.models.response.ContenidoResponse;
import ar.com.ada.api.pootflix.services.PeliculaService;

/**
 * PeliculaController
 */
@RestController
public class PeliculaController {

    @Autowired
    PeliculaService peliculaService;

    @PostMapping("/peliculas")
    public ContenidoResponse postRegistrarPelicula(@RequestBody ContenidoRequest req) {

        ContenidoResponse p = new ContenidoResponse();

        peliculaService.registrarPelicula(req.titulo, req.genero, req.director, req.anio, req.ganoOscar);

        p.message = "Pelicula registrada con exito";

        return p;
    }

    @GetMapping("/peliculas")
    public List<Pelicula> getPeliculas() {

        List<Pelicula> listaPeliculas = peliculaService.buscarPeliculas();

        return listaPeliculas;

    }

    @GetMapping("/peliculas/{_id}")
    public Pelicula getPeliculaById(@PathVariable ObjectId _id) {

        Pelicula p = peliculaService.getPeliculaById(_id);

        return p;

    }


}