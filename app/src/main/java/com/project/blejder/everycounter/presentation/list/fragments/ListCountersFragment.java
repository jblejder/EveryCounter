package com.project.blejder.everycounter.presentation.list.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.project.blejder.everycounter.R;
import com.project.blejder.everycounter.databinding.ListFragmentBinding;
import com.project.blejder.everycounter.presentation.list.ListCountersAdapter;
import com.project.blejder.everycounter.presentation.list.callbacks.ListCountersFragmentsCallback;
import com.project.blejder.everycounter.presentation.list.viewmodels.ListCountersViewModel;
import com.project.blejder.everycounter.presentation.shared.fragments.BaseFragment;

import javax.inject.Inject;


public class ListCountersFragment extends BaseFragment<ListFragmentBinding> {

    @Inject
    ListCountersViewModel viewModel;
    @Inject
    ListCountersAdapter   adapter;

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
        initAdapter();
    }

    private void initAdapter() {
        adapter.setFeed(viewModel.getCounterModels());
    }

    private ListCountersFragmentsCallback getCallback() {
        return ((ListCountersFragmentsCallback) getActivity());
    }
}
