package com.project.blejder.everycounter;

import android.app.Application;

public class EveryCounterApp extends Application {

    @Deprecated
    public static EveryCounterApp instance;

    @Override
    public void onCreate() {
        super.onCreate();

        EveryCounterApp.instance = this;
        Fonts.initialize(getAssets());
    }
}
