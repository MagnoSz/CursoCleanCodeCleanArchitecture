package com.example.loja.dao;

import com.example.loja.entidades.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoDAO extends JpaRepository<Produto, Long> {
}
