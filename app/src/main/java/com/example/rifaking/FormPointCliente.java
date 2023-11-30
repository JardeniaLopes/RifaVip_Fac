package com.example.rifaking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;

public class FormPointCliente extends AppCompatActivity {
    EditText nomeCliente, telefoneCliente, enderecoCliente, numeroPonto;
    String nome, telefone, endereco, numPonto, pontoId;
    boolean isEditar = false;
    Button botao1, botao2, botao3, botao4, botao5, botao6, botao7, botao8, botao9, botao10,
            botao11, botao12, botao13, botao14, botao15, botao16, botao17, botao18, botao19, botao20,
            botao21, botao22, botao23, botao24, botao25, botao26, botao27, botao28, botao29, botao30,
            botao31, botao32, botao33, botao34, botao35, botao36, botao37, botao38, botao39, botao40,
            botao41, botao42, botao43, botao44, botao45, botao46, botao47, botao48, botao49, botao50;

    String docId, textEditText;
    CheckBox botao_pago;
    ImageButton menu_Pontos, delete;
    TextView Titulo;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_point_cliente);

        nomeCliente = (EditText)findViewById(R.id.nomeCliente);
        telefoneCliente = (EditText)findViewById(R.id.phone_Customer);
        enderecoCliente = (EditText)findViewById(R.id.enderecoCliente);
        botao_pago = findViewById(R.id.checkBox_Pago);
        numeroPonto = (EditText)findViewById(R.id.numero_Ponto);
        menu_Pontos = findViewById(R.id.menu_pontos);
        Titulo = findViewById(R.id.TituloCadastro);
        delete = findViewById(R.id.deletePonto);

        docId = getIntent().getStringExtra("docId");
        textEditText = getIntent().getStringExtra("textButton");
        inicializarComponentes();

        //receberDados
        nome = getIntent().getStringExtra("nomeCliente");
        telefone = getIntent().getStringExtra("telefoneCliente");
        endereco = getIntent().getStringExtra("endereco");
        numPonto = getIntent().getStringExtra("numeroDoPonto");
        pontoId = getIntent().getStringExtra("pontoId");

        if(pontoId!=null && !pontoId.isEmpty()){
            isEditar = true;
            docId = getIntent().getStringExtra("docId");
        }

        nomeCliente.setText(nome);
        telefoneCliente.setText(telefone);
        enderecoCliente.setText(endereco);
        numeroPonto.setText(textEditText);

        if(isEditar){
            Titulo.setText("Editar Cadastro");
            delete.setVisibility(View.VISIBLE);
        }
        else {
            Titulo.setText("Cadastrar Ponto");
            delete.setVisibility(View.GONE);
        }


    }


    public void Opcoes_Pontos(View v){
        PopupMenu popupMenu = new PopupMenu(FormPointCliente.this, menu_Pontos);
        for (int i = 0 ; i < 50 ; ++i) {
            popupMenu.getMenu().add(String.format("%02d",i));
        }
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                for (int i = 0; i < 50; ++i) {
                    String numberComparar = String.format("%02d", i);
                    if (menuItem.getTitle() == numberComparar) {
                        numeroPonto.setText(String.format("%02d", i));
                    }
                }
                return false;
            }
        });
    }




    private void inicializarComponentes() {
        botao1 = findViewById(R.id.botao01);
        botao2 = findViewById(R.id.botao02);
        botao3 = findViewById(R.id.botao03);
        botao4 = findViewById(R.id.botao04);
        botao5 = findViewById(R.id.botao05);
        botao6 = findViewById(R.id.botao06);
        botao7 = findViewById(R.id.botao07);
        botao8 = findViewById(R.id.botao08);
        botao9 = findViewById(R.id.botao09);
        botao10 = findViewById(R.id.botao10);
        botao11 = findViewById(R.id.botao11);
        botao12 = findViewById(R.id.botao12);
        botao13 = findViewById(R.id.botao13);
        botao14 = findViewById(R.id.botao14);
        botao15 = findViewById(R.id.botao15);
        botao16 = findViewById(R.id.botao16);
        botao17 = findViewById(R.id.botao17);
        botao18 = findViewById(R.id.botao18);
        botao19 = findViewById(R.id.botao19);
        botao20 = findViewById(R.id.botao20);
        botao21 = findViewById(R.id.botao21);
        botao22 = findViewById(R.id.botao22);
        botao23 = findViewById(R.id.botao23);
        botao24 = findViewById(R.id.botao24);
        botao25 = findViewById(R.id.botao25);
        botao26 = findViewById(R.id.botao26);
        botao27 = findViewById(R.id.botao27);
        botao28 = findViewById(R.id.botao28);
        botao29 = findViewById(R.id.botao29);
        botao30 = findViewById(R.id.botao30);
        botao31 = findViewById(R.id.botao31);
        botao32 = findViewById(R.id.botao32);
        botao33 = findViewById(R.id.botao33);
        botao34 = findViewById(R.id.botao34);
        botao35 = findViewById(R.id.botao35);
        botao36 = findViewById(R.id.botao36);
        botao37 = findViewById(R.id.botao37);
        botao38 = findViewById(R.id.botao38);
        botao39 = findViewById(R.id.botao39);
        botao40 = findViewById(R.id.botao40);
        botao41 = findViewById(R.id.botao41);
        botao42 = findViewById(R.id.botao42);
        botao43 = findViewById(R.id.botao43);
        botao44 = findViewById(R.id.botao44);
        botao45 = findViewById(R.id.botao45);
        botao46 = findViewById(R.id.botao46);
        botao47 = findViewById(R.id.botao47);
        botao48 = findViewById(R.id.botao48);
        botao49 = findViewById(R.id.botao49);
        botao50 = findViewById(R.id.botao50);
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
        i.putExtra("docId", docId);
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

        i.putExtra("docId", docId);
        SalvarNoFirebase(cliente, docId);
    }

    public void SalvarNoFirebase(Cliente_Model cliente, String docId){
        DocumentReference documentReference;

        try {
            if (isEditar) {
                documentReference = ConfiguracoesDB.getColecaoPontos(docId).document(pontoId);

                documentReference.set(cliente).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            //Ponto é adicionado
                            Toast.makeText(FormPointCliente.this, "Atualizado com Sucesso", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(FormPointCliente.this, "Não foi possível Atualizar", Toast.LENGTH_SHORT).show();
                        }
                    }

                });
            } else {

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


        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(FormPointCliente.this, "Erro ao interagir com o sistema. ", Toast.LENGTH_SHORT).show();
        }
    }

    public void DeleteRifa(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Confirmação");
        builder.setMessage("Tem certeza que deseja deletar o ponto");
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DeletarNoFirebase();
            }
        });
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog confirmacao = builder.create();
        confirmacao.show();
    }

    public void DeletarNoFirebase() {
        DocumentReference documentReference;
        try {
            documentReference = ConfiguracoesDB.getColecaoPontos(docId).document(pontoId);

            documentReference.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        //Rifa é deletada
                        Toast.makeText(FormPointCliente.this, "Rifa deletada com Sucesso!", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(FormPointCliente.this, "Erro ao deletar!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } catch (Exception e){
            e.printStackTrace();
            Toast.makeText(FormPointCliente.this, "Erro ao interagir com o sistema", Toast.LENGTH_SHORT).show();
        }
    }
}