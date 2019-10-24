package ar.com.ada.api.inmobiliaria.entities.operacion;

import java.util.Date;

import javax.persistence.*;

/**
 * Operacion
 */
@Entity
@Table(name= "operacion")
public class Operacion {

    @Id
    @Column(name = "operacion_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int operacionId;

    private Date fecha;

    private String tipo;

    @Column(name= "inmueble_id")
    private int inmuebleId;

    
    @Column(name= "usuario_id")
    private int usuarioId;

    public int getOperacionId() {
        return operacionId;
    }

    public void setOperacionId(int operacionId) {
        this.operacionId = operacionId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getInmuebleId() {
        return inmuebleId;
    }

    public void setInmuebleId(int inmuebleId) {
        this.inmuebleId = inmuebleId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
    
}