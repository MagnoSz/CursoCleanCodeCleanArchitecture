package com.example.auth.testes.unitario;

import com.example.auth.dominio.entidades.Senha;
import org.junit.Assert;
import org.junit.Test;

public class SenhaTest {

    @Test
    public void deveCriarUmaSenha() throws Exception {
        Senha senha = Senha.criar("abc123", "salt");
        Assert.assertEquals("jfvUDuVwO7kckWUkxQjWiZakTIKUzwBpKJ7SqwBAV9b/Q0F61ZYfeMsua+QstK6QrQwuYIKgf8zRL/jsl0skcw==", senha.getValue());
        Assert.assertEquals("salt", senha.getSalt());
    }

    @Test
    public void deveValidarUmaSenha() throws Exception {
        Senha senha = new Senha("jfvUDuVwO7kckWUkxQjWiZakTIKUzwBpKJ7SqwBAV9b/Q0F61ZYfeMsua+QstK6QrQwuYIKgf8zRL/jsl0skcw==", "salt");
        Assert.assertTrue(senha.validar("abc123"));
    }

}
