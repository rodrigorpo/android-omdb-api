package com.example.omdbapiconsume.repository.config;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public abstract class BaseRetrofitConfig {
    protected Retrofit retrofit;
    protected String apiKey = "ba1f4581";

    public BaseRetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("http://www.omdbapi.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }
}
