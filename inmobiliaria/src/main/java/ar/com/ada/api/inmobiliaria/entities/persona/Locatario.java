package ar.com.ada.api.inmobiliaria.entities.persona;

import java.util.List;

import javax.persistence.*;

import ar.com.ada.api.inmobiliaria.entities.inmueble.Inmueble;

/**
 * Locatario
 */
@Entity
@Table(name = "locatario")
public class Locatario {

    private int locatarioId;

    private String nombre;

    private String dni;

    private int telefono;

    private String email;

    private String direccion;

    @OneToOne(mappedBy = "locatario", cascade = CascadeType.ALL)
    private Inmueble inmueble;

    public String getNombre() {
        return nombre;

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getLocatarioId() {
        return locatarioId;
    }

    public void setLocatarioId(int locatarioId) {
        this.locatarioId = locatarioId;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }


}