package com.project.blejder.everycounter.presentation.shared.binding.adapters;

import android.databinding.BindingAdapter;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

public class ImageAdapter {

    @BindingAdapter("android:src")
    public static void setImageResource(ImageView imageView, @DrawableRes int resource) {
        imageView.setImageResource(resource);
    }
}
