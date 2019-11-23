package com.example.omdbapiconsume;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.omdbapiconsume.model.OmdbMovieResponse;
import com.example.omdbapiconsume.presenter.MoviePresenter;
import com.example.omdbapiconsume.ui.AdapterMovie;
import com.example.omdbapiconsume.ui.MovieContract;

import static java.util.Objects.requireNonNull;

public class MovieActivity extends AppCompatActivity implements MovieContract.View {
    Button btnSearch;
    Button btnClean;
    RecyclerView rvMovies;
    EditText etMovie;
    TextView tvTotal;
    MoviePresenter moviePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moviePresenter = new MoviePresenter(this);

        btnSearch = findViewById(R.id.bt_search);
        btnClean = findViewById(R.id.bt_clean);
        rvMovies = findViewById(R.id.rv_movies);
        etMovie = findViewById(R.id.et_movie);
        tvTotal = findViewById(R.id.tv_total);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moviePresenter.getMoviesBySearch(etMovie.getText().toString());
                InputMethodManager keyboard = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                requireNonNull(keyboard).hideSoftInputFromWindow(etMovie.getWindowToken(), 0);
            }
        });

        btnClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

                rvMovies.setLayoutManager(linearLayoutManager);
                rvMovies.setAdapter(null);
                etMovie.getText().clear();
                tvTotal.setText("");
            }
        });
    }

    @Override
    public void updateRecycleView(OmdbMovieResponse omdbMovieResponse) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        AdapterMovie adapterMovie = new AdapterMovie(omdbMovieResponse);

        rvMovies.setLayoutManager(linearLayoutManager);
        rvMovies.setAdapter(adapterMovie);
    }

    @Override
    public void updateTextViewResults(String text) {
        tvTotal.setText(text);
    }
}
