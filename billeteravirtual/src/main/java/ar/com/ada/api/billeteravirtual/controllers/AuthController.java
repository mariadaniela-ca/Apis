package ar.com.ada.api.billeteravirtual.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.billeteravirtual.entities.Persona;
import ar.com.ada.api.billeteravirtual.models.request.RegistrationRequest;
import ar.com.ada.api.billeteravirtual.models.response.RegistrationResponse;
import ar.com.ada.api.billeteravirtual.services.PersonaService;


/**
 * AuthController
 */
@RestController
public class AuthController {
    
    @Autowired
    PersonaService personaService;


    @PostMapping("auth/register")
    public RegistrationResponse postRegisterUser(@RequestBody RegistrationRequest req){


        RegistrationResponse r = new RegistrationResponse();

        Persona p = new Persona();
        p.setNombre(req.nombre);
        p.setDni(req.dni);
        p.setEdad(req.edad);
        p.setEmail(req.email);
        r.isOk = true;
        r.message = "Te registraste con exito";

        personaService.save(p);

        return r;
        
    }
    
}