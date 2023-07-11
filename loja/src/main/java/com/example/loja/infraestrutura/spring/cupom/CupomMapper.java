package com.example.loja.infraestrutura.spring.cupom;

import com.example.loja.dominio.cupom.entidade.Cupom;
import com.example.loja.infraestrutura.spring.BaseMapper;
import org.springframework.stereotype.Component;

@Component
public class CupomMapper extends BaseMapper<CupomModel, Cupom> {
    @Override
    public Cupom toDomain(CupomModel cupomModel) throws Exception {
        return new Cupom(
                cupomModel.getId(),
                cupomModel.getCodigo(),
                cupomModel.getPorcentagem(),
                cupomModel.getDataDeExpiracao()
        );
    }

    @Override
    public CupomModel toModel(Cupom cupom) {
        CupomModel cupomModel = new CupomModel();
        cupomModel.setId(cupom.getId());
        cupomModel.setCodigo(cupom.getCodigo());
        cupomModel.setPorcentagem(cupom.getPorcentagem());
        cupomModel.setDataDeExpiracao(cupom.getDataDeExpiracao());
        return cupomModel;
    }
}
