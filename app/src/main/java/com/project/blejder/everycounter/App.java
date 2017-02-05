package com.project.blejder.everycounter;

import android.app.Application;

import com.project.blejder.everycounter.presentation.shared.dagger.AppComponent;
import com.project.blejder.everycounter.presentation.shared.dagger.DaggerAppComponent;
import com.project.blejder.everycounter.presentation.shared.dagger.modules.AppModule;

import timber.log.Timber;

public class App extends Application {

    private AppComponent appComponent;

    public AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        Fonts.initialize(getAssets());
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }
}
