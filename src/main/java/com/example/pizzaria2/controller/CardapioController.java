package com.example.pizzaria2.controller;

import com.example.pizzaria2.model.Cardapio;
import com.example.pizzaria2.repository.CardapioDTO;
import com.example.pizzaria2.repository.CardapioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cardapio")
@CrossOrigin(origins = "http://localhost:3000")
public class CardapioController {
    @Autowired
    private CardapioRepository repository;
    @PostMapping
    public void saveCliente(@RequestBody CardapioDTO data){
        Cardapio cardapioData = new Cardapio(data);
        repository.save(cardapioData);
    }
    @GetMapping
    public List<CardapioDTO> getAll(){
        List<CardapioDTO> listCardapio = repository.findAll().stream().map(CardapioDTO::new).toList();
        return listCardapio;
    }
    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id){
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateCardapio(@RequestBody Cardapio newCardapio, @PathVariable Long id){
        repository.findById(id).map(cardapio -> {
            cardapio.setNome(newCardapio.getNome());
            cardapio.setDescricao(newCardapio.getDescricao());
            cardapio.setUrl(newCardapio.getUrl());
            cardapio.setValor(newCardapio.getValor());
            repository.save(cardapio);
            return null;
        });
    }
}
