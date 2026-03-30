package com.loja.vendas;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.loja.vendas.util.CpfMask;

public class ClienteActivity extends AppCompatActivity {

    private EditText etNome, etCpf;
    private Button btnSalvar, btnLimpar;
    private DataStore dataStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Cadastro de Cliente");
        }

        dataStore = DataStore.getInstance();

        etNome    = findViewById(R.id.etNome);
        etCpf     = findViewById(R.id.etCpf);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnLimpar = findViewById(R.id.btnLimpar);

        etCpf.addTextChangedListener(new CpfMask(etCpf));

        btnSalvar.setOnClickListener(v -> salvar());
        btnLimpar.setOnClickListener(v -> limpar());
    }

    private void salvar() {
        String nome = etNome.getText().toString().trim();
        String cpf  = etCpf.getText().toString().trim();

        if (nome.isEmpty()) {
            etNome.setError("Informe o nome");
            etNome.requestFocus();
            return;
        }
        if (cpf.isEmpty()) {
            etCpf.setError("Informe o CPF");
            etCpf.requestFocus();
            return;
        }
        String apenasDigitos = cpf.replaceAll("[^0-9]", "");
        if (apenasDigitos.length() != 11) {
            etCpf.setError("CPF deve ter 11 dígitos");
            etCpf.requestFocus();
            return;
        }

        boolean sucesso = dataStore.adicionarCliente(nome, cpf);
        if (sucesso) {
            Toast.makeText(this, "Cliente cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
            limpar();
        } else {
            etCpf.setError("CPF já cadastrado");
            etCpf.requestFocus();
        }
    }

    private void limpar() {
        etNome.setText("");
        etCpf.setText("");
        etNome.requestFocus();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
