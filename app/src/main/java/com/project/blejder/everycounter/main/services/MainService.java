package com.project.blejder.everycounter.main.services;

import com.project.blejder.everycounter.CounterModel;

import java.util.List;

import io.reactivex.Observable;

public interface MainService {

    Observable<List<CounterModel>> getCounters();
}
