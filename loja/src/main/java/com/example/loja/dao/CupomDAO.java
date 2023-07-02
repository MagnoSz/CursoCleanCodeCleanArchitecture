package com.example.loja.dao;

import com.example.loja.entidades.Cupom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CupomDAO extends JpaRepository<Cupom, Long> {
}
