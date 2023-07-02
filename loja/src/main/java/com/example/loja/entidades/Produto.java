package com.example.loja.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Produto {

    @Id
    @GeneratedValue
    private Long id;

    private String descricao;

    private Double preco;

    private Double altura;

    private Double largura;

    private Double comprimento;

    private Double peso;

    public Produto() {}

    public Produto(String descricao, Double preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    public Produto(Long id, String descricao, Double preco) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Produto(Long id, String descricao, Double preco, Double altura, Double largura, Double comprimento) throws Exception {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        if(tamanhoValido(altura)) this.altura = altura;
        if(tamanhoValido(largura)) this.largura = largura;
        if(tamanhoValido(comprimento)) this.comprimento = comprimento;
    }

    public Produto(Long id, String descricao, Double preco, Double altura, Double largura, Double comprimento, Double peso) throws Exception {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        if(tamanhoValido(altura)) this.altura = altura;
        if(tamanhoValido(largura)) this.largura = largura;
        if(tamanhoValido(comprimento)) this.comprimento = comprimento;
        if(pesoValido(peso)) this.peso = peso;
    }

    private Boolean tamanhoValido(Double tamanho) throws Exception {
        if (tamanho <= 0) throw new Exception("Tamanho inválido!");
        return true;
    }

    private Boolean pesoValido(Double peso) throws Exception {
        if (peso <= 0) throw new Exception("Peso inválido!");
        return true;
    }

    public Double getVolume(){
        return (this.largura/100) * (this.largura/100) * (this.comprimento/100);
    }

}
