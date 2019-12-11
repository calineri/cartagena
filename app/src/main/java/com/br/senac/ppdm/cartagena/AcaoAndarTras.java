package com.br.senac.ppdm.cartagena;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AcaoAndarTras {

    @POST("/cartagena/rest/v1/jogo/jogar/{posicao}")
    Call<Status> postAndarTras(@Body Autenticacao autenticacao, @Path("posicao") String pos);

}
