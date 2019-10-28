package ar.com.ada.api.inmobiliaria.entities.inmobiliaria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


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

    private String email;
/*
    @OneToMany(mappedBy = "inmobiliaria", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Inmueble> inmuebles = new ArrayList<Inmueble>();

    /*@OneToMany(mappedBy = "inmobiliaria", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Locador> locadores = new ArrayList<Locador>();

    @OneToMany(mappedBy = "inmobiliaria", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Locatario> locatarios = new ArrayList<Locatario>();
*/
    
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
/*
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
    */

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getInmobiliariaId (){
        return inmobiliariaId;
    }

	public Inmobiliaria buscarPorId(int id) {
		return null;
	}
}