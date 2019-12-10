package com.br.senac.ppdm.cartagena;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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

        containerH1 =  (ViewGroup) findViewById(R.id.containerH1);
        containerH2 =  (ViewGroup) findViewById(R.id.containerH2);
        containerH3 =  (ViewGroup) findViewById(R.id.containerH3);
        containerH4 =  (ViewGroup) findViewById(R.id.containerH4);
        containerH5 =  (ViewGroup) findViewById(R.id.containerH5);
        containerH6 =  (ViewGroup) findViewById(R.id.containerH6);
        containerH7 =  (ViewGroup) findViewById(R.id.containerH7);
        containerH8 =  (ViewGroup) findViewById(R.id.containerH8);
        containerH9 =  (ViewGroup) findViewById(R.id.containerH9);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://kingme.azurewebsites.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ObterConfTabuleiro confTabuleiro = retrofit.create(ObterConfTabuleiro.class);

        Call<List<CasaTabuleiro>> casaTabuleiro = confTabuleiro.getConfTabuleiro("154");

        casaTabuleiro.enqueue(new Callback<List<CasaTabuleiro>>() {
            @Override
            public void onResponse(Call<List<CasaTabuleiro>> call, Response<List<CasaTabuleiro>> response) {

                if (!response.isSuccessful()){
                    Toast.makeText(JogoPrincipal.this, "Deu erro: " + response.code(), Toast.LENGTH_LONG).show();
                } else {
                    List<CasaTabuleiro> casas = response.body();
                    montaTabuleiro(casas);

                }

            }

            @Override
            public void onFailure(Call<List<CasaTabuleiro>> call, Throwable t) {
                Toast.makeText(JogoPrincipal.this, "Erro Inesperado!", Toast.LENGTH_LONG).show();

            }
        });

    }

    private void montaTabuleiro(List<CasaTabuleiro> casas){
        int numCard = 1;

        for(int j = 0; j < 4; j++){
            addItem(containerH1, casas.get(numCard).getTipo(),numCard++);

        }

        numCard = numCard + 3;
        for(int j = 0; j < 4; j++){
            addItem(containerH2, casas.get(numCard).getTipo(),numCard--);

        }

        numCard = numCard + 5;
        for(int j = 0; j < 4; j++){
            addItem(containerH3, casas.get(numCard).getTipo(),numCard++);

        }

        numCard = numCard + 3;
        for(int j = 0; j < 4; j++){
            addItem(containerH4, casas.get(numCard).getTipo(),numCard--);

        }

        numCard = numCard + 5;
        for(int j = 0; j < 4; j++){
            addItem(containerH5, casas.get(numCard).getTipo(),numCard++);

        }

        numCard = numCard + 3;
        for(int j = 0; j < 4; j++){
            addItem(containerH6, casas.get(numCard).getTipo(),numCard--);

        }

        numCard = numCard + 5;
        for(int j = 0; j < 4; j++){
            addItem(containerH7, casas.get(numCard).getTipo(),numCard++);

        }

        numCard = numCard + 3;
        for(int j = 0; j < 4; j++){
            addItem(containerH8, casas.get(numCard).getTipo(),numCard--);

        }

        numCard = numCard + 5;
        for(int j = 0; j < 4; j++){
            addItem(containerH9, casas.get(numCard).getTipo(),numCard++);

        }
    }

    private void addItem(ViewGroup container, String tipo,int num){

        CardView cardView = (CardView) LayoutInflater.from(this)
                .inflate(R.layout.card_mapa, container, false);

        TextView numCard  = (TextView)  cardView.findViewById(R.id.numCard);
        ImageView imgJog1 = (ImageView) cardView.findViewById(R.id.peaoAmarelo);
        ImageView imgJog2 = (ImageView) cardView.findViewById(R.id.peaoAzul);
        ImageView imgJog3 = (ImageView) cardView.findViewById(R.id.peaoPreto);
        ImageView imgJog4 = (ImageView) cardView.findViewById(R.id.peaoVerde);
        ImageView imgJog5 = (ImageView) cardView.findViewById(R.id.peaoVermelho);
        ImageView imgCasa = (ImageView) cardView.findViewById(R.id.imageView4);

        imgJog1.setVisibility(View.INVISIBLE);
        imgJog2.setVisibility(View.INVISIBLE);
        imgJog3.setVisibility(View.INVISIBLE);

        numCard.setText(String.valueOf(num));

        switch (tipo){
            case "F":
                imgCasa.setImageResource(R.drawable.faca);
                break;
            case "G":
                imgCasa.setImageResource(R.drawable.garrafa);
                break;
            case "C":
                imgCasa.setImageResource(R.drawable.chave);
                break;
            case "P":
                imgCasa.setImageResource(R.drawable.pistola);
                break;
            case "T":
                imgCasa.setImageResource(R.drawable.tricornio);
                break;
            case "E":
                imgCasa.setImageResource(R.drawable.esqueleto);
                break;
            default:
                break;
        }

        container.addView(cardView);

    }
}
