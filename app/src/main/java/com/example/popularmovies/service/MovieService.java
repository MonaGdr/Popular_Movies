package com.example.popularmovies.service;

import com.example.popularmovies.model.MoviesResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieService {

    String endpointUrl = "movie/popular";
    @GET(endpointUrl)
    Call<MoviesResult> getMovies(@Query("api_key") String apiKey);
}
