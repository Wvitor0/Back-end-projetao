package com.example.pizzaria2.model;


import com.example.pizzaria2.repository.CardapioDTO;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "cardapio")
@Entity(name = "cardapio")
public class Cardapio {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private String url;
    private Double valor;

    public Cardapio(CardapioDTO data){
        this.id = data.id();
        this.nome = data.nome();
        this.descricao = data.descricao();
        this.url = data.url();
        this.valor = data.valor();
    }
}
