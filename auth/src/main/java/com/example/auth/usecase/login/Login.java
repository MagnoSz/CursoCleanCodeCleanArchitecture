package com.example.auth.usecase.login;

import com.example.auth.dominio.entidades.TokenGenerator;
import com.example.auth.dominio.entidades.Usuario;
import com.example.auth.infraestrutura.spring.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class Login {

    @Autowired
    UsuarioDAO usuarioDAO;

    public OutputLogin logar(InputLogin input) throws Exception {
        Usuario usuario = usuarioDAO.findUsuarioByEmail(input.email);
        if (usuario == null) throw new Exception("Usuário não encontrado");
        boolean senhaValida = usuario.validarSenha(input.senha);
        if (!senhaValida) throw new Exception("Senha inválida");
        TokenGenerator tokenGenerator = new TokenGenerator("key");
        String token = tokenGenerator.generate(usuario, 1000000, new Date());
        return new OutputLogin(token);
    }

}
