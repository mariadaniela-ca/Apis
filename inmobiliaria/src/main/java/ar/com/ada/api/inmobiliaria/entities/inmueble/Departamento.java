package ar.com.ada.api.inmobiliaria.entities.inmueble;

import java.util.*;

import ar.com.ada.api.inmobiliaria.entities.amenitie.Amenitie;

/**
 * Departamento
 */
public class Departamento extends Inmueble {

    
    private List<Amenitie> amenities = new ArrayList<Amenitie>();

    public List<Amenitie> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<Amenitie> amenities) {
        this.amenities = amenities;
    }
    
}