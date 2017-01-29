package com.project.blejder.everycounter.main.dagger;

import com.project.blejder.everycounter.main.activities.MainActivity;

import dagger.Component;

@Component
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
