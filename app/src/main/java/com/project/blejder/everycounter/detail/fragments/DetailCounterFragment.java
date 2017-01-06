package com.project.blejder.everycounter.detail.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.blejder.everycounter.R;
import com.project.blejder.everycounter.databinding.DetailCounterFragmentBinding;
import com.project.blejder.everycounter.shared.fragments.BaseFragment;

public class DetailCounterFragment extends BaseFragment<DetailCounterFragmentBinding> {

    public static Fragment newInstance() {
        return new DetailCounterFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.detail_counter_fragment;
    }

    @Override
    protected void onCreateView(@Nullable Bundle savedInstanceState) {

    }
}
