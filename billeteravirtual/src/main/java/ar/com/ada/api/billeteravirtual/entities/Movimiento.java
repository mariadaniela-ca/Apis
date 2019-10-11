package ar.com.ada.api.billeteravirtual.entities;

import java.math.BigDecimal;
import java.util.*;
import javax.persistence.*;

/**
 * Movimiento
 */
@Entity
@Table(name = "movimiento")
public class Movimiento {

    @Id
    @Column(name = "movimiento_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movimientoId;

    @ManyToOne
    @JoinColumn(name = "cuenta_id", referencedColumnName = "cuenta_id")
    private Cuenta cuenta;
    @Column(name = "fecha_movimiento")
    private Date fechaMovimiento;

    // private Coordenada ubicacion;

    private BigDecimal importe;
    @Column(name = "tipo_de_operacion")
    private String tipoDeOperacion;
    
    @Column(name = "concepto_de_operacion")
    private String conceptoDeOperacion;

    private String detalle;

    private int estado;

    @Column(name = "de_usuario_id")
    private int deUsuarioId;

    @Column(name = "a_usuario_id")
    private int aUsuarioId;
    
    @Column(name = "cuenta_destino_id")
    private int cuentaDestinoId;


    @Column(name = "cuenta_origen_id")
    private int cuentaOrigenId;

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public int getMovimientoId() {
        return movimientoId;
    }

    public void setMovimientoId(int movimientoId) {
        this.movimientoId = movimientoId;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public String getTipoDeOperacion() {
        return tipoDeOperacion;
    }

    public void setTipoDeOperacion(String tipoDeOperacion) {
        this.tipoDeOperacion = tipoDeOperacion;
    }

    public String getConceptoDeOperacion() {
        return conceptoDeOperacion;
    }

    public void setConceptoDeOperacion(String conceptoDeOperacion) {
        this.conceptoDeOperacion = conceptoDeOperacion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getDeUsuarioId() {
        return deUsuarioId;
    }

    public void setDeUsuarioId(int deUsuarioId) {
        this.deUsuarioId = deUsuarioId;
    }

    public int getaUsuarioId() {
        return aUsuarioId;
    }

    public void setAUsuarioId(int aUsuarioId) {
        this.aUsuarioId = aUsuarioId;
    }

    public int getCuentaDestinoId() {
        return cuentaDestinoId;
    }

    public void setCuentaDestinoId(int cuentaDestinoId) {
        this.cuentaDestinoId = cuentaDestinoId;
    }

    public int getCuentaOrigenId() {
        return cuentaOrigenId;
    }

    public void setCuentaOrigenId(int cuentaOrigenId) {
        this.cuentaOrigenId = cuentaOrigenId;
    }

    public void setaUsuarioId(int aUsuarioId) {
        this.aUsuarioId = aUsuarioId;
    }

}