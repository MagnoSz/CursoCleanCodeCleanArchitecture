package com.example.loja.testes.unitario;

import com.example.loja.utils.Util;
import org.junit.Assert;
import org.junit.Test;

public class CpfTest {

    @Test
    public void cpfDeveSerValido() {
        Assert.assertTrue(Util.CPFValido("936.077.760-91"));
    }

    @Test
    public void cpfDeveSerInvalido() {
        Assert.assertFalse(Util.CPFValido("936.077.70-91"));
    }

}
