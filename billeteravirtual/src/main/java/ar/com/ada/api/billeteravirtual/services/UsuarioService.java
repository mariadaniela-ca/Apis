package ar.com.ada.api.billeteravirtual.services;

//import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.billeteravirtual.entities.*;
import ar.com.ada.api.billeteravirtual.repo.UsuarioRepository;

/**
 * UsuarioService
 */
@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepo;

    @Autowired
    PersonaService personaService;

    public void save(Usuario u) {

        usuarioRepo.save(u);
    }

    public Usuario buscarPorId(int id) {
        Optional<Usuario> u = usuarioRepo.findById(id);

        if (u.isPresent())
            return u.get();
        return null;
    }

    public Usuario crearUsuario(String nombre, String dni, int edad, String email, String password) {

        Persona persona = new Persona();
        persona.setNombre(nombre);
        persona.setDni(dni);
        persona.setEdad(edad);
        persona.setEmail(email);

        Usuario u = new Usuario();
        u.setUsername(persona.getEmail());
        u.setPassword(password);
        u.setEmail(persona.getEmail());

        persona.setUsuario(u);

        personaService.save(persona);

        return u;

    }

}