package com.example.rifaking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;

public class FormPointCliente extends AppCompatActivity {
    EditText nomeCliente, telefoneCliente, enderecoCliente;

    String docId;
    CheckBox botao_pago;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_point_cliente);

        nomeCliente = (EditText)findViewById(R.id.nomeCliente);
        telefoneCliente = (EditText)findViewById(R.id.phone_Customer);
        enderecoCliente = (EditText)findViewById(R.id.enderecoCliente);
        botao_pago = findViewById(R.id.checkBox_Pago);

        docId = getIntent().getStringExtra("docId");
    }

    public boolean validar()
    {
        boolean retorno = true;
        String nome = nomeCliente.getText().toString();
        String telefone = telefoneCliente.getText().toString();
        String endereco = enderecoCliente.getText().toString();
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

        Cliente_Model cliente = new Cliente_Model();
        cliente.setNomeCliente(nome);
        cliente.setTelefoneCliente(telefone);
        cliente.setEndereco(endereco);

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