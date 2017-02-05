package com.project.blejder.everycounter.domain.userCases;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public abstract class UseCase<TArg, TResult> {

    protected abstract Observable<TResult> buildUseCase(TArg arg);

    public Observable<TResult> execute(TArg arg) {
        return buildUseCase(arg).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
