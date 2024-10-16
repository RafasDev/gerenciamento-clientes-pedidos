package com.projetosDoRafael.gerenciamento_clientes_pedidos.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Gerenciamento De Clientes E Pedidos")
                        .version("1.1")
                        .description("Documentação da API do meu sistema Gerenciamento De Clientes E Pedidos"));
    }
}