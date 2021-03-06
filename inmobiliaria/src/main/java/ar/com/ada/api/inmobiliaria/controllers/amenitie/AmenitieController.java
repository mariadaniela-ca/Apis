package ar.com.ada.api.inmobiliaria.controllers.amenitie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.inmobiliaria.entities.amenitie.AmenitieDeInmueble;
import ar.com.ada.api.inmobiliaria.models.request.AmenitieRequest;
import ar.com.ada.api.inmobiliaria.models.response.PostResponse;
import ar.com.ada.api.inmobiliaria.services.amenitie.AmenitieService;

/**
 * AmenitieController
 */
@RestController
public class AmenitieController {

    @Autowired
    AmenitieService amenitieService;

    @PostMapping("/amenities")
    public PostResponse postRegistrarAmenitie(@RequestBody AmenitieRequest req) {

        PostResponse a = new PostResponse();
        amenitieService.registrarAmenitie(req.inmuebleId,req.ascensor,req.gimnasio,req.pileta);
        a.isOk = true;
        a.message = "Amenitie registrada con éxito";
        return a;

    }

    @GetMapping("/amenities")
    public List<AmenitieDeInmueble> getAmenities() {

        List<AmenitieDeInmueble> listaAmenities = amenitieService.getAmenities();

        return listaAmenities;
    }

    @GetMapping("/amenities/{id}")
    public AmenitieDeInmueble getAmenitieById(@PathVariable int id) {

        AmenitieDeInmueble amenitie = amenitieService.buscarAmenitiePorId(id);
        return amenitie;

    }

}