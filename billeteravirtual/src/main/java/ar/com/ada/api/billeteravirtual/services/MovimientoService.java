package ar.com.ada.api.billeteravirtual.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.billeteravirtual.entities.Movimiento;
import ar.com.ada.api.billeteravirtual.repo.MovimientoRepository;

/**
 * MovimientoService
 */
@Service
public class MovimientoService {

    @Autowired
    MovimientoRepository movimientoRepo;

    public List<Movimiento> getMovimientos() {
        return movimientoRepo.findAll();
    }
}