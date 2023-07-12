package com.example.auth.testes.unitario;

import com.example.auth.dominio.entidades.Usuario;
import org.junit.Assert;
import org.junit.Test;

public class UsuarioTest {

    @Test
    public void deveCriarUmUsuario() throws Exception {
        Usuario usuario = Usuario.criarUsuario("joao@gmail.com", "abc123");
        Assert.assertTrue(usuario.validarSenha("abc123"));
    }

    @Test
    public void deveCriarUmUsuarioAPartirDoBancoDeDados() throws Exception {
        Usuario usuario = Usuario.getUsuarioExistente("joao@gmail.com", "jfvUDuVwO7kckWUkxQjWiZakTIKUzwBpKJ7SqwBAV9b/Q0F61ZYfeMsua+QstK6QrQwuYIKgf8zRL/jsl0skcw==", "salt");
        Assert.assertTrue(usuario.validarSenha("abc123"));
    }

}
