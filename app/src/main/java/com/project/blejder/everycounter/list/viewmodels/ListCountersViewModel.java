package com.project.blejder.everycounter.list.viewmodels;

import android.databinding.ObservableList;

import com.project.blejder.everycounter.CounterModel;
import com.project.blejder.everycounter.main.viewmodels.MainViewModel;

import javax.inject.Inject;

public class ListCountersViewModel {

    final ObservableList<CounterModel> counterModels;

    @Inject
    public ListCountersViewModel(MainViewModel model) {
        this.counterModels = model.counters;
    }
}
