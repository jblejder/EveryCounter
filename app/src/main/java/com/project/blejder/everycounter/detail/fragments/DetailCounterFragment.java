package com.project.blejder.everycounter.detail.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.project.blejder.everycounter.R;
import com.project.blejder.everycounter.databinding.DetailCounterFragmentBinding;
import com.project.blejder.everycounter.detail.dagger.DaggerDetailComponent;
import com.project.blejder.everycounter.detail.viewhandler.DetailCounterHandler;
import com.project.blejder.everycounter.detail.viewmodels.DetailCounterViewModel;
import com.project.blejder.everycounter.main.activities.MainActivity;
import com.project.blejder.everycounter.shared.fragments.BaseFragment;

import javax.inject.Inject;

public class DetailCounterFragment extends BaseFragment<DetailCounterFragmentBinding> {

    DetailCounterHandler viewHandler = new ViewHandler();
    @Inject
    DetailCounterViewModel viewModel;

    public static Fragment newInstance() {
        return new DetailCounterFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.detail_counter_fragment;
    }

    @Override
    protected void onCreateView(@Nullable Bundle savedInstanceState) {


        DaggerDetailComponent.builder().mainComponent(((MainActivity) getActivity()).mainComponent)
                .build().inject(this);

        this.binding.setHandler(viewHandler);
        this.binding.setModel(viewModel);
    }

    public class ViewHandler implements DetailCounterHandler {

        @Override
        public void increment() {
            viewModel.increment();
        }

        @Override
        public void changeSign() {
            viewModel.changeSign();
        }

        @Override
        public void openList() {

        }
    }
}
