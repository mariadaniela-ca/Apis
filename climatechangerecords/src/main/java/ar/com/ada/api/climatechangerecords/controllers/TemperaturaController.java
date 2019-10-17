package ar.com.ada.api.climatechangerecords.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.climatechangerecords.entities.Temperatura;
import ar.com.ada.api.climatechangerecords.models.request.TemperaturaRequest;
import ar.com.ada.api.climatechangerecords.models.response.TemperaturaResponse;
import ar.com.ada.api.climatechangerecords.services.TemperaturaService;

/**
 * TemperaturaController
 */
@RestController
public class TemperaturaController {

    @Autowired
    TemperaturaService temperaturaService;

    @PostMapping("/temperaturas")
    public TemperaturaResponse postRegistroTemperatura(@RequestBody TemperaturaRequest req) {

        TemperaturaResponse response = new TemperaturaResponse();
        temperaturaService.registrarTemperatura(req.codigoPais, req.anioTemperatura, req.grados);

        response.message = "Temperatura registrada con exito";
        return response;

    }

    @GetMapping("/temperaturas")
    public List<Temperatura> getTemperaturas() {

        List<Temperatura> listaTemperaturas = temperaturaService.getTemperaturas();

        return listaTemperaturas;
    }

    @GetMapping("/temperaturas/paises/{codigoPais}")
    public List<Temperatura> getTemperatuasPorCodigoPais(@PathVariable int codigoPais) {

        List<Temperatura> listaTemperaturas = temperaturaService.getTemperaturaPorCodigoPais(codigoPais);

        return listaTemperaturas;

    }

    @GetMapping("temperaturas/anios/{anio}")

    @DeleteMapping("temperaturas/{id}")
    public Temperatura eliminarTemperaturaPorId(@PathVariable int id) {

        Temperatura t = temperaturaService.EliminarTemperaturaPorId(id);

        return t;
    }

}