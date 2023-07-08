package com.example.loja.dominio.item.entidade;

import com.example.loja.dominio.produto.entidade.Produto;

public interface ItemInterface {
    Produto getProduto();
    Integer getQuantidade();
}
