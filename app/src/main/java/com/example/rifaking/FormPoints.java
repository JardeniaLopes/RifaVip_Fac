package com.example.rifaking;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;

public class FormPoints extends AppCompatActivity {

    Button botao1, botao2, botao3, botao4, botao5, botao6, botao7, botao8, botao9, botao10,
            botao11, botao12, botao13, botao14, botao15, botao16, botao17, botao18, botao19, botao20,
            botao21, botao22, botao23, botao24, botao25, botao26, botao27, botao28, botao29, botao30,
            botao31, botao32, botao33, botao34, botao35, botao36, botao37, botao38, botao39, botao40,
            botao41, botao42, botao43, botao44, botao45, botao46, botao47, botao48, botao49, botao50;
    String docId;
    ImageButton menu_Pontos;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_points);

        menu_Pontos = findViewById(R.id.menu_pontos);
        docId = getIntent().getStringExtra("docId");

    }
    public void onClick_Return(View v) {

        Intent i = new Intent( this,FormMain.class);
        startActivity(i);
    }

    public void onClick_Edit(View v) {

        Intent i = new Intent( this,FormPointCliente.class);
        i.putExtra("docId", docId);
        FormPoints.this.startActivity(i);

    }

    public void PontosCadastrados(View v) {

        Intent i = new Intent( this,MeusPontos.class);
        i.putExtra("docId", docId);
        FormPoints.this.startActivity(i);

    }
}