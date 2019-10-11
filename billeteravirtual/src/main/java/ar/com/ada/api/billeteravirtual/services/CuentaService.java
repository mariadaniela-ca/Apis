package ar.com.ada.api.billeteravirtual.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.billeteravirtual.entities.Cuenta;

/**
 * CuentaService
 */
@Service
public class CuentaService {

   @Autowired
   CuentaService cuentaService;

   public void save(Cuenta c){
       cuentaService.save(c);
       
   }

}