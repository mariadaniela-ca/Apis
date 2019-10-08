package ar.com.ada.api.billeteravirtual.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.billeteravirtual.entities.Billetera;
import ar.com.ada.api.billeteravirtual.repo.BilleteraRepository;

/**
 * BilleteraService
 */
@Service
public class BilleteraService {

  @Autowired
  BilleteraRepository billeteraRepo;

  //Busca una billetera por su id
    public Billetera buscarPorId(int id) {
        Optional<Billetera> b = billeteraRepo.findById(id);

        if (b.isPresent())
            return b.get();
        return null;
    }
}