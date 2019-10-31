package ar.com.ada.api.inmobiliaria.services.amenitie;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.inmobiliaria.entities.amenitie.AmenitieDeInmueble;
import ar.com.ada.api.inmobiliaria.entities.inmueble.Inmueble;
import ar.com.ada.api.inmobiliaria.repositorys.amenitie.AmenitieRepository;
import ar.com.ada.api.inmobiliaria.services.inmueble.InmuebleService;

/**
 * AmenitieService
 */
@Service
public class AmenitieService {

    @Autowired
    AmenitieRepository repoAmenitie;

    @Autowired
    InmuebleService inmuebleService;

    public void guardarAmenitie(AmenitieDeInmueble amenitie) {
        repoAmenitie.save(amenitie);
    }

    public AmenitieDeInmueble registrarAmenitie(int inmuebleId, String ascensor, String pileta, String gimnasio) {
        AmenitieDeInmueble amenitie = new AmenitieDeInmueble();

        Inmueble i = inmuebleService.buscarInmueblePorId(inmuebleId);
    
        amenitie.setAscensor(ascensor);
        amenitie.setGimnasio(gimnasio);
        amenitie.setPileta(pileta);
        amenitie.setInmueble(i);

        repoAmenitie.save(amenitie);
        return amenitie;

    }

    public List<AmenitieDeInmueble> getAmenities() {

        return repoAmenitie.findAll();
    }

    public AmenitieDeInmueble buscarAmenitiePorId(int id) {
        Optional<AmenitieDeInmueble> amenitie = repoAmenitie.findById(id);

        if (amenitie.isPresent())
            return amenitie.get();
        return null;

    }
}