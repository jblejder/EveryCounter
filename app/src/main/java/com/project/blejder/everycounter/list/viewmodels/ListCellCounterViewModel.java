package com.project.blejder.everycounter.list.viewmodels;

import android.databinding.ObservableField;

public class ListCellCounterViewModel {

    public ObservableField<Integer> value;

    {
        value = new ObservableField<>(0);
    }

    public void increment(int value) {
        this.value.set(this.value.get() + value);
    }
}
