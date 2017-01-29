package com.project.blejder.everycounter.data;

import android.util.SparseArray;

import com.project.blejder.everycounter.CounterModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

public class CounterStorage {
    private static Map<Integer, CounterModel> counterModels;

    static {
        counterModels = new HashMap<>();
    }

    @Inject
    CounterStorage() {
        SparseArray a;
    }

    public List<CounterModel> getCounters() {
        return new ArrayList<CounterModel>(counterModels.values());
    }

    public CounterModel getCounter(Integer id) throws NotFoundException {
        CounterModel counter = counterModels.get(id);
        if (counter == null) {
            throw new NotFoundException();
        }
        return counter;
    }
}
