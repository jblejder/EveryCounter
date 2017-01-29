package com.project.blejder.everycounter.detail.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.project.blejder.everycounter.R;
import com.project.blejder.everycounter.databinding.DetailCounterFragmentBinding;
import com.project.blejder.everycounter.detail.viewmodels.DetailCounterViewModel;
import com.project.blejder.everycounter.shared.fragments.BaseFragment;

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
    public void onAttach(Context context) {
        super.onAttach(context);

        getAppComponent().inject(this);

        viewHandler.setRef(this);
    }

    @Override
    protected void onCreateView(@Nullable Bundle savedInstanceState) {

        this.binding.setHandler(viewHandler);
        this.binding.setModel(viewModel);
    }
}

