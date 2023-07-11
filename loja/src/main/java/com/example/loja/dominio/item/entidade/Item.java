package com.example.loja.dominio.item.entidade;

import com.example.loja.dominio._shared.Util;
import com.example.loja.dominio.produto.entidade.Produto;

public class Item implements ItemInterface {

    private Long id;
    private Produto produto;
    private Integer quantidade;

    public Item(Long id, Produto produto, Integer quantidade) throws Exception {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        validar();
    }

    private void validar() throws Exception {
        if (!Util.isDiferenteDeNullEDeVazio(produto)) throw new Exception("Deve haver um produto");
        if (quantidade <= 0) throw new Exception("A quantidade deve ser maior que 0");
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Produto getProduto() {
        return produto;
    }

    @Override
    public Integer getQuantidade() {
        return quantidade;
    }
}
