package ar.com.ada.api.billeteravirtual.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import ar.com.ada.api.billeteravirtual.models.request.*;
import ar.com.ada.api.billeteravirtual.models.response.*;
import ar.com.ada.api.billeteravirtual.security.jwt.JWTTokenUtil;
import ar.com.ada.api.billeteravirtual.services.*;
import ar.com.ada.api.billeteravirtual.sistema.comms.EmailService;;


/**
 * AuthController
 */
@RestController
public class AuthController {

    @Autowired
    PersonaService personaService;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    private JWTTokenUtil jwtTokenUtil;

    @Autowired
    private JWTUserDetailsService userDetailsService;

    @Autowired
    private EmailService emailService;



    //Registro de una persona
    @PostMapping("auth/register")
    public RegistrationResponse postRegisterUser(@RequestBody RegistrationRequest req){


        RegistrationResponse r = new RegistrationResponse();
      
        usuarioService.crearUsuario(req.nombre,req.dni, req.edad,req.email, req.password);
        
        r.isOk = true;
        r.message = "Te registraste con exito";
       
        return r;
        
    }

      @PostMapping("auth/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest authenticationRequest)
            throws Exception {

        usuarioService.login(authenticationRequest.username, authenticationRequest.password);

        final UserDetails userDetails = userDetailsService
            .loadUserByUsername(authenticationRequest.username);

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));

    }

    
}