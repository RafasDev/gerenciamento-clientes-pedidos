package com.projetosDoRafael.gerenciamento_clientes_pedidos.service;

import com.projetosDoRafael.gerenciamento_clientes_pedidos.model.Pedido;
import com.projetosDoRafael.gerenciamento_clientes_pedidos.repository.PedidoRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> buscarPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    public Pedido criar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Optional<Pedido> atualizar(Long id, Pedido pedidoAtualizado) {
        return pedidoRepository.findById(id).map(pedido -> {
            pedido.setCliente(pedidoAtualizado.getCliente());
            pedido.setProdutos(pedidoAtualizado.getProdutos());
            pedido.setDataPedido(pedidoAtualizado.getDataPedido());
            pedido.setTotal(pedidoAtualizado.getTotal());
            return pedidoRepository.save(pedido);
        });
    }

    public boolean deletar(Long id) {
        return pedidoRepository.findById(id).map(p -> {
            pedidoRepository.delete(p);
            return true;
        }).orElse(false);
    }
}

