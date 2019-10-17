package ar.com.ada.api.climatechangerecords.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.climatechangerecords.entities.Pais;
import ar.com.ada.api.climatechangerecords.repo.PaisRepository;

/**
 * PaisService
 */
@Service
public class PaisService {

    @Autowired
    PaisRepository paisRepo;

    public void guardarPais(Pais pais) {
        paisRepo.save(pais);
    }

    public Pais registrarPais(int codigoPais, String nombre ) {
        Pais pais = new Pais();
        pais.setCodigoPaisId(codigoPais);
        pais.setNombre(nombre);
       
        paisRepo.save(pais);

        return pais;
    }
    public List<Pais> getPaises() {

        return paisRepo.findAll();
    }
      public Pais buscarCodigoId(int id) {
        Optional<Pais> p = paisRepo.findById(id);

        if (p.isPresent())
            return p.get();
        return null;
    }

     public Pais actualizarNombrePaisporId(int id, String nombre){

        Pais p = buscarCodigoId(id);
        p.setNombre(nombre);
       
        paisRepo.save(p);

        return p;
    }

    
    


    
}