package com.example.loja.infraestrutura.spring.pedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoDAO extends JpaRepository<PedidoModel, Long> {
}
