package com.project.blejder.everycounter.shared.dagger;

import com.project.blejder.everycounter.App;
import com.project.blejder.everycounter.list.fragments.ListCountersFragment;
import com.project.blejder.everycounter.shared.dagger.modules.AppModule;

import dagger.Component;

@Component(modules = {AppModule.class})
public interface AppComponent {

    App provideApp();
}
