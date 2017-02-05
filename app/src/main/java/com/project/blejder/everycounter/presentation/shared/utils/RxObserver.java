package com.project.blejder.everycounter.presentation.shared.utils;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

public abstract class RxObserver<T> implements Observer<T> {
    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T value) {

    }

    @Override
    public void onError(Throwable e) {
        Timber.e(e);
    }

    @Override
    public void onComplete() {

    }
}
