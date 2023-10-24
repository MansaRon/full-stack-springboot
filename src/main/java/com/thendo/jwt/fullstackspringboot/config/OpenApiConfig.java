package com.thendo.jwt.fullstackspringboot.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    public OpenAPI customOpenApi() {
        Server server = new Server()
                .url("localhost:8080")
                .description("Localhost Server URL");

        Contact contact = new Contact()
                .email("kramashia101@gmail.com")
                .name("Thendo Ramashia");

        Info info = new Info()
                .title("Grocery App API")
                .description("A grocery management application for tracking what items are purchased")
                .termsOfService("terms")
                .contact(contact)
                .license(new License().name("GNU"))
                .version("1.0");

        return new OpenAPI().info(info).addServersItem(server);
    }
}
