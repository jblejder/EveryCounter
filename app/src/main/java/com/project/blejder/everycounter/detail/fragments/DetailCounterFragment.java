package com.project.blejder.everycounter.detail.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.project.blejder.everycounter.R;
import com.project.blejder.everycounter.databinding.DetailCounterFragmentBinding;
import com.project.blejder.everycounter.detail.viewhandler.DetailCounterHandler;
import com.project.blejder.everycounter.detail.viewmodels.DetailCounterViewModel;
import com.project.blejder.everycounter.shared.fragments.BaseFragment;
import com.project.blejder.everycounter.shared.fragments.dialog.TextEditDialog;

import java.lang.ref.WeakReference;

public class DetailCounterFragment extends BaseFragment<DetailCounterFragmentBinding> {

    DetailCounterHandler   viewHandler;
    DetailCounterViewModel viewModel;

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
        viewModel = new DetailCounterViewModel();
        viewHandler = new ViewHandler(this);
    }

    @Override
    protected void onCreateView(@Nullable Bundle savedInstanceState) {

        this.binding.setHandler(viewHandler);
        this.binding.setModel(viewModel);
    }

    static class ViewHandler implements DetailCounterHandler {

        private WeakReference<DetailCounterFragment> parentReference;

        ViewHandler(DetailCounterFragment parent) {
            this.parentReference = new WeakReference<>(parent);
        }

        @Override
        public void increment() {
            DetailCounterFragment fragment = this.parentReference.get();
            if (fragment != null) {
                fragment.viewModel.increment();
            }
        }

        @Override
        public void changeSign() {
            DetailCounterFragment fragment = this.parentReference.get();
            if (fragment != null) {
                fragment.viewModel.changeSign();
            }
        }

        @Override
        public void openList() {

        }

        @Override
        public void loadPrevious() {

        }

        @Override
        public void loadNext() {

        }

        @Override
        public void setName() {
            DetailCounterFragment fragment = this.parentReference.get();
            if (fragment != null) {
                TextEditDialog dialog = TextEditDialog
                        .newInstance(TextEditDialog.Type.Text, "Rename");
                dialog.show(fragment.getChildFragmentManager(), "dialog");
            }
        }

        @Override
        public void setValue() {
            DetailCounterFragment fragment = this.parentReference.get();
            if (fragment != null) {
                TextEditDialog dialog = TextEditDialog
                        .newInstance(TextEditDialog.Type.Number, "Value");
                dialog.show(fragment.getChildFragmentManager(), "dialog");
            }
        }

        @Override
        public void setIncrement() {
            DetailCounterFragment fragment = this.parentReference.get();
            if (fragment != null) {
                TextEditDialog dialog = TextEditDialog
                        .newInstance(TextEditDialog.Type.Number, "Increment");
                dialog.show(fragment.getChildFragmentManager(), "dialog");
            }
        }

        @Override
        public void setLimit() {
            DetailCounterFragment fragment = this.parentReference.get();
            if (fragment != null) {
                TextEditDialog dialog = TextEditDialog
                        .newInstance(TextEditDialog.Type.Number, "Limit");
                dialog.show(fragment.getChildFragmentManager(), "dialog");
            }
        }
    }
}
