package com.example.auth.usecase.signup;

import com.example.auth.dominio.entidades.Usuario;
import com.example.auth.infraestrutura.spring.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUp {

    @Autowired
    UsuarioDAO usuarioDAO;

    public void cadastrar(InputSignUp input) throws Exception {
        Usuario usuario = Usuario.criarUsuario(input.email, input.senha);
        usuarioDAO.save(usuario);
    }

}
