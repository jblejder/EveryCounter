package com.project.blejder.everycounter.presentation.shared.dagger;


import com.project.blejder.everycounter.presentation.detail.fragments.DetailCounterFragment;

import dagger.Component;

@Component(dependencies = AppComponent.class)
public interface ActivityComponent {

    void inject(DetailCounterFragment detailCounterFragment);
}
