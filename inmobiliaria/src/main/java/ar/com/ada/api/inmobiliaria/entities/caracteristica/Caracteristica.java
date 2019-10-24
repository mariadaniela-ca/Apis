package ar.com.ada.api.inmobiliaria.entities.caracteristica;

import javax.persistence.*;

/**
 * Caracteristica
 */
@Entity
@Table(name = "caracteristica")

public class Caracteristica {
    @Id
    @Column(name = "caracteristica_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int caracteristicaId;
    
    private String descripcion;

    public int getCaracteristicaId() {
        return caracteristicaId;
    }

    public void setCaracteristicaId(int caracteristicaId) {
        this.caracteristicaId = caracteristicaId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}