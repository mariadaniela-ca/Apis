package ar.com.ada.api.inmobiliaria.entities.caracteristica;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ar.com.ada.api.inmobiliaria.entities.inmueble.Inmueble;




/**
 * Caracteristica
 */
@Entity
@Table(name = "caracteristica_de_inmueble")
public class CaracteristicaDeInmueble {
    @Id
    @Column(name = "caracteristica_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int caracteristicaId;
    public int ambientes;
    public int baños;
    public int balcon;
    public int patio;
    public int cochera;
    public int terraza;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name= "inmueble_id", referencedColumnName = "inmueble_id")
    private Inmueble inmueble;


    public int getCaracteristicaId() {
        return caracteristicaId;
    }

    public void setCaracteristicaId(int caracteristicaId) {
        this.caracteristicaId = caracteristicaId;
    }

    public int getAmbientes() {
        return ambientes;
    }

    public void setAmbientes(int ambientes) {
        this.ambientes = ambientes;
    }

    public int getBaños() {
        return baños;
    }

    public void setBaños(int baños) {
        this.baños = baños;
    }

    public int getBalcon() {
        return balcon;
    }

    public void setBalcon(int balcon) {
        this.balcon = balcon;
    }

    public int getPatio() {
        return patio;
    }

    public void setPatio(int patio) {
        this.patio = patio;
    }

    public int getCochera() {
        return cochera;
    }

    public void setCochera(int cochera) {
        this.cochera = cochera;
    }

    public int getTerraza() {
        return terraza;
    }

    public void setTerraza(int terraza) {
        this.terraza = terraza;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    
}