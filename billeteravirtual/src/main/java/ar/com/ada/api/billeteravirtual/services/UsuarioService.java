package ar.com.ada.api.billeteravirtual.services;

import java.util.List;
//import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import ar.com.ada.api.billeteravirtual.entities.Billetera;
import ar.com.ada.api.billeteravirtual.entities.Cuenta;
import ar.com.ada.api.billeteravirtual.entities.Persona;
import ar.com.ada.api.billeteravirtual.entities.Usuario;
import ar.com.ada.api.billeteravirtual.repo.UsuarioRepository;
import ar.com.ada.api.billeteravirtual.security.Crypto;
import ar.com.ada.api.billeteravirtual.sistema.comms.EmailService;

/**
 * UsuarioService
 */
@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepo;

    @Autowired
    PersonaService personaService;

    @Autowired
    EmailService emailService;

    public List<Usuario> getUsuarios() {

        return usuarioRepo.findAll();
    }

    public void save(Usuario u) {

        usuarioRepo.save(u);
    }

    public Usuario buscarPorId(int id) {
        Optional<Usuario> u = usuarioRepo.findById(id);

        if (u.isPresent())
            return u.get();
        return null;
    }

    public Usuario buscarUsuarioPorEmail(String email) {

        Usuario u = usuarioRepo.findByEmail(email);
        return u;
    }

    // Crea la persona, el usuario, una cuenta en pesos y la billetera.
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

        Billetera billetera = new Billetera();

        Cuenta cuenta = new Cuenta();
        // La primera cuenta se crea en pesos argentinos
        cuenta.setMoneda("ARS");

        billetera.agregarCuenta(cuenta);
        billetera.setPersona(persona);

        personaService.save(persona);

        emailService.SendEmail(u.getEmail(), "Bienvenida a la Billetera Virtual!!!",
                "Hola " + persona.getNombre() + "\nBienvenida a este hermoso proyecto hecho con mucho amor\n");

        return u;

    }

    public Usuario buscarPorUsername(String username) {

        Usuario u = usuarioRepo.findByUsername(username);
        return u;

    }

    public void login(String username, String password) {

        Usuario u = usuarioRepo.findByUsername(username);

        if (u == null || !u.getPassword().equals(Crypto.encrypt(password, u.getUsername()))) {

            throw new BadCredentialsException("Usuario o contraseña invalida");
        }

    }

}