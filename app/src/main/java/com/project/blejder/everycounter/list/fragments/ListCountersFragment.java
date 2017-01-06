package com.project.blejder.everycounter.list.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.project.blejder.everycounter.R;
import com.project.blejder.everycounter.databinding.ListFragmentBinding;
import com.project.blejder.everycounter.shared.fragments.BaseFragment;


public class ListCountersFragment extends BaseFragment<ListFragmentBinding> {

    public static Fragment newInstance() {
        return new ListCountersFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.list_fragment;
    }

    @Override
    protected void onCreateView(@Nullable Bundle savedInstanceState) {

    }
}
