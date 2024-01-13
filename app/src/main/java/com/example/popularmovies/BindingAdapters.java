package com.example.popularmovies;

import android.widget.ImageView;
import androidx.databinding.BindingAdapter;
import com.bumptech.glide.Glide;

public class BindingAdapters {
    @BindingAdapter("posterPath")
    public static void loadPoster(ImageView view, String posterPath) {


        String defaultUrl = "https://cdn1.iconfinder.com/data/icons/photo/154/landscape-photo-1024.png";
        String url = "http://image.tmdb.org/t/p/w500"+posterPath;
        Glide.with(view.getContext())
                .asBitmap()
                .load(url)
                .error(Glide.with(view.getContext())
                        .asBitmap()
                        .load(defaultUrl))
                .into(view);



    }
}