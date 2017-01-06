package com.project.blejder.everycounter.main.viewmodels;

import com.project.blejder.everycounter.CounterModel;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel {
    public List<CounterModel> counters;

    {
        counters = new ArrayList<>();
    }
}
