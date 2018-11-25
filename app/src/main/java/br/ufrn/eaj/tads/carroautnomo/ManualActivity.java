package br.ufrn.eaj.tads.carroautnomo;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.ufrn.eaj.tads.carroautnomo.Modelo.Carro;

public class ManualActivity extends AppCompatActivity {

    private Button esquerda;
    private Button direita;
    private Button frente;
    private Button parar;

    /*
    * OBJETOS DE ACESSO AO FIREBASE
    * */
    private FirebaseDatabase mFirebase;
    private DatabaseReference mReference;

    private Carro mCarro;
    private boolean bEsquerda = false;
    private boolean bDireita = false;
    private boolean bFrente = false;
    private boolean bTras = false;

    private int contParar = 0;
    private int contFrente = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual);

        esquerda = findViewById(R.id.esquerda);
        direita = findViewById(R.id.direita);
        frente = findViewById(R.id.frente);
        parar = findViewById(R.id.parar);

        mFirebase = FirebaseDatabase.getInstance();
        mReference = mFirebase.getReference().child("modo");
        mReference.setValue("manual");

        esquerda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bDireita = false;
                bEsquerda = true;
                mCarro = new Carro(bEsquerda, bDireita, bFrente, bTras);
                mReference.setValue(mCarro);
            }
        });

        direita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bEsquerda = false;
                bDireita = true;
                mCarro = new Carro(bEsquerda, bDireita, bFrente, bTras);
                mReference.setValue(mCarro);
            }
        });

        frente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bTras = false;
                bFrente = true;
                contFrente++;
                if(contFrente == 2){
                    bEsquerda = false;
                    bDireita = false;
                    contFrente = 0;
                }
                mCarro = new Carro(bEsquerda, bDireita, bFrente, bTras);
                mReference.setValue(mCarro);
            }
        });

        parar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bFrente = false;
                contParar++;
                if(contParar == 2){
                    //implementar
                }
                mCarro = new Carro(bEsquerda, bDireita, bFrente, bTras);
                mReference.setValue(mCarro);
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        mReference = mFirebase.getReference().child("carro");
    }
}
