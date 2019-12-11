package com.br.senac.ppdm.cartagena;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ObterStatus {

    @GET("/cartagena/rest/v1/jogo/status/{idJogo}")
    Call<Status> getStatus(@Path("idJogo") String idJogo);

}
