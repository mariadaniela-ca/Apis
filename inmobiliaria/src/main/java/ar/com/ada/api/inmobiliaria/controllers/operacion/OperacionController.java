package ar.com.ada.api.inmobiliaria.controllers.operacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.inmobiliaria.entities.operacion.Operacion;
import ar.com.ada.api.inmobiliaria.models.request.OperacionRequest;
import ar.com.ada.api.inmobiliaria.models.response.PostResponse;
import ar.com.ada.api.inmobiliaria.services.inmueble.InmuebleService;
import ar.com.ada.api.inmobiliaria.services.operacion.OperacionService;
import ar.com.ada.api.inmobiliaria.services.usuario.UsuarioService;

/**
 * OperacionController
 */
@RestController
public class OperacionController {

    @Autowired
    OperacionService operacionService;

    @Autowired
    InmuebleService inmuebleService;

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/operaciones")
    public PostResponse postNewOperacion(@RequestBody OperacionRequest req) {

        PostResponse r = new PostResponse();

        operacionService.agregarOperacion(req.monto, req.tipo, req.inmuebleId, req.usuarioId);

        r.message = "Operación registrada con éxito";

        return r;
    }

    @PostMapping("/operaciones/reservas")
    public PostResponse postReserva(@RequestBody OperacionRequest req) {
        PostResponse r = new PostResponse();

        operacionService.operacionReserva(req.monto, req.inmuebleId, req.usuarioId);
        r.message = ("Reserva realizada con éxito");

        return r;

    }

    @PostMapping("/operaciones/alquileres")
    public PostResponse postAlquiler(@RequestBody OperacionRequest req) {
        PostResponse r = new PostResponse();

        operacionService.operacionAlquiler(req.monto, req.inmuebleId, req.usuarioId);
        r.message = ("Alquiler realizado con éxito");

        return r;

    }

    @GetMapping("operaciones")
    public List<Operacion> getOperaciones() {
        List<Operacion> operaciones = operacionService.getOperaciones();

        return operaciones;
    }

    @GetMapping("operaciones/reservas")
    public List<Operacion> getOperacionesByReservas() {

        List<Operacion> operaciones = operacionService.getOperacionesReservas();

        return operaciones;

    }

    @GetMapping("operaciones/alquileres")
    public List<Operacion> getOperacionesByAlquileres() {

        List<Operacion> operaciones = operacionService.getOperacionesAlquileres();

        return operaciones;

    }

}

