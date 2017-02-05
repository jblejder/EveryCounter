package com.project.blejder.everycounter.domain.factories;

import com.project.blejder.everycounter.domain.models.CounterModel;

import java.util.UUID;

public class CounterFactory {
    public static CounterModel createCounter() {
        return createCounter(UUID.randomUUID());
    }

    public static CounterModel createCounter(UUID uuid) {
        CounterModel counterModel = new CounterModel();
        counterModel.setUuid(uuid);
        return counterModel;
    }
}
