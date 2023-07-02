package com.example.loja.testes.unitario;

import com.example.loja.entidades.Produto;
import org.junit.Assert;
import org.junit.Test;

public class ProdutoTest {

    @Test(expected = Exception.class)
    public void nenhumaDimensaoDoProdutoPodeSerNegativa() throws Exception {
        try {
            Produto produto = new Produto(1L, "meia", 10.0, 0.0, -1.0, 1.0);
        } catch (Exception e){
            Assert.assertEquals("Tamanho inválido!", e.getMessage());
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
