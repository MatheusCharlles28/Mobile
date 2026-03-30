package com.loja.vendas.model;

import java.util.ArrayList;

public class Pedido {
    private int codigo;
    private Cliente cliente;
    private ArrayList<ItemPedido> itens;
    private String condicaoPagamento;
    private int numeroParcelas;

    public Pedido(int codigo, Cliente cliente, ArrayList<ItemPedido> itens,
                  String condicaoPagamento, int numeroParcelas) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.itens = itens;
        this.condicaoPagamento = condicaoPagamento;
        this.numeroParcelas = numeroParcelas;
    }

    public int getCodigo() { return codigo; }
    public Cliente getCliente() { return cliente; }
    public ArrayList<ItemPedido> getItens() { return itens; }
    public String getCondicaoPagamento() { return condicaoPagamento; }
    public int getNumeroParcelas() { return numeroParcelas; }

    public double getValorBruto() {
        double total = 0;
        for (ItemPedido ip : itens) total += ip.getSubtotal();
        return total;
    }

    public double getValorFinal() {
        double bruto = getValorBruto();
        if ("vista".equals(condicaoPagamento)) return bruto * 0.95;
        if ("prazo".equals(condicaoPagamento)) return bruto * 1.05;
        return bruto;
    }
}
