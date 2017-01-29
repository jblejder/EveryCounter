package com.project.blejder.everycounter.detail.viewmodels;

import android.databinding.ObservableField;
import android.util.Log;

import com.google.common.base.Optional;
import com.project.blejder.everycounter.shared.models.Sign;

import javax.inject.Inject;


public class DetailCounterViewModel {

    public ObservableField<Optional<String>> name;
    public ObservableField<Double>           value;
    public ObservableField<Sign>             sign;

    public Double incrementValue = 1d;

    {
        value = new ObservableField<>(0d);
        sign = new ObservableField<>(Sign.Plus);
        name = new ObservableField<>(Optional.<String>absent());
    }

    @Inject
    public DetailCounterViewModel() {
        Log.d("qwe", "DetailCounterViewModel: qwe");
    }

    public void increment() {
        this.value.set(sign.get().multiplier() * incrementValue + value.get());
    }

    public void changeSign() {
        this.sign.set(this.sign.get() == Sign.Plus ? Sign.Minus : Sign.Plus);
    }
}
