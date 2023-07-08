package com.example.loja.infraestrutura.spring.pedido;

import com.example.loja.infraestrutura.spring.cupom.CupomModel;
import com.example.loja.infraestrutura.spring.item.ItemModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class PedidoModel {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private List<ItemModel> itens = new ArrayList<>();

    @OneToOne
    private CupomModel cupomDeDesconto;

    private String cpf;

    private String codigo = "1";

    private Date dataDoPedido;

}
