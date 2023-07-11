package com.example.loja.dominio.pedido.entidade;

import com.example.loja.dominio.cupom.entidade.Cupom;
import com.example.loja.dominio.item.entidade.Item;

import java.util.Date;
import java.util.List;

public interface PedidoInterface {
    Long getId();
    Double getTotal();
    void aplicarCupomDeDesconto();
    void adicionarItem(Item item) throws Exception;
    String getCodigo();
    Date getDataDoPedido();
    Cupom getCupomDeDesconto();
    List<Item> getItens();
    String getCpf();
    String getCodigoFormatado(String codigo, Date dataDoPedido);
}
