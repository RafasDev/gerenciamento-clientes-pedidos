package com.projetosDoRafael.gerenciamento_clientes_pedidos.service;

import com.projetosDoRafael.gerenciamento_clientes_pedidos.model.Produto;
import com.projetosDoRafael.gerenciamento_clientes_pedidos.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto criar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Optional<Produto> atualizar(Long id, Produto produtoAtualizado) {
        return produtoRepository.findById(id).map(produto -> {
            produto.setNome(produtoAtualizado.getNome());
            produto.setPreco(produtoAtualizado.getPreco());
            produto.setQuantidadeEstoque(produtoAtualizado.getQuantidadeEstoque());
            return produtoRepository.save(produto);
        });
    }

    public boolean deletar(Long id) {
        return produtoRepository.findById(id).map(p -> {
            produtoRepository.delete(p);
            return true;
        }).orElse(false);
    }
}
