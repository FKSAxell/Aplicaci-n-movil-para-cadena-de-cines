package com.example.triviamagica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_login = (Button) findViewById(R.id.btn_login);
        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }
    }
    public void avanzar(View view) {
        Intent intent = new Intent(this, Pregunta.class);
        startActivity(intent);
    }
}