package com.example.loja.dominio.pedido.entidade;

import com.example.loja.dominio.item.entidade.Item;

import java.util.Date;

public interface PedidoInterface {
    Long getId();
    Double getTotal();
    void aplicarCupomDeDesconto();
    void adicionarItem(Item item) throws Exception;
    String getCodigo();
    Date getDataDoPedido();
    String getCodigoFormatado(String codigo, Date dataDoPedido);
}
