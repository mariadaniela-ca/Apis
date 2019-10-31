package ar.com.ada.api.inmobiliaria.entities.instalacion;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ar.com.ada.api.inmobiliaria.entities.inmueble.Inmueble;

/**
 * Instalacion
 */
@Entity
@Table(name= "instalacion_de_inmueble")
public class InstalacionDeInmueble {

    @Id
    @Column(name = "instalacion_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int instalacionId;
    
    private String luz;

    @Column(name= "agua_corriente")
    private String aguaCorriente;

    private String gas;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "inmueble_id", referencedColumnName = "inmueble_id")
    private Inmueble inmueble;

    public int getInstalacionId() {
        return instalacionId;
    }

    public void setInstalacionId(int instalacionId) {
        this.instalacionId = instalacionId;
    }

    public String getLuz() {
        return luz;
    }

    public void setLuz(String luz) {
        this.luz = luz;
    }

    public String getAguaCorriente() {
        return aguaCorriente;
    }

    public void setAguaCorriente(String aguaCorriente) {
        this.aguaCorriente = aguaCorriente;
    }

    public String getGas() {
        return gas;
    }

    public void setGas(String gas) {
        this.gas = gas;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

   
}