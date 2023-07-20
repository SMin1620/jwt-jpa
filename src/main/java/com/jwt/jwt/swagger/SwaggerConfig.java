package com.jwt.jwt.swagger;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI swaggerApi() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("몽, 팔레트 jwt")
                        .description("몽, 팔레트 jwt")
                        .version("1.0.0"));
    }
}
