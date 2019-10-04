package ar.com.ada.api.billeteravirtual.entities;

import java.util.ArrayList;
import java.util.*;
import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * Billetera
 */
@Entity
@Table(name = "billetera")
public class Billetera {
    @Id
    @Column(name = "billetera_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billeteraId;

    @OneToOne
    @JoinColumn(name = "persona_id", referencedColumnName = "persona_id")
    private Persona persona;

    @OneToMany(mappedBy = "billetera", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Cuenta> cuentas = new ArrayList<Cuenta>();

    public Persona getPersona() {

        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
        this.persona.setBilletera(this);
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;

    }

    public void agregarCuenta(Cuenta cuenta) {

        cuenta.setBilletera(this);
        cuentas.add(cuenta);

    }

    public void agregarMovimiento(Movimiento movimiento) {

        this.getCuentas().get(0).agregarMovimiento(movimiento);

    }

    public int getBilleteraId() {
        return billeteraId;
    }

    public void setBilleteraId(int billeteraId) {
        this.billeteraId = billeteraId;
    }

    public static void movimientoTransferencia(double importe, Usuario usuarioOrigen, Usuario usuarioDestino) {

        Movimiento m = new Movimiento();
        m.setImporte(importe);
        m.setDeUsuarioId(usuarioOrigen.getUsuarioId());
        m.setAUsuarioId(usuarioDestino.getUsuarioId());
        m.setConceptoDeOperacion("Transferencia");
        m.setFechaMovimiento(new Date());
        m.setEstado(0);
        m.setCuentaOrigenId(usuarioOrigen.getPersona().getPersonaId());
        m.setCuentaDestinoId(usuarioDestino.getPersona().getPersonaId());
        m.setCuenta(usuarioOrigen.getPersona().getBilletera().getCuentas().get(0));

        
        







    }

}