package com.example.loja.dominio.produto.entidade;

import org.junit.Assert;
import org.junit.Test;

public class ProdutoTest {

    @Test(expected = Exception.class)
    public void alturaNaoPodeSerInvalida() throws Exception {
        try {
            Produto produto = new Produto(1L, "meia", 10.0, 0.0, 1.0, 1.0, 10.0);
        } catch (Exception e){
            Assert.assertEquals("Altura inválida!", e.getMessage());
            throw e;
        }
    }

    @Test(expected = Exception.class)
    public void larguraNaoPodeSerInvalida() throws Exception {
        try {
            Produto produto = new Produto(1L, "meia", 10.0, 10.0, -1.0, 1.0, 10.0);
        } catch (Exception e){
            Assert.assertEquals("Largura inválida!", e.getMessage());
            throw e;
        }
    }

    @Test(expected = Exception.class)
    public void comprimentoNaoPodeSerInvalido() throws Exception {
        try {
            Produto produto = new Produto(1L, "meia", 10.0, 10.0, 1.0, -1.0, 10.0);
        } catch (Exception e){
            Assert.assertEquals("Comprimento inválido!", e.getMessage());
            throw e;
        }
    }

    @Test(expected = Exception.class)
    public void pesoDoProdutoPodeSerNegativo() throws Exception {
        try {
            Produto produto = new Produto(1L, "meia", 10.0, 10.0, 1.0, 1.0, -10.0);
        } catch (Exception e){
            Assert.assertEquals("Peso inválido!", e.getMessage());
            throw e;
        }
    }

}
