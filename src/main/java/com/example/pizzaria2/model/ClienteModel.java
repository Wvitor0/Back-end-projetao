package com.example.pizzaria2.model;

import com.example.pizzaria2.repository.ClienteRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "cliente")
@Entity(name = "cliente")
public class ClienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String bairro;
    private String cep;
    private String rua;
    private String complemento;

    public ClienteModel(ClienteRequestDTO data){
        this.nome = data.nome();
        this.bairro = data.bairro();
        this.cep = data.cep();
        this.rua = data.rua();
        this.complemento = data.complemento();
    }
}
