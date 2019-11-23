package com.example.omdbapiconsume;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    Button btnSearch;
    Button btnClean;
    RecyclerView rvMovies;
    EditText etMovie;
    MovieService movieService = new MovieService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSearch = findViewById(R.id.bt_search);
        btnClean = findViewById(R.id.bt_clean);
        rvMovies = findViewById(R.id.rv_movies);
        etMovie = findViewById(R.id.et_movie);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                movieService.searchMoviesByText(etMovie.getText().toString(), rvMovies, linearLayoutManager);
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
