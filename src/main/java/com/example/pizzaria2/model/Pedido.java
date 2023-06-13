package com.example.pizzaria2.model;

import com.example.pizzaria2.repository.PedidoDTO;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "pedido")
@Entity(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private Double total;

    public Pedido(PedidoDTO data){
        this.id = data.id();
        this.nome = data.nome();
        this.descricao = data.descricao();
        this.total = data.total();
    }
}