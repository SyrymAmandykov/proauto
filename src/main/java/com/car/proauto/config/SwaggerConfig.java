package com.car.proauto.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "proauto",
                version = "v1.0 BETA",
                contact = @Contact(
                        name = "Syrym", email = "cloudkazakhstan@gmail.com", url = "https://github.com/SyrymAmandykov/proauto"
                ),
                license = @License(
                        name = "Apache 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0"
                ),
                termsOfService = "test",
                description = "Simple project for REST API overview"
        )
)
public class SwaggerConfig {
}
