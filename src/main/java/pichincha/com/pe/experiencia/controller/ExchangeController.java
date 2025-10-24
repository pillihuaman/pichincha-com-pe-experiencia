package pichincha.com.pe.experiencia.controller;



import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import pichincha.com.pe.experiencia.dto.ExchangeRequest;
import pichincha.com.pe.experiencia.dto.ExchangeResponse;
import pichincha.com.pe.experiencia.service.ExchangeService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/exchange")
@RequiredArgsConstructor
@Tag(name = "API de Experiencia - Tipo de Cambio", description = "Endpoint principal para realizar el cambio de moneda")
public class ExchangeController {

    private final ExchangeService exchangeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Realiza una operación de tipo de cambio", security = @SecurityRequirement(name = "bearerAuth"))
    public Mono<ExchangeResponse> performExchange(@RequestBody ExchangeRequest request) {
        return ReactiveSecurityContextHolder.getContext()
                .map(ctx -> ctx.getAuthentication().getName())
                .flatMap(auditorUsername -> exchangeService.performExchange(request, auditorUsername));
    }
}