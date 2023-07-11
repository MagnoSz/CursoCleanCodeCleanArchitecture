package com.example.loja.infraestrutura.spring.produto;

import com.example.loja.dominio.produto.entidade.Produto;
import com.example.loja.infraestrutura.spring.BaseMapper;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper extends BaseMapper<ProdutoModel, Produto> {
    @Override
    public Produto toDomain(ProdutoModel produtoModel) throws Exception {
        return new Produto(
                produtoModel.getId(),
                produtoModel.getDescricao(),
                produtoModel.getPreco(),
                produtoModel.getAltura(),
                produtoModel.getLargura(),
                produtoModel.getComprimento(),
                produtoModel.getPeso()
        );
    }

    @Override
    public ProdutoModel toModel(Produto produto) {
        ProdutoModel produtoModel = new ProdutoModel();
        produtoModel.setId(produto.getId());
        produtoModel.setDescricao(produto.getDescricao());
        produtoModel.setPreco(produto.getPreco());
        produtoModel.setAltura(produto.getAltura());
        produtoModel.setLargura(produto.getLargura());
        produtoModel.setComprimento(produto.getComprimento());
        produtoModel.setPeso(produto.getPeso());
        return produtoModel;
    }
}
