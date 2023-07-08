package com.example.loja.infraestrutura.spring.produto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ProdutoModel {

    @Id
    @GeneratedValue
    private Long id;

    private String descricao;

    private Double preco;

    private Double altura;

    private Double largura;

    private Double comprimento;

    private Double peso;

}
