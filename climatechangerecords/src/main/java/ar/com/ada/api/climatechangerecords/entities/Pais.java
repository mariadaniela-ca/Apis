package ar.com.ada.api.climatechangerecords.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * Pais
 */
@Entity
@Table(name = "pais")
public class Pais {

    @Id
    @Column(name = "codigo_pais_id")
    private int codigoPaisId;

    private String nombre;

    @OneToMany(mappedBy = "pais", cascade = CascadeType.ALL)
    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Temperatura> temperaturas;

    public int getCodigoPaisId() {
        return codigoPaisId;
    }

    public void setCodigoPaisId(int codigoPaisId) {
        this.codigoPaisId = codigoPaisId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Temperatura> getTemperaturas() {
        return temperaturas;
    }

    public void setTemperaturas(List<Temperatura> temperaturas) {
        this.temperaturas = temperaturas;
    }

}