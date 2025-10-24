package pichincha.com.pe.experiencia.service;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import pichincha.com.pe.experiencia.dto.GorestUser;
import pichincha.com.pe.experiencia.exception.UserNotFoundException;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class GorestService {
    private final WebClient gorestWebClient;

    public Mono<GorestUser> findUserById(Long userId) {
        return gorestWebClient.get()
                .uri("/users/{id}", userId)
                .retrieve()
                .onStatus(
                        httpStatus -> httpStatus.equals(HttpStatus.NOT_FOUND),
                        clientResponse -> Mono.error(new UserNotFoundException("Usuario no encontrado en GoRest con ID: " + userId))
                )
                .bodyToMono(GorestUser.class);
    }
}