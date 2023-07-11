package com.example.loja.dominio.item.entidade;

import com.example.loja.dominio.produto.entidade.Produto;

public interface ItemInterface {
    Long getId();
    Produto getProduto();
    Integer getQuantidade();
}
