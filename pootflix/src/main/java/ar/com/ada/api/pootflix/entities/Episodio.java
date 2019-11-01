package ar.com.ada.api.pootflix.entities;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Episodio
 */
@Document(collection = "Episodios")
public class Episodio {

    public int nroEpisodio;
    public String titulo;
    public int duracion;

    public void reproducir()
    {
        System.out.println("Reproduciendo episodio " + this.nroEpisodio + " " + this.titulo);
    }
}