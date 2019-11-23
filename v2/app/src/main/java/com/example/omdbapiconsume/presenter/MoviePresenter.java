package com.example.omdbapiconsume.presenter;

import android.annotation.SuppressLint;

import com.example.omdbapiconsume.model.OmdbMovieResponse;
import com.example.omdbapiconsume.repository.MovieRepository;
import com.example.omdbapiconsume.repository.config.BaseCallBack;
import com.example.omdbapiconsume.ui.MovieContract;

import static java.util.Objects.requireNonNull;

public class MoviePresenter implements MovieContract.Presenter {
    private MovieContract.View mview;
    private MovieRepository movieRepository;

    public MoviePresenter(MovieContract.View mview) {
        this.mview = mview;
        movieRepository = new MovieRepository();
    }

    @Override
    public void getMoviesBySearch(String search) {
        movieRepository.searchMoviesByText(search, new BaseCallBack<OmdbMovieResponse>() {
            @Override
            public void onSuccess(OmdbMovieResponse response) {
                mview.updateRecycleView(response);
                mview.updateTextViewResults(getFormattedResults(requireNonNull(response).getTotalResults()));
            }

            @Override
            public void onError(Throwable t) {

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
