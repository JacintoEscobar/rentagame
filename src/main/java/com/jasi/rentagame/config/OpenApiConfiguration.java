package com.jasi.rentagame.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI defineOpenApi() {
        Server server = new Server();
        server.setUrl("http://localhost:8090");
        server.setDescription("Development");

        Contact myContact = new Contact();
        myContact.setName("Jacinto Escobar Quezada");
        myContact.setEmail("jacesc10@gmail.com");

        Info information = new Info()
                .title("Rental Games System API")
                .version("1.0.0")
                .description("This API exposes endpoints to manage videogames.")
                .contact(myContact);
        return new OpenAPI().info(information).servers(List.of(server));
    }
}
