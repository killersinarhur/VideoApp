package com.ramon.videoapp.webservices.movie;

import android.app.Application;

import com.ramon.videoapp.webservices.movie.callback.MovieListCallback;
import com.ramon.videoapp.webservices.movie.models.DiscoverResults;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDbClient {


    private final Application app;
    private final MovieDbApi client;
    public static final String API_KEY="656a890baf30770abeb36adae862c19e";

    public MovieDbClient(Application app, MovieDbApi client) {
        this.app=app;
        this.client=client;
    }

    public void getDiscoverList(final MovieListCallback callback, int page){
        client.getDiscoverList(API_KEY,true,page).enqueue(new Callback<DiscoverResults>() {
            @Override
            public void onResponse(Call<DiscoverResults> call, Response<DiscoverResults> response) {
                if (response.isSuccessful()){
                    callback.onMovieSuccess(response.body());
                }else {
                    callback.onMovieFailure(response.code(),response.message());
                }
            }

            @Override
            public void onFailure(Call<DiscoverResults> call, Throwable t) {
                callback.onMovieFailure(-1,t.getMessage());

            }
        });
    }
}
