package com.example.loja.testes.integracao.pedido;

import com.example.loja.dao.PedidoDAO;
import com.example.loja.entidades.Pedido;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

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
    public void insere1PedidoNoBancoDeDados() throws Exception {
        Pedido pedido = new Pedido("257.877.630-09");
        pedidoDAO.save(pedido);
        Assert.assertEquals(1, pedidoDAO.findAll().size());
        deletarTodos();
    }

    @Test
    public void insere2PedidosNoBancoDeDados() throws Exception {
        Pedido pedido = new Pedido("257.877.630-09");
        pedidoDAO.save(pedido);
        Pedido pedido2 = new Pedido("257.877.630-09");
        pedidoDAO.save(pedido2);
        Assert.assertEquals(2, pedidoDAO.findAll().size());
        deletarTodos();
    }

}
