package com.example.loja.entidades;

public class Frete {

    public static double calcularFrete(Produto produto, Double distancia){
        double volume = produto.getVolume();
        double densidade = produto.getPeso() / volume;
        double frete = distancia * volume * (densidade/100);
        return frete >= 10.0 ? frete : 10.0;
    }

}
