package com.br.senac.ppdm.cartagena;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AcaoPularVez {

    @POST("/cartagena/rest/v1/jogo/jogar")
    Call<Status> postPularVez(@Body Autenticacao autenticacao);

}
