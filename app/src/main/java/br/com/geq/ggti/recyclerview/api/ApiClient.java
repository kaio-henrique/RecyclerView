package br.com.geq.ggti.recyclerview.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 750371415 on 20/09/2017.
 */

public class ApiClient {

    public static final String API_BASE_URL = "http://api.esmaltec.com.br/";
    private static Retrofit retrofit = null;

    public static Retrofit getRetrofit(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }



}
