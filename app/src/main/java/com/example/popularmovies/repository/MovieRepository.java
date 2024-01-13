package com.example.popularmovies.repository;

import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.example.popularmovies.model.Movie;
import com.example.popularmovies.model.MoviesResult;
import com.example.popularmovies.service.MovieService;
import com.example.popularmovies.service.RetrofitInstance;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {

    private MovieService movieService ;

    private MutableLiveData<List<Movie>> movies;

    public MovieRepository(){

        //accessing interface using retrofit instance
        this.movieService = new RetrofitInstance().getMovieService();
        //mutable live data
        this.movies = new MutableLiveData<>();
    }

    public MutableLiveData<List<Movie>> getMovies(){

        String apiKey = "0506af694fffd7f39f8df8f4babb9508";
        Call<MoviesResult> moviesResultCall = movieService.getMovies(apiKey);

        moviesResultCall.enqueue(new Callback<MoviesResult>() {
            @Override
            public void onResponse(Call<MoviesResult> call, Response<MoviesResult> response) {

                if (response.body() != null && response.body().getResults() != null){
                    movies.setValue(response.body().getResults());

                }

            }

            @Override
            public void onFailure(Call<MoviesResult> call, Throwable t) {

                Log.i("mytag", "ON FAILURE");
            }
        });

        return movies;
    }
}