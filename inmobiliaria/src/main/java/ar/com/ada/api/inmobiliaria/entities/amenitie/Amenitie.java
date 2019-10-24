package ar.com.ada.api.inmobiliaria.entities.amenitie;

import javax.persistence.*;

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