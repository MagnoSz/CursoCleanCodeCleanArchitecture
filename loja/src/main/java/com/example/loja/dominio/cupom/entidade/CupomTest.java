package com.example.loja.dominio.cupom.entidade;

import com.example.loja.dominio._shared.Util;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class CupomTest {

    @Test
    public void validarSeCupomEstaExpirado() throws Exception {
        Date dataVencida = Util.formatarStringParaDate("20/06/2023");
        Cupom cupomDeDesconto = new Cupom(1L, "EE", 10.0, dataVencida);
        Assert.assertTrue(cupomDeDesconto.estaExpirado(new Date()));
    }

    @Test
    public void validarSeCupomEstaEmVigencia() throws Exception {
        Date dataFutura = Util.formatarStringParaDate("20/06/2050");
        Cupom cupomDeDesconto = new Cupom(1L, "EE", 10.0, dataFutura);
        Assert.assertFalse(cupomDeDesconto.estaExpirado(new Date()));
    }

}
