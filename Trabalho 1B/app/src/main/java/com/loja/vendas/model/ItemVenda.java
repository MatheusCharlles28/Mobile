package com.loja.vendas.model;

public class ItemVenda {
    private int id;
    private String codigo;
    private String descricao;
    private double valorUnitario;

    public ItemVenda(int id, String codigo, String descricao, double valorUnitario) {
        this.id = id;
        this.codigo = codigo;
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
    }

    public int getId() { return id; }
    public String getCodigo() { return codigo; }
    public String getDescricao() { return descricao; }
    public double getValorUnitario() { return valorUnitario; }

    @Override
    public String toString() {
        return "[" + codigo + "] " + descricao + " - R$ " + String.format("%.2f", valorUnitario);
    }
}
