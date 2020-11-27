package com.example.triviamagica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Perder extends AppCompatActivity {
    private TextView mensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perder);
        Bundle datos = this.getIntent().getExtras();
        int cuantas = datos.getInt("cuantas");
        mensaje = (TextView) findViewById(R.id.mensaje);
        mensaje.setText("Ha respondido "+cuantas+" preguntas");


    }
    public void salir(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXIT", true);
        startActivity(intent);
    }
    public void volver(View view) {
        System.exit(0);
    }
}