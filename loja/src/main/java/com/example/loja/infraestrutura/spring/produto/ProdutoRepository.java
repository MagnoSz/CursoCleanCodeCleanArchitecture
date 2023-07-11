package com.example.loja.infraestrutura.spring.produto;

import com.example.loja.dominio.produto.entidade.Produto;
import com.example.loja.infraestrutura.spring.RepositoryGenerico;
import org.springframework.stereotype.Service;

@Service
public class ProdutoRepository extends RepositoryGenerico<ProdutoModel, Long, Produto> {
    public ProdutoRepository(ProdutoDAO produtoDAO, ProdutoMapper produtoMapper){
        super(produtoDAO, produtoMapper);
    }
}
