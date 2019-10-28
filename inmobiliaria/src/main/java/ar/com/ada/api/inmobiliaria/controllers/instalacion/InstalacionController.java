package ar.com.ada.api.inmobiliaria.controllers.instalacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.inmobiliaria.services.instalacion.InstalacionService;

/**
 * InstalacionController
 */
@RestController
public class InstalacionController {

    @Autowired
    InstalacionService instalacionService;
    
}