package com.projetosDoRafael.gerenciamento_clientes_pedidos.repository;


import com.projetosDoRafael.gerenciamento_clientes_pedidos.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT c FROM Cliente c WHERE " +
            "(:nome IS NULL OR c.nome LIKE %:nome%) AND " +
            "(:cpf IS NULL OR c.cpf = :cpf) AND " +
            "(:email IS NULL OR c.email LIKE %:email%) AND " +
            "(:telefone IS NULL OR c.telefone = :telefone)")
    List<Cliente> pesquisaComFiltroCliente(
            @Param("nome") String nome,
            @Param("cpf") Integer cpf,
            @Param("email") String email,
            @Param("telefone") Integer telefone);
}

