package com.br.senac.ppdm.cartagena;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ObterConfTabuleiro {

    @GET("/cartagena/rest/v1/jogo/tabuleiro/{idJogo}")
    Call<List<CasaTabuleiro>> getConfTabuleiro(@Path("idJogo") String idJogo);
}
