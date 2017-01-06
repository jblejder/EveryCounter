package com.project.blejder.everycounter.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.project.blejder.everycounter.R;
import com.project.blejder.everycounter.databinding.MainActivityBinding;
import com.project.blejder.everycounter.detail.fragments.DetailCounterFragment;
import com.project.blejder.everycounter.list.fragments.ListCountersFragment;
import com.project.blejder.everycounter.main.viewmodels.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private MainActivityBinding binding;

    MainViewModel viewModel = new MainViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = DataBindingUtil.setContentView(this, R.layout.main_activity);

        if (this.viewModel.counters.size() == 0) {
            loadFragment(DetailCounterFragment.newInstance());
        } else {
            loadFragment(ListCountersFragment.newInstance());
        }
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager     fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(this.binding.mainFragmentContainer.getId(), fragment);
        ft.commit();
    }
}
