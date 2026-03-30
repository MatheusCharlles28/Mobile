package com.loja.vendas;

import com.loja.vendas.model.Cliente;
import com.loja.vendas.model.ItemVenda;
import com.loja.vendas.model.Pedido;

import java.util.ArrayList;

public class DataStore {

    private static DataStore instancia;

    private ArrayList<Cliente>   clientes   = new ArrayList<>();
    private ArrayList<ItemVenda> itensVenda = new ArrayList<>();
    private ArrayList<Pedido>    pedidos    = new ArrayList<>();

    private int proximoIdCliente   = 1;
    private int proximoIdItem      = 1;
    private int proximoCodigoPedido = 1;

    private DataStore() {}

    public static DataStore getInstance() {
        if (instancia == null) instancia = new DataStore();
        return instancia;
    }

    public ArrayList<Cliente> getClientes() { return clientes; }

    public boolean adicionarCliente(String nome, String cpf) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) return false;
        }
        clientes.add(new Cliente(proximoIdCliente++, nome, cpf));
        return true;
    }

    public ArrayList<ItemVenda> getItensVenda() { return itensVenda; }

    public boolean adicionarItemVenda(String codigo, String descricao, double valor) {
        for (ItemVenda iv : itensVenda) {
            if (iv.getCodigo().equals(codigo)) return false;
        }
        itensVenda.add(new ItemVenda(proximoIdItem++, codigo, descricao, valor));
        return true;
    }

    public ArrayList<Pedido> getPedidos() { return pedidos; }

    public int getProximoCodigoPedido() { return proximoCodigoPedido; }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
        proximoCodigoPedido++;
    }

    public Pedido buscarPedidoPorCodigo(int codigo) {
        for (Pedido p : pedidos) {
            if (p.getCodigo() == codigo) return p;
        }
        return null;
    }
}
