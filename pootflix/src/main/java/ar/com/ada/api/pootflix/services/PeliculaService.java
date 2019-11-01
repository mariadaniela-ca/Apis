package ar.com.ada.api.pootflix.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.pootflix.entities.Pelicula;
import ar.com.ada.api.pootflix.repo.PeliculaRepository;

/**
 * PeliculaService
 */
@Service
public class PeliculaService {
    @Autowired
    PeliculaRepository peliculaRepository;

    public void registrarPelicula(String titulo, String genero, String director, int anio, Boolean ganoOscar){

        Pelicula p = new Pelicula();
        p.setTitulo(titulo);
        p.setGenero(genero);
        p.setDirector(director);
        p.setAnio(anio);
        p.setGanoOscar(ganoOscar);

        peliculaRepository.save(p);

    }

    public Pelicula buscarPorTitulo(String titulo) {

        Pelicula p = peliculaRepository.findByTitulo(titulo);

        return p;

    }

    public List<Pelicula> buscarPorGenero(String genero) {

        List<Pelicula> listaPeliculas = new ArrayList<Pelicula>();

        for (Pelicula p : peliculaRepository.findAll()) {
            if (p.getGenero().equals(genero)) {
                listaPeliculas.add(p);
            }

        }
        return listaPeliculas;

    }
}