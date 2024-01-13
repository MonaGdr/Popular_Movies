package com.example.popularmovies.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    public static final String BASE_URL = "https://api.themoviedb.org/3/";


    private Retrofit retrofit = null;

    public MovieService getMovieService(){

        if ( retrofit == null ){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }

        return retrofit.create(MovieService.class);
    }
}
