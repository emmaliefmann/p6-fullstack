package com.openclassrooms.mddapi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info =@Info(
                title = "Orion - Monde du Dev (MDD)",
                description = "Project 6 for Fullstack developer degree, created by Emma Liefmann"
        )
)
public class SwaggerConfig {
}
