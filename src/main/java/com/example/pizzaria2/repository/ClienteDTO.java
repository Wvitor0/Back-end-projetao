package com.example.pizzaria2.repository;

import com.example.pizzaria2.model.Cliente;
public record ClienteDTO(Long id, String nome, String bairro, String rua, String cep, String complemento) {
    public ClienteDTO(Cliente cliente){
        this(cliente.getId(), cliente.getNome(), cliente.getBairro(), cliente.getRua(), cliente.getCep(), cliente.getComplemento());
    }
}
