package com.example.loja.infraestrutura.spring.item;

import com.example.loja.dominio.item.entidade.Item;
import com.example.loja.infraestrutura.spring.ControllerGenerico;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController extends ControllerGenerico<ItemModel, Long, Item> {
    protected ItemController(ItemRepository itemRepository, ItemMapper itemMapper) {
        super(itemRepository, itemMapper);
    }
}
