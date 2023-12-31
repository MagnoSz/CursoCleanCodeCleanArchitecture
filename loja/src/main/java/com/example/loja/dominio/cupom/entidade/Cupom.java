package com.example.loja.dominio.cupom.entidade;

import java.util.Date;

public class Cupom implements CupomInterface {

    private Long id;
    private String codigo;
    private Double porcentagem;
    private Date dataDeExpiracao;

    public Cupom(Long id, String codigo, Double porcentagem, Date dataDeExpiracao) throws Exception {
        this.id = id;
        this.codigo = codigo;
        this.porcentagem = porcentagem;
        this.dataDeExpiracao = dataDeExpiracao;
        validar();
    }

    private void validar() {
    }

    @Override
    public Boolean estaExpirado(Date dataHoje) {
        return dataDeExpiracao.before(dataHoje);
    }

    @Override
    public Double calcularDesconto(Double valor) {
        return (valor * porcentagem)/100;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Double getPorcentagem() {
        return porcentagem;
    }

    @Override
    public String getCodigo() {
        return codigo;
    }

    @Override
    public Date getDataDeExpiracao() {
        return dataDeExpiracao;
    }
}
