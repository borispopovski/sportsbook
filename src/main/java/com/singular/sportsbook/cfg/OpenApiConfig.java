package com.singular.sportsbook.cfg;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
@EnableWebMvc
public class OpenApiConfig {
  
  @Bean
  public GroupedOpenApi api() {
    return GroupedOpenApi.builder()
        .group("sportsbook")
        .pathsToMatch("/**")
        .build();
  }

  @Bean
  public OpenAPI apiInfo() {
    return new OpenAPI().info(new Info().title("sportsbook - REST API")
        .description("SportsBook")
        .version("1.0.0")
        .termsOfService("Singular")
        .license(new License().name("Singular Standard License")
            .url("https://singular.uk/")));
  }

}
