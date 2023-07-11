package com.example.loja.infraestrutura.spring.pedido;

import com.example.loja.dominio.pedido.entidade.Pedido;
import com.example.loja.infraestrutura.spring.BaseMapper;
import com.example.loja.infraestrutura.spring.cupom.CupomMapper;
import com.example.loja.infraestrutura.spring.item.ItemMapper;
import org.springframework.stereotype.Component;

@Component
public class PedidoMapper extends BaseMapper<PedidoModel, Pedido> {

    private final CupomMapper cupomMapper = new CupomMapper();
    private final ItemMapper itemMapper = new ItemMapper();

    @Override
    public Pedido toDomain(PedidoModel pedidoModel) throws Exception {
        return new Pedido(
                pedidoModel.getId(),
                itemMapper.toDomainList(pedidoModel.getItens()),
                cupomMapper.toDomain(pedidoModel.getCupomDeDesconto()),
                pedidoModel.getCpf(),
                pedidoModel.getCodigo(),
                pedidoModel.getDataDoPedido()
        );
    }

    @Override
    public PedidoModel toModel(Pedido pedido) {
        PedidoModel pedidoModel = new PedidoModel();
        pedidoModel.setId(pedido.getId());
        pedidoModel.setItens(itemMapper.toModelList(pedido.getItens()));
        pedidoModel.setCupomDeDesconto(cupomMapper.toModel(pedido.getCupomDeDesconto()));
        pedidoModel.setCpf(pedido.getCpf());
        pedidoModel.setCodigo(pedido.getCodigo());
        pedidoModel.setDataDoPedido(pedido.getDataDoPedido());
        return pedidoModel;
    }
}
