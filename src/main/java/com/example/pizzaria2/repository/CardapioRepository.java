package com.example.pizzaria2.repository;

import com.example.pizzaria2.model.Cardapio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardapioRepository extends JpaRepository<Cardapio, Long> {
}
