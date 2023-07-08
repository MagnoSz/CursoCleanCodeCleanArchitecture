package com.example.loja.dominio.pedido.factory;

import com.example.loja.dominio.cupom.entidade.Cupom;
import com.example.loja.dominio.item.entidade.Item;
import com.example.loja.dominio.pedido.entidade.Pedido;
import com.example.loja.dominio.pedido.entidade.PedidoInterface;

import java.util.Date;
import java.util.List;

public class PedidoFactory {

    public static PedidoInterface criar(Long id, List<Item> itens, Cupom cupomDeDesconto, String cpf, String codigo, Date dataDoPedido, Double total) throws Exception {
        return new Pedido(id, itens, cupomDeDesconto, cpf, codigo, dataDoPedido, total);
    }

}
