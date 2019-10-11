package ar.com.ada.api.billeteravirtual.models.request;

import java.math.BigDecimal;

/**
 * MovimientoRequest
 */
public class MovimientoRequest {

    public BigDecimal importe;    
    public String email;
    public String tipoDeOperacion;
    public String conceptoDeOperacion;
    public String detalle;
    public String moneda;
    
}