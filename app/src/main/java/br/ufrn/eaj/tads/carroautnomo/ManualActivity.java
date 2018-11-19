package br.ufrn.eaj.tads.carroautnomo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ManualActivity extends AppCompatActivity {

    ImageView tabuleiro[][];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual);

    }
}
