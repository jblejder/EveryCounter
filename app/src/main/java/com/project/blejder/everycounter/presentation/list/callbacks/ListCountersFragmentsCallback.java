package com.project.blejder.everycounter.presentation.list.callbacks;

import android.databinding.ObservableList;

import com.project.blejder.everycounter.domain.models.CounterModel;

public interface ListCountersFragmentsCallback {
    ObservableList<CounterModel> getCounters();
}
