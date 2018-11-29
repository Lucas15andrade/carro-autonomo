package br.ufrn.eaj.tads.carroautnomo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button estacionar;
    private Button mapear;
    private Button manual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void abaEstacionar(View v){
        Intent i = new Intent(MainActivity.this, EstacionamentoActivity.class);
        startActivity(i);
    }

    public void abaMapeamento(View v){
        //Intent i = new Intent(MainActivity.this, MapeamentoActivity.class);
        Intent i = new Intent(getApplicationContext(), RadarActivity.class);
        startActivity(i);
    }

    public void abaManual(View v){
        Intent i = new Intent(MainActivity.this, ManualActivity.class);
        startActivity(i);
    }
}
