package com.example.loja.infraestrutura.spring.produto;

import com.example.loja.infraestrutura.spring.RepositoryGenerico;
import org.springframework.stereotype.Service;

@Service
public class ProdutoRepository extends RepositoryGenerico<ProdutoModel, Long> {
    public ProdutoRepository(ProdutoDAO produtoDAO){
        super(produtoDAO);
    }
}
