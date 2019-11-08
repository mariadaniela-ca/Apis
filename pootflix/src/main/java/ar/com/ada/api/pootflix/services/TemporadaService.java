package ar.com.ada.api.pootflix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.pootflix.entities.Episodio;
import ar.com.ada.api.pootflix.entities.Temporada;
import ar.com.ada.api.pootflix.repo.TemporadaRepository;

/**
 * TemporadaService
 */
@Service
public class TemporadaService {

    @Autowired
    TemporadaRepository temporadaRepository;

    public void registrarTemporada(int numeroTemporada) {
        Temporada t = new Temporada();

        t.setNumeroTemporada(numeroTemporada);

        temporadaRepository.save(t);
    }

    public void registarEpisodio(int numeroTemporada, int numeroEpisodio, String titulo, int duracion) {
        Temporada t = temporadaRepository.findByNumeroTemporada(numeroTemporada);

        List<Episodio> listaEpisodios = t.getEpisodios();

        Episodio e = new Episodio();
        e.setNroEpisodio(numeroEpisodio);
        e.setTitulo(titulo);
        e.setDuracion(duracion);

        listaEpisodios.add(e);

        temporadaRepository.save(t);

    }
}