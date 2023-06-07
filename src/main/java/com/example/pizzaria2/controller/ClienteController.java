package com.example.pizzaria2.controller;

import com.example.pizzaria2.model.ClienteModel;
import com.example.pizzaria2.repository.ClienteDTO;
import com.example.pizzaria2.repository.ClienteRepository;
import com.example.pizzaria2.repository.ClienteRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cliente")
public class ClienteController {
    @Autowired
    private ClienteRepository repository;
    @PostMapping
    public void saveCliente(@RequestBody ClienteRequestDTO data){
        ClienteModel clienteData = new ClienteModel(data);
        repository.save(clienteData);
    }
    @GetMapping
    public List<ClienteDTO> getAll(){
        List<ClienteDTO> listCliente = repository.findAll().stream().map(ClienteDTO::new).toList();
        return listCliente;
    }
}
