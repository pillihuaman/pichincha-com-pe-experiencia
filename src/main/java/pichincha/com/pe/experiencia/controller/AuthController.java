package pichincha.com.pe.experiencia.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import pichincha.com.pe.experiencia.dto.AuthRequest;
import pichincha.com.pe.experiencia.dto.AuthResponse;
import pichincha.com.pe.experiencia.security.JwtUtil;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "API de Experiencia - Autenticación", description = "Generación de JWT para pruebas")
public class AuthController {

    private final JwtUtil jwtUtil;

    @PostMapping("/token")
    public Mono<AuthResponse> getToken(@RequestBody AuthRequest request) {
        String token = jwtUtil.generateToken(request.username());
        return Mono.just(new AuthResponse(token));
    }
}