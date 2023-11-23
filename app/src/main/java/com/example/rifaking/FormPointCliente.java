package com.example.rifaking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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

    String docId;
    CheckBox botao_pago;
    ImageButton menu_Pontos, delete;

    TextView Titulo;
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
        numeroPonto.setText(numPonto);

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
        popupMenu.getMenu().add("01");
        popupMenu.getMenu().add("02");
        popupMenu.getMenu().add("03");
        popupMenu.getMenu().add("04");
        popupMenu.getMenu().add("05");
        popupMenu.getMenu().add("06");
        popupMenu.getMenu().add("07");
        popupMenu.getMenu().add("08");
        popupMenu.getMenu().add("09");
        popupMenu.getMenu().add("10");
        popupMenu.getMenu().add("11");
        popupMenu.getMenu().add("12");
        popupMenu.getMenu().add("13");
        popupMenu.getMenu().add("14");
        popupMenu.getMenu().add("15");
        popupMenu.getMenu().add("16");
        popupMenu.getMenu().add("17");
        popupMenu.getMenu().add("18");
        popupMenu.getMenu().add("19");
        popupMenu.getMenu().add("20");
        popupMenu.getMenu().add("21");
        popupMenu.getMenu().add("22");
        popupMenu.getMenu().add("23");
        popupMenu.getMenu().add("24");
        popupMenu.getMenu().add("25");
        popupMenu.getMenu().add("26");
        popupMenu.getMenu().add("27");
        popupMenu.getMenu().add("28");
        popupMenu.getMenu().add("29");
        popupMenu.getMenu().add("30");
        popupMenu.getMenu().add("31");
        popupMenu.getMenu().add("32");
        popupMenu.getMenu().add("33");
        popupMenu.getMenu().add("34");
        popupMenu.getMenu().add("35");
        popupMenu.getMenu().add("36");
        popupMenu.getMenu().add("37");
        popupMenu.getMenu().add("38");
        popupMenu.getMenu().add("39");
        popupMenu.getMenu().add("40");
        popupMenu.getMenu().add("41");
        popupMenu.getMenu().add("42");
        popupMenu.getMenu().add("43");
        popupMenu.getMenu().add("44");
        popupMenu.getMenu().add("45");
        popupMenu.getMenu().add("46");
        popupMenu.getMenu().add("47");
        popupMenu.getMenu().add("48");
        popupMenu.getMenu().add("49");
        popupMenu.getMenu().add("50");
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (menuItem.getTitle() == "01") {
                    numeroPonto.setText("01");

                } else if (menuItem.getTitle() == "02") {
                    numeroPonto.setText("02");

                } else if (menuItem.getTitle() == ("03")) {
                    numeroPonto.setText("03");

                }else if (menuItem.getTitle() ==("04")) {
                    numeroPonto.setText("04");

                } else if (menuItem.getTitle() == ("05")) {
                    numeroPonto.setText("05");

                } else if (menuItem.getTitle() == ("06")) {
                    numeroPonto.setText("06");

                } else if (menuItem.getTitle() == ("07")) {
                    numeroPonto.setText("07");

                } else if (menuItem.getTitle() == ("08")) {
                    numeroPonto.setText("08");

                } else if (menuItem.getTitle() == ("09")) {
                    numeroPonto.setText("09");

                } else if (menuItem.getTitle() == ("10")) {
                    numeroPonto.setText("10");

                } else if (menuItem.getTitle() == ("11")) {
                    numeroPonto.setText("11");

                } else if (menuItem.getTitle() == ("12")) {
                    numeroPonto.setText("12");

                } else if (menuItem.getTitle() == ("13")) {
                    numeroPonto.setText("13");
                } else if (menuItem.getTitle() == ("14")) {
                    numeroPonto.setText("14");
                } else if (menuItem.getTitle() == ("15")) {
                    numeroPonto.setText("15");
                } else if (menuItem.getTitle() == ("16")) {
                    numeroPonto.setText("16");
                } else if (menuItem.getTitle() == ("17")) {
                    numeroPonto.setText("17");
                } else if (menuItem.getTitle() == ("18")) {
                    numeroPonto.setText("18");
                } else if (menuItem.getTitle() == ("19")) {
                    numeroPonto.setText("19");
                } else if (menuItem.getTitle() == ("20")) {
                    numeroPonto.setText("20");
                } else if (menuItem.getTitle() == ("21")) {
                    numeroPonto.setText("21");
                } else if (menuItem.getTitle() == ("22")) {
                    numeroPonto.setText("22");
                } else if (menuItem.getTitle() == ("23")) {
                    numeroPonto.setText("23");
                } else if (menuItem.getTitle() == ("24")) {
                    numeroPonto.setText("24");
                } else if (menuItem.getTitle() == ("25")) {
                    numeroPonto.setText("25");
                } else if (menuItem.getTitle() == ("26")) {
                    numeroPonto.setText("26");
                } else if (menuItem.getTitle() == ("27")) {
                    numeroPonto.setText("27");
                } else if (menuItem.getTitle() == ("28")) {
                    numeroPonto.setText("28");
                } else if (menuItem.getTitle() == ("29")) {
                    numeroPonto.setText("29");
                } else if (menuItem.getTitle() == ("30")) {
                    numeroPonto.setText("30");
                } else if (menuItem.getTitle() == ("31")) {
                    numeroPonto.setText("31");
                } else if (menuItem.getTitle() == ("32")) {
                    numeroPonto.setText("32");
                } else if (menuItem.getTitle() == ("33")) {
                    numeroPonto.setText("33");
                } else if (menuItem.getTitle() == ("34")) {
                    numeroPonto.setText("34");
                } else if (menuItem.getTitle() == ("35")) {
                    numeroPonto.setText("35");
                } else if (menuItem.getTitle() == ("36")) {
                    numeroPonto.setText("36");
                } else if (menuItem.getTitle() == ("37")) {
                    numeroPonto.setText("37");
                } else if (menuItem.getTitle() == ("38")) {
                    numeroPonto.setText("38");
                } else if (menuItem.getTitle() == ("39")) {
                    numeroPonto.setText("39");
                } else if (menuItem.getTitle() == ("40")) {
                    numeroPonto.setText("40");
                } else if (menuItem.getTitle() == ("41")) {
                    numeroPonto.setText("41");
                } else if (menuItem.getTitle() == ("42")) {
                    numeroPonto.setText("42");
                } else if (menuItem.getTitle() == ("43")) {
                    numeroPonto.setText("43");
                } else if (menuItem.getTitle() == ("44")) {
                    numeroPonto.setText("44");
                } else if (menuItem.getTitle() == ("45")) {
                    numeroPonto.setText("45");
                } else if (menuItem.getTitle() == ("46")) {
                    numeroPonto.setText("46");
                } else if (menuItem.getTitle() == ("47")) {
                    numeroPonto.setText("47");
                } else if (menuItem.getTitle() == ("48")) {
                    numeroPonto.setText("48");
                } else if (menuItem.getTitle() == ("49")) {
                    numeroPonto.setText("49");
                } else if (menuItem.getTitle() == ("50")) {
                    numeroPonto.setText("50");
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

        SalvarNoFirebase(cliente);

    }

    public void SalvarNoFirebase(Cliente_Model cliente){
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