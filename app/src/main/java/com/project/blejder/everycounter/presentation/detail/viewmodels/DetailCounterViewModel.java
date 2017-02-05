package com.project.blejder.everycounter.presentation.detail.viewmodels;

import android.databinding.ObservableField;
import android.util.Log;

import com.google.common.base.Optional;
import com.project.blejder.everycounter.domain.models.CounterModel;
import com.project.blejder.everycounter.domain.userCases.LoadMainCounter;
import com.project.blejder.everycounter.presentation.shared.models.Sign;
import com.project.blejder.everycounter.presentation.shared.utils.RxObserver;

import javax.inject.Inject;


public class DetailCounterViewModel {

    private final LoadMainCounter loadMainCounter;

    public ObservableField<Optional<String>> name;
    public ObservableField<Double>           value;
    public ObservableField<Sign>             sign;
    public Double incrementValue = 1d;

    CounterModel model;

    {
        value = new ObservableField<>(0d);
        sign = new ObservableField<>(Sign.Plus);
        name = new ObservableField<>(Optional.<String>absent());
    }

    @Inject
    public DetailCounterViewModel(LoadMainCounter loadMainCounter) {
        Log.d("qwe", "DetailCounterViewModel: qwe");
        this.loadMainCounter = loadMainCounter;
    }

    public void loadMainCounter() {
        loadMainCounter.execute(null).subscribe(new RxObserver<CounterModel>() {
            @Override
            public void onNext(CounterModel value) {
                model = value;
            }
        });
    }

    public void increment() {
        this.value.set(sign.get().multiplier() * incrementValue + value.get());
    }

    public void changeSign() {
        this.sign.set(this.sign.get() == Sign.Plus ? Sign.Minus : Sign.Plus);
    }
}
