package com.example.pizzaria2.repository;

import com.example.pizzaria2.model.ClienteModel;
public record ClienteDTO(String nome, String bairro, String rua, String cep, String complemento) {
    public ClienteDTO(ClienteModel cliente){
        this(cliente.getNome(), cliente.getBairro(), cliente.getRua(), cliente.getCep(), cliente.getComplemento());
    }
}
