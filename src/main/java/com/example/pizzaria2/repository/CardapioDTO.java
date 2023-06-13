package com.example.pizzaria2.repository;

import com.example.pizzaria2.model.Cardapio;

public record CardapioDTO(Long id, String nome, String descricao, String url, Double valor) {
    public CardapioDTO(Cardapio cardapio){
        this(cardapio.getId(), cardapio.getNome(), cardapio.getDescricao(), cardapio.getUrl(), cardapio.getValor());
    }
}
