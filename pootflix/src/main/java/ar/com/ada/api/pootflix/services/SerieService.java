package ar.com.ada.api.pootflix.services;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.pootflix.entities.Episodio;
import ar.com.ada.api.pootflix.entities.Serie;
import ar.com.ada.api.pootflix.entities.Temporada;
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

    public void registrarTemporada(ObjectId _id,int nroTemporada){

        List<Temporada> listaTemporada = new ArrayList<Temporada>();

        Serie s = serieRepository.findBy_id(_id);

        Temporada t = new Temporada();
        t.setNumeroTemporada(nroTemporada);

        listaTemporada.add(t);

        s.setTemporadas(listaTemporada);
        
        serieRepository.save(s);

    }

    public void agregarEpisodios(ObjectId _id, int temporada, int nroEpisodio , String titulo, int duracion ) {

        Episodio e = new Episodio();
        e.setNroEpisodio(nroEpisodio);
        e.setTitulo(titulo);
        e.setDuracion(duracion);

        Serie s = serieRepository.findBy_id(_id);

        //List<Temporada> listaTemporadas = s.getTemporadas();

        for (Temporada t : s.getTemporadas()) {
            if (t.getNumeroTemporada() == temporada) {
                List<Episodio> listaEpisodios = t.getEpisodios();
                listaEpisodios.add(e);
            }

        }

    }
}