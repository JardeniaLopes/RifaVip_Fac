package com.example.rifaking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.Query;

public class MeusPontos extends AppCompatActivity {

    RecyclerView pontosView;
    TextView msgNoPontos;
    PontosAdaptador pontosAdaptador;
    String docId;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_pontos);

        pontosView = findViewById(R.id.pontos_view);
        msgNoPontos = findViewById(R.id.msgPontos);
        docId = getIntent().getStringExtra("docId");

        setupPontosView(docId);
    }

    public void VoltarTelaPontos(View v){
        try {
            Intent i = new Intent(this, FormPoints.class);
            i.putExtra("docId", docId);
            startActivity(i);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Erro ao iniciar a página", Toast.LENGTH_SHORT).show();
        }
    }
    public void setupPontosView(String docId){
        Query query = ConfiguracoesDB.getColecaoPontos(docId).orderBy("numeroDoPonto", Query.Direction.DESCENDING);
        FirestoreRecyclerOptions<Cliente_Model> options = new FirestoreRecyclerOptions.Builder<Cliente_Model>()
                .setQuery(query,Cliente_Model.class).build();
        pontosView.setLayoutManager(new LinearLayoutManager(this));
        pontosAdaptador = new PontosAdaptador(options, this);
        pontosView.setAdapter(pontosAdaptador);

        query.get().addOnCompleteListener(task ->{
            if (task.isSuccessful()) {
                if (task.getResult().isEmpty()) {
                    msgNoPontos.setVisibility(View.VISIBLE);
                    pontosView.setVisibility(View.GONE);
                } else {
                    msgNoPontos.setVisibility(View.GONE);
                    pontosView.setVisibility(View.VISIBLE);
                }
            } else {
                Toast.makeText(MeusPontos.this, "Falha ao obter dados", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        pontosAdaptador.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        pontosAdaptador.stopListening();
    }

    @Override
    protected void onResume() {
        super.onResume();
        pontosAdaptador.notifyDataSetChanged();
    }
}