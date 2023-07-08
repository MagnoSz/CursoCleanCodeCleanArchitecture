package com.example.loja.dominio.frete.service;

import com.example.loja.dominio.produto.entidade.Produto;

public class FreteService {

    public static double calcularFrete(Produto produto, Double distancia){
        double volume = produto.getVolume();
        double densidade = produto.getPeso() / volume;
        double frete = distancia * volume * (densidade/100);
        return frete >= 10.0 ? frete : 10.0;
    }

}
