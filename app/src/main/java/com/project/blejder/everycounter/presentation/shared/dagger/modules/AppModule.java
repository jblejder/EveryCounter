package com.project.blejder.everycounter.presentation.shared.dagger.modules;

import android.content.Context;

import com.project.blejder.everycounter.App;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private App mApp;

    public AppModule(App mApp) {
        this.mApp = mApp;
    }

    @Provides
    App provideApplication() {
        return mApp;
    }

    @Provides
    Context proviceContext() {
        return mApp;
    }
}
