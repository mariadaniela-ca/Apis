package ar.com.ada.api.inmobiliaria.models.request;

import java.math.BigDecimal;

/**
 * InmuebleRequest
 */
public class InmuebleRequest {

    public String direccion;

    public BigDecimal precio;

    public String estado;

    public double superficie;

    public int antiguedad;
   
    public String tipoInmueble;

    public int id;

    public int amenitieId;

}