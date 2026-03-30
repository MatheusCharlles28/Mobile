package com.loja.vendas;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ItemVendaActivity extends AppCompatActivity {

    private EditText etCodigo, etDescricao, etValor;
    private Button btnSalvar, btnLimpar;
    private DataStore dataStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_venda);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Cadastro de Item");
        }

        dataStore = DataStore.getInstance();

        etCodigo    = findViewById(R.id.etCodigo);
        etDescricao = findViewById(R.id.etDescricao);
        etValor     = findViewById(R.id.etValorUnitario);
        btnSalvar   = findViewById(R.id.btnSalvar);
        btnLimpar   = findViewById(R.id.btnLimpar);

        btnSalvar.setOnClickListener(v -> salvar());
        btnLimpar.setOnClickListener(v -> limpar());
    }

    private void salvar() {
        String codigo    = etCodigo.getText().toString().trim();
        String descricao = etDescricao.getText().toString().trim();
        String valorStr  = etValor.getText().toString().trim();

        if (codigo.isEmpty()) {
            etCodigo.setError("Informe o código");
            etCodigo.requestFocus();
            return;
        }
        if (descricao.isEmpty()) {
            etDescricao.setError("Informe a descrição");
            etDescricao.requestFocus();
            return;
        }
        if (valorStr.isEmpty()) {
            etValor.setError("Informe o valor");
            etValor.requestFocus();
            return;
        }

        double valor;
        try {
            valor = Double.parseDouble(valorStr.replace(",", "."));
        } catch (NumberFormatException e) {
            etValor.setError("Valor inválido");
            etValor.requestFocus();
            return;
        }

        if (valor <= 0) {
            etValor.setError("Valor deve ser maior que zero");
            etValor.requestFocus();
            return;
        }

        boolean sucesso = dataStore.adicionarItemVenda(codigo, descricao, valor);
        if (sucesso) {
            Toast.makeText(this, "Item cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
            limpar();
        } else {
            etCodigo.setError("Código já cadastrado");
            etCodigo.requestFocus();
        }
    }

    private void limpar() {
        etCodigo.setText("");
        etDescricao.setText("");
        etValor.setText("");
        etCodigo.requestFocus();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
