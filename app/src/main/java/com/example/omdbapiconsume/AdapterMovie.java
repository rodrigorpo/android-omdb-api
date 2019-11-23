package com.example.omdbapiconsume;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class AdapterMovie extends RecyclerView.Adapter<AdapterMovie.ViewHolder> {
    private OmdbMovieResponse omdb;

    public AdapterMovie(OmdbMovieResponse omdb) {
        this.omdb = omdb;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.video_frame, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.bind(omdb.getSearch().get(position), omdb.getTotalResults());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivMovie;
        TextView tvTitle;
        TextView tvYear;
        TextView tvType;
        TextView tvImdbId;
        TextView tvTotal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            findItemsById(itemView);
        }

        public void bind(Movie movie, Integer total) {
            if (movie == null) {
                return;
            }

//            Picasso.get().load(movie.getPosterURL()).into(ivMovie);
            tvTitle.setText(movie.getTitle());
            tvYear.setText(movie.getYear());
            tvType.setText(movie.getType().name());
            tvImdbId.setText(movie.getImdbID());
            tvTotal.setText(getFormattedResults(total));
        }

        @SuppressLint("DefaultLocale")
        private String getFormattedResults(Integer total) {
            if (total == null) {
                total = 0;
            }

            return String.format("Total Results: %d", total);
        }

        private void findItemsById(@NonNull View itemView) {
            ivMovie = itemView.findViewById(R.id.iv_movie);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvYear = itemView.findViewById(R.id.tv_year);
            tvType = itemView.findViewById(R.id.tv_type);
            tvImdbId = itemView.findViewById(R.id.tv_imdbId);
            tvTotal = itemView.findViewById(R.id.tv_total);
        }
    }
}
