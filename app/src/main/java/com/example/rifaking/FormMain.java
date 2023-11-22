package com.example.rifaking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.Query;

public class FormMain extends AppCompatActivity {

 RecyclerView rifaView;
 ImageButton menuRifa;
 ImageButton menuExit;
 private TextView messagemNoRifa;
 RifaAdaptador rifaAdaptador;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_main);
        rifaView = findViewById(R.id.rifas_view);
        messagemNoRifa = findViewById(R.id.rifamensagem);
        menuExit = findViewById(R.id.menu_btn);
        setupRifasView();

    }

    public void setupRifasView(){
        Query query = ConfiguracoesDB.getColecaoReferenciaParaRifa().orderBy("dataSorteio", Query.Direction.DESCENDING);
        FirestoreRecyclerOptions<Rifa_Model> options = new FirestoreRecyclerOptions.Builder<Rifa_Model>()
                .setQuery(query,Rifa_Model.class).build();
        rifaView.setLayoutManager(new LinearLayoutManager(this));
        rifaAdaptador = new RifaAdaptador(options,this);
        rifaView.setAdapter(rifaAdaptador);

        // Verifica diretamente os dados da consulta do Firestore
        query.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                if (task.getResult().isEmpty()) {
                    messagemNoRifa.setVisibility(View.VISIBLE);
                    rifaView.setVisibility(View.GONE);
                } else {
                    messagemNoRifa.setVisibility(View.GONE);
                    rifaView.setVisibility(View.VISIBLE);
                }
            } else {
                Toast.makeText(FormMain.this, "Falha ao obter dados", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        rifaAdaptador.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        rifaAdaptador.stopListening();
    }

    @Override
    protected void onResume() {
        super.onResume();
        rifaAdaptador.notifyDataSetChanged();
    }

    public  void Menu(View v){
        PopupMenu popupMenu = new PopupMenu(FormMain.this,menuExit);
        popupMenu.getMenu().add("Sair");
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if(menuItem.getTitle() == "Sair"){
                    FirebaseAuth.getInstance().signOut();
                    startActivity(new Intent( FormMain.this, FormLogin.class));
                    finish();
                    return true;
                }
                return false;
            }
        });
    }
    public void onClick_Points(View v) {
        Intent i = new Intent( this,FormPoints.class);
        startActivity(i);
    }

    public void onClick_createRifa(View view) {
        Intent i = new Intent(FormMain.this,FormCreateRifa.class);
        startActivity(i);
    }
}