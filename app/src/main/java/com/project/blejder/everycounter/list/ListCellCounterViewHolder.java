package com.project.blejder.everycounter.list;

import android.support.v7.widget.RecyclerView;

import com.project.blejder.everycounter.databinding.ListCellCounterBinding;

public class ListCellCounterViewHolder extends RecyclerView.ViewHolder{
    private ListCellCounterBinding binding;

    public ListCellCounterViewHolder(ListCellCounterBinding binding) {
        super(binding.getRoot());

        this.binding = binding;
        this.binding.setHandler(new ViewHandler());
    }

    public void bind(ListCellCounterViewModel viewModel)
    {
        this.binding.setModel(viewModel);
    }

    private class ViewHandler implements ListCellCounterHandler {

        @Override
        public void plusClick() {
            binding.getModel().increment(1);
        }

        @Override
        public void minusClick() {
            binding.getModel().increment(-1);
        }
    }
}
