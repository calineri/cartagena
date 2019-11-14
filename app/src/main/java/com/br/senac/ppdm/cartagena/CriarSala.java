package com.br.senac.ppdm.cartagena;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.senac.pdm.mepresidenta.lobby.CriarJogoActivity;

public class CriarSala extends AppCompatActivity {

    EditText etNomePartida;
    EditText etNomeJogador;
    EditText etSenha;
    Button btnCriar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_sala);

        etNomePartida = findViewById(R.id.etNomePartida);
        etNomeJogador = findViewById(R.id.etNomeJogadorCriarSala);
        etSenha = findViewById(R.id.etSenhaCriarSala);
        btnCriar = findViewById(R.id.btnCriarSala);

        btnCriar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CriarSala.this, CriarJogoActivity.class);
                intent.putExtra("nomeJogador",etNomeJogador.getText().toString());
                intent.putExtra("nomeJogo",etNomePartida.getText().toString());
                intent.putExtra("senhaJogo", etSenha.getText().toString());
                intent.putExtra("criar",true);
                intent.putExtra("atividadeJogo","com.br.senac.ppdm.cartagena.JogoPrincipal");
                startActivity(intent);
            }
        });
    }
}
