package com.br.senac.ppdm.cartagena;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.senac.pdm.mepresidenta.lobby.EscolherJogoActivity;

public class EntrarEmSala extends AppCompatActivity {

    EditText etNomeJogador;
    Button btnEntrarSala;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrar_em_sala);

        etNomeJogador = findViewById(R.id.etNomeJogadorEntrarSala);
        btnEntrarSala = findViewById(R.id.btnEntrarEmSala);

        btnEntrarSala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EntrarEmSala.this, EscolherJogoActivity.class);
                intent.putExtra("nomeJogador",etNomeJogador.getText().toString());
                intent.putExtra("atividadeJogo","com.br.senac.ppdm.cartagena.JogoPrincipal");
                intent.putExtra("criar",false);
                startActivity(intent);
            }
        });

    }
}
