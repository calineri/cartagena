package com.br.senac.ppdm.cartagena;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class JogoPrincipal extends AppCompatActivity {

    private ViewGroup containerH1;
    private ViewGroup containerH2;
    private ViewGroup containerH3;
    private ViewGroup containerH4;
    private ViewGroup containerH5;
    private ViewGroup containerH6;
    private ViewGroup containerH7;
    private ViewGroup containerH8;
    private ViewGroup containerH9;

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

        containerH1 =  (ViewGroup) findViewById(R.id.containerH1);
        containerH2 =  (ViewGroup) findViewById(R.id.containerH2);
        containerH3 =  (ViewGroup) findViewById(R.id.containerH3);
        containerH4 =  (ViewGroup) findViewById(R.id.containerH4);
        containerH5 =  (ViewGroup) findViewById(R.id.containerH5);
        containerH6 =  (ViewGroup) findViewById(R.id.containerH6);
        containerH7 =  (ViewGroup) findViewById(R.id.containerH7);
        containerH8 =  (ViewGroup) findViewById(R.id.containerH8);
        containerH9 =  (ViewGroup) findViewById(R.id.containerH9);

        int numCard = 1;

        for(int j = 0; j < 4; j++){
            addItem(containerH1, numCard++);

        }

        numCard = numCard + 3;
        for(int j = 0; j < 4; j++){
            addItem(containerH2, numCard--);

        }

        numCard = numCard + 5;
        for(int j = 0; j < 4; j++){
            addItem(containerH3, numCard++);

        }

        numCard = numCard + 3;
        for(int j = 0; j < 4; j++){
            addItem(containerH4, numCard--);

        }

        numCard = numCard + 5;
        for(int j = 0; j < 4; j++){
            addItem(containerH5, numCard++);

        }

        numCard = numCard + 3;
        for(int j = 0; j < 4; j++){
            addItem(containerH6, numCard--);

        }

        numCard = numCard + 5;
        for(int j = 0; j < 4; j++){
            addItem(containerH7, numCard++);

        }

        numCard = numCard + 3;
        for(int j = 0; j < 4; j++){
            addItem(containerH8, numCard--);

        }

        numCard = numCard + 5;
        for(int j = 0; j < 4; j++){
            addItem(containerH9, numCard++);

        }

    }

    private void addItem(ViewGroup container, int num){

        CardView cardView = (CardView) LayoutInflater.from(this)
                .inflate(R.layout.card_mapa, container, false);

        TextView numCard  = (TextView)  cardView.findViewById(R.id.numCard);
        ImageView imgJog1 = (ImageView) cardView.findViewById(R.id.imageView1);
        ImageView imgJog2 = (ImageView) cardView.findViewById(R.id.imageView2);
        ImageView imgJog3 = (ImageView) cardView.findViewById(R.id.imageView3);
        ImageView imgCasa = (ImageView) cardView.findViewById(R.id.imageView4);

        numCard.setText(String.valueOf(num));

        container.addView(cardView);

    }
}
