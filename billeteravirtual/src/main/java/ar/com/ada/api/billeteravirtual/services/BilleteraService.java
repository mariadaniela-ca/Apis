package ar.com.ada.api.billeteravirtual.services;

import java.util.*;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.billeteravirtual.entities.Billetera;
import ar.com.ada.api.billeteravirtual.entities.Cuenta;
import ar.com.ada.api.billeteravirtual.entities.Movimiento;
import ar.com.ada.api.billeteravirtual.entities.Persona;
import ar.com.ada.api.billeteravirtual.entities.Usuario;
import ar.com.ada.api.billeteravirtual.repo.BilleteraRepository;

/**
 * BilleteraService
 */
@Service
public class BilleteraService {

    @Autowired
    BilleteraRepository billeteraRepo;

    @Autowired
    UsuarioService usuarioService;

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

    public Billetera traerBilletera(Usuario usuario){
        
        Billetera b=  usuario.getPersona().getBilletera();

        return b;

    }
    

    
    public void transferirDinero(double importe, int id, String conceptoDeOperacion, String tipoDeOperacion) {

        Usuario usuarioDestino = usuarioService.buscarPorId(id);
        Usuario usuarioOrigen = usuarioService.buscarPorId(78);

        Billetera bOrigen = traerBilletera(usuarioOrigen);

        Movimiento enviarDinero = new Movimiento();
        enviarDinero.setImporte(-(importe));
        enviarDinero.setDeUsuarioId(usuarioOrigen.getUsuarioId());
        enviarDinero.setAUsuarioId(usuarioDestino.getUsuarioId());
        enviarDinero.setCuentaDestinoId(usuarioDestino.getPersona().getBilletera().getBilleteraId());
        enviarDinero.setCuentaOrigenId(usuarioOrigen.getPersona().getBilletera().getBilleteraId());
        enviarDinero.setConceptoDeOperacion(conceptoDeOperacion);
        enviarDinero.setFechaMovimiento(new Date());
        enviarDinero.setEstado(0);
        enviarDinero.setTipoDeOperacion("Transferencia");

        //bOrigen.agregarMovimiento(enviarDinero);
        
        usuarioOrigen.getPersona().getBilletera().agregarMovimiento(enviarDinero);
        billeteraRepo.save(usuarioOrigen.getPersona().getBilletera());
        //billeteraRepo.save.update(usuarioOrigen.getPersona().getBilletera());

        Movimiento recibirDinero = new Movimiento();
        recibirDinero.setImporte(importe);
        recibirDinero.setDeUsuarioId(bOrigen.getPersona().getUsuario().getUsuarioId());
        recibirDinero.setAUsuarioId(usuarioDestino.getUsuarioId());
        recibirDinero.setCuentaDestinoId(usuarioDestino.getPersona().getBilletera().getBilleteraId());
        recibirDinero.setCuentaOrigenId(bOrigen.getBilleteraId());
        recibirDinero.setConceptoDeOperacion("Regalo");
        recibirDinero.setFechaMovimiento(new Date());
        recibirDinero.setEstado(0);
        recibirDinero.setTipoDeOperacion("Transferencia");

        usuarioDestino.getPersona().getBilletera().agregarMovimiento(recibirDinero);
        billeteraRepo.save(usuarioDestino.getPersona().getBilletera());

    }

    public double getSaldo(int id) {
        Optional<Billetera> b = billeteraRepo.findById(id);

        if (b.isPresent()){
            Cuenta c = b.get().getCuenta(0);
          
            return c.getSaldo();
        }
        return id;

    }
    public double getSaldoDisponible(int id) {
        Optional<Billetera> b = billeteraRepo.findById(id);

        if (b.isPresent()){
            Cuenta c = b.get().getCuenta(0);
          
            return c.getSaldoDisponible();
        }
        return id;
    }
}