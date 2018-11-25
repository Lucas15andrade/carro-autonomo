package br.ufrn.eaj.tads.carroautnomo;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EstacionamentoActivity extends AppCompatActivity {

    private FirebaseDatabase mFirebase;
    private DatabaseReference mReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estacionamento);

        mFirebase = FirebaseDatabase.getInstance();
        mReference = mFirebase.getReference().child("modo");
        mReference.setValue("estacionamento");

    }

    @Override
    protected void onStart(){
        super.onStart();
        mReference = mFirebase.getReference().child("estacionamento");
    }
}
