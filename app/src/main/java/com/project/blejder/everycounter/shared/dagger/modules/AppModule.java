package com.project.blejder.everycounter.shared.dagger.modules;

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
}
