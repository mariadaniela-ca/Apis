package ar.com.ada.api.inmobiliaria.services.persona;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.inmobiliaria.entities.persona.Locador;
import ar.com.ada.api.inmobiliaria.repositorys.persona.LocadorRepository;

/**
 * LocadorService
 */
@Service
public class LocadorService {

    @Autowired
    LocadorRepository repoLocador;

    public Locador registrarLocador(String nombre, String dni, String email, int telefono, String direccion){

        Locador l = new Locador();
        l.setNombre(nombre);
        l.setDni(dni);
        l.setEmail(email);
        l.setTelefono(telefono);
        l.setDireccion(direccion);
        
        repoLocador.save(l);

        return l;
    }

    public void saveLocador(Locador locador) {
        repoLocador.save(locador);
    }

    public List<Locador> getLocadores(){
        return repoLocador.findAll();
    }

    public Locador buscarLocadorPorId(int id) {
        Optional<Locador> l = repoLocador.findById(id);

        if (l.isPresent())
            return l.get();
        return null;
    }

    public Locador buscarLocadorPorDni(String dni) {

        Locador l = repoLocador.findByDni(dni);

        return l;
    }

    public Locador actualizarLocadorPorDni(String dni, String email, int telefono, String direccion){

        Locador l = buscarLocadorPorDni(dni);
        l.setEmail(email);
        l.setTelefono(telefono);
        l.setDireccion(direccion);

        repoLocador.save(l);

        return l;
    }

    public Locador darDeBajaLocador(int id){

        Locador l = buscarLocadorPorId(id);
        l.setDireccion("NULL");
        repoLocador.save(l);

        return l;
    }


}