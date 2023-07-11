package com.example.loja.infraestrutura.spring.item;

import com.example.loja.dominio.item.entidade.Item;
import com.example.loja.infraestrutura.spring.RepositoryGenerico;
import org.springframework.stereotype.Service;

@Service
public class ItemRepository extends RepositoryGenerico<ItemModel, Long, Item> {
    public ItemRepository(ItemDAO itemDao, ItemMapper itemMapper){
        super(itemDao, itemMapper);
    }
}
