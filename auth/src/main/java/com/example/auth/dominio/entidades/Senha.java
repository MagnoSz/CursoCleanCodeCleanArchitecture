package com.example.auth.dominio.entidades;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class Senha {
    private static final int ITERATIONS = 1000;
    private static final int KEY_LENGTH = 512;
    private static final String DIGEST = "PBKDF2WithHmacSHA512";

    private String value;
    private String salt;

    public Senha(String value, String salt) {
        this.value = value;
        this.salt = salt;
    }

    public static Senha criar(String password, String salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String generatedSalt = salt != null ? salt : generateSalt();
        String hashedValue = hashPassword(password, generatedSalt);
        return new Senha(hashedValue, generatedSalt);
    }

    public boolean validar(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String hashedValue = hashPassword(password, salt);
        return value.equals(hashedValue);
    }

    private static String generateSalt() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    private static String hashPassword(String password, String salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        char[] passwordChars = password.toCharArray();
        byte[] saltBytes = Base64.getDecoder().decode(salt);

        PBEKeySpec spec = new PBEKeySpec(passwordChars, saltBytes, ITERATIONS, KEY_LENGTH);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DIGEST);
        byte[] hashedBytes = keyFactory.generateSecret(spec).getEncoded();

        return Base64.getEncoder().encodeToString(hashedBytes);
    }

    public String getValue(){
        return value;
    }

    public String getSalt(){
        return salt;
    }

}
