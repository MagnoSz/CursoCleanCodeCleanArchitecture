package com.example.loja.infraestrutura.spring.produto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
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
