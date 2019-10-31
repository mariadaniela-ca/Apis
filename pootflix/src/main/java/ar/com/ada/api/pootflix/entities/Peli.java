package ar.com.ada.api.pootflix.entities;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Peli
 */
@Document(collection = "Peliculas")
public class Peli  extends Contenido{
    public boolean ganoOscar;
    
    
}