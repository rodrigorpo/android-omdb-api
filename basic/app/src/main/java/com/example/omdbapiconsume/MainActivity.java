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

import static java.util.Objects.requireNonNull;

public class MainActivity extends AppCompatActivity {
    Button btnSearch;
    Button btnClean;
    RecyclerView rvMovies;
    EditText etMovie;
    MovieService movieService = new MovieService();
    TextView tvTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSearch = findViewById(R.id.bt_search);
        btnClean = findViewById(R.id.bt_clean);
        rvMovies = findViewById(R.id.rv_movies);
        etMovie = findViewById(R.id.et_movie);
        tvTotal = findViewById(R.id.tv_total);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                movieService.searchMoviesByText(etMovie.getText().toString(), rvMovies, tvTotal, linearLayoutManager);
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
            }
        });
    }
}
