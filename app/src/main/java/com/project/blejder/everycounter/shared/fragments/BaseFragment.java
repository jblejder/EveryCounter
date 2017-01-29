package com.project.blejder.everycounter.shared.fragments;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.blejder.everycounter.databinding.BaseFragmentBinding;
import com.project.blejder.everycounter.shared.dagger.AppComponent;

public abstract class BaseFragment<T extends ViewDataBinding> extends Fragment {

    public    T                   binding;
    protected BaseFragmentBinding baseBinding;

    @LayoutRes
    protected abstract int getLayoutId();

    protected abstract void onCreateView(@Nullable Bundle savedInstanceState);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        baseBinding = BaseFragmentBinding.inflate(inflater);
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        baseBinding.baseContainer.addView(binding.getRoot());
        this.onCreateView(savedInstanceState);
        return baseBinding.getRoot();
    }

    public void openFragment(Fragment fragment) {
        FragmentManager fm = getChildFragmentManager();
        fm.beginTransaction().add(baseBinding.baseContainer.getId(), fragment).addToBackStack(null)
                .commit();
    }

    public boolean handleOnBackPress() {
        FragmentManager fm = getChildFragmentManager();
        if (fm.getBackStackEntryCount() > 0) {
            fm.popBackStack();
            return true;
        }
        return false;
    }

    protected AppComponent getAppComponent() {
        return ((BaseActivity) getActivity()).getAppComponent();
    }
}
