package com.example.loja.dominio.produto.factory;

import com.example.loja.dominio.produto.entidade.Produto;
import com.example.loja.dominio.produto.entidade.ProdutoInterface;

public class ProdutoFactory {

    public static ProdutoInterface criar(Long id, String descricao, Double preco, Double altura, Double largura, Double comprimento, Double peso) throws Exception {
        return new Produto(id, descricao, preco, altura, largura, comprimento, peso);
    }

}
