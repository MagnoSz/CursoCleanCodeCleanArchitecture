package com.example.auth.testes.integracao;

import com.example.auth.dominio.entidades.TokenGenerator;
import io.jsonwebtoken.Claims;
import org.junit.Assert;
import org.junit.Test;

public class VerifyTest {

    @Test
    public void deveVerificarUmToken() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6ImpvYW9AZ21haWwuY29tIiwiaWF0IjoxNzAxNDM1NjAwLCJleHAiOjE3MDE0MzY2MDB9.N4BRsHLgZoFVrJWKBlRLXyxSR8g29go_H1-bjj5FVJo";
        TokenGenerator tokenGenerator = new TokenGenerator("3aT97B5fDeSd00aRRb36GDuGaeiWLaevLPVlgqtWoeM=");
        Claims payload = tokenGenerator.verify(token);

        Assert.assertEquals("joao@gmail.com", payload.get("email"));
    }

}
