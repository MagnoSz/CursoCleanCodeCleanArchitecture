package com.example.loja.entidades;

import com.example.loja.utils.Util;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Entity
@Getter
@Setter
public class Pedido {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private List<Item> itens = new ArrayList<>();

    @OneToOne
    private Cupom cupomDeDesconto;

    private String cpf;

    private String codigo = "1";

    private Date dataDoPedido;

    @Transient
    private Double total = 0.0;

    public Pedido() {}

    public Pedido(String cpf) throws Exception {
        if (cpfValido(cpf)) this.cpf = cpf;
    }

    public Pedido(Cupom cupomDeDesconto, String cpf) throws Exception {
        this.cupomDeDesconto = cupomDeDesconto;
        if (cpfValido(cpf)) this.cpf = cpf;
    }

    public Pedido(Cupom cupomDeDesconto, String cpf, String codigo, Date dataDoPedido) {
        this.cupomDeDesconto = cupomDeDesconto;
        this.cpf = cpf;
        this.codigo = getCodigoFormatado(codigo, dataDoPedido);
    }

    public Boolean cpfValido(String cpf) throws Exception {
        if(!Util.CPFValido(cpf.replace(".", "").replace("-", ""))) throw new Exception("CPF inválido!");
        return true;
    }

    public Double getTotal(){
        itens.forEach(item -> total += (item.getProduto().getPreco() * item.getQuantidade()));
        aplicarCupomDeDesconto();
        return total;
    }

    private void aplicarCupomDeDesconto(){
        if (cupomDeDesconto != null && !cupomDeDesconto.estaExpirado(new Date())){
            total -= total * (cupomDeDesconto.getPorcentagem()/100);
        }
    }

    public void adicionarItem(Item item) throws Exception {
        if (item.getQuantidade() <= 0) throw new Exception("Quantidade inválida!");
        if (itens.stream().anyMatch(itemDaLista -> Objects.equals(item.getProduto().getId(), itemDaLista.getProduto().getId()))) throw new Exception("O item já está na lista!");
        itens.add(item);
    }

    private String getCodigoFormatado(String codigo, Date dataDoPedido){
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(dataDoPedido);
        String sequencia = String.format("%08d", Integer.valueOf(codigo));
        return calendario.get(Calendar.YEAR) + sequencia;
    }

}
