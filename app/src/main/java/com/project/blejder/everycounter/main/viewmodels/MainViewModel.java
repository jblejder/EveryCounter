package com.project.blejder.everycounter.main.viewmodels;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;

import com.project.blejder.everycounter.CounterModel;
import com.project.blejder.everycounter.main.services.imp.MainServiceImp;

import org.jdeferred.Promise;

import java.util.List;

import javax.inject.Inject;

import dagger.Lazy;

public class MainViewModel {

    public ObservableList<CounterModel> counters;

    private Lazy<MainServiceImp> mainService;

    {
        counters = new ObservableArrayList<>();
    }

    @Inject
    public MainViewModel(Lazy<MainServiceImp> mainService) {
        this.mainService = mainService;
    }

    public Promise<List<CounterModel>, Void, Void> load() {
        return mainService.get().getData().then(result -> {
            if (result.size() == 0) {
                result.add(new CounterModel());
                counters.clear();
                counters.addAll(result);
            }
        });
    }
}
