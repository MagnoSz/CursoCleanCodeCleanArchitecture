package com.example.auth.dominio.entidades;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class TokenGenerator {

    private String key;

    public TokenGenerator(String key) {
        this.key = key;
    }

    public String generate(Usuario usuario, long expiresIn, Date issueDate) {
        return Jwts.builder()
                .claim("email", usuario.getEmail())
                .setIssuedAt(issueDate)
                .setExpiration(new Date(issueDate.getTime() + expiresIn))
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
    }

    public Claims verify(String token) throws JwtException {
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
    }

}
