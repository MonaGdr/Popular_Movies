package com.example.popularmovies.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;


import com.example.popularmovies.model.Movie;
import com.example.popularmovies.repository.MovieRepository;

import java.util.List;

public class MovieViewModel extends AndroidViewModel {

    private MovieRepository movieRepository;

    public MovieViewModel(@NonNull Application application) {
        super(application);
        movieRepository = new MovieRepository();
    }


    public MutableLiveData<List<Movie>> getMovies() {
        return movieRepository.getMovies();
    }

}
