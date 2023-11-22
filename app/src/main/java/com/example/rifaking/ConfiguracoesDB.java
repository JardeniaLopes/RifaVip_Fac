package com.example.rifaking;

import android.content.Context;
import android.provider.ContactsContract;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConfiguracoesDB {
    private static FirebaseAuth auth;

    public static FirebaseAuth FirebaseAutenticacao() {
        if (auth == null) {
            auth = FirebaseAuth.getInstance();
        }
        return auth;
    }

    public static CollectionReference getColecaoReferenciaParaRifa(){
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        return FirebaseFirestore.getInstance().collection("Rifas")
                .document(currentUser.getUid()).collection("minhas_rifas");
    }

    public static CollectionReference getColecaoPontos(String rifaId){
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

        return FirebaseFirestore.getInstance().collection("Rifas")
                .document(currentUser.getUid()).collection("minhas_rifas")
                .document(rifaId).collection("meus_pontos");
    }


    public static String dataToString(Date data){
        return new SimpleDateFormat("dd/MM/yyyy").format(data);
    }
}
