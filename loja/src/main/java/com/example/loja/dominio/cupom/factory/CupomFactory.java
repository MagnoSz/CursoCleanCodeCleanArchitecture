package com.example.loja.dominio.cupom.factory;

import com.example.loja.dominio.cupom.entidade.Cupom;
import com.example.loja.dominio.cupom.entidade.CupomInterface;

import java.util.Date;

public class CupomFactory {

    public static CupomInterface criar(Long id, String codigo, Double porcentagem, Date dataDeExpiracao) throws Exception {
        return new Cupom(id, codigo, porcentagem, dataDeExpiracao);
    }

}
