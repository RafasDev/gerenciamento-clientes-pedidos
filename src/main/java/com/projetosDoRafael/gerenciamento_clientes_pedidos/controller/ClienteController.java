package com.projetosDoRafael.gerenciamento_clientes_pedidos.controller;

import com.projetosDoRafael.gerenciamento_clientes_pedidos.model.Cliente;
import com.projetosDoRafael.gerenciamento_clientes_pedidos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        return clienteRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cliente criar(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteRepository.findById(id)
                //Só pra deixar claro o "c" se refere ao cliente
                .map(c -> {
                    c.setNome(cliente.getNome());
                    c.setCpf(cliente.getCpf());
                    c.setId(cliente.getId());
                    c.setTelefone(cliente.getTelefone());
                    c.setEmail(cliente.getEmail());
                    clienteRepository.save(c);
                    return ResponseEntity.ok(c);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable Long id) {
        return clienteRepository.findById(id)
                .map(c -> {
                    clienteRepository.delete(c);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}