package ar.com.ada.api.pootflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.pootflix.entities.Serie;
import ar.com.ada.api.pootflix.repo.SerieRepository;

/**
 * SerieService
 */
@Service
public class SerieService {

    @Autowired
    SerieRepository serieRepository;

    public void registrarSerie(String titulo, String genero, int anio) {

        Serie s = new Serie();
        s.setTitulo(titulo);
        s.setGenero(genero);
        s.setAnio(anio);

        serieRepository.save(s);

    }
}