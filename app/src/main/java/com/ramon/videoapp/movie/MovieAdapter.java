package com.ramon.videoapp.movie;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.ramon.videoapp.webservices.movie.models.MovieResult;

import java.util.List;


public class MovieAdapter extends RecyclerView.Adapter {


    private final ItemClickedListener listner;
    private final List<MovieResult> movieResults;

    public MovieAdapter(ItemClickedListener listener, List<MovieResult> movieResults) {
        this.listner=listener;
        this.movieResults=movieResults;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return MovieViewHolder.inflate(viewGroup,listner);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (!movieResults.isEmpty()) {
            ((MovieViewHolder) viewHolder).bind(movieResults.get(i));
        }
    }

    @Override
    public int getItemCount() {
        return movieResults.size();
    }
}
