package com.example.loja.controllers;

import com.example.loja.dao.CupomDAO;
import com.example.loja.entidades.Cupom;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/cupom")
public class CupomController extends BaseController<Cupom, Long> {

    private CupomDAO cupomDAO;

    @Autowired
    public CupomController(CupomDAO cupomDAO) {
        super(cupomDAO);
        this.cupomDAO = cupomDAO;
    }

}
