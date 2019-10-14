package com.example.dunqian;

import android.app.Application;

import com.example.dunqian.manager.RequestManager;


public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RequestManager.getInstance().init(this);
    }
}
