package com.example.loja;

import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        int sequence = 999999999;
        Date data = new Date();
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(data);
        int ano = calendario.get(Calendar.YEAR);
        String paddedSequence = String.format("%08d", sequence);

        System.out.println(ano + paddedSequence);
    }

}
