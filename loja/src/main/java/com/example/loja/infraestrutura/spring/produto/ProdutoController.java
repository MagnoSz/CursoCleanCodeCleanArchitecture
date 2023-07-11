package com.example.loja.infraestrutura.spring.produto;

import com.example.loja.dominio.produto.entidade.Produto;
import com.example.loja.infraestrutura.spring.ControllerGenerico;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoController extends ControllerGenerico<ProdutoModel, Long, Produto> {
    protected ProdutoController(ProdutoRepository produtoRepository, ProdutoMapper produtoMapper) {
        super(produtoRepository, produtoMapper);
    }
}
