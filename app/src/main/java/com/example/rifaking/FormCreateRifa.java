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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;

import org.w3c.dom.Document;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormCreateRifa extends AppCompatActivity {
    EditText nomeRifa, premioRifa, q_pontosRifa, valorRifa, dataRifa;
    TextView Titulo;
    ImageButton delete;
    boolean isEditar = false;
    String nome, premio, dataSorteio, qtPontos, valor, docId;

    ImageButton menu_Opcoes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_create_rifa);

        nomeRifa = (EditText)findViewById(R.id.nameRifa);
        premioRifa = (EditText)findViewById(R.id.awardRifa);
        q_pontosRifa = (EditText)findViewById(R.id.qtPtRifa);
        valorRifa = (EditText)findViewById(R.id.valueRifa);
        dataRifa = (EditText)findViewById(R.id.drawRifa);
        Titulo = findViewById(R.id.titulo_criarRifa);
        delete = findViewById(R.id.delete);
        menu_Opcoes = findViewById(R.id.menu_expandir);

        //receberDados
        nome = getIntent().getStringExtra("nomeRifa");
        premio = getIntent().getStringExtra("premio");
        dataSorteio = getIntent().getStringExtra("dataSorteio");
        qtPontos = getIntent().getStringExtra("qtPontos");
        valor = getIntent().getStringExtra("valor");
        docId = getIntent().getStringExtra("docId");

        if(docId!=null && !docId.isEmpty()){
            isEditar = true;
        }

        nomeRifa.setText(nome);
        premioRifa.setText(premio);
        dataRifa.setText(dataSorteio);
        q_pontosRifa.setText(qtPontos);
        valorRifa.setText(valor);

        if(isEditar){
            Titulo.setText("Editar Rifa");
            delete.setVisibility(View.VISIBLE);
        }
        else {
            Titulo.setText("Criar Rifa");
            delete.setVisibility(View.GONE);
        }
    }

    public void Opcoes_QtPontos(View v){
        PopupMenu popupMenu = new PopupMenu(FormCreateRifa.this, menu_Opcoes);
        popupMenu.getMenu().add("50");
        popupMenu.getMenu().add("100");
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if(menuItem.getTitle() == "50"){
                    q_pontosRifa.setText("50");
                } else if (menuItem.getTitle() == "100") {
                    q_pontosRifa.setText("100");
                }
                return false;
            }
        });
    }

    public void TodosPontos(View v) {
        Intent i = new Intent( this,FormPoints.class);
        startActivity(i);
    }
    public boolean validar()
    {
        boolean retorno = true;
        String nome = nomeRifa.getText().toString();
        String premio = premioRifa.getText().toString();
        String pontos = q_pontosRifa.getText().toString();
        String valor= valorRifa.getText().toString();
        String data = dataRifa.getText().toString();

        if (nome.isEmpty())
        {
            nomeRifa.setError("Campo vazio");
            retorno = false;
        }
        if (premio.isEmpty())
        {
            premioRifa.setError("Campo vazio");
            retorno = false;
        }
        if(pontos.isEmpty())
        {
            q_pontosRifa.setError("Campo vazio");
            retorno = false;
        }
        if(valor.isEmpty())
        {
            valorRifa.setError("Campo vazio");
            retorno = false;
        }
        if(data.isEmpty())
        {
            dataRifa.setError("Campo vazio");
            retorno = false;
        }

        return retorno;
    }

    public void onClick_Create(View v) {
        Intent i = new Intent( this,FormMain.class);
        startActivity(i);
    }

    public void Salvar(View v) {
        if (!validar()) {
            Toast.makeText(this, "Por favor, preencha todos os campos corretamente", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent i = new Intent(this, FormMain.class);
        startActivity(i);

        String nome = nomeRifa.getText().toString();
        String premio = premioRifa.getText().toString();
        String pontos = q_pontosRifa.getText().toString();
        int qtPontos = Integer.parseInt(pontos);
        String valor= valorRifa.getText().toString();
        float valorRifa = Float.parseFloat(valor);
        String data = dataRifa.getText().toString();

        Rifa_Model rifa = new Rifa_Model();
        rifa.setNomeRifa(nome);
        rifa.setPremio(premio);
        rifa.setValor(valorRifa);
        rifa.setQtPontos(qtPontos);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dataRifa = dateFormat.parse(data);
            rifa.setDataSorteio(dataRifa);
        } catch (ParseException e) {
            e.printStackTrace();
            System.err.println("Erro ao converter a data." );
        }

        SalvarNoFirebase(rifa);

    }

    public void SalvarNoFirebase(Rifa_Model rifa) {
        DocumentReference documentReference;
        try {
            if (isEditar) {
                //Update da Rifa
                documentReference = ConfiguracoesDB.getColecaoReferenciaParaRifa().document(docId);
                documentReference.set(rifa).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            //Rifa é adicionada
                            Toast.makeText(FormCreateRifa.this, "Rifa Editada com Sucesso!", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(FormCreateRifa.this, "Não foi Posível Editar!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            } else {
                //Criar Nova Rifa
                documentReference = ConfiguracoesDB.getColecaoReferenciaParaRifa().document();
                documentReference.set(rifa).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            //Rifa é adicionada
                            Toast.makeText(FormCreateRifa.this, "Rifa adicionada com Sucesso!", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(FormCreateRifa.this, "Não foi possível adicionar a Rifa!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }

        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(FormCreateRifa.this, "Erro ao interagir com o sistema. ", Toast.LENGTH_SHORT).show();
        }
    }

    public void DeleteRifa(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Confirmação");
        builder.setMessage("Tem certeza que deseja deletar esta rifa");
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
            documentReference = ConfiguracoesDB.getColecaoReferenciaParaRifa().document(docId);

            documentReference.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        //Rifa é deletada
                        Toast.makeText(FormCreateRifa.this, "Rifa deletada com Sucesso!", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(FormCreateRifa.this, "Erro ao deletar!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } catch (Exception e){
            e.printStackTrace();
            Toast.makeText(FormCreateRifa.this, "Erro ao interagir com o sistema", Toast.LENGTH_SHORT).show();
        }
    }
}