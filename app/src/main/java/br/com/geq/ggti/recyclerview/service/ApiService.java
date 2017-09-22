package br.com.geq.ggti.recyclerview.service;

import java.util.List;

import br.com.geq.ggti.recyclerview.model.Usuario;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by 750371415 on 20/09/2017.
 */

public interface ApiService {

    @GET("v1.1/henrique")
    Call<List<Usuario>> getDadosUsuarios();
}
