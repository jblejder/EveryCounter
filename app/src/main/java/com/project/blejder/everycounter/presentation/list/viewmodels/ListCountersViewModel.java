package com.project.blejder.everycounter.presentation.list.viewmodels;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;

import com.project.blejder.everycounter.domain.models.CounterModel;

import javax.inject.Inject;

public class ListCountersViewModel {

    public final ObservableList<CounterModel> counterModels;

    @Inject
    public ListCountersViewModel() {
        this.counterModels = new ObservableArrayList<>();
    }

    public ObservableList<CounterModel> getCounterModels() {
        return counterModels;
    }
}
