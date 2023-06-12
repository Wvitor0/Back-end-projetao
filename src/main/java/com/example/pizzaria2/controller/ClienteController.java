package com.example.pizzaria2.controller;

import com.example.pizzaria2.model.Cliente;
import com.example.pizzaria2.repository.ClienteDTO;
import com.example.pizzaria2.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cliente")
@CrossOrigin(origins = "http://localhost:3000")
public class ClienteController {
    @Autowired
    private ClienteRepository repository;
    @PostMapping
    public void saveCliente(@RequestBody ClienteDTO data){
        Cliente clienteData = new Cliente(data);
        repository.save(clienteData);
    }
    @GetMapping
    public List<ClienteDTO> getAll(){
        List<ClienteDTO> listCliente = repository.findAll().stream().map(ClienteDTO::new).toList();
        return listCliente;
    }
    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id){
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateCliente(@RequestBody Cliente newCliente, @PathVariable Long id){
        repository.findById(id).map(cliente -> {
            cliente.setNome(newCliente.getNome());
            cliente.setCep(newCliente.getCep());
            cliente.setBairro(newCliente.getBairro());
            cliente.setRua(newCliente.getRua());
            cliente.setComplemento(newCliente.getComplemento());
            repository.save(cliente);
            return null;
        });
    }
}
