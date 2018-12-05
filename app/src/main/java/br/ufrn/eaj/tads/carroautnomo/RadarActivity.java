package br.ufrn.eaj.tads.carroautnomo;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import br.ufrn.eaj.tads.carroautnomo.Modelo.Carro;
import br.ufrn.eaj.tads.carroautnomo.Modelo.RadarModelo;
import processing.android.PFragment;
import processing.android.CompatUtils;
import processing.core.PApplet;

public class RadarActivity extends AppCompatActivity {

    private PApplet sketch;

    private FirebaseDatabase mFirebase;
    private DatabaseReference mReference;
    private DatabaseReference mReferenceDistancia;
    private ChildEventListener mChildEventListener;

    int angulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mFirebase = FirebaseDatabase.getInstance();
        mReference = mFirebase.getReference().child("modo");
        mReference.setValue("mapeamento");
        mReference = mFirebase.getReference().child("angulo");
        mReferenceDistancia = mFirebase.getReference().child("distancia");

        sketch = new Radar();

        //Listenner que fica ouvindo o ângulo do servo motor do arduino
        ValueEventListener valueAngulo = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //Log.i("TESTE", dataSnapshot.getKey());
                //RadarModelo radar = dataSnapshot.getValue(RadarModelo.class);
                Log.i("TESTE", "Angulo: "+ dataSnapshot.getValue().toString());
                ((Radar) sketch).setAngulo(Integer.parseInt(dataSnapshot.getValue().toString()));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        mReference.addValueEventListener(valueAngulo);

        //Listenner que fica ouvindo a distância obtida pelo sensor ultrassônico
        ValueEventListener valueDistancia = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.i("TESTE", "Distância: "+ dataSnapshot.getValue().toString());
                ((Radar) sketch).setDistancia(Integer.parseInt(dataSnapshot.getValue().toString()));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        mReferenceDistancia.addValueEventListener(valueDistancia);

        //Configuração padrão do layout do radar
        FrameLayout frame = new FrameLayout(this);
        frame.setId(CompatUtils.getUniqueViewId());
        setContentView(frame, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));


        PFragment fragment = new PFragment(sketch);
        fragment.setView(frame, this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (sketch != null) {
            sketch.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    public void onNewIntent(Intent intent) {
        if (sketch != null) {
            sketch.onNewIntent(intent);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (sketch != null) {
            sketch.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onBackPressed() {
        if (sketch != null) {
            sketch.onBackPressed();
        }
    }

    @Override
    protected void onStart(){
        super.onStart();

    }
}

