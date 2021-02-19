package com.assignment.expressionevaluator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Project: expression-evaluator
 * Package: com.assignment.expressionevaluator.config
 * <p>
 * User: Rohit Patidar
 * Date: 19-02-2021
 * <p>
 */
@Configuration
public class SwaggerConfig {

    private static final String BASE_PACKAGE = "com.assignment.expressionevaluator";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build();
    }
}
