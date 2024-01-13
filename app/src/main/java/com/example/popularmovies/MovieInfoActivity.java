package com.example.popularmovies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.popularmovies.databinding.ActivityMovieInfoBinding;
import com.example.popularmovies.model.Movie;


public class MovieInfoActivity extends AppCompatActivity {

    //data binding
    ActivityMovieInfoBinding activityMovieInfoBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_info);

        Intent intent = getIntent();
        Movie movie = intent.getParcelableExtra("movie");

        activityMovieInfoBinding = DataBindingUtil.setContentView(MovieInfoActivity.this, R.layout.activity_movie_info);
        activityMovieInfoBinding.setMovie(movie);

        movie.setPosterPath( "http://image.tmdb.org/t/p/w500"+movie.getPosterPath());
        Log.i("myTag", movie.getPosterPath() );



    }
}