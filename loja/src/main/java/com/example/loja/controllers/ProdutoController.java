package com.example.loja.controllers;

import com.example.loja.dao.ProdutoDAO;
import com.example.loja.entidades.Produto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/produto")
public class ProdutoController extends BaseController<Produto, Long> {

    private ProdutoDAO produtoDAO;

    @Autowired
    public ProdutoController(ProdutoDAO produtoDAO) {
        super(produtoDAO);
        this.produtoDAO = produtoDAO;
    }

}
