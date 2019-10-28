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

import ar.com.ada.api.inmobiliaria.entities.persona.Locador;
import ar.com.ada.api.inmobiliaria.models.request.AuthRequest;
import ar.com.ada.api.inmobiliaria.models.response.PostResponse;
import ar.com.ada.api.inmobiliaria.services.persona.LocadorService;

/**
 * LocadorController
 */
@RestController
public class LocadorController {

    @Autowired
    LocadorService locadorService;

    @PostMapping("/locadores")
    public PostResponse postNewLocador(@RequestBody AuthRequest req) {

        PostResponse r = new PostResponse();
        
        locadorService.registrarLocador(req.nombre, req.dni, req.email, req.telefono, req.direccion);

        r.message = "Locador registrado con éxito";

        return r;

    }

    @GetMapping("/locadores")
    public List<Locador> getLocadores() {

        List<Locador> listaLocadores = locadorService.getLocadores();

        return listaLocadores;
    }

    @GetMapping("/locadores/{id}")
    public Locador getLocadorById(@PathVariable int id) {

        Locador l = locadorService.buscarLocadorPorId(id);
        return l;
    }

    @PutMapping("/locadores/{dni}")
    public PostResponse putActualizarDatosLocador(@PathVariable String dni, @RequestBody AuthRequest req) {

        PostResponse r = new PostResponse();

        locadorService.actualizarLocadorPorDni(dni, req.email, req.telefono, req.direccion);

        r.message = "Locador actualizado con éxito";

        return r;

    }

    @DeleteMapping("/locadores/{id}")
    public Locador deleteLocadorPorId(@PathVariable int id){

        Locador l= locadorService.darDeBajaLocador(id);

        return l;
    }
    
}