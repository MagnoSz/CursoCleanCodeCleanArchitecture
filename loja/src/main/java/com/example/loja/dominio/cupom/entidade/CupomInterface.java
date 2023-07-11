package com.example.loja.dominio.cupom.entidade;

import java.util.Date;

public interface CupomInterface {
    Boolean estaExpirado(Date dataHoje);
    Double calcularDesconto(Double valor);
    Long getId();
    Double getPorcentagem();
    String getCodigo();
    Date getDataDeExpiracao();
}
