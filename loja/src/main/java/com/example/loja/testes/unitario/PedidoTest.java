package com.example.loja.testes.unitario;

import com.example.loja.entidades.Cupom;
import com.example.loja.entidades.Item;
import com.example.loja.entidades.Pedido;
import com.example.loja.entidades.Produto;
import com.example.loja.utils.Util;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class PedidoTest {

    @Test
    public void adicionaPedidoCom3ProdutosECalculaTotal() throws Exception {
        Produto produto1 = new Produto(1L,"meia", 10.0);
        Produto produto2 = new Produto(2L, "meia", 10.0);
        Produto produto3 = new Produto(3L, "meia", 10.0);

        Pedido pedido = new Pedido("257.877.630-09");
        pedido.adicionarItem(new Item(1L, produto1, 1));
        pedido.adicionarItem(new Item(2L, produto2, 1));
        pedido.adicionarItem(new Item(3L, produto3, 1));

        Assert.assertEquals(30.0, pedido.getTotal(), 0.1);
    }

    @Test
    public void adicionaPedidoCom3ProdutosComCupomDeDescontoECalculaTotal() throws Exception {
        Produto produto1 = new Produto(1L, "meia", 10.0);
        Produto produto2 = new Produto(2L, "meia", 10.0);
        Produto produto3 = new Produto(3L, "meia", 10.0);

        Date data = Util.formatarStringParaDate("30/06/2025");
        Cupom cupomDeDesconto = new Cupom("EE", 10.0, data);

        Pedido pedido = new Pedido(cupomDeDesconto, "936.077.760-91");
        pedido.adicionarItem(new Item(produto1, 1));
        pedido.adicionarItem(new Item(produto2, 1));
        pedido.adicionarItem(new Item(produto3, 1));

        Assert.assertEquals(27.0, pedido.getTotal(), 0.1);
    }

    @Test(expected = Exception.class)
    public void deveLancarExcecaoAoInserirCPFInvalido() throws Exception {
        try {
            Produto produto1 = new Produto("meia", 10.0);
            Cupom cupomDeDesconto = new Cupom("EE", 10.0, new Date());

            Pedido pedido = new Pedido(cupomDeDesconto, "257.877.63-09");
            pedido.adicionarItem(new Item(produto1, 1));
        } catch (Exception e){
            Assert.assertEquals("CPF inválido!", e.getMessage());
            throw e;
        }
    }

    @Test
    public void naoDeveAplicarUmCupomExpirado() throws Exception {
        Produto produto1 = new Produto(1L, "meia", 10.0);

        Date dataVencida = Util.formatarStringParaDate("20/06/2023");
        Cupom cupomDeDesconto = new Cupom("EE", 10.0, dataVencida);

        Pedido pedido = new Pedido(cupomDeDesconto, "936.077.760-91");
        pedido.adicionarItem(new Item(1L, produto1, 1));
        Assert.assertEquals(10.0, pedido.getTotal(), 0.1);
    }

    @Test(expected = Exception.class)
    public void aoFazerPedidoQuantidadeDeItensNaoPodeSerNegativa() throws Exception {
        try {
            Produto produto1 = new Produto("meia", 10.0);

            Date dataVencida = Util.formatarStringParaDate("20/06/2023");
            Cupom cupomDeDesconto = new Cupom("EE", 10.0, dataVencida);

            Pedido pedido = new Pedido(cupomDeDesconto, "936.077.760-91");
            pedido.adicionarItem(new Item(1L, produto1, -1));
            Assert.assertEquals(10.0, pedido.getTotal(), 0.1);
        } catch (Exception e){
            Assert.assertEquals("Quantidade inválida!", e.getMessage());
            throw e;
        }
    }

    @Test(expected = Exception.class)
    public void aoFazerPedidoNaoPodeTerItemRepetido() throws Exception {
        try {
            Produto produto1 = new Produto("meia", 10.0);

            Date dataVencida = Util.formatarStringParaDate("20/06/2023");
            Cupom cupomDeDesconto = new Cupom("EE", 10.0, dataVencida);

            Pedido pedido = new Pedido(cupomDeDesconto, "936.077.760-91");
            pedido.adicionarItem(new Item(1L, produto1, 1));
            pedido.adicionarItem(new Item(1L, produto1, 1));
        } catch (Exception e){
            Assert.assertEquals("O item já está na lista!", e.getMessage());
            throw e;
        }
    }

    @Test
    public void deveCriarUmPedidoEGerarUmCodigo() throws Exception {
        Cupom cupomDeDesconto = new Cupom("EE", 10.0, new Date());
        Pedido pedido = new Pedido(cupomDeDesconto, "936.077.760-91", "1", new Date());
        Assert.assertEquals("202300000001", pedido.getCodigo());
    }

}
