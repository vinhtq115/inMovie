package com.inmovie.inmovie.Handlers;

import android.os.Handler;
import android.os.Message;

import com.inmovie.inmovie.Activities.MoviesActivities.MovieDetails;
import com.inmovie.inmovie.MovieTvClasses.Movies;

public class HandlingMovie extends Handler {
    private MovieDetails movieDetails;

    public HandlingMovie(MovieDetails activity) {
        movieDetails = activity;
    }

    @Override
    public void handleMessage(Message message) {
        Movies movies = (Movies) message.getData().get("details");
        if (movies != null) {
            movieDetails.setTrailerTextColor(movies);
        }
    }
}
