package com.example.auth.infraestrutura.spring;

import com.example.auth.dominio.entidades.Email;
import com.example.auth.dominio.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Long> {
    Usuario findUsuarioByEmail(Email email);
}
