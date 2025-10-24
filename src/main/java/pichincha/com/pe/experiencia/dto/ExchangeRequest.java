package pichincha.com.pe.experiencia.dto;


import java.math.BigDecimal;

public record ExchangeRequest(
        Long idUsuarioGorest,
        BigDecimal monto,
        String monedaOrigen,
        String monedaDestino
) {}