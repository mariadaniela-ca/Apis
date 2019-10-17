package ar.com.ada.api.climatechangerecords.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.climatechangerecords.entities.Pais;
import ar.com.ada.api.climatechangerecords.entities.Temperatura;
import ar.com.ada.api.climatechangerecords.repo.TemperaturaRepository;

/**
 * TemperaturaService
 */
@Service
public class TemperaturaService {

    @Autowired
    TemperaturaRepository temperaturaRepo;

    @Autowired
    PaisService paisService;

    public void guardarTemperatura(Temperatura temperatura) {
        temperaturaRepo.save(temperatura);
    }

    public Temperatura buscarTemperaturaPorId(int id) {
        Optional<Temperatura> t = temperaturaRepo.findById(id);

        if (t.isPresent())
            return t.get();
        return null;

    }

    public Temperatura registrarTemperatura(int codigoPais, int anioTemperatura, Double grados) {
        Pais pais = paisService.buscarCodigoId(codigoPais);

        Temperatura t = new Temperatura();
        t.setPais(pais);
    
        t.setAnioTemperatura(anioTemperatura);
        t.setGrados(grados);

        temperaturaRepo.save(t);

        return t;

    }

    public List<Temperatura> getTemperaturas() {

        return temperaturaRepo.findAll();
    }

    public Temperatura EliminarTemperaturaPorId(int id) {

        Temperatura t = buscarTemperaturaPorId(id);
        t.setAnioTemperatura(0);
        temperaturaRepo.save(t);

        return t;
    }

    public List<Temperatura> getTemperaturaPorCodigoPais(int id) {

        Pais p = paisService.buscarCodigoId(id);

        List<Temperatura> listaTemperaturas = p.getTemperaturas();

        return listaTemperaturas;

    }

}