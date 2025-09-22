package com.divisas.guardadito_go.microservice_ggo_cuentas.config;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DotenvConfig {

  @PostConstruct
  public void loadEnvVariables() {
    Dotenv dotenv = Dotenv.configure().directory(".").ignoreIfMissing().load();

    dotenv
        .entries()
        .forEach(
            entry -> {
              System.setProperty(entry.getKey(), entry.getValue());
            });
  }
}
