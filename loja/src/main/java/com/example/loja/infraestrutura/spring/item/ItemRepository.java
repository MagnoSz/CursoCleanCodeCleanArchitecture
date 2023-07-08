package com.example.loja.infraestrutura.spring.item;

import com.example.loja.infraestrutura.spring.RepositoryGenerico;

public class ItemRepository extends RepositoryGenerico<ItemModel, Long> {

    public ItemRepository(ItemDAO itemDao){
        super(itemDao);
    }

}
