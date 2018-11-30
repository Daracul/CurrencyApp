package com.daracul.android.currencyapp.currencylist.ui.adapter;

import android.view.ViewGroup;

import com.daracul.android.currencyapp.models.ValuteItem;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyViewHolder> {
    private final List<ValuteItem> items = new ArrayList<>();


    public CurrencyAdapter() {
    }

    @NonNull
    @Override
    public CurrencyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return CurrencyViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrencyViewHolder holder, int position) {
        ValuteItem valuteItem = items.get(position);
        holder.bindItem(valuteItem);

    }

    public void replaceItems(@NonNull List<ValuteItem> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
