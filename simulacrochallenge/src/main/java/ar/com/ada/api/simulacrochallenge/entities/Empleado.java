package ar.com.ada.api.simulacrochallenge.entities;

import javax.persistence.Column;

import java.math.BigDecimal;
import java.util.*;

import javax.persistence.*;
import javax.persistence.Table;

/**
 * Empleado
 */
@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @Column(name = "empleado_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empleadoId;

    @ManyToOne
    @JoinColumn(name = "categoria_id", referencedColumnName = "categoria_id")
    private Categoria categoria;

    private String nombre;

    private int edad;

    private String estado;

    private BigDecimal sueldo;

    @Column(name = "fecha_alta")
    private Date fechaAlta;

    @Column(name = "fecha_baja")
    private Date fechaBaja;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public BigDecimal getSueldo() {
        return sueldo;
    }

    public void setSueldo(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }

    public void actualizarEmpleado(String nombre, int edad, Categoria categoria){
        this.setNombre(nombre);
        this.setEdad(edad);
        this.setCategoria(categoria);
        
    }

}