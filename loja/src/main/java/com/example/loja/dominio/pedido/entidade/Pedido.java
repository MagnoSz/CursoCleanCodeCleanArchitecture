package com.example.loja.dominio.pedido.entidade;

import com.example.loja.dominio._shared.Util;
import com.example.loja.dominio.cupom.entidade.Cupom;
import com.example.loja.dominio.item.entidade.Item;

import java.util.*;

public class Pedido implements PedidoInterface {

    private Long id = 0L;
    private List<Item> itens = new ArrayList<>();
    private Cupom cupomDeDesconto;
    private String cpf;
    private String codigo = "1";
    private Date dataDoPedido;
    private Double total = 0.0;

    public Pedido(String cpf) throws Exception {
        this.cpf = cpf;
        validar();
    }

    public Pedido(Cupom cupomDeDesconto, String cpf) throws Exception {
        this.cupomDeDesconto = cupomDeDesconto;
        this.cpf = cpf;
        validar();
    }

    public Pedido(Cupom cupomDeDesconto, String cpf, String codigo, Date dataDoPedido) throws Exception {
        this.cupomDeDesconto = cupomDeDesconto;
        this.cpf = cpf;
        this.dataDoPedido = dataDoPedido;
        validar();
    }

    public Pedido(Long id, List<Item> itens, Cupom cupomDeDesconto, String cpf, String codigo, Date dataDoPedido) throws Exception {
        this.id = id;
        this.itens = itens;
        this.cupomDeDesconto = cupomDeDesconto;
        this.cpf = cpf;
        this.codigo = codigo;
        this.dataDoPedido = dataDoPedido;
        validar();
    }

    public Pedido(Long id, List<Item> itens, Cupom cupomDeDesconto, String cpf, String codigo, Date dataDoPedido, Double total) throws Exception {
        this.id = id;
        this.itens = itens;
        this.cupomDeDesconto = cupomDeDesconto;
        this.cpf = cpf;
        this.codigo = codigo;
        this.dataDoPedido = dataDoPedido;
        this.total = total;
        validar();
    }

    private void validar() throws Exception {
        if(!Util.CPFValido(cpf.replace(".", "").replace("-", ""))) throw new Exception("CPF inválido!");
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Double getTotal() {
        itens.forEach(item -> total += (item.getProduto().getPreco() * item.getQuantidade()));
        aplicarCupomDeDesconto();
        return total;
    }

    @Override
    public void aplicarCupomDeDesconto() {
        if (cupomDeDesconto != null && !cupomDeDesconto.estaExpirado(new Date())){
            total -= total * (cupomDeDesconto.getPorcentagem()/100);
        }
    }

    @Override
    public void adicionarItem(Item item) throws Exception {
        if (item.getQuantidade() <= 0) throw new Exception("Quantidade inválida!");
        if (itens.stream().anyMatch(itemDaLista -> Objects.equals(item.getProduto().getDescricao(), itemDaLista.getProduto().getDescricao()))) throw new Exception("O item já está na lista!");
        itens.add(item);
    }

    @Override
    public String getCodigo() {
        return codigo;
    }

    @Override
    public Date getDataDoPedido() {
        return dataDoPedido;
    }

    @Override
    public Cupom getCupomDeDesconto() {
        return cupomDeDesconto;
    }

    @Override
    public List<Item> getItens() {
        return itens;
    }

    @Override
    public String getCpf() {
        return cpf;
    }

    @Override
    public String getCodigoFormatado(String codigo, Date dataDoPedido) {
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(dataDoPedido);
        String sequencia = String.format("%08d", Integer.valueOf(codigo));
        return calendario.get(Calendar.YEAR) + sequencia;
    }
}
