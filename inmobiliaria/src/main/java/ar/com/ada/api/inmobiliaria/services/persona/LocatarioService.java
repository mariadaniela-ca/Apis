package ar.com.ada.api.inmobiliaria.services.persona;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.inmobiliaria.entities.persona.Locatario;
import ar.com.ada.api.inmobiliaria.entities.usuario.Usuario;
import ar.com.ada.api.inmobiliaria.repositorys.persona.LocatarioRepository;
import ar.com.ada.api.inmobiliaria.services.usuario.UsuarioService;

/**
 * LocatarioService
 */
@Service
public class LocatarioService {

    @Autowired
    LocatarioRepository repoLocatario;

    @Autowired
    UsuarioService usuarioService;

    public Locatario registrarLocatario(String nombre, String dni, String email, int telefono, String direccion){

        Locatario l = new Locatario();
        l.setNombre(nombre);
        l.setDni(dni);
        l.setEmail(email);
        l.setTelefono(telefono);
        l.setDireccion(direccion);
        
        repoLocatario.save(l);

        return l;
    }

    public void saveLocatario(Locatario locatario) {
        repoLocatario.save(locatario);
    }

    public List<Locatario> getLocatarios(){
        return repoLocatario.findAll();
    }

    public Locatario buscarLocatarioPorId(int id) {
        Optional<Locatario> l = repoLocatario.findById(id);

        if (l.isPresent())
            return l.get();
        return null;
    }
    
    public Locatario buscarLocatarioPorDni(String dni) {

        Locatario l = repoLocatario.findByDni(dni);

        return l;
    }

    public Locatario actualizarLocatarioPorDni(String dni, String email, int telefono, String direccion){

        Locatario l = buscarLocatarioPorDni(dni);
        l.setEmail(email);
        l.setTelefono(telefono);
        l.setDireccion(direccion);

        repoLocatario.save(l);

        return l;
    }
    public Locatario buscarLocatarioConUsuario(int id){
        Usuario u = usuarioService.buscarPorId(id);
        Locatario l = u.getLocatario();
        return l;
    }

    public Locatario darDeBajaLocatario(int id){

        Locatario l = buscarLocatarioPorId(id);
        l.setDireccion("NULL");
        repoLocatario.save(l);

        return l;
    }
}