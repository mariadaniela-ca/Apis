package ar.com.ada.api.inmobiliaria.models.response;

import java.math.BigDecimal;

/**
 * InmuebleResponse
 */
public class EstadosResponse {

    public int inmuebleId;
    public String tipo;
    public String direccion;
    public int locatarioId;
    public int locadorId;
    public String nombreInmob;
    public String nombreLocador;
    public String email;
    public BigDecimal precio;
    public String estado;
    public BigDecimal monto;
    

    public String message = "";
}