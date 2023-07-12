package com.example.loja.testes.integracao.pedido;

import com.example.loja.infraestrutura.spring.pedido.PedidoDAO;
import com.example.loja.infraestrutura.spring.pedido.PedidoModel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class PedidoTest {

    @Autowired
    private PedidoDAO pedidoDAO;

//    @BeforeEach
//    @BeforeAll
    public void deletarTodos() {
        pedidoDAO.deleteAll();
    }

    @Test
    public void inserePedidoNoBancoDeDados() {
        PedidoModel pedido = new PedidoModel();
        pedido.setId(1L);
        pedido.setCpf("123456789");
        pedido.setDataDoPedido(new Date());
        pedidoDAO.save(pedido);
        Assert.assertEquals(1, pedidoDAO.findAll().size());
        deletarTodos();
    }

}
