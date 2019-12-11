package com.br.senac.ppdm.cartagena;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ObterMaoJogador {

    @GET("/cartagena/rest/v1/jogador/mao/{id}/{senha}")
    Call<List<Carta>> getMaoJogador(@Path("id") String id, @Path("senha") String senha);
}
