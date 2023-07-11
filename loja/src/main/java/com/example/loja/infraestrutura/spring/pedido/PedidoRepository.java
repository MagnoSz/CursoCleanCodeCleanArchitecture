package com.example.loja.infraestrutura.spring.pedido;

import com.example.loja.dominio.pedido.entidade.Pedido;
import com.example.loja.infraestrutura.spring.RepositoryGenerico;
import org.springframework.stereotype.Service;

@Service
public class PedidoRepository extends RepositoryGenerico<PedidoModel, Long, Pedido> {
    public PedidoRepository(PedidoDAO pedidoDAO, PedidoMapper pedidoMapper){
        super(pedidoDAO, pedidoMapper);
    }
}
