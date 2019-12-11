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

        // Cria os objetos que serao utilizados no POST nas mensagens que necessitam
        //TODO Alterar os parametros IDJOGADOR e SENHAJOGADOR pelas variaveis idJogador e senhaJogador respectivamente
        Autenticacao autenticacao = new Autenticacao(243, "C1B427");

        // Cria objeto Retrofit que sera utilizado em todas as chamadas webservice
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://kingme.azurewebsites.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // fim da criacao do objeto

        // Cria objeto que sera chamado para obter as informacoes de configuracao do tabuleiro
        ObterConfTabuleiro confTabuleiro = retrofit.create(ObterConfTabuleiro.class);

        // Cria objeto que ira realizar a chamada e passa o ID da partida como parametro
        //TODO alterar o parametro do ID JOGO para variavel idJogo
        Call<List<CasaTabuleiro>> casaTabuleiro = confTabuleiro.getConfTabuleiro("154");

        // Enfilera chamada do webservice e configura o callback
        casaTabuleiro.enqueue(new Callback<List<CasaTabuleiro>>() {
            @Override
            public void onResponse(Call<List<CasaTabuleiro>> call, Response<List<CasaTabuleiro>> response) {

                if (!response.isSuccessful()){
                    Toast.makeText(JogoPrincipal.this, "Deu erro: " + response.code(), Toast.LENGTH_LONG).show();
                } else {
                    // Obtem as informacoes do servico e guarda em uma lista
                    List<CasaTabuleiro> casas = response.body();
                    // monta o tabuleiro a partir das informacoes retornadas no servico
                    montaTabuleiro(casas);

                }

            }

            @Override
            public void onFailure(Call<List<CasaTabuleiro>> call, Throwable t) {
                Toast.makeText(JogoPrincipal.this, "Erro Inesperado!", Toast.LENGTH_LONG).show();

            }
        });

        //Cria objeto que sera chamado para obter as informacoes de status do jogo
        ObterStatus status = retrofit.create(ObterStatus.class);

        //Cria objeto que ira realizar a chamada e passa o ID da partida como parametro
        //TODO alterar o parametro IDJOGO para variavel idJogo
        Call<Status> statusAtual = status.getStatus("154");

        //Enfilera chamada do webservice e configura o callback
        statusAtual.enqueue(new Callback<Status>() {
            @Override
            public void onResponse(Call<Status> call, Response<Status> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(JogoPrincipal.this, "Deu erro: " + response.code(), Toast.LENGTH_LONG).show();
                } else {
                    // Obtem as informacoes do servico e guarda em uma referencia de objeto
                    Status situacao = response.body();

                    System.out.println(situacao.getIdJogadorDaVez());
                    System.out.println(situacao.getNumeroDaJogada());
                    System.out.println(situacao.getTabuleiro().get(situacao.getIdJogadorDaVez()));

                    for(CasaTabuleiro casa : situacao.getTabuleiro().get(situacao.getIdJogadorDaVez())){
                        System.out.println(casa.getPosicao());
                        System.out.println(casa.getQtd());
                        System.out.println(casa.getTipo());
                    }

                }
            }

            @Override
            public void onFailure(Call<Status> call, Throwable t) {
                Toast.makeText(JogoPrincipal.this, "Erro Inesperado!", Toast.LENGTH_LONG).show();
            }
        });

        // Cria objeto que sera chamado para obter as informacoes da mao jogador
        ObterMaoJogador maoJogador = retrofit.create(ObterMaoJogador.class);

        // Cria objeto que ira realizar a chamada e passa o ID e senha do jogador como parametro
        //TODO Alterar os parametros IDJOGADOR e SENHAJOGADOR pelas variaveis idJogador e senhaJogador respectivamente
        Call<List<Carta>> cartasJogador = maoJogador.getMaoJogador("243", "C1B427");
        System.out.println("ID Jogador: " + idJogador);
        System.out.println("Senha Jogador: " + senhaJogador);

        //Enfilera chamada do webservice e configura o callback
        cartasJogador.enqueue(new Callback<List<Carta>>() {
            @Override
            public void onResponse(Call<List<Carta>> call, Response<List<Carta>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(JogoPrincipal.this, "Deu erro: " + response.code(), Toast.LENGTH_LONG).show();
                } else {
                    List<Carta> cartas = response.body();

                    for(Carta carta : cartas){
                        System.out.println(carta.getTipo());
                        System.out.println(carta.getQtd());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Carta>> call, Throwable t) {
                Toast.makeText(JogoPrincipal.this, "Erro Inesperado!", Toast.LENGTH_LONG).show();
            }
        });
        /*
        //Cria objeto que sera chamado para realizar ação de pular a vez
        AcaoPularVez pularVez = retrofit.create(AcaoPularVez.class);

        // Realiza a chamada e passa os parametros com as informações do jogador que ira realizar esta acao
        // recebe como retorno o status atual da partida
        statusAtual = pularVez.postPularVez(autenticacao);

        statusAtual.enqueue(new Callback<Status>() {
            @Override
            public void onResponse(Call<Status> call, Response<Status> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(JogoPrincipal.this, "Deu erro: " + response.code(), Toast.LENGTH_LONG).show();
                } else {
                    // Obtem as informacoes do servico e guarda em uma referencia de objeto
                    Status situacao = response.body();

                    System.out.println("Pulou a vez com sucesso!!!");
                    System.out.println(situacao.getIdJogadorDaVez());
                    System.out.println(situacao.getNumeroDaJogada());
                    System.out.println(situacao.getTabuleiro().get(situacao.getIdJogadorDaVez()));

                    for(CasaTabuleiro casa : situacao.getTabuleiro().get(situacao.getIdJogadorDaVez())){
                        System.out.println(casa.getPosicao());
                        System.out.println(casa.getQtd());
                        System.out.println(casa.getTipo());
                    }

                }
            }

            @Override
            public void onFailure(Call<Status> call, Throwable t) {
                Toast.makeText(JogoPrincipal.this, "Erro Inesperado!", Toast.LENGTH_LONG).show();
            }
        });
        */
        /*
        //Cria objeto que sera chamado para realizar ação de andar para frente
        AcaoAndarFrente andarFrente = retrofit.create(AcaoAndarFrente.class);

        // Realiza a chamada e passa os parametros com as informações do jogador que ira realizar esta acao
        // passa tambem posicao origem do pirata a ser movido para frente e a carta que sera utilizada
        // recebe como retorno o status atual da partida
        statusAtual = andarFrente.postAndarFrente(autenticacao, "0", "E");

        statusAtual.enqueue(new Callback<Status>() {
            @Override
            public void onResponse(Call<Status> call, Response<Status> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(JogoPrincipal.this, "Deu erro: " + response.code(), Toast.LENGTH_LONG).show();
                } else {
                    // Obtem as informacoes do servico e guarda em uma referencia de objeto
                    Status situacao = response.body();

                    System.out.println("Andou para frente com sucesso!!!");
                    System.out.println(situacao.getIdJogadorDaVez());
                    System.out.println(situacao.getNumeroDaJogada());
                    System.out.println(situacao.getTabuleiro().get(situacao.getIdJogadorDaVez()));

                    for(CasaTabuleiro casa : situacao.getTabuleiro().get(situacao.getIdJogadorDaVez())){
                        System.out.println(casa.getPosicao());
                        System.out.println(casa.getQtd());
                        System.out.println(casa.getTipo());
                    }

                }
            }

            @Override
            public void onFailure(Call<Status> call, Throwable t) {
                Toast.makeText(JogoPrincipal.this, "Erro Inesperado!", Toast.LENGTH_LONG).show();
            }
        });
        */

        //Cria objeto que sera chamado para realizar ação de andar para tras
        AcaoAndarTras andartras = retrofit.create(AcaoAndarTras.class);

        // Realiza a chamada e passa os parametros com as informações do jogador que ira realizar esta acao
        // passa tambem posicao origem do pirata a ser movido para tras
        // recebe como retorno o status atual da partida
        statusAtual = andartras.postAndarTras(autenticacao, "6");

        statusAtual.enqueue(new Callback<Status>() {
            @Override
            public void onResponse(Call<Status> call, Response<Status> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(JogoPrincipal.this, "Deu erro: " + response.code(), Toast.LENGTH_LONG).show();

                } else {
                    // Obtem as informacoes do servico e guarda em uma referencia de objeto
                    Status situacao = response.body();

                    System.out.println("Andou para tras com sucesso!!!");
                    System.out.println(situacao.getIdJogadorDaVez());
                    System.out.println(situacao.getNumeroDaJogada());
                    System.out.println(situacao.getTabuleiro().get(situacao.getIdJogadorDaVez()));

                    for(CasaTabuleiro casa : situacao.getTabuleiro().get(situacao.getIdJogadorDaVez())){
                        System.out.println(casa.getPosicao());
                        System.out.println(casa.getQtd());
                        System.out.println(casa.getTipo());
                    }

                }
            }

            @Override
            public void onFailure(Call<Status> call, Throwable t) {
                Toast.makeText(JogoPrincipal.this, "Erro Inesperado!", Toast.LENGTH_LONG).show();
            }
        });

    }

    // monta o tabuleiro de forma dinamica a partir da lista com as informacoes obtidas no servico
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

    // Cria Card representando cada casa do tabuleiro
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
