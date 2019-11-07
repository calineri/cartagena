package com.br.senac.ppdm.cartagena;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {

    Button btnJogar;
    Button btnOpcoes;
    Button btnSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnJogar = findViewById(R.id.btnJogar);
        btnOpcoes = findViewById(R.id.btnOpcoes);
        btnSair = findViewById(R.id.btnSair);

        btnJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jogar = new Intent(MainActivity.this, Entrar.class);
                startActivity(jogar);
            }
        });

        btnOpcoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent opcoes = new Intent(MainActivity.this, Opcoes.class);
                startActivity(opcoes);
            }
        });

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }
}
