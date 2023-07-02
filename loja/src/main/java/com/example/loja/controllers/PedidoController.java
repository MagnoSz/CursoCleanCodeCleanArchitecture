package com.example.loja.controllers;

import com.example.loja.dao.PedidoDAO;
import com.example.loja.entidades.Pedido;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/pedido")
public class PedidoController extends BaseController<Pedido, Long> {

    private PedidoDAO pedidoDAO;

    @Autowired
    public PedidoController(PedidoDAO pedidoDAO) {
        super(pedidoDAO);
        this.pedidoDAO = pedidoDAO;
    }

}
