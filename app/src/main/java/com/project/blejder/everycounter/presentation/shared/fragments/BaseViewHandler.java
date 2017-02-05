package com.project.blejder.everycounter.presentation.shared.fragments;

import java.lang.ref.WeakReference;

public abstract class BaseViewHandler<T> {

    private WeakReference<T> weakReference = new WeakReference<T>(null);

    public void setRef(T ref) {
        weakReference = new WeakReference<T>(ref);
    }

    protected void perform(Action<T> action) {
        T reference = this.weakReference.get();
        if (reference != null) {
            action.task(reference);
        }
    }

    protected interface Action<T> {
        void task(T ref);
    }
}
