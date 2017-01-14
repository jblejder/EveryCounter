package com.project.blejder.everycounter.detail.dagger;

import com.project.blejder.everycounter.detail.fragments.DetailCounterFragment;
import com.project.blejder.everycounter.main.dagger.MainComponent;

import dagger.Component;

@Component(dependencies = MainComponent.class)
public interface DetailComponent {
    void inject(DetailCounterFragment detailCounterFragment);
}
