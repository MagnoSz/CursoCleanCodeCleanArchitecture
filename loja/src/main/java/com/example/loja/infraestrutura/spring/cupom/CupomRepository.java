package com.example.loja.infraestrutura.spring.cupom;

import com.example.loja.dominio.cupom.entidade.Cupom;
import com.example.loja.infraestrutura.spring.RepositoryGenerico;
import org.springframework.stereotype.Service;

@Service
public class CupomRepository extends RepositoryGenerico<CupomModel, Long, Cupom> {
    public CupomRepository(CupomDAO cupomDAO, CupomMapper cupomMapper) {
        super(cupomDAO, cupomMapper);
    }
}
