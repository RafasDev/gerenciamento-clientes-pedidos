package com.projetosDoRafael.gerenciamento_clientes_pedidos;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableCaching
@EnableWebMvc
@OpenAPIDefinition
@SpringBootApplication
public class GerenciamentoClientesPedidosApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciamentoClientesPedidosApplication.class, args);
	}

}
