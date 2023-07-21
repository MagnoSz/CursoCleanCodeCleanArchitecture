package com.example.auth.usecase.verify;

import com.example.auth.dominio.entidades.TokenGenerator;

public class Verify {

    public Object execute(String token) {
        TokenGenerator tokenGenerator = new TokenGenerator("key");
        return tokenGenerator.verify(token);
    }

}
