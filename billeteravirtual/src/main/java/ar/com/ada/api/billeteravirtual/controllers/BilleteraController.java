package ar.com.ada.api.billeteravirtual.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ar.com.ada.api.billeteravirtual.entities.*;
import ar.com.ada.api.billeteravirtual.models.request.MovimientoRequest;
import ar.com.ada.api.billeteravirtual.models.response.MovimientoResponse;
import ar.com.ada.api.billeteravirtual.services.BilleteraService;


/**
 * BilleteraController
 */
@RestController
public class BilleteraController {
    @Autowired
    BilleteraService billeteraService;

    @GetMapping("/billeteras/{id}")
    public Billetera getBilleteraById(@PathVariable int id) {

        Billetera b = billeteraService.buscarPorId(id);
        return b;
    }

    @PostMapping("/billeteras/{id}/transferencias")
    public MovimientoResponse transferencia(@PathVariable int id, @RequestBody MovimientoRequest req) {

        MovimientoResponse r = new MovimientoResponse();

        Billetera b = billeteraService.buscarPorId(id);
        

        billeteraService.transferirDinero(b,req.importe, req.email, req.conceptoDeOperacion, req.tipoDeOperacion,req.moneda);

        r.message = "Transferencia realizada con éxito";

        return r;
    }

    @GetMapping("/billeteras/{id}/saldo")
    public BigDecimal getSaldo(@PathVariable int id) {

        BigDecimal b = billeteraService.getSaldo(id);
        return b;
    }

    @GetMapping("/billeteras/{id}/saldoDisponible")
    public BigDecimal getSaldoDisponible(@PathVariable int id) {

        BigDecimal b = billeteraService.getSaldoDisponible(id);
        return b;
    }

    @GetMapping("/billeteras/{id}/movimientos")
    public List<Movimiento> getMovimientos(@PathVariable int id){
        List<Movimiento> listaMovimientos = billeteraService.movimientos(id);

        return listaMovimientos;

    }

}
