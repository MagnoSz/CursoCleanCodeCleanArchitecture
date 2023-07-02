package com.example.loja.testes.unitario;

import com.example.loja.entidades.Cupom;
import com.example.loja.entidades.Item;
import com.example.loja.entidades.Pedido;
import com.example.loja.entidades.Produto;
import com.example.loja.utils.Util;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class CupomTest {

    @Test
    public void validarSeCupomEstaExpirado() {
        Date dataVencida = Util.formatarStringParaDate("20/06/2023");
        Cupom cupomDeDesconto = new Cupom("EE", 10.0, dataVencida);
        Assert.assertTrue(cupomDeDesconto.estaExpirado(new Date()));
    }

    @Test
    public void validarSeCupomEstaEmVigencia() {
        Date dataFutura = Util.formatarStringParaDate("20/06/2050");
        Cupom cupomDeDesconto = new Cupom("EE", 10.0, dataFutura);
        Assert.assertFalse(cupomDeDesconto.estaExpirado(new Date()));
    }

}
