package com.inmovie.inmovie;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;

import com.inmovie.inmovie.Activities.MainActivity;

public class HandlingTrending extends Handler {
    private MainActivity main;

    public HandlingTrending(MainActivity activity){
        main = activity;
    }

    @Override
    public void handleMessage(Message message){
    }

}