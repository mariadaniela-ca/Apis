package ar.com.ada.api.inmobiliaria.controllers.persona;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.inmobiliaria.entities.persona.Locatario;
import ar.com.ada.api.inmobiliaria.models.request.AuthRequest;
import ar.com.ada.api.inmobiliaria.models.response.PostResponse;
import ar.com.ada.api.inmobiliaria.services.persona.LocatarioService;

/**
 * LocatarioController
 */
@RestController
public class LocatarioController {

    @Autowired
    LocatarioService locatarioService;

    @PostMapping("/locatarios")
    public PostResponse postNewLocatario(@RequestBody AuthRequest req) {

        PostResponse r = new PostResponse();
        
        locatarioService.registrarLocatario(req.nombre, req.dni, req.email, req.telefono, req.direccion);

        r.message = "Locatario registrado con éxito";

        return r;

    }

    @GetMapping("/locatarios")
    public List<Locatario> getLocatarios() {

        List<Locatario> listaLocatarios = locatarioService.getLocatarios();

        return listaLocatarios;
    }

    @GetMapping("/locatarios/{id}")
    public Locatario getLocatarioById(@PathVariable int id) {

        Locatario l = locatarioService.buscarLocatarioPorId(id);
        return l;
    }

    @PutMapping("/locatarios/{dni}")
    public PostResponse putActualizarDatosLocatario(@PathVariable String dni, @RequestBody AuthRequest req) {

        PostResponse r = new PostResponse();

        locatarioService.actualizarLocatarioPorDni(dni, req.email, req.telefono, req.direccion);

        r.message = "Locatario actualizado con éxito";

        return r;

    }

    @DeleteMapping("/locatarios/{id}")
    public Locatario deleteLocatarioPorId(@PathVariable int id){

        Locatario l= locatarioService.darDeBajaLocatario(id);

        return l;
    }
    
}