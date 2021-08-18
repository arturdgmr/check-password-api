package br.com.artur.check.password.api.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("local")
public class SwaggerConfiguration {

    @Autowired
    private BuildProperties buildProperties;

    @Bean
    public OpenAPI api () {
        return new OpenAPI()
                .addServersItem(new Server().url("/"))
                .info(apiInfo());
    }

    private Info apiInfo () {
        return new Info()
                .title("Check Password API")
                .version(buildProperties.getVersion())
                .description("API de validação de senha");
    }
}
