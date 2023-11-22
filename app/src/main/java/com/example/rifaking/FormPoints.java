package com.example.rifaking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FormPoints extends AppCompatActivity {

    String docId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_points);

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
}