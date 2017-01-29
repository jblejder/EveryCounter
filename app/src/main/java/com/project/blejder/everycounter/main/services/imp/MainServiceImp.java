package com.project.blejder.everycounter.main.services.imp;

import com.project.blejder.everycounter.CounterModel;
import com.project.blejder.everycounter.main.services.MainService;

import org.jdeferred.Promise;
import org.jdeferred.impl.DeferredObject;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainServiceImp implements MainService {

    @Inject
    public MainServiceImp() {
    }

    @Override
    public Promise<List<CounterModel>, Void, Void> getData() {
        return new DeferredObject<List<CounterModel>, Void, Void>().resolve(new ArrayList<>());
    }
}
