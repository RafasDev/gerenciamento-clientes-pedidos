package com.projetosDoRafael.gerenciamento_clientes_pedidos.repository;


import com.projetosDoRafael.gerenciamento_clientes_pedidos.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}