package com.br.senac.ppdm.cartagena;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AcaoAndarFrente {

    @POST("/cartagena/rest/v1/jogo/jogar/{posicao}/{carta}")
    Call<Status> postAndarFrente(@Body Autenticacao autenticacao, @Path("posicao") String pos, @Path("carta") String carta);

}
