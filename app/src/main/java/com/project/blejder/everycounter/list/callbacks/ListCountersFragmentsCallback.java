package com.project.blejder.everycounter.list.callbacks;

import android.databinding.ObservableList;

import com.project.blejder.everycounter.CounterModel;

public interface ListCountersFragmentsCallback {
    ObservableList<CounterModel> getCounters();
}
