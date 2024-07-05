package com.planodesaude.teste_ekan;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BeneficiariosApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeneficiariosApiApplication.class, args);
    }
 @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public-api")
                .pathsToMatch("/beneficiarios/**", "/documentos/**")
                .build();
    }
    
}
