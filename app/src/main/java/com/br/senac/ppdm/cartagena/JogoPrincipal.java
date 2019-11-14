package com.br.senac.ppdm.cartagena;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

public class JogoPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo_principal);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("jogo", 0); // 0 - for private mode

        String idJogador = pref.getString("idJogador","");
        String nomeJogador = pref.getString("nomeJogador","");
        String senhaJogador = pref.getString("senhaJogador","");
        String idJogo = pref.getString("idJogo","");
        String nomeJogo = pref.getString("nomeJogo","");
        String senhaJogo = pref.getString("senhaJogo","");

        // TODO: 13/11/2019 - Criar Interface Principal aqui

    }
}
