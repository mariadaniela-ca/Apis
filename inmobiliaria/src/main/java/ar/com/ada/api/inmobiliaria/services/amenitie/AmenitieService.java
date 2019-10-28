package ar.com.ada.api.inmobiliaria.services.amenitie;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.inmobiliaria.entities.amenitie.Amenitie;
import ar.com.ada.api.inmobiliaria.repositorys.amenitie.AmenitieRepository;

/**
 * AmenitieService
 */
@Service
public class AmenitieService {

    @Autowired
    AmenitieRepository repoAmenitie;

    public void guardarAmenitie(Amenitie amenitie) {
        repoAmenitie.save(amenitie);
    }

    public Amenitie registrarAmenitie(String descripcion) {
        Amenitie amenitie = new Amenitie();

        amenitie.setDescripcion(descripcion);

        repoAmenitie.save(amenitie);
        return amenitie;

    }

    public List<Amenitie> getAmenities() {

        return repoAmenitie.findAll();
    }

    public Amenitie buscarAmenitiePorId(int id) {
        Optional<Amenitie> amenitie = repoAmenitie.findById(id);

        if (amenitie.isPresent())
            return amenitie.get();
        return null;

    }
}