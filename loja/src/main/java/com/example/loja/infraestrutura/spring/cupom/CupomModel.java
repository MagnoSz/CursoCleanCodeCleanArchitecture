package com.example.loja.infraestrutura.spring.cupom;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class CupomModel {

    @Id
    @GeneratedValue
    private Long id;

    private String codigo;

    private Double porcentagem;

    private Date dataDeExpiracao;

}
