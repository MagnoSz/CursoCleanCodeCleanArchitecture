package com.example.loja.dominio.item.factory;

import com.example.loja.dominio.item.entidade.Item;
import com.example.loja.dominio.item.entidade.ItemInterface;
import com.example.loja.dominio.produto.entidade.Produto;

public class ItemFactory {

    public static ItemInterface criar(Long id, Produto produto, Integer quantidade) throws Exception {
        return new Item(id, produto, quantidade);
    }

}
