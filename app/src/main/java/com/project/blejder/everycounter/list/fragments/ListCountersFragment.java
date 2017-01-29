package com.project.blejder.everycounter.list.fragments;

import android.database.Observable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.project.blejder.everycounter.App;
import com.project.blejder.everycounter.CounterModel;
import com.project.blejder.everycounter.R;
import com.project.blejder.everycounter.databinding.ListFragmentBinding;
import com.project.blejder.everycounter.detail.fragments.DetailCounterFragment;
import com.project.blejder.everycounter.list.callbacks.ListCountersFragmentsCallback;
import com.project.blejder.everycounter.list.viewmodels.ListCountersViewModel;
import com.project.blejder.everycounter.shared.fragments.BaseFragment;

import javax.inject.Inject;


public class ListCountersFragment extends BaseFragment<ListFragmentBinding> {

    @Inject
    ListCountersViewModel viewModel;

    public static Fragment newInstance() {
        return new ListCountersFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.list_fragment;
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {

    }

    @Override
    protected void onCreateView(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            super.openFragment(DetailCounterFragment.newInstance());
        }
    }

    private ListCountersFragmentsCallback getCallback() {
        return ((ListCountersFragmentsCallback) getActivity());
    }
}
