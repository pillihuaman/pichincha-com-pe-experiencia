package pichincha.com.pe.experiencia.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${gorest.api.url}")
    private String gorestUrl;

    @Value("${api.soporte.url}")
    private String soporteUrl;

    @Bean
    public WebClient gorestWebClient() {
        return WebClient.builder().baseUrl(gorestUrl).build();
    }

    @Bean
    public WebClient soporteWebClient() {
        return WebClient.builder().baseUrl(soporteUrl).build();
    }
}