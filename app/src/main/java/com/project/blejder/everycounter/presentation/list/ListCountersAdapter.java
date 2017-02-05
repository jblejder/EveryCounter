package com.project.blejder.everycounter.presentation.list;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.project.blejder.everycounter.domain.models.CounterModel;
import com.project.blejder.everycounter.databinding.ListCellCounterBinding;

import javax.inject.Inject;

public class ListCountersAdapter
        extends RecyclerView.Adapter<ListCountersAdapter.CounterViewHolder> {

    private ObservableList<CounterModel> feed = new ObservableArrayList<>();

    @Inject
    public ListCountersAdapter() {
    }

    @Override
    public CounterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater         inflater = LayoutInflater.from(parent.getContext());
        ListCellCounterBinding binding  = ListCellCounterBinding.inflate(inflater, parent, false);
        return new CounterViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(CounterViewHolder holder, int position) {
        holder.setModel(feed.get(position));
    }

    @Override
    public int getItemCount() {
        return feed.size();
    }

    public void setFeed(ObservableList<CounterModel> feed) {
        this.feed = feed;
        this.notifyDataSetChanged();
    }

    class CounterViewHolder extends RecyclerView.ViewHolder {
        private ListCellCounterBinding binding;


        CounterViewHolder(ListCellCounterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void setModel(CounterModel model) {

        }
    }
}
