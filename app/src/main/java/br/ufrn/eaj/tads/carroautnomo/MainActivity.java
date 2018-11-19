package br.ufrn.eaj.tads.carroautnomo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botaoManual = findViewById(R.id.botaoManual);
        botaoManual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("TESTE", "Botão manual");
                Intent intent = new Intent(getApplicationContext(), ManualActivity.class);
                startActivity(intent);
            }
        });

        Button botaoEstacionamento = findViewById(R.id.botaoEstacionamento);
        botaoEstacionamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("TESTE", "Botão estacionamento");
                Intent intent = new Intent(getApplicationContext(), EstacionamentoActivity.class);
                startActivity(intent);
            }
        });

        Button botaoMapeamento = findViewById(R.id.botaoMapeamento);
        botaoMapeamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("TESTE", "Botão mapeamentusdsdi");
                Intent intent = new Intent(getApplicationContext(), MapeamentoActivity.class);
                startActivity(intent);
            }
        });
    }
}
