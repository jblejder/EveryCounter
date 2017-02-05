package com.project.blejder.everycounter.presentation.main.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.project.blejder.everycounter.presentation.detail.fragments.DetailCounterFragment;
import com.project.blejder.everycounter.presentation.shared.dagger.ActivityComponent;
import com.project.blejder.everycounter.presentation.shared.dagger.AppComponent;
import com.project.blejder.everycounter.presentation.shared.dagger.DaggerActivityComponent;
import com.project.blejder.everycounter.presentation.shared.fragments.BaseActivity;
import com.project.blejder.everycounter.presentation.shared.fragments.TransactionType;

public class MainActivity extends BaseActivity {

    ActivityComponent activityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createComponent();

        super.loadFragment(DetailCounterFragment.newInstance(), TransactionType.Replace);
    }

    private void createComponent() {
        AppComponent appComponent = getAppComponent();
        activityComponent = DaggerActivityComponent.builder().appComponent(appComponent).build();
    }

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }
}
