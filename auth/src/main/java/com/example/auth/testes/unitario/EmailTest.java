package com.example.auth.testes.unitario;

import com.example.auth.dominio.entidades.Email;
import org.junit.Assert;
import org.junit.Test;

public class EmailTest {

    @Test
    public void deveCriarUmEmailValido() throws Exception {
        Email email = new Email("joao@gmail.com");
        Assert.assertEquals("joao@gmail.com", email.getValue());
    }

    @Test(expected = Exception.class)
    public void deveLancarExcecaoPorEmailInvalido() throws Exception {
        try {
            Email email = new Email("joao@gmail");
        } catch (Exception e){
            Assert.assertEquals("Email Inválido!", e.getMessage());
            throw e;
        }
    }

}
