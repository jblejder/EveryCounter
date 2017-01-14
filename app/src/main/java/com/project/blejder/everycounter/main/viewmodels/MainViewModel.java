package com.project.blejder.everycounter.main.viewmodels;

import android.util.Log;

import com.project.blejder.everycounter.CounterModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainViewModel {

    public List<CounterModel> counters;

    {
        counters = new ArrayList<>();
    }

    @Inject
    public MainViewModel() {
        Log.d("qwe", "MainViewModel: ");
    }
}
