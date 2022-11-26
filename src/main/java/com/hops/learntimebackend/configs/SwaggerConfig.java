package com.hops.learntimebackend.configs;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI springOpenAPI() {
        Info info = new Info()
            .title("Title")
            .version("v0.0.1")
            .description("Description");

        return new OpenAPI()
            .components(new Components())
            .info(info);
    }
}
