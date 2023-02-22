package com.springpoc.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket CapitalApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.springpoc.app"))
                .paths(PathSelectors.ant("/.*"))
                .build();

    }

//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("Spring Boot API With Swagger")
//                .description("Spring Boot API for my application")
//                .version("1.0.0")
//                .contact(new Contact("Demo", "https://demo.com", "demo@example.com"))
//                .build();
//    }
}
