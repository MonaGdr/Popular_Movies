package com.example.popularmovies.adapter;

import android.content.Context;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.popularmovies.R;
import com.example.popularmovies.databinding.MovieItemLayoutBinding;
import com.example.popularmovies.model.Movie;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private ArrayList<Movie> movies;

    private Context context;

    public MovieAdapter(Context context) {
        this.context = context;
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    private OnItemClickListener listener;
    public void setMovies(ArrayList<Movie> newMovies) {

        DiffUtil.DiffResult result = DiffUtil.calculateDiff(new MovieUtilCallbacks(movies, newMovies));
        movies = newMovies;
        result.dispatchUpdatesTo(MovieAdapter.this);

    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        MovieItemLayoutBinding movieItemLayoutBinding = DataBindingUtil.inflate(inflater, R.layout.movie_item_layout,parent,false);
        return new MovieViewHolder(movieItemLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.movieItemLayoutBinding.setMovie(movies.get(position));

    }

    @Override
    public int getItemCount() {
        return movies != null? movies.size() : 0;
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        MovieItemLayoutBinding movieItemLayoutBinding;
        public MovieViewHolder(@NonNull MovieItemLayoutBinding movieItemLayoutBinding) {
            super(movieItemLayoutBinding.getRoot());
            this.movieItemLayoutBinding = movieItemLayoutBinding;

            movieItemLayoutBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if ( listener != null && pos != RecyclerView.NO_POSITION ){
                        listener.onItemClick(movies.get(pos));
                    }
                }
            });

        }
    }

    public interface OnItemClickListener{
        void onItemClick(Movie movie);
    }





}
