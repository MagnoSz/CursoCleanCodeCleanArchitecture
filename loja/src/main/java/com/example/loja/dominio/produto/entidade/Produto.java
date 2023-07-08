package com.example.loja.dominio.produto.entidade;

public class Produto implements ProdutoInterface {

    private Long id;
    private String descricao;
    private Double preco;
    private Double altura;
    private Double largura;
    private Double comprimento;
    private Double peso;

    public Produto(Long id, String descricao, Double preco, Double altura, Double largura, Double comprimento, Double peso) throws Exception {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.altura = altura;
        this.largura = largura;
        this.comprimento = comprimento;
        this.peso = peso;
        validar();
    }

    private void validar() throws Exception {
        if (altura <= 0) throw new Exception("Altura inválida!");
        if (largura <= 0) throw new Exception("Largura inválida!");
        if (comprimento <= 0) throw new Exception("Comprimento inválido!");
        if (peso <= 0) throw new Exception("Peso inválido!");
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Double getPreco() {
        return preco;
    }

    @Override
    public Double getVolume() {
        return (this.largura/100) * (this.largura/100) * (this.comprimento/100);
    }

    @Override
    public Double getPeso() {
        return peso;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }
}
