package com.example.loja.infraestrutura.spring.cupom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CupomDAO extends JpaRepository<CupomModel, Long> {
}
