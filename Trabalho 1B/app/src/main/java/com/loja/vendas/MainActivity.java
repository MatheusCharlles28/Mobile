package com.loja.vendas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View cardClientes = findViewById(R.id.cardClientes);
        View cardItens    = findViewById(R.id.cardItens);
        View cardPedido   = findViewById(R.id.cardPedido);

        cardClientes.setOnClickListener(v ->
                startActivity(new Intent(this, ClienteActivity.class)));

        cardItens.setOnClickListener(v ->
                startActivity(new Intent(this, ItemVendaActivity.class)));

        cardPedido.setOnClickListener(v ->
                startActivity(new Intent(this, PedidoActivity.class)));
    }
}
