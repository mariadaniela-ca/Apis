package ar.com.ada.api.pootflix.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Peli
 */
@Document(collection = "Peliculas")
public class Pelicula extends Contenido {

    @Id
    private ObjectId _id;
    
    @JsonIgnore
    public boolean ganoOscar;

    public boolean isGanoOscar() {
        return ganoOscar;
    }

    public void setGanoOscar(boolean ganoOscar) {
        this.ganoOscar = ganoOscar;
    }

}