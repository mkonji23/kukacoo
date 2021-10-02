package com.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * http://localhost:8080/v2/api-docs
 * http://localhost:8080/swagger-resources/configuration/ui
 * http://localhost:8080/swagger-resources/configuration/security
 * http://localhost:8080/swagger-ui/index.html
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig{

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());

    }

    private ApiInfo apiInfo() {
        String description = "Welcome Log Company";
        return new ApiInfoBuilder()
                .title("SWAGGER TEST2")
                .description(description)
                .version("1.0")
                .build();
    }
    
    

}