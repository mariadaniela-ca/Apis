package ar.com.ada.api.inmobiliaria.controllers.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.inmobiliaria.entities.usuario.Usuario;
import ar.com.ada.api.inmobiliaria.models.request.AuthRequest;
import ar.com.ada.api.inmobiliaria.models.response.PostResponse;
import ar.com.ada.api.inmobiliaria.services.inmobiliaria.InmobiliariaService;
import ar.com.ada.api.inmobiliaria.services.persona.LocatarioService;
import ar.com.ada.api.inmobiliaria.services.usuario.UsuarioService;

/**
 * UsuarioController
 */
@RestController
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    InmobiliariaService inmobiliariaService;

    @Autowired
    LocatarioService locatarioService;

    @GetMapping("/usuarios/{id}")
    public Usuario getUsusarioById(@PathVariable int id) {
        Usuario u = usuarioService.buscarPorId(id);
        return u;
    }

    @GetMapping("usuarios")
    public List<Usuario> getUsuarios() {
        List<Usuario> usuarios = usuarioService.getUsuarios();
        return usuarios;
    }

    @PutMapping("/usuarios/{id}")
    public PostResponse actualizaUsuario(@PathVariable int id, @RequestBody AuthRequest req) {
        PostResponse p = new PostResponse();

        usuarioService.actualizarEmailDeUsuario(id, req.email);
        p.isOk = true;

        p.message = "El email del usuario ha sido actualizado";
        return p;
    }

    @DeleteMapping("usuarios/{id}")
    public PostResponse deleteUsuario(@PathVariable int id) {
        PostResponse p = new PostResponse();
        usuarioService.buscarPorId(id);
        p.isOk = true;
        p.message = "El usuario ha sido dada de baja.";
        return p;

    }
}