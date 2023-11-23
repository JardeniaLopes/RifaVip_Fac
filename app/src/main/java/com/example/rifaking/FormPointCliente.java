package com.example.rifaking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;

public class FormPointCliente extends AppCompatActivity {
    EditText nomeCliente, telefoneCliente, enderecoCliente, numeroPonto;

    Button botao1, botao2, botao3, botao4, botao5, botao6, botao7, botao8, botao9, botao10,
            botao11, botao12, botao13, botao14, botao15, botao16, botao17, botao18, botao19, botao20,
            botao21, botao22, botao23, botao24, botao25, botao26, botao27, botao28, botao29, botao30,
            botao31, botao32, botao33, botao34, botao35, botao36, botao37, botao38, botao39, botao40,
            botao41, botao42, botao43, botao44, botao45, botao46, botao47, botao48, botao49, botao50;

    String docId;
    CheckBox botao_pago;
    ImageButton menu_Pontos;
    int VerdeRifa = getResources().getColor(R.color.verdeRifa);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_point_cliente);

        nomeCliente = (EditText)findViewById(R.id.nomeCliente);
        telefoneCliente = (EditText)findViewById(R.id.phone_Customer);
        enderecoCliente = (EditText)findViewById(R.id.enderecoCliente);
        botao_pago = findViewById(R.id.checkBox_Pago);
        numeroPonto = findViewById(R.id.numero_Ponto);
        menu_Pontos = findViewById(R.id.menu_pontos);

        docId = getIntent().getStringExtra("docId");

    }
    public boolean validar()
    {
        boolean retorno = true;
        String nome = nomeCliente.getText().toString();
        String telefone = telefoneCliente.getText().toString();
        String endereco = enderecoCliente.getText().toString();
        String ponto = numeroPonto.getText().toString();
        if (nome.isEmpty())
        {
            nomeCliente.setError("Nome vazio");
            retorno = false;
        }
        if (telefone.isEmpty())
        {
            telefoneCliente.setError("Telefone Vazio");
            retorno = false;
        }
        if(endereco.isEmpty())
        {
            enderecoCliente.setError("Endereço vazio");
            retorno = false;
        }
        if(ponto.isEmpty())
        {
            numeroPonto.setError("Ponto vazio");
            retorno = false;
        }

        return retorno;
    }

    public void onClick_Cancel(View v) {

        Intent i = new Intent( this,FormPoints.class);
        startActivity(i);
    }

    public void SalvarPonto(View v) {
        if (!validar()) {
            Toast.makeText(this, "Por favor, preencha todos os campos corretamente", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent i = new Intent(this, FormPoints.class);
        startActivity(i);

        String nome = nomeCliente.getText().toString();
        String telefone = telefoneCliente.getText().toString();
        String endereco = enderecoCliente.getText().toString();
        String ponto = numeroPonto.getText().toString();

        Cliente_Model cliente = new Cliente_Model();
        cliente.setNomeCliente(nome);
        cliente.setTelefoneCliente(telefone);
        cliente.setEndereco(endereco);
        cliente.setNumeroDoPonto(ponto);

        SalvarNoFirebase(cliente);

    }

    public void SalvarNoFirebase(Cliente_Model cliente){
        DocumentReference documentReference;

        documentReference = ConfiguracoesDB.getColecaoPontos(docId).document();

        documentReference.set(cliente).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    //Ponto é adicionado
                    Toast.makeText(FormPointCliente.this, "Ponto cadastrado com Sucesso!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(FormPointCliente.this, "Não foi possível cadastrar Ponto!", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

}