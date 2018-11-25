package br.ufrn.eaj.tads.carroautnomo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import processing.core.PApplet;

public class MainActivity extends AppCompatActivity {

    private Button estacionar;
    private Button mapear;
    private Button manual;

    private PApplet sketch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sketch = new Sketch();

    }

    public void abaEstacionar(View v) {
        Intent i = new Intent(MainActivity.this, EstacionamentoActivity.class);
        startActivity(i);
    }

    public void abaMapeamento(View v) {
        Intent i = new Intent(MainActivity.this, MapeamentoActivity.class);
        startActivity(i);
    }

    public void abaManual(View v) {
        Intent i = new Intent(MainActivity.this, ManualActivity.class);
        startActivity(i);
    }

////    @Override
////    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
////        if (sketch != null) {
////            sketch.onRequestPermissionsResult(requestCode, permissions, grantResults);
////        }
////    }
////
////    @Override
////    public void onNewIntent(Intent intent) {
////        if (sketch != null) {
////            sketch.onNewIntent(intent);
////        }
////    }
////
////    @Override
////    public void onActivityResult(int requestCode, int resultCode, Intent data) {
////        if (sketch != null) {
////            sketch.onActivityResult(requestCode, resultCode, data);
////        }
////    }
////
////    @Override
////    public void onBackPressed() {
////        if (sketch != null) {
////            sketch.onBackPressed();
////        }
//    }
}
