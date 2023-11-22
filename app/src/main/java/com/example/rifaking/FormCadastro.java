package com.example.rifaking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

public class FormCadastro extends AppCompatActivity {
    Usuario usuario;
    FirebaseAuth autenticacao;
    EditText campoNome, campoEmail, campoSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cadastro);
        inicializar();
    }

    private void inicializar() {
        campoNome = findViewById(R.id.edt_nome);
        campoEmail = findViewById(R.id.edt_email);
        campoSenha = findViewById(R.id.edt_senha);

    }

    public void validar(View view)
    {
        String nome = campoNome.getText().toString();
        String email = campoEmail.getText().toString();
        String senha = campoSenha.getText().toString();

        if (nome.isEmpty()) {
            Toast.makeText(this, "Preencha o Nome", Toast.LENGTH_SHORT).show();
        } else if (email.isEmpty()) {
            Toast.makeText(this, "Preencha o Email", Toast.LENGTH_SHORT).show();
        } else if(senha.isEmpty()) {
            Toast.makeText(this, "Preencha a Senha", Toast.LENGTH_SHORT).show();
        } else {
            usuario = new Usuario();
            usuario.setNome(nome);
            usuario.setEmail(email);
            usuario.setSenha(senha);
            cadastrarUsuario();
        }
    }

    public void onClick_SingIn() {
        Intent i = new Intent( this,FormLogin.class);
        startActivity(i);
    }

    private void cadastrarUsuario() {
        autenticacao = ConfiguracoesDB.FirebaseAutenticacao();

        autenticacao.createUserWithEmailAndPassword(
                usuario.getEmail(),
                usuario.getSenha()
        ).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(FormCadastro.this, "Validacao Ok", Toast.LENGTH_SHORT).show();
                    onClick_SingIn();
                } else {
                    String exececao;

                    try {
                        throw task.getException();
                    } catch (FirebaseAuthUserCollisionException e) {
                        exececao = "Essa conta ja existe";
                    } catch (FirebaseAuthWeakPasswordException e) {
                        exececao = "Digite uma senha mais forte";
                    } catch (Exception e) {
                        exececao = "Preencha os campos corretamente";
                        e.printStackTrace();
                    }

                    Toast.makeText(FormCadastro.this, exececao, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}