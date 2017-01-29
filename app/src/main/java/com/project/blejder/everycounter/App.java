package com.project.blejder.everycounter;

import android.app.Application;

import com.project.blejder.everycounter.shared.dagger.AppComponent;
import com.project.blejder.everycounter.shared.dagger.DaggerAppComponent;
import com.project.blejder.everycounter.shared.dagger.modules.AppModule;

public class App extends Application {

    private static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Fonts.initialize(getAssets());
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }
}
