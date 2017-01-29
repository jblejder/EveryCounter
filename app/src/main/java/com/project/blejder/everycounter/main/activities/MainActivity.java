package com.project.blejder.everycounter.main.activities;

import android.databinding.ObservableList;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.project.blejder.everycounter.CounterModel;
import com.project.blejder.everycounter.detail.fragments.DetailCounterFragment;
import com.project.blejder.everycounter.list.callbacks.ListCountersFragmentsCallback;
import com.project.blejder.everycounter.main.viewmodels.MainViewModel;
import com.project.blejder.everycounter.shared.fragments.BaseActivity;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements ListCountersFragmentsCallback {

    @Inject
    MainViewModel viewModel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.loadFragment(DetailCounterFragment.newInstance());
    }

    @Override
    public ObservableList<CounterModel> getCounters() {
        return viewModel.counters;
    }
}
