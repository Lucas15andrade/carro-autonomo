package br.ufrn.eaj.tads.carroautnomo;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.ufrn.eaj.tads.carroautnomo.Modelo.Jogo;

public class EstacionamentoActivity extends AppCompatActivity {

    private ImageView tabuleiro[][];
    private GridLayout grid;
    private LayoutInflater inflate;

    FirebaseDatabase mFirebase;
    DatabaseReference mreference;

    ChildEventListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estacionamento);

        mFirebase = FirebaseDatabase.getInstance();
        mreference = mFirebase.getReference().child("jogo");

        tabuleiro = new ImageView[3][3];

        grid = findViewById(R.id.gridBoard);
        grid.setRowCount(3);
        grid.setColumnCount(3);

        inflate = LayoutInflater.from(this);

        for(int i = 0; i < grid.getRowCount(); i++){
            for(int j = 0; j < grid.getColumnCount(); j++){
                //tabuleiro[i][j].setImageResource(R.drawable.blocoblackp);
                tabuleiro[i][j] = (ImageView) inflate.inflate(R.layout.layout_inflate_imageblack, grid, false);
                grid.addView(tabuleiro[i][j]);
            }
        }

        listener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Jogo j = dataSnapshot.getValue(Jogo.class);

                if(j.isValor())
                    tabuleiro[j.getLinha()][j.getColuna()].setImageResource(R.drawable.bloco_branco);
                else
                    tabuleiro[j.getLinha()][j.getColuna()].setImageResource(R.drawable.blocoblackp);
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };

        mreference.addChildEventListener(listener);
    }
}
