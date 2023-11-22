package com.example.rifaking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

public class FormLogin extends AppCompatActivity {

    EditText campoEmail, campoSenha;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);
        auth = ConfiguracoesDB.FirebaseAutenticacao();
        inicializarComponentes();
    }

    public void Login()
    {
        Intent i = new Intent( this,FormMain.class);
        startActivity(i);
    }

    private void inicializarComponentes() {
        campoEmail = findViewById(R.id.emailLogin);
        campoSenha = findViewById(R.id.passwordLogin);
    }

    public void validar(View view)
    {
        String email = campoEmail.getText().toString();
        String senha = campoSenha.getText().toString();

        if (email.isEmpty()) {
            campoSenha.setError("Email vazio");
        } else if(senha.isEmpty()) {
            campoSenha.setError("Senha vazia");
        } else {
            Usuario usuario = new Usuario();
            usuario.setEmail(email);
            usuario.setSenha(senha);
            logar(usuario);
        }
    }

    private void logar(Usuario usuario) {
        String s = "SIM";

        auth.signInWithEmailAndPassword(usuario.getEmail(), usuario.getSenha()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Login();
                } else {
                    String exececao;

                    try {
                        throw task.getException();
                    } catch (FirebaseAuthInvalidUserException e) {
                        exececao = "Usuario Invalido";
                    } catch (FirebaseAuthInvalidCredentialsException e) {
                        exececao = "Credenciais Invalidas";
                    } catch (Exception e) {
                        exececao = "Preencha os campos corretamente";
                        e.printStackTrace();
                    }

                    Toast.makeText(FormLogin.this, exececao, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void onClick_SingUp(View v) {
        Intent i = new Intent( this,FormCadastro.class);
        startActivity(i);
    }
}