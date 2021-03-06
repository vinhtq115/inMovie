package com.inmovie.inmovie.Handlers;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.inmovie.inmovie.Activities.MainActivity;
import com.inmovie.inmovie.MovieTvClasses.Movies;

public class HandlingTrending extends Handler {
    private MainActivity main;

    public HandlingTrending(MainActivity activity){
        main = activity;
    }

    @Override
    public void handleMessage(Message message){
        Bundle data = message.getData();
        Movies hottest = (Movies) data.getSerializable("hottest");
        main.setHottestTrendingMovieBanner(hottest);
    }

}
