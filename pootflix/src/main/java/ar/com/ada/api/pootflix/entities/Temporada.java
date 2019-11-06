package ar.com.ada.api.pootflix.entities;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Temporada
 */
@Document(collection = "Temporadas")
public class Temporada {

    @Id
    private ObjectId _id;
    
    public int numeroTemporada;

    public List<Episodio> episodios = new ArrayList<Episodio>();

    public Episodio getEpisodio(int nro) {

        for (Episodio e : this.episodios) {
            if (e.nroEpisodio == nro) {
                return e;
            }

        }

        return null;
    }

    public int getNumeroTemporada() {
        return numeroTemporada;
    }

    public void setNumeroTemporada(int numeroTemporada) {
        this.numeroTemporada = numeroTemporada;
    }

    public List<Episodio> getEpisodios() {
        return episodios;
    }

    public void setEpisodios(List<Episodio> episodios) {
        this.episodios = episodios;
    }
}