package com.projetosDoRafael.gerenciamento_clientes_pedidos.repository;

import com.projetosDoRafael.gerenciamento_clientes_pedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository  extends JpaRepository<Pedido, Long> {
}
