package pichincha.com.pe.experiencia.service;



import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import pichincha.com.pe.experiencia.dto.TipoCambioSoporteRequest;
import pichincha.com.pe.experiencia.dto.TipoCambioSoporteResponse;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SoporteService {
    private final WebClient soporteWebClient;

    public Mono<TipoCambioSoporteResponse> registrarCambio(TipoCambioSoporteRequest request) {
        return soporteWebClient.post()
                .uri("/registros-cambio")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(TipoCambioSoporteResponse.class);
    }
}