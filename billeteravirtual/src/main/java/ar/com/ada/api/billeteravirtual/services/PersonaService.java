package ar.com.ada.api.billeteravirtual.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.billeteravirtual.entities.Persona;
import ar.com.ada.api.billeteravirtual.repo.PersonaRepository;

/**
 * PersonaService
 */
@Service
public class PersonaService {

    @Autowired
    PersonaRepository personaRepo;

    //Trae una lista de personas
    public List<Persona> getPersonas() {

        return personaRepo.findAll();
    }

    public Persona buscarPorNombre(String nombre) {
        return personaRepo.findByNombre(nombre);
    }

    public Persona buscarPorDni(String dni) {
        return personaRepo.findByDni(dni);
    }

    public Persona buscarPorId(int id) {
        Optional<Persona> p = personaRepo.findById(id);

        if (p.isPresent())
            return p.get();
        return null;
    }

    public void save(Persona p) {
        personaRepo.save(p);

    }

    public Persona crearPersona(String nombre, String dni, int edad, String email){
        Persona p = new Persona();

        p.setNombre(nombre);
        p.setDni(dni);
        p.setEdad(edad);
        p.setEmail(email);

        personaRepo.save(p);

        return p;
    }

}