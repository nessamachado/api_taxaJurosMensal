package com.vanessa.api_taxaJurosMensal.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class SwaggerConfig {

    @Bean
    public OpenAPI customApi(){
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Bacen API REST")
                        .description("Taxa de Juros Mensal")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Vanessa Machado")
                                .email("van.a.s@hotmail.com")));
    }
}
