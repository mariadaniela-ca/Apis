package ar.com.ada.api.inmobiliaria.entities.inmueble;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ar.com.ada.api.inmobiliaria.entities.caracteristica.Caracteristica;
import ar.com.ada.api.inmobiliaria.entities.inmobiliaria.Inmobiliaria;
import ar.com.ada.api.inmobiliaria.entities.instalacion.Instalacion;

/**
 * Inmueble
 */
@Entity
@Table(name= "inmueble")
public class Inmueble {

    @Id
    @Column(name = "inmueble_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inmuebleId;

    private double precio;

    private String estado;

    private double superficie;

    private int antiguedad;

    private int direccion;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "inmobiliaria_id", referencedColumnName = "inmobiliaria_id")
    private Inmobiliaria inmobiliaria;


    @OneToOne
    @JoinColumn(name = "locatario_id", referencedColumnName = "locatario_id")
    @Column(name= "locador_id")
    private int locatarioId;     // cómo reconce estos id si en bd va a ser persona_id??

    @ManyToOne
    @JoinColumn(name = "locador_id", referencedColumnName = "locador_id")
    private int locadorId;


    private List<Caracteristica> caracteristicas = new ArrayList<Caracteristica>();
    private List<Instalacion> instalaciones = new ArrayList<Instalacion>();

    public int getInmuebleId() {
        return inmuebleId;
    }

    public void setInmuebleId(int inmuebleId) {
        this.inmuebleId = inmuebleId;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    public Inmobiliaria getInmobiliaria() {
        return inmobiliaria;
    }

    public void setInmobiliaria(Inmobiliaria inmobiliaria) {
        this.inmobiliaria = inmobiliaria;
    }

    public int getLocadorId() {
        return locadorId;
    }

    public void setLocadorId(int locadorId) {
        this.locadorId = locadorId;
    }

    public int getLocatarioId() {
        return locatarioId;
    }

    public void setLocatarioId(int locatarioId) {
        this.locatarioId = locatarioId;
    }

    public List<Caracteristica> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<Caracteristica> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public List<Instalacion> getInstalaciones() {
        return instalaciones;
    }

    public void setInstalaciones(List<Instalacion> instalaciones) {
        this.instalaciones = instalaciones;
    }
    
}