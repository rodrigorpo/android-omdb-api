package com.example.omdbapiconsume;

import android.annotation.SuppressLint;
import android.widget.EditText;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.util.Objects.requireNonNull;

public class MovieService extends BaseRetrofitConfig {
    private MovieApiService movieApiService;

    public MovieService() {
        super();
        movieApiService = retrofit.create(MovieApiService.class);
    }

    public void searchMoviesByText(String text, final RecyclerView rvMovies, final TextView tvTotal, final LinearLayoutManager linearLayoutManager) {
        Call<OmdbMovieResponse> omdbApi = movieApiService.getOmdbApi(apiKey, text);

        omdbApi.enqueue(new Callback<OmdbMovieResponse>() {
            @Override
            public void onResponse(Call<OmdbMovieResponse> call, Response<OmdbMovieResponse> response) {
                OmdbMovieResponse omdbMovieResponse = response.body();

                AdapterMovie adapterMovie = new AdapterMovie(omdbMovieResponse);

                rvMovies.setLayoutManager(linearLayoutManager);
                rvMovies.setAdapter(adapterMovie);
                tvTotal.setText(getFormattedResults(requireNonNull(omdbMovieResponse).getTotalResults()));
            }

            @Override
            public void onFailure(Call<OmdbMovieResponse> call, Throwable t) {
                try {
                    throw t;
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        });
    }


    @SuppressLint("DefaultLocale")
    private String getFormattedResults(Integer total) {
        if (total == null) {
            total = 0;
        }

        return String.format("Total Results: %d", total);
    }
}
