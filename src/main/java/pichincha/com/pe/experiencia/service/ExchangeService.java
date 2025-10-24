package pichincha.com.pe.experiencia.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import pichincha.com.pe.experiencia.dto.ExchangeRequest;
import pichincha.com.pe.experiencia.dto.ExchangeResponse;
import pichincha.com.pe.experiencia.dto.TipoCambioSoporteRequest;
import reactor.core.publisher.Mono;
import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ExchangeService {

    private final GorestService gorestService;
    private final SoporteService soporteService;

    public Mono<ExchangeResponse> performExchange(ExchangeRequest request, String auditorUsername) {
        return gorestService.findUserById(request.idUsuarioGorest())
                .flatMap(gorestUser -> {
                    BigDecimal tipoCambio = simularTipoDeCambio(request.monedaOrigen(), request.monedaDestino());
                    String nombreUsuarioParaRegistro = String.format("%s (Auditado por: %s)", gorestUser.name(), auditorUsername);

                    TipoCambioSoporteRequest soporteRequest = new TipoCambioSoporteRequest(
                            nombreUsuarioParaRegistro,
                            request.monto(),
                            request.monedaOrigen(),
                            request.monedaDestino(),
                            tipoCambio
                    );

                    return soporteService.registrarCambio(soporteRequest);
                })
                .map(soporteResponse -> new ExchangeResponse(
                        soporteResponse.id(),
                        request.idUsuarioGorest(),
                        soporteResponse.nombreUsuario(),
                        soporteResponse.montoInicial(),
                        soporteResponse.montoFinal(),
                        soporteResponse.monedaOrigen(),
                        soporteResponse.monedaDestino(),
                        soporteResponse.tipoCambio(),
                        soporteResponse.fechaProceso()
                ));
    }

    private BigDecimal simularTipoDeCambio(String origen, String destino) {
        if ("USD".equals(origen) && "PEN".equals(destino)) return new BigDecimal("3.75");
        if ("PEN".equals(origen) && "USD".equals(destino)) return new BigDecimal("0.27");
        if ("EUR".equals(origen) && "USD".equals(destino)) return new BigDecimal("1.09");
        return BigDecimal.ONE;
    }
}