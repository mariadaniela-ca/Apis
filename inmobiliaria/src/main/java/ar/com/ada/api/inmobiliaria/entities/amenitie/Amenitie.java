package ar.com.ada.api.inmobiliaria.entities.amenitie;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import ar.com.ada.api.inmobiliaria.entities.inmueble.Inmueble;

/**
 * Amenitie
 */
@Entity
@Table(name= "amenitie")
public class Amenitie {

    @Id
    @Column(name = "amenitie_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int amenitieId;


    @ManyToMany(mappedBy = "amenities")
    private List<Inmueble> inmuebles = new ArrayList<Inmueble>();
    
    private String descripcion;

    public int getAmenitieId() {
        return amenitieId;
    }

    public void setAmenitieId(int amenitieId) {
        this.amenitieId = amenitieId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}