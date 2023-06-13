package com.example.pizzaria2.repository;

import com.example.pizzaria2.model.Pedido;

public record PedidoDTO(Long id, String nome, String descricao, Double total) {
    public PedidoDTO(Pedido pedido){
        this(pedido.getId(), pedido.getNome(), pedido.getDescricao(), pedido.getTotal());
    }
}