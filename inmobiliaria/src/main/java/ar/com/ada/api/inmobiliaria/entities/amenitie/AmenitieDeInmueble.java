package ar.com.ada.api.inmobiliaria.entities.amenitie;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ar.com.ada.api.inmobiliaria.entities.inmueble.Inmueble;

/**
 * Amenitie
 */
@Entity
@Table(name= "amenitie_de_inmueble")
public class AmenitieDeInmueble {

    @Id
    @Column(name = "amenitie_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int amenitieId;

    private String ascensor;

    private String pileta;
    
    private String gimnasio;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "inmueble_id", referencedColumnName = "inmueble_id")
    private Inmueble inmueble;


    public int getAmenitieId() {
        return amenitieId;
    }

    public void setAmenitieId(int amenitieId) {
        this.amenitieId = amenitieId;
    }

    public String getAscensor() {
        return ascensor;
    }

    public void setAscensor(String ascensor) {
        this.ascensor = ascensor;
    }

    public String getPileta() {
        return pileta;
    }

    public void setPileta(String pileta) {
        this.pileta = pileta;
    }

    public String getGimnasio() {
        return gimnasio;
    }

    public void setGimnasio(String gimnasio) {
        this.gimnasio = gimnasio;
    }


    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    
}