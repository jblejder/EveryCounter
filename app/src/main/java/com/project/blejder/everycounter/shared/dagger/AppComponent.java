package com.project.blejder.everycounter.shared.dagger;

import com.project.blejder.everycounter.App;
import com.project.blejder.everycounter.detail.fragments.DetailCounterFragment;
import com.project.blejder.everycounter.shared.dagger.modules.AppModule;

import dagger.Component;

@Component(modules = {AppModule.class})
public interface AppComponent {

    App provideApp();

    void inject(DetailCounterFragment detailCounterFragment);
}
