package com.example.pizzaria2.controller;

import com.example.pizzaria2.model.Pedido;
import com.example.pizzaria2.repository.PedidoRepository;
import com.example.pizzaria2.repository.PedidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cardapio")
@CrossOrigin(origins = "http://localhost:3000")
public class CardapioController {
    @Autowired
    private PedidoRepository repository;
    @PostMapping
    public void saveCliente(@RequestBody PedidoDTO data){
        Pedido pedidoData = new Pedido(data);
        repository.save(pedidoData);
    }
    @GetMapping
    public List<PedidoDTO> getAll(){
        List<PedidoDTO> listCardapio = repository.findAll().stream().map(PedidoDTO::new).toList();
        return listCardapio;
    }
    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id){
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateCardapio(@RequestBody Pedido newPedido, @PathVariable Long id){
        repository.findById(id).map(pedido -> {
            pedido.setNome(newPedido.getNome());
            pedido.setDescricao(newPedido.getDescricao());
            pedido.setTotal(newPedido.getTotal());
            repository.save(pedido);
            return null;
        });
    }
}