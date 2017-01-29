package com.project.blejder.everycounter.shared.fragments;

import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.project.blejder.everycounter.App;
import com.project.blejder.everycounter.R;
import com.project.blejder.everycounter.databinding.MainActivityBinding;
import com.project.blejder.everycounter.shared.dagger.AppComponent;

public class BaseActivity extends AppCompatActivity {


    protected MainActivityBinding binding;

    protected void loadFragment(Fragment fragment) {
        FragmentManager     fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        this.binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        ft.replace(this.binding.mainFragmentContainer.getId(), fragment);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        boolean handled = false;
        Fragment fr = getSupportFragmentManager()
                .findFragmentById(binding.mainFragmentContainer.getId());
        if (fr != null && fr instanceof BaseFragment) {
            handled = ((BaseFragment) fr).handleOnBackPress();
        }
        if (!handled) {
            super.onBackPressed();
        }
    }

    public AppComponent getAppComponent() {
        return ((App) getApplication()).getAppComponent();
    }
}
