package ar.com.ada.api.inmobiliaria.services.inmueble;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.inmobiliaria.repositorys.inmobiliaria.InmobiliariaRepository;

/**
 * CasaService
 */
@Service
public class CasaService {

    @Autowired
    InmobiliariaRepository repoInmobiliaria;
    
}