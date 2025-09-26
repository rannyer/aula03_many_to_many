package com.example.projeto_many_to_many.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("(☞ﾟヮﾟ)☞ API CONTROLE DE ALUNOS ☜(ﾟヮﾟ☜)")
                        .version("1.0")
                        .description("API para gerenciar alunos com paginação e filtros"));
    }
}
