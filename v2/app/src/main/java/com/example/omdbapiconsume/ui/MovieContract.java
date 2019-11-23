package com.example.omdbapiconsume.ui;

import com.example.omdbapiconsume.model.OmdbMovieResponse;

public class MovieContract {
    public interface Presenter {
        void getMoviesBySearch(String search);
    }

    public interface View{
        void updateRecycleView(OmdbMovieResponse omdbMovieResponse);
        void updateTextViewResults(String text);
    }
}
