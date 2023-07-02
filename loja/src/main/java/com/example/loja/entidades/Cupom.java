package com.example.loja.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Cupom {

    @Id
    @GeneratedValue
    private Long id;

    private String codigo;

    private Double porcentagem;

    private Date dataDeExpiracao;

    public Cupom() {}

    public Cupom(String codigo, Double porcentagem, Date dataDeExpiracao) {
        this.codigo = codigo;
        this.porcentagem = porcentagem;
        this.dataDeExpiracao = dataDeExpiracao;
    }

    public Boolean estaExpirado(Date dataHoje){
        return dataDeExpiracao.before(dataHoje);
    }

    public Double calcularDesconto(Double valor){
        return (valor * porcentagem)/100;
    }

}
