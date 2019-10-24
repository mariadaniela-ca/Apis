package ar.com.ada.api.inmobiliaria.entities.inmobiliaria;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import ar.com.ada.api.inmobiliaria.entities.inmueble.Inmueble;
import ar.com.ada.api.inmobiliaria.entities.persona.Locador;
import ar.com.ada.api.inmobiliaria.entities.persona.Locatario;

/**
 * Inmobiliaria
 */
@Entity
@Table(name = "inmobiliaria")
public class Inmobiliaria {
    @Id
    @Column(name = "inmobiliaria_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inmobiliariaId;

    private String nombre;

    private String direccion;

    private String cuit;

    @OneToMany(mappedBy = "inmobiliaria", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Inmueble> inmuebles = new ArrayList<Inmueble>();

    @OneToMany(mappedBy = "inmobiliaria", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Locador> locadores = new ArrayList<Locador>();

    @OneToMany(mappedBy = "inmobiliaria", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Locatario> locatarios = new ArrayList<Locatario>();

    public int getInmobiliariaId() {
        return inmobiliariaId;
    }

    public void setInmobiliariaId(int inmobiliariaId) {
        this.inmobiliariaId = inmobiliariaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public List<Inmueble> getInmuebles() {
        return inmuebles;
    }

    public void setInmuebles(List<Inmueble> inmuebles) {
        this.inmuebles = inmuebles;
    }

    public List<Locador> getLocadores() {
        return locadores;
    }

    public void setLocadores(List<Locador> locadores) {
        this.locadores = locadores;
    }

    public List<Locatario> getLocatarios() {
        return locatarios;
    }

    public void setLocatarios(List<Locatario> locatarios) {
        this.locatarios = locatarios;
    }
}