package ar.com.ada.api.pootflix.entities;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Serie
 */
@Document(collection = "Series")
public class Serie extends Contenido {

    @Id
    private ObjectId _id;

    public List<Temporada> temporadas = new ArrayList<Temporada>();
    

    public Temporada getTemporada(int nro)
    {
        //Recorrer cada temporada
        //Si el nro de temporada del ciclo es igual a "nro"
        //Devolver esa temporada
        
        for (Temporada tempo : this.temporadas) {
            if(tempo.numeroTemporada == nro)
            {
                return tempo;
            }
            
        }

        return null;
    }

    public List<Temporada> getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(List<Temporada> temporadas) {
        this.temporadas = temporadas;
    }
}