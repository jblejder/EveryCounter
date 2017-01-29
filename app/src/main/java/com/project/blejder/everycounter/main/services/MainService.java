package com.project.blejder.everycounter.main.services;

import com.project.blejder.everycounter.CounterModel;

import org.jdeferred.Promise;

import java.util.List;

public interface MainService {
    Promise<List<CounterModel>, Void, Void> getData();
}
