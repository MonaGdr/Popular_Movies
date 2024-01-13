package com.example.popularmovies.adapter;

import androidx.recyclerview.widget.DiffUtil;

import com.example.popularmovies.model.Movie;

import java.util.List;

public class MovieUtilCallbacks extends DiffUtil.Callback {


    List<Movie> oldList;
    List<Movie> newList;

    public MovieUtilCallbacks(List<Movie> oldList, List<Movie> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList != null? oldList.size() : 0;
    }

    @Override
    public int getNewListSize() {
        return newList != null? newList.size() : 0;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).getId() == newList.get(newItemPosition).getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).equals(newList.get(newItemPosition));
    }
}
