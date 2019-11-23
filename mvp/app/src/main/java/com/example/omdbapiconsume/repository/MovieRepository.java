package com.example.omdbapiconsume.repository;

import com.example.omdbapiconsume.model.OmdbMovieResponse;
import com.example.omdbapiconsume.repository.config.BaseCallBack;
import com.example.omdbapiconsume.repository.config.BaseRetrofitConfig;
import com.example.omdbapiconsume.repository.config.MovieApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.util.Objects.requireNonNull;

public class MovieRepository extends BaseRetrofitConfig {
    private MovieApiService movieApiService;

    public MovieRepository() {
        super();
        movieApiService = retrofit.create(MovieApiService.class);
    }

    public void searchMoviesByText(String text, BaseCallBack<OmdbMovieResponse> baseCallBack) {
        Call<OmdbMovieResponse> omdbApi = movieApiService.getOmdbApi(apiKey, text);

        omdbApi.enqueue(baseCallBack);
    }

}
