package mx.com.actinver.ms.clients.config;

import java.time.Duration;
import java.util.Objects;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ClientConfig {

    @Bean
    public RestTemplate restTemplateExample(RestTemplateBuilder restTemplateBuilder, Environment env) {
        return restTemplateBuilder
                .setConnectTimeout(Duration.ofMillis(Integer
                        .parseInt(Objects.requireNonNull(env.getProperty("application.client.registrationKeyword.timeout.read")))))
                .setReadTimeout(Duration.ofMillis(Integer
                        .parseInt(Objects.requireNonNull(env.getProperty("application.client.registrationKeyword.timeout.connection")))))
                .build();
    }

}

