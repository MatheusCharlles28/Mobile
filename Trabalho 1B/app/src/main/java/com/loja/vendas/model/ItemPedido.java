package com.loja.vendas.model;

public class ItemPedido {
    private ItemVenda item;
    private int quantidade;
    private double valorUnitario;

    public ItemPedido(ItemVenda item, int quantidade, double valorUnitario) {
        this.item = item;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }

    public ItemVenda getItem() { return item; }
    public int getQuantidade() { return quantidade; }
    public double getValorUnitario() { return valorUnitario; }

    public double getSubtotal() {
        return quantidade * valorUnitario;
    }
}
