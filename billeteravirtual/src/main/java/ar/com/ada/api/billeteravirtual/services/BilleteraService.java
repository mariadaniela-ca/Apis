package ar.com.ada.api.billeteravirtual.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.billeteravirtual.entities.Billetera;
import ar.com.ada.api.billeteravirtual.entities.Cuenta;
import ar.com.ada.api.billeteravirtual.entities.Movimiento;
import ar.com.ada.api.billeteravirtual.entities.Usuario;
import ar.com.ada.api.billeteravirtual.repo.BilleteraRepository;
import ar.com.ada.api.billeteravirtual.sistema.comms.EmailService;

/**
 * BilleteraService
 */
@Service
public class BilleteraService {

    @Autowired
    BilleteraRepository billeteraRepo;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    MovimientoService movimientoService;

    @Autowired
    EmailService emailService;

    public void save(Billetera b) {
        billeteraRepo.save(b);
    }

    // Busca una billetera por su id
    public Billetera buscarPorId(int id) {
        Optional<Billetera> b = billeteraRepo.findById(id);

        if (b.isPresent())
            return b.get();
        return null;
    }

    public Billetera traerBilletera(Usuario usuario) {

        Billetera b = usuario.getPersona().getBilletera();

        return b;

    }

    public void transferirDinero(Billetera billeteraOrigen, BigDecimal importe, String email,
            String conceptoDeOperacion, String tipoDeOperacion, String moneda) {

        Usuario usuarioDestino = usuarioService.buscarUsuarioPorEmail(email);

        Usuario usuarioOrigen = billeteraOrigen.getPersona().getUsuario();

        Movimiento enviarDinero = new Movimiento();
        enviarDinero.setImporte(importe.negate());
        enviarDinero.setDeUsuarioId(usuarioOrigen.getUsuarioId());
        enviarDinero.setCuenta(usuarioOrigen.getPersona().getBilletera().getCuenta(0));
        enviarDinero.setAUsuarioId(usuarioDestino.getUsuarioId());
        enviarDinero.setCuentaDestinoId(usuarioDestino.getPersona().getBilletera().buscarCuenta(moneda).getNroCuentaId());
        enviarDinero.setCuentaOrigenId(usuarioOrigen.getPersona().getBilletera().buscarCuenta(moneda).getNroCuentaId());
        enviarDinero.setConceptoDeOperacion(conceptoDeOperacion);
        enviarDinero.setFechaMovimiento(new Date());
        enviarDinero.setEstado(0);
        enviarDinero.setTipoDeOperacion("Transferencia");

        // bOrigen.agregarMovimiento(enviarDinero);
   
        usuarioOrigen.getPersona().getBilletera().agregarMovimiento(enviarDinero);
        billeteraRepo.save(usuarioOrigen.getPersona().getBilletera());
        // billeteraRepo.save.update(usuarioOrigen.getPersona().getBilletera());

        Movimiento recibirDinero = new Movimiento();
        recibirDinero.setImporte(importe);
        recibirDinero.setDeUsuarioId(usuarioOrigen.getPersona().getUsuario().getUsuarioId());
        recibirDinero.setAUsuarioId(usuarioDestino.getUsuarioId());
        recibirDinero
                .setCuentaDestinoId(usuarioDestino.getPersona().getBilletera().buscarCuenta(moneda).getNroCuentaId());
        recibirDinero
                .setCuentaOrigenId(usuarioOrigen.getPersona().getBilletera().buscarCuenta(moneda).getNroCuentaId());
        recibirDinero.setConceptoDeOperacion("Regalo");
        recibirDinero.setFechaMovimiento(new Date());
        recibirDinero.setEstado(0);
        recibirDinero.setTipoDeOperacion("Transferencia");

        usuarioDestino.getPersona().getBilletera().agregarMovimiento(recibirDinero);
        billeteraRepo.save(usuarioDestino.getPersona().getBilletera());

        
        emailService.SendEmail(usuarioOrigen.getEmail(),"AVISO de Transferencia", 
        "Se ha realizo la transferencia satisfactoriamente:\n Datos de transferencia:\n De: "+ 
        usuarioOrigen.getPersona().getNombre() + "\n A: "+ usuarioDestino.getPersona().getNombre() +
        "\n Email: "+ usuarioDestino.getEmail()+ "\n Fecha: "+ enviarDinero.getFechaMovimiento()+ 
        "\n Monto: "+ enviarDinero.getImporte()+ 
        "\n Si usted no ha realizado esta transferencia escriba al: resolvemosproblemas@gmail.com");

        emailService.SendEmail(usuarioDestino.getEmail(),"AVISO de Transferencia", 
        "Ha recibido una transferencia de:\n Datos de transferencia:\n De: "+ 
        usuarioOrigen.getPersona().getNombre() + "\n Email: "+ usuarioOrigen.getEmail()+ 
        "\n Fecha: "+ recibirDinero.getFechaMovimiento()+ 
        "\n Importe: "+ recibirDinero.getImporte());
        
    }

    public BigDecimal getSaldo(int id) {
        Optional<Billetera> b = billeteraRepo.findById(id);

        if (b.isPresent()) {
            Cuenta c = b.get().getCuenta(0);

            return c.getSaldo();
        }
        return null;

    }

    public BigDecimal getSaldoDisponible(int id) {
        Optional<Billetera> b = billeteraRepo.findById(id);

        if (b.isPresent()) {
            Cuenta c = b.get().getCuenta(0);

            return c.getSaldoDisponible();
        }
        return null;
    }

    public List<Movimiento> movimientos(int id) {
        Optional<Billetera> b = billeteraRepo.findById(id);

        if (b.isPresent()) {
            Cuenta c = b.get().getCuenta(0);

            return c.getMovimientos();
        }
        return null;

    }
}