package com.project.blejder.everycounter.main.viewmodels;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;

import com.project.blejder.everycounter.CounterModel;
import com.project.blejder.everycounter.main.services.imp.CounterServiceImp;
import com.project.blejder.everycounter.shared.utils.RxObserver;

import java.util.List;

import javax.inject.Inject;

import dagger.Lazy;
import timber.log.Timber;

public class MainViewModel {

    public ObservableList<CounterModel> counters;

    private Lazy<CounterServiceImp> mainService;

    {
        counters = new ObservableArrayList<>();
    }

    @Inject
    MainViewModel(Lazy<CounterServiceImp> mainService) {
        this.mainService = mainService;
    }

    public void load() {
        Timber.d("load");
        mainService.get().getCounters().subscribe(new OnLoadObserver());
    }

    private class OnLoadObserver extends RxObserver<List<CounterModel>> {

        @Override
        public void onNext(List<CounterModel> resultCounters) {
            counters.clear();
            counters.addAll(resultCounters);
        }
    }
}
