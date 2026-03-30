package com.loja.vendas;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import com.loja.vendas.model.*;

import java.util.ArrayList;

public class PedidoActivity extends AppCompatActivity {

    private EditText etCodigoPedido, etBuscarPedido;
    private EditText etQuantidade, etValorUnitarioItem, etNumeroParcelas;
    private Spinner  spCliente, spItem;
    private RadioGroup rgPagamento;
    private RadioButton rbVista, rbPrazo;
    private TextView tvListaItens, tvTotalItens, tvTotalBruto, tvTotalFinal, tvListaParcelas;
    private LinearLayout layoutParcelas;
    private Button btnAdicionarItem, btnConcluirPedido, btnBuscarPedido;

    private DataStore dataStore;
    private ArrayList<ItemPedido> itensPedido = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Lançamento de Pedido");
        }

        dataStore = DataStore.getInstance();

        initViews();
        configurarEventos();
        carregarSpinners();
        atualizarCodigoPedido();
    }

    private void initViews() {
        etCodigoPedido    = findViewById(R.id.etCodigoPedido);
        etBuscarPedido    = findViewById(R.id.etBuscarPedido);
        btnBuscarPedido   = findViewById(R.id.btnBuscarPedido);
        spCliente         = findViewById(R.id.spCliente);
        spItem            = findViewById(R.id.spItem);
        etQuantidade      = findViewById(R.id.etQuantidade);
        etValorUnitarioItem = findViewById(R.id.etValorUnitarioItem);
        btnAdicionarItem  = findViewById(R.id.btnAdicionarItem);
        tvListaItens      = findViewById(R.id.tvListaItens);
        tvTotalItens      = findViewById(R.id.tvTotalItens);
        tvTotalBruto      = findViewById(R.id.tvTotalBruto);
        tvTotalFinal      = findViewById(R.id.tvTotalFinal);
        rgPagamento       = findViewById(R.id.rgPagamento);
        rbVista           = findViewById(R.id.rbVista);
        rbPrazo           = findViewById(R.id.rbPrazo);
        layoutParcelas    = findViewById(R.id.layoutParcelas);
        etNumeroParcelas  = findViewById(R.id.etNumeroParcelas);
        tvListaParcelas   = findViewById(R.id.tvListaParcelas);
        btnConcluirPedido = findViewById(R.id.btnConcluirPedido);
    }

    private void carregarSpinners() {
        ArrayAdapter<Cliente> adpClientes = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, dataStore.getClientes());
        adpClientes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCliente.setAdapter(adpClientes);

        ArrayAdapter<ItemVenda> adpItens = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, dataStore.getItensVenda());
        adpItens.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spItem.setAdapter(adpItens);


        spItem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (!dataStore.getItensVenda().isEmpty()) {
                    double val = dataStore.getItensVenda().get(position).getValorUnitario();
                    etValorUnitarioItem.setText(String.format("%.2f", val));
                }
            }
            @Override public void onNothingSelected(AdapterView<?> parent) {}
        });
    }

    private void configurarEventos() {
        btnAdicionarItem.setOnClickListener(v -> adicionarItem());
        btnConcluirPedido.setOnClickListener(v -> concluirPedido());
        btnBuscarPedido.setOnClickListener(v -> buscarPedido());

        rgPagamento.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rbPrazo) {
                layoutParcelas.setVisibility(View.VISIBLE);
            } else {
                layoutParcelas.setVisibility(View.GONE);
                etNumeroParcelas.setText("");
                tvListaParcelas.setText("");
            }
            atualizarTotais();
        });

        etNumeroParcelas.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            public void afterTextChanged(Editable s) {
                atualizarParcelas();
                atualizarTotais();
            }
        });
    }

    private void atualizarCodigoPedido() {
        etCodigoPedido.setText(String.valueOf(dataStore.getProximoCodigoPedido()));
    }

    private void adicionarItem() {
        if (dataStore.getItensVenda().isEmpty()) {
            Toast.makeText(this, "Nenhum item cadastrado", Toast.LENGTH_SHORT).show();
            return;
        }

        String qtdStr   = etQuantidade.getText().toString().trim();
        String valorStr = etValorUnitarioItem.getText().toString().trim();

        if (qtdStr.isEmpty()) {
            etQuantidade.setError("Informe a quantidade");
            etQuantidade.requestFocus();
            return;
        }
        if (valorStr.isEmpty()) {
            etValorUnitarioItem.setError("Informe o valor unitário");
            etValorUnitarioItem.requestFocus();
            return;
        }

        int qtd;
        double valor;
        try {
            qtd   = Integer.parseInt(qtdStr);
            valor = Double.parseDouble(valorStr.replace(",", "."));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Valores inválidos", Toast.LENGTH_SHORT).show();
            return;
        }

        if (qtd <= 0) {
            etQuantidade.setError("Quantidade deve ser maior que zero");
            return;
        }
        if (valor <= 0) {
            etValorUnitarioItem.setError("Valor deve ser maior que zero");
            return;
        }

        ItemVenda itemSelecionado = dataStore.getItensVenda().get(spItem.getSelectedItemPosition());
        itensPedido.add(new ItemPedido(itemSelecionado, qtd, valor));

        etQuantidade.setText("");
        atualizarListaItens();
        atualizarTotais();
        Toast.makeText(this, "Item adicionado!", Toast.LENGTH_SHORT).show();
    }

    private void atualizarListaItens() {
        if (itensPedido.isEmpty()) {
            tvListaItens.setText("Nenhum item adicionado");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < itensPedido.size(); i++) {
            ItemPedido ip = itensPedido.get(i);
            sb.append("Item ").append(i + 1).append("\n");
            sb.append("  Cód: ").append(ip.getItem().getCodigo()).append("\n");
            sb.append("  Desc: ").append(ip.getItem().getDescricao()).append("\n");
            sb.append("  Qtd: ").append(ip.getQuantidade())
              .append(" x R$ ").append(String.format("%.2f", ip.getValorUnitario())).append("\n");
            sb.append("  Subtotal: R$ ").append(String.format("%.2f", ip.getSubtotal()));
            if (i < itensPedido.size() - 1) sb.append("\n──────────────────\n");
        }
        tvListaItens.setText(sb.toString());
    }

    private void atualizarTotais() {
        double bruto = 0;
        for (ItemPedido ip : itensPedido) bruto += ip.getSubtotal();

        tvTotalItens.setText("Total de itens: " + itensPedido.size());
        tvTotalBruto.setText("Valor bruto: R$ " + String.format("%.2f", bruto));

        if (rbVista.isChecked()) {
            double final_ = bruto * 0.95;
            tvTotalFinal.setText("Total c/ 5% desconto: R$ " + String.format("%.2f", final_));
        } else if (rbPrazo.isChecked()) {
            double final_ = bruto * 1.05;
            tvTotalFinal.setText("Total c/ 5% acréscimo: R$ " + String.format("%.2f", final_));
        } else {
            tvTotalFinal.setText("Total: R$ " + String.format("%.2f", bruto));
        }
    }

    private void atualizarParcelas() {
        if (!rbPrazo.isChecked()) return;

        String parcelasStr = etNumeroParcelas.getText().toString().trim();
        if (parcelasStr.isEmpty()) { tvListaParcelas.setText(""); return; }

        int numParcelas;
        try { numParcelas = Integer.parseInt(parcelasStr); }
        catch (NumberFormatException e) { tvListaParcelas.setText(""); return; }

        if (numParcelas <= 0) { tvListaParcelas.setText(""); return; }

        double bruto = 0;
        for (ItemPedido ip : itensPedido) bruto += ip.getSubtotal();
        double totalFinal  = bruto * 1.05;
        double valorParcela = totalFinal / numParcelas;

        StringBuilder sb = new StringBuilder("Parcelas:\n");
        for (int i = 1; i <= numParcelas; i++) {
            sb.append("  ").append(i).append("ª: R$ ")
              .append(String.format("%.2f", valorParcela)).append("\n");
        }
        tvListaParcelas.setText(sb.toString().trim());
    }

    private void concluirPedido() {
        if (dataStore.getClientes().isEmpty()) {
            Toast.makeText(this, "Nenhum cliente cadastrado", Toast.LENGTH_SHORT).show();
            return;
        }
        if (itensPedido.isEmpty()) {
            Toast.makeText(this, "Adicione pelo menos um item", Toast.LENGTH_SHORT).show();
            return;
        }
        if (rgPagamento.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Selecione a condição de pagamento", Toast.LENGTH_SHORT).show();
            return;
        }

        int numeroParcelas = 0;
        if (rbPrazo.isChecked()) {
            String pStr = etNumeroParcelas.getText().toString().trim();
            if (pStr.isEmpty()) {
                etNumeroParcelas.setError("Informe o número de parcelas");
                etNumeroParcelas.requestFocus();
                return;
            }
            try { numeroParcelas = Integer.parseInt(pStr); }
            catch (NumberFormatException e) {
                etNumeroParcelas.setError("Número inválido");
                return;
            }
            if (numeroParcelas <= 0) {
                etNumeroParcelas.setError("Deve ser maior que zero");
                return;
            }
        }

        int codigo = dataStore.getProximoCodigoPedido();
        Cliente cliente = dataStore.getClientes().get(spCliente.getSelectedItemPosition());
        String condicao = rbVista.isChecked() ? "vista" : "prazo";

        Pedido pedido = new Pedido(codigo, cliente, new ArrayList<>(itensPedido),
                condicao, numeroParcelas);
        dataStore.adicionarPedido(pedido);

        Toast.makeText(this,
                "✅ Pedido Nº " + codigo + " cadastrado com sucesso!",
                Toast.LENGTH_LONG).show();

        limparTudo();
        atualizarCodigoPedido();
    }

    private void buscarPedido() {
        String codigoStr = etBuscarPedido.getText().toString().trim();
        if (codigoStr.isEmpty()) {
            Toast.makeText(this, "Informe o código do pedido", Toast.LENGTH_SHORT).show();
            return;
        }

        int codigo;
        try { codigo = Integer.parseInt(codigoStr); }
        catch (NumberFormatException e) {
            Toast.makeText(this, "Código inválido", Toast.LENGTH_SHORT).show();
            return;
        }

        Pedido pedido = dataStore.buscarPedidoPorCodigo(codigo);
        if (pedido == null) {
            Toast.makeText(this, "Pedido não encontrado", Toast.LENGTH_SHORT).show();
            return;
        }

        etCodigoPedido.setText(String.valueOf(pedido.getCodigo()));
        itensPedido = new ArrayList<>(pedido.getItens());
        atualizarListaItens();
        ArrayList<Cliente> clientes = dataStore.getClientes();
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == pedido.getCliente().getId()) {
                spCliente.setSelection(i);
                break;
            }
        }

        if ("vista".equals(pedido.getCondicaoPagamento())) {
            rbVista.setChecked(true);
            layoutParcelas.setVisibility(View.GONE);
        } else {
            rbPrazo.setChecked(true);
            layoutParcelas.setVisibility(View.VISIBLE);
            etNumeroParcelas.setText(String.valueOf(pedido.getNumeroParcelas()));
        }

        atualizarTotais();
        atualizarParcelas();
        Toast.makeText(this, "Pedido Nº " + codigo + " carregado!", Toast.LENGTH_SHORT).show();
    }

    private void limparTudo() {
        itensPedido.clear();
        tvListaItens.setText("Nenhum item adicionado");
        tvTotalItens.setText("Total de itens: 0");
        tvTotalBruto.setText("Valor bruto: R$ 0,00");
        tvTotalFinal.setText("Total: R$ 0,00");
        etQuantidade.setText("");
        etValorUnitarioItem.setText("");
        etNumeroParcelas.setText("");
        tvListaParcelas.setText("");
        layoutParcelas.setVisibility(View.GONE);
        rgPagamento.clearCheck();
        etBuscarPedido.setText("");

        carregarSpinners();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
