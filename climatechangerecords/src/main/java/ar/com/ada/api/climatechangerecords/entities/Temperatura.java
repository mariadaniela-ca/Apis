package ar.com.ada.api.climatechangerecords.entities;

import javax.persistence.*;

/**
 * Temperatura
 */
@Entity
@Table(name = "temperatura")
public class Temperatura {

    @Id
    @Column(name = "temperatura_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int temperaturaId;

    @ManyToOne
    @JoinColumn(name = "codigo_pais_id", referencedColumnName = "codigo_pais_id")
    private Pais pais;

    @Column(name = "anio_temperatura")
    private int anioTemperatura;

    private Double grados;

    public int getTemperaturaId() {
        return temperaturaId;
    }

    public void setTemperaturaId(int temperaturaId) {
        this.temperaturaId = temperaturaId;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public int getAnioTemperatura() {
        return anioTemperatura;
    }

    public void setAnioTemperatura(int anioTemperatura) {
        this.anioTemperatura = anioTemperatura;
    }

    public Double getGrados() {
        return grados;
    }

    public void setGrados(Double grados) {
        this.grados = grados;
    }


    
}