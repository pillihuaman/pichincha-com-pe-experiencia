package pichincha.com.pe.experiencia.dto;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ExchangeResponse(
        Long idOperacion,
        Long idUsuario,
        String nombreUsuario,
        BigDecimal montoInicial,
        BigDecimal montoConTipoCambio,
        String monedaOrigen,
        String monedaDestino,
        BigDecimal tipoCambio,
        LocalDateTime fechaProceso
) {}