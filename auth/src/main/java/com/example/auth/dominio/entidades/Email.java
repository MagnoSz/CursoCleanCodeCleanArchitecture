package com.example.auth.dominio.entidades;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {

    private String email;

    public Email(String email) throws Exception {
        this.email = email;
        validar();
    }

    private void validar() throws Exception {
        if (!emailValido(email)) throw new Exception("Email Inválido!");
    }

    private boolean emailValido(String email){
        String pattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(email.toLowerCase());
        return matcher.matches();
    }

    public String getValue() {
        return email;
    }
}
