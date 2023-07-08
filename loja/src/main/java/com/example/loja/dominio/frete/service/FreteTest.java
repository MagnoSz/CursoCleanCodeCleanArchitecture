package com.example.loja.dominio.frete.service;

import com.example.loja.dominio.produto.entidade.Produto;
import org.junit.Assert;
import org.junit.Test;

public class FreteTest {

    @Test
    public void calculaFreteComValorMenorQue10() throws Exception {
        Produto produto = new Produto(1L, "Câmera", 100.0, 10.0, 10.0, 10.0, 0.9);
        Assert.assertEquals(10.0, FreteService.calcularFrete(produto, 1000.0), 0.1);
    }

    @Test
    public void calculaFreteComValorMaiorQue10() throws Exception {
        Produto produto = new Produto(1L, "Guitarra", 100.0, 100.0, 30.0, 10.0, 3.0);
        Assert.assertEquals(30.0, FreteService.calcularFrete(produto, 1000.0), 0.1);
    }

}
