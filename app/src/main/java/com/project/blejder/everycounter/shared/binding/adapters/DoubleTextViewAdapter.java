package com.project.blejder.everycounter.shared.binding.adapters;

import android.databinding.BindingAdapter;
import android.widget.TextView;

import java.text.NumberFormat;

public class DoubleTextViewAdapter {

    @BindingAdapter("android:text")
    public static void setText(TextView view, Double val) {
        if (val == null) {
            val = 0d;
        }
        view.setText(String.valueOf(val));
    }

    @BindingAdapter({"android:text", "bind:decimal"})
    public static void setText(TextView view, Double val, int decimal) {
        if (val == null) {
            val = 0d;
        }
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMinimumFractionDigits(0);
        nf.setMaximumFractionDigits(2);
        view.setText(nf.format(val));
    }
}
