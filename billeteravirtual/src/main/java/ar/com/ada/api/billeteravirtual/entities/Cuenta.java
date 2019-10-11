package ar.com.ada.api.billeteravirtual.entities;

import java.math.BigDecimal;
import java.util.*;
import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * Cuenta
 */
@Entity
@Table(name = "cuenta")
public class Cuenta {
    @Id
    @Column(name = "cuenta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nroCuentaId;

    @ManyToOne
    @JoinColumn(name = "billetera_id", referencedColumnName = "billetera_id")
    private Billetera billetera;

    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Movimiento> movimientos = new ArrayList<Movimiento>();

    private String moneda;

    private BigDecimal saldo;

    @Column(name = "saldo_disponible")
    private BigDecimal saldoDisponible;

    public Cuenta() {
    
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getMonedad() {
        return moneda;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public Billetera getBilletera() {
        return billetera;
    }

    public void setBilletera(Billetera billetera) {
        this.billetera = billetera;

    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    public void agregarMovimiento(Movimiento movimiento) {
        
        movimiento.setCuenta(this);
        movimientos.add(movimiento);

        this.setSaldo(this.getSaldo().add(movimiento.getImporte()));
        this.setSaldoDisponible(this.getSaldo());
        
    }

    public int getNroCuentaId() {
        return nroCuentaId;
    }

    public void setNroCuentaId(int nroCuentaId) {
        this.nroCuentaId = nroCuentaId;
    }

    public String getMoneda() {
        return moneda;
    }

    public BigDecimal getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(BigDecimal saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }
    public Usuario getUsuario(){

        Usuario u = this.getBilletera().getPersona().getUsuario();
        return u;
        
    }

}