package com.project.blejder.everycounter.presentation.detail.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.project.blejder.everycounter.R;
import com.project.blejder.everycounter.databinding.DetailCounterFragmentBinding;
import com.project.blejder.everycounter.presentation.detail.viewmodels.DetailCounterViewModel;
import com.project.blejder.everycounter.presentation.main.activities.Navigator;
import com.project.blejder.everycounter.presentation.shared.fragments.BaseFragment;

import javax.inject.Inject;

public class DetailCounterFragment extends BaseFragment<DetailCounterFragmentBinding> {

    @Inject
    DetailCounterViewHandler viewHandler;
    @Inject
    DetailCounterViewModel   viewModel;


    public static Fragment newInstance() {
        return new DetailCounterFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.detail_counter_fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        inject();
    }

    private void inject() {
        getActivityComponent().inject(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.loadMainCounter();
    }

    @Override
    protected void onCreateView(@Nullable Bundle savedInstanceState) {

        viewHandler.setRef(this);
        this.binding.setHandler(viewHandler);
        this.binding.setModel(viewModel);
    }

    public Navigator getNavigator() {
        return null;
    }
}

