package com.example.auth.testes.unitario;

import com.example.auth.dominio.entidades.Token;
import com.example.auth.dominio.entidades.Usuario;
import io.jsonwebtoken.Claims;
import org.junit.Assert;
import org.junit.ComparisonFailure;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TokenTest {

    @Test
    public void deveGerarUmTokenDeUsuario() throws Exception {
        Usuario usuario = Usuario.criarUsuario("joao@gmail.com", "abc123");
        Integer expiresIn = 1000000;
        String dateString = "2023-12-01T10:00:00";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date issueDate = format.parse(dateString);
        Token tokenGenerator = new Token("3aT97B5fDeSd00aRRb36GDuGaeiWLaevLPVlgqtWoeM=");
        String token = tokenGenerator.generate(usuario, expiresIn, issueDate);

        Assert.assertEquals("eyJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6ImpvYW9AZ21haWwuY29tIiwiaWF0IjoxNzAxNDM1NjAwLCJleHAiOjE3MDE0MzY2MDB9.N4BRsHLgZoFVrJWKBlRLXyxSR8g29go_H1-bjj5FVJo", token);
    }

    @Test
    public void deveValidarUmTokenDeUsuario() throws Exception {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6ImpvYW9AZ21haWwuY29tIiwiaWF0IjoxNzAxNDM1NjAwLCJleHAiOjE3MDE0MzY2MDB9.N4BRsHLgZoFVrJWKBlRLXyxSR8g29go_H1-bjj5FVJo";
        Token tokenGenerator = new Token("3aT97B5fDeSd00aRRb36GDuGaeiWLaevLPVlgqtWoeM=");
        Claims payload = tokenGenerator.verify(token);

        Assert.assertEquals("joao@gmail.com", payload.get("email"));
    }

    @Test(expected = Exception.class)
    public void deveValidarUmTokenInvalido() {
        try {
            String token = "eyJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6ImpvYW9AZ21haWwuY29tIiwiaWF0IjoxNjcyNTc4MDAwLCJleHAiOjE2NzI1NzkwMDB9.kOlpkyTtPq13Nv24AKyqWBxmJDxiFFNTfsq5T8yb7E8";
            Token tokenGenerator = new Token("3aT97B5fDeSd00aRRb36GDuGaeiWLaevLPVlgqtWoeM=");
            tokenGenerator.verify(token);
        } catch (ComparisonFailure e){
            Assert.assertEquals("Invalid token", e.getMessage());
        }

    }

}
