package com.project.blejder.everycounter.presentation.shared.models;

import android.support.annotation.DrawableRes;

import com.project.blejder.everycounter.R;

public enum Sign {
    Plus(1, R.drawable.ic_plus),
    Minus(-1, R.drawable.ic_minus);

    private int multiplier;
    private int img;

    Sign(int multiplier, int img) {
        this.multiplier = multiplier;
        this.img = img;
    }

    @DrawableRes
    public int getIcon() {
        return this.img;
    }

    public int multiplier() {
        return this.multiplier;
    }
}
