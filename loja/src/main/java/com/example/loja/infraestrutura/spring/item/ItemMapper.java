package com.example.loja.infraestrutura.spring.item;

import com.example.loja.dominio.item.entidade.Item;
import com.example.loja.infraestrutura.spring.BaseMapper;
import com.example.loja.infraestrutura.spring.produto.ProdutoMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemMapper extends BaseMapper<ItemModel, Item> {

    private final ProdutoMapper produtoMapper = new ProdutoMapper();

    @Override
    public Item toDomain(ItemModel itemModel) throws Exception {

        return new Item(
                itemModel.getId(),
                produtoMapper.toDomain(itemModel.getProduto()),
                itemModel.getQuantidade()
        );
    }

    @Override
    public ItemModel toModel(Item item) {
        ItemModel itemModel = new ItemModel();
        itemModel.setId(item.getId());
        itemModel.setProduto(produtoMapper.toModel(item.getProduto()));
        itemModel.setQuantidade(item.getQuantidade());
        return itemModel;
    }

    public List<Item> toDomainList(List<ItemModel> itemModels) throws Exception {
        List<Item> items = new ArrayList<>();
        for (ItemModel itemModel : itemModels) {
            Item item = toDomain(itemModel);
            items.add(item);
        }
        return items;
    }

    public List<ItemModel> toModelList(List<Item> items) {
        List<ItemModel> itemModels = new ArrayList<>();
        for (Item item : items) {
            ItemModel itemModel = toModel(item);
            itemModels.add(itemModel);
        }
        return itemModels;
    }

}
