package com.project.blejder.everycounter.shared.binding.adapters;

import android.databinding.BindingAdapter;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.widget.TextView;

public class TypefaceAdapter {

    @BindingAdapter({"android:typeface"})
    public static void applyTypeface(TextView view, Typeface typeface) {
        view.setTypeface(typeface);
        view.setPaintFlags(view.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
    }
}
