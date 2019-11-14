package com.br.senac.ppdm.cartagena;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Entrar extends AppCompatActivity {

    Button btnEntrarSala;
    Button btnCriarSala;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrar);

        btnEntrarSala = findViewById(R.id.btnEntrarEmSala);
        btnCriarSala = findViewById(R.id.btnCriarSala);

        btnEntrarSala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent entrarSala = new Intent (Entrar.this, EntrarEmSala.class);
                startActivity(entrarSala);

            }
        });

        btnCriarSala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent criarSala = new Intent (Entrar.this, CriarSala.class);
                startActivity(criarSala);
            }
        });



    }
}
