package com.project.blejder.everycounter.main.services.imp;

import com.project.blejder.everycounter.CounterModel;
import com.project.blejder.everycounter.data.CounterStorage;
import com.project.blejder.everycounter.main.services.MainService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class CounterServiceImp implements MainService {

    private CounterStorage storage;

    @Inject
    CounterServiceImp(CounterStorage storage) {
        this.storage = storage;
    }

    @Override
    public Observable<List<CounterModel>> getCounters() {

        return Observable.create((ObservableEmitter<List<CounterModel>> subscriber) -> {
            subscriber.onNext(storage.getCounters());
        }).observeOn(AndroidSchedulers.mainThread());
    }
}
