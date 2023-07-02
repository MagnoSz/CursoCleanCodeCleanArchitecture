package com.example.loja.dao;

import com.example.loja.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoDAO extends JpaRepository<Pedido, Long> {

}
