package com.project.blejder.everycounter;

import android.app.Application;

public class EveryCounter extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Fonts.initialize(getAssets());
    }
}
