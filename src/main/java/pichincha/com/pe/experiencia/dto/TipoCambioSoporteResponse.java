package pichincha.com.pe.experiencia.dto;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TipoCambioSoporteResponse(
        Long id,
        String nombreUsuario,
        BigDecimal montoInicial,
        BigDecimal montoFinal,
        String monedaOrigen,
        String monedaDestino,
        BigDecimal tipoCambio,
        LocalDateTime fechaProceso
) {}