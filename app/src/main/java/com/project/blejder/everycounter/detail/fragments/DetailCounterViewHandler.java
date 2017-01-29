package com.project.blejder.everycounter.detail.fragments;

import com.project.blejder.everycounter.detail.viewhandler.DetailCounterHandler;
import com.project.blejder.everycounter.list.fragments.ListCountersFragment;
import com.project.blejder.everycounter.shared.fragments.BaseViewHandler;
import com.project.blejder.everycounter.shared.fragments.dialog.TextEditDialog;

import javax.inject.Inject;

class DetailCounterViewHandler extends BaseViewHandler<DetailCounterFragment>
        implements DetailCounterHandler {

    @Inject
    public DetailCounterViewHandler() {
    }

    @Override
    public void increment() {
        perform(ref -> ref.viewModel.increment());
    }

    @Override
    public void changeSign() {
        perform(ref -> ref.viewModel.changeSign());
    }

    @Override
    public void openList() {
        perform(ref -> ref.openFragment(ListCountersFragment.newInstance()));
    }

    @Override
    public void loadPrevious() {

    }

    @Override
    public void loadNext() {

    }

    @Override
    public void setName() {
        perform(ref -> {
            TextEditDialog dialog = TextEditDialog.newInstance(TextEditDialog.Type.Text, "Rename");
            dialog.show(ref.getChildFragmentManager(), "dialog");
        });
    }

    @Override
    public void setValue() {
        perform(ref -> {
            TextEditDialog dialog = TextEditDialog.newInstance(TextEditDialog.Type.Number, "Value");
            dialog.show(ref.getChildFragmentManager(), "dialog");
        });
    }

    @Override
    public void setIncrement() {
        perform(ref -> {
            TextEditDialog dialog = TextEditDialog
                    .newInstance(TextEditDialog.Type.Number, "Increment");
            dialog.show(ref.getChildFragmentManager(), "dialog");
        });
    }

    @Override
    public void setLimit() {
        perform(ref -> {
            TextEditDialog dialog = TextEditDialog.newInstance(TextEditDialog.Type.Number, "Limit");
            dialog.show(ref.getChildFragmentManager(), "dialog");
        });
    }
}
