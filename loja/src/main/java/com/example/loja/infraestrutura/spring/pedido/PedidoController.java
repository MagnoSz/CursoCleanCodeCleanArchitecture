package com.example.loja.infraestrutura.spring.pedido;

import com.example.loja.dominio.pedido.entidade.Pedido;
import com.example.loja.infraestrutura.spring.ControllerGenerico;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedido")
public class PedidoController extends ControllerGenerico<PedidoModel, Long, Pedido> {
    protected PedidoController(PedidoRepository pedidoRepository, PedidoMapper pedidoMapper) {
        super(pedidoRepository, pedidoMapper);
    }
}
