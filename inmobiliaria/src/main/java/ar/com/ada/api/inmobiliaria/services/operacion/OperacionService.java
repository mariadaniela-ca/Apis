package ar.com.ada.api.inmobiliaria.services.operacion;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.inmobiliaria.entities.inmueble.Inmueble;
import ar.com.ada.api.inmobiliaria.entities.operacion.Operacion;
import ar.com.ada.api.inmobiliaria.entities.usuario.Usuario;
import ar.com.ada.api.inmobiliaria.repositorys.operacion.OperacionRepository;
import ar.com.ada.api.inmobiliaria.services.inmueble.InmuebleService;
import ar.com.ada.api.inmobiliaria.services.persona.LocatarioService;
import ar.com.ada.api.inmobiliaria.services.usuario.UsuarioService;

/**
 * OperacionService
 */
@Service
public class OperacionService {

    @Autowired
    OperacionRepository repoOperacion;

    @Autowired
    InmuebleService inmuebleService;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    LocatarioService locatarioService;

    public void guardarOperacion(Operacion operacion) {
        repoOperacion.save(operacion);
    }

    public List<Operacion> getOperaciones() {

        return repoOperacion.findAll();
    }

    public Operacion buscarOperacionPorId(int id) {

        Optional<Operacion> o = repoOperacion.findById(id);

        if (o.isPresent())
            return o.get();
        return null;
    }

    public void agregarOperacion(BigDecimal monto, String tipo, int inmuebleId, int usuarioId) {

        Inmueble i = inmuebleService.buscarInmueblePorId(inmuebleId);

        Usuario u = usuarioService.buscarPorId(usuarioId);

        Operacion o = new Operacion();
        o.setMonto(monto);
        o.setTipo(tipo);
        o.setFecha(new Date());
        o.setInmueble(i);
        o.setUsuario(u);

        repoOperacion.save(o);
    }

    public Operacion operacionReserva(BigDecimal monto, int inmuebleId, int usuarioId) {

        Usuario u = usuarioService.buscarPorId(usuarioId);

        Inmueble i = inmuebleService.buscarInmueblePorId(inmuebleId);
        i.setEstado("Reservado");
        i.setLocatario(u.getLocatario());
        inmuebleService.guardarInmueble(i);

        Operacion operacion = new Operacion();
        operacion.setFecha(new Date());
        operacion.setMonto(monto);
        operacion.setInmueble(i);
        operacion.setUsuario(u);
        operacion.setTipo("Reserva");
        guardarOperacion(operacion);

        return operacion;

    }

    public Operacion operacionAlquiler(BigDecimal monto, int inmuebleId, int usuarioId) {

        Usuario u = usuarioService.buscarPorId(usuarioId);

        Inmueble i = inmuebleService.buscarInmueblePorId(inmuebleId);
        i.setEstado("Alquilado");
        i.setLocatario(u.getLocatario());
        inmuebleService.guardarInmueble(i);
        
            Operacion operacion = new Operacion();
            operacion.setFecha(new Date());
            operacion.setMonto(monto);
            operacion.setInmueble(i);
            operacion.setUsuario(u);
            operacion.setTipo("Alquiler");
            guardarOperacion(operacion);

            return operacion;
    }

    public List<Operacion> getOperacionesReservas() {
        List<Operacion> operaciones = new ArrayList<Operacion>();

        for (Operacion o : getOperaciones()) {
            if (o.getTipo().equals("Reserva")) {
                Operacion op = o;

                operaciones.add(op);
            }
        }
        return operaciones;
    }

    public List<Operacion> getOperacionesAlquileres() {
        List<Operacion> operaciones = new ArrayList<Operacion>();

        for (Operacion o : getOperaciones()) {
            if (o.getTipo().equals("Alquiler")) {
                Operacion op = o;

                operaciones.add(op);
            }
        }
        return operaciones;
    }
}
