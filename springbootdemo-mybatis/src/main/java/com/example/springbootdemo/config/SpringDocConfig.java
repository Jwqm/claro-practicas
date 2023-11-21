package com.example.springbootdemo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;


@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "springdoc.info")
@Validated
public class SpringDocConfig {
    @NotNull
    @NotBlank
    private String nameContact;
    @NotNull
    @NotBlank
    private String mailContact;
    @NotNull
    @NotBlank
    private String title;
    @NotNull
    @NotBlank
    private String description;
    @NotNull
    @NotBlank
    private String version;

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title(title)
                        .description(description)
                        .version(version)
                        .contact(new Contact()
                                .name(nameContact)
                                .email(mailContact)
                        ));
    }
}
