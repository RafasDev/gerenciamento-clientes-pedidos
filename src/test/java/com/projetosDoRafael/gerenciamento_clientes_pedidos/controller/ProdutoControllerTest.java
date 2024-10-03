package com.projetosDoRafael.gerenciamento_clientes_pedidos.controller;

import com.projetosDoRafael.gerenciamento_clientes_pedidos.model.Produto;
import com.projetosDoRafael.gerenciamento_clientes_pedidos.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;

@WebMvcTest(ProdutoController.class)
public class ProdutoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProdutoRepository produtoRepository;

    @Test
    public void deveRetornarProdutoPorId() throws Exception {
        Produto produto = new Produto();
        produto.setId(1L);
        produto.setNome("Produto X");
        produto.setPreco(99.90);

        Mockito.when(produtoRepository.findById(1L)).thenReturn(Optional.of(produto));

        mockMvc.perform(get("/api/produtos/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome", is("Produto X")))
                .andExpect(jsonPath("$.preco", is(99.90)));
    }
}
