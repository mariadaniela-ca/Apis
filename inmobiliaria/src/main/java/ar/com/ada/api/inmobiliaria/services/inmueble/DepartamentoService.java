package ar.com.ada.api.inmobiliaria.services.inmueble;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.inmobiliaria.repositorys.inmobiliaria.InmobiliariaRepository;

/**
 * DepartamentoService
 */
@Service
public class DepartamentoService {

    @Autowired
    InmobiliariaRepository repoInmobiliaria;
    
}