package com.projetosDoRafael.gerenciamento_clientes_pedidos.service;

import com.projetosDoRafael.gerenciamento_clientes_pedidos.model.Cliente;
import com.projetosDoRafael.gerenciamento_clientes_pedidos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public List<Cliente> filtrarClientes(String nome, Integer cpf, String email, Integer telefone) {
        return clienteRepository.pesquisaComFiltroCliente(
                nome == null ? "" : nome,
                cpf == null ? null : cpf,
                email == null ? "" : email,
                telefone == null ? null : telefone);
    }



    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente criarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> atualizar(Long id, Cliente clienteAtualizado) {
        return clienteRepository.findById(id).map(cliente -> {
            cliente.setNome(clienteAtualizado.getNome());
            cliente.setCpf(clienteAtualizado.getCpf());
            cliente.setTelefone(clienteAtualizado.getTelefone());
            cliente.setEmail(clienteAtualizado.getEmail());
            return clienteRepository.save(cliente);
        });
    }

    public boolean deletar(Long id) {
        return clienteRepository.findById(id).map(cliente -> {
            clienteRepository.delete(cliente);
            return true;
        }).orElse(false);
    }
}
