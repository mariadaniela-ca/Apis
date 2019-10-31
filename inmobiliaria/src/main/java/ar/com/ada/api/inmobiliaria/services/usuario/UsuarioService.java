package ar.com.ada.api.inmobiliaria.services.usuario;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import ar.com.ada.api.inmobiliaria.entities.inmobiliaria.Inmobiliaria;
import ar.com.ada.api.inmobiliaria.entities.persona.Locador;
import ar.com.ada.api.inmobiliaria.entities.persona.Locatario;
import ar.com.ada.api.inmobiliaria.entities.usuario.Usuario;
import ar.com.ada.api.inmobiliaria.repositorys.inmobiliaria.InmobiliariaRepository;
import ar.com.ada.api.inmobiliaria.repositorys.persona.LocadorRepository;
import ar.com.ada.api.inmobiliaria.repositorys.persona.LocatarioRepository;
import ar.com.ada.api.inmobiliaria.repositorys.usuario.UsuarioRepository;
import ar.com.ada.api.inmobiliaria.security.Crypto;
import ar.com.ada.api.inmobiliaria.services.inmobiliaria.InmobiliariaService;
import ar.com.ada.api.inmobiliaria.services.persona.LocadorService;
import ar.com.ada.api.inmobiliaria.services.persona.LocatarioService;

/**
 * UsuarioService
 */
@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repoUsuario;

    @Autowired
    InmobiliariaRepository repoInmobiliaria;

    @Autowired
    LocatarioRepository repoLocatario;

    @Autowired
    InmobiliariaService inmobiliariaService;

    @Autowired
    LocadorRepository repoLocador;

    @Autowired
    LocatarioService locatarioService;

    public void save(Usuario u) {
        repoUsuario.save(u);
    }

    public Usuario agregarUsuarioInmobiliaria(String nombre, String direccion, String cuit, String email,
            String password) {

        Inmobiliaria i = new Inmobiliaria();
        Usuario u = new Usuario();

        i.setNombre(nombre);
        i.setDireccion(direccion);
        i.setCuit(cuit);
        i.setEmail(email);

        u.setEmail(i.getEmail());
        u.setUsername(i.getEmail());
        u.setPassword(Crypto.encrypt(password, u.getEmail()));
        u.setInmobiliaria(i);

        repoInmobiliaria.save(i);
        repoUsuario.save(u);
        return u;
    }

    public Usuario agregarUsuarioLocatario(String nombre, String dni, int telefono, String direccion, String email,
            String password) {

        Locatario l = new Locatario();
        Usuario u = new Usuario();

        l.setNombre(nombre);
        l.setDni(dni);
        l.setTelefono(telefono);
        l.setDireccion(direccion);
        l.setEmail(email);

        repoLocatario.save(l);

        u.setEmail(l.getEmail());
        u.setUsername(l.getEmail());
        u.setPassword(Crypto.encrypt(password, u.getEmail()));
        u.setLocatario(l);

        repoUsuario.save(u);
        return u;
    }

    public Usuario agregarUsuarioLocador(String nombre, String dni, int telefono, String direccion, String email,
            String password) {

       Locador l = new Locador();
        Usuario u = new Usuario();

        l.setNombre(nombre);
        l.setDni(dni);
        l.setTelefono(telefono);
        l.setDireccion(direccion);
        l.setEmail(email);

        repoLocador.save(l);

        u.setEmail(l.getEmail());
        u.setUsername(l.getEmail());
        u.setPassword(Crypto.encrypt(password, u.getEmail()));
        u.setLocador(l);

        repoUsuario.save(u);
        return u;
    }


    public List<Usuario> getUsuarios() {

        return repoUsuario.findAll();
    }

    public Usuario buscarPorId(int id) {

        Optional<Usuario> u = repoUsuario.findById(id);

        if (u.isPresent())
            return u.get();
        return null;
    }

    public Usuario buscarPorEmail(String email) {
        return repoUsuario.findByEmail(email);
    }

    public Usuario actualizarEmailDeUsuario(int id, String email) {
        Usuario u = buscarPorId(id);
        u.setEmail(email);
        repoUsuario.save(u);

        return u;
    }

    /*
     * public void login(String username, String password) {
     * 
     * Usuario u = repoUsuario.findByUsername(username);
     * 
     * if(u == null || !u.getPassword().equals(Crypto.encrypt(password,
     * u.getUsername()))) {
     * 
     * throw new BadCredentialsException("Usuario o contraseña invalida"); }
     * 
     * }
     */

    public Usuario buscarPorUsername(String username) {

        Usuario u = repoUsuario.findByUsername(username);
        return u;

    }

    public void login(String username, String password) {

        Usuario u = repoUsuario.findByUsername(username);

        if (u == null || !u.getPassword().equals(Crypto.encrypt(password, u.getUsername()))) {

            throw new BadCredentialsException("Usuario o contraseña invalida");
        }

    }

}