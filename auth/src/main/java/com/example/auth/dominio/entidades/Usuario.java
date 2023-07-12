package com.example.auth.dominio.entidades;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Usuario {

    private Email email;
    private Senha senha;

    public Usuario(Email email, Senha senha) {
        this.email = email;
        this.senha = senha;
    }

    public static Usuario criarUsuario(String email, String senha) throws Exception {
        return new Usuario(new Email(email), Senha.criar(senha, null));
    }

    public static Usuario getUsuarioExistente(String email, String hash, String salt) throws Exception {
        return new Usuario(new Email(email), new Senha(hash, salt));
    }

    public boolean validarSenha(String senha) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return this.senha.validar(senha);
    }

    public String getEmail() {
        return email.getValue();
    }
}
