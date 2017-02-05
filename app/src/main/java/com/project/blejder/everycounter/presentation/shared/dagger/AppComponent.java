package com.project.blejder.everycounter.presentation.shared.dagger;

import android.content.Context;

import com.project.blejder.everycounter.App;
import com.project.blejder.everycounter.presentation.shared.dagger.modules.AppModule;

import dagger.Component;

@Component(modules = {AppModule.class})
public interface AppComponent {

    App provideApp();

    Context provideContext();
}
