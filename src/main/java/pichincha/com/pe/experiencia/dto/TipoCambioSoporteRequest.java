package pichincha.com.pe.experiencia.dto;


import java.math.BigDecimal;

public record TipoCambioSoporteRequest(
        String nombreUsuario,
        BigDecimal montoInicial,
        String monedaOrigen,
        String monedaDestino,
        BigDecimal tipoCambio
) {}