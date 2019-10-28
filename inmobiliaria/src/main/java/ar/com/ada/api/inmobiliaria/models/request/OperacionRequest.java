package ar.com.ada.api.inmobiliaria.models.request;

import java.math.BigDecimal;
import java.util.*;

/**
 * OperacionRequest
 */
public class OperacionRequest {

    public BigDecimal monto;

    public Date fecha;

    public String tipo;

    public int inmuebleId;

    public int usuarioId;
}