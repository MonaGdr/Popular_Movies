package com.example.popularmovies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.popularmovies.adapter.MovieAdapter;
import com.example.popularmovies.databinding.ActivityMainBinding;
import com.example.popularmovies.model.Movie;
import com.example.popularmovies.viewModel.MovieViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Data binding
    ActivityMainBinding activityMainBinding;

    //view model
    MovieViewModel movieViewModel;

    //data
    ArrayList<Movie> moviesArrayList;

    //adapter
    MovieAdapter adapter;
    RecyclerView rv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //data binding
        activityMainBinding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);


        //view model
        movieViewModel = new ViewModelProvider(this).get(MovieViewModel.class);


        movieViewModel.getMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                moviesArrayList = (ArrayList<Movie>) movies;

                //testing if data is fetching successfully.
                for (Movie movie: moviesArrayList){
                    String url2 = "http://image.tmdb.org/t/p/w500"+movie.getPosterPath();
                    Log.i("myTag1", url2);
                }

                //set the adapter
                loadMoviesOnRecyclerView();

            }
        });





    }

    private void loadMoviesOnRecyclerView() {
        rv = activityMainBinding.recyclerView;
        rv.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
        adapter = new MovieAdapter(MainActivity.this);
        adapter.setMovies(moviesArrayList);
        adapter.setListener(new MovieAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Movie movie) {
                Intent intent = new Intent(MainActivity.this, MovieInfoActivity.class);
                intent.putExtra("movie", movie);
                startActivity(intent);
            }
        });
        rv.setAdapter(adapter);
    }

}