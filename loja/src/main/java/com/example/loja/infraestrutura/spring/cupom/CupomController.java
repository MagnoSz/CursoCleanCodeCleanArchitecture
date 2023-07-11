package com.example.loja.infraestrutura.spring.cupom;

import com.example.loja.dominio.cupom.entidade.Cupom;
import com.example.loja.infraestrutura.spring.ControllerGenerico;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cupom")
public class CupomController extends ControllerGenerico<CupomModel, Long, Cupom> {

    protected CupomController(CupomRepository cupomRepository, CupomMapper cupomMapper) {
        super(cupomRepository, cupomMapper);
    }

}
