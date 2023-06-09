package com.example.springbootrestapi;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Spring  Boot Rest API Documentation",
                description = "Spring  Boot Rest API Documentation",
                version = "v1.0",
                contact = @Contact(
                        name = "Ibrahim",
                        email = "ibrahimozigis0@gmail.com"
                ),
                license =  @License(
                        name = "Apache 2.0"
                )
        ),
        externalDocs =  @ExternalDocumentation(
                description = "Spring boot User Manageniment Documentation"
        )
)
public class SpringbootRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRestApiApplication.class, args);
    }
    @Bean
    public ModelMapper modelMapper(){
        return  new ModelMapper();
    }
}
