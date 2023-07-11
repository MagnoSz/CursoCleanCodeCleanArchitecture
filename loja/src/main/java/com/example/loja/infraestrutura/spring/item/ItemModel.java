package com.example.loja.infraestrutura.spring.item;

import com.example.loja.infraestrutura.spring.produto.ProdutoModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ItemModel {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private ProdutoModel produto;

    private Integer quantidade;
}
