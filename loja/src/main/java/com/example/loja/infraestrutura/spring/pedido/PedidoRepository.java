package com.example.loja.infraestrutura.spring.pedido;

import com.example.loja.infraestrutura.spring.RepositoryGenerico;
import org.springframework.stereotype.Service;

@Service
public class PedidoRepository extends RepositoryGenerico<PedidoModel, Long> {
    public PedidoRepository(PedidoDAO pedidoDAO){
        super(pedidoDAO);
    }
}
