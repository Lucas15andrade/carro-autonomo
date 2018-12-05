package br.ufrn.eaj.tads.carroautnomo;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
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

        isOnline(MainActivity.this);
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

    //Verifica Permissão a Acesso a Internet
    private boolean getPermission(){
        if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED)
            return  true;
        return false;
    }

    public boolean isOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnected())
            return true;
        else {

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Erro ao Conectar a Internet")
                    .setPositiveButton("Sair", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            finish();
                        }
                    });
            // Create the AlertDialog object and return it
            AlertDialog dialog = builder.create();
            dialog.show();
            return false;
        }
    }
}
