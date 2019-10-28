package ar.com.ada.api.inmobiliaria.entities.inmueble;

import java.math.BigDecimal;
import java.util.*;

import javax.persistence.*;

import ar.com.ada.api.inmobiliaria.entities.caracteristica.Caracteristica;
import ar.com.ada.api.inmobiliaria.entities.inmobiliaria.Inmobiliaria;
import ar.com.ada.api.inmobiliaria.entities.operacion.Operacion;
import ar.com.ada.api.inmobiliaria.entities.persona.Locador;
import ar.com.ada.api.inmobiliaria.entities.persona.Locatario;

/**
 * Inmueble
 */
@Entity
@Table(name = "inmueble")
public class Inmueble {

    @Id
    @Column(name = "inmueble_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inmuebleId;

    private BigDecimal precio;

    private String estado;

    private double superficie;

    private int antiguedad;

    private String direccion;

    @Column(name= "tipo_inmueble")
    private String tipoInmueble;

    @ManyToOne
    @JoinColumn(name = "inmobiliaria_id", referencedColumnName = "inmobiliaria_id")
    private Inmobiliaria inmobiliaria;

    @OneToOne
    @JoinColumn(name = "locatario_id", referencedColumnName = "locatario_id")
    private Locatario locatario; // cómo reconce estos id si en bd va a ser persona_id??

    @OneToMany(mappedBy = "inmueble", cascade = CascadeType.ALL)
    private List<Operacion> operaciones;

    @ManyToOne
    @JoinColumn(name = "locador_id", referencedColumnName = "locador_id")
    private Locador locador;

    @ManyToMany
    @JoinTable(name = "caracteristica_por_inmueble", joinColumns = @JoinColumn(name = "inmueble_id"), 
    inverseJoinColumns = @JoinColumn(name = "caracteristica_id"))
    private List<Caracteristica> caracteristicas = new ArrayList<Caracteristica>();

    @ManyToMany
    @JoinTable(name = "amenitie_por_inmueble", joinColumns = @JoinColumn(name = "inmueble_id"), 
    inverseJoinColumns = @JoinColumn(name = "amenitie_id"))
    private List<Caracteristica> amenities = new ArrayList<Caracteristica>();

   /* @ManyToMany(mappedBy = "inmuebles")
    private List<Amenitie> amenities= new ArrayList<Amenitie>();
*/
    /*
     * @OneToMany(mappedBy = "Inmueble", cascade = CascadeType.ALL)
     * 
     * @LazyCollection(LazyCollectionOption.FALSE) private List<Instalacion>
     * instalaciones = new ArrayList<Instalacion>();
     */
    public int getInmuebleId() {
        return inmuebleId;
    }

    public void setInmuebleId(int inmuebleId) {
        this.inmuebleId = inmuebleId;
    }

    public BigDecimal getPrecio() {
        return precio;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    /*
     * public Inmobiliaria getInmobiliaria() { return inmobiliaria; }
     * 
     * public void setInmobiliaria(Inmobiliaria inmobiliaria) { this.inmobiliaria =
     * inmobiliaria; }
     * 
     * 
     * public List<Caracteristica> getCaracteristicas() { return caracteristicas; }
     * 
     * public void setCaracteristicas(List<Caracteristica> caracteristicas) {
     * this.caracteristicas = caracteristicas; }
     * 
     * public List<Instalacion> getInstalaciones() { return instalaciones; }
     * 
     * public void setInstalaciones(List<Instalacion> instalaciones) {
     * this.instalaciones = instalaciones; }
     */

    public Locatario getLocatario() {
        return locatario;
    }

    public void setLocatario(Locatario locatario) {
        this.locatario = locatario;
    }

    public Locador getLocador() {
        return locador;
    }

    public void setLocador(Locador locador) {
        this.locador = locador;
    }

    public String getTipoInmueble() {
        return tipoInmueble;
    }

    public void setTipoInmueble(String tipoInmueble) {
        this.tipoInmueble = tipoInmueble;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Inmobiliaria getInmobiliaria() {
        return inmobiliaria;
    }

    public void setInmobiliaria(Inmobiliaria inmobiliaria) {
        this.inmobiliaria = inmobiliaria;
    }

    public List<Caracteristica> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<Caracteristica> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
/*
    public List<Amenitie> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<Amenitie> amenities) {
        this.amenities = amenities;
    }
*/


}