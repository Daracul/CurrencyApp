package com.daracul.android.currencyapp.currencylist.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.daracul.android.currencyapp.R;
import com.daracul.android.currencyapp.models.ValuteItem;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CurrencyViewHolder extends RecyclerView.ViewHolder {
    private static final int LAYOUT = R.layout.item_currency;

    private TextView valuteCode;
    private ImageView valuteFlag;
    private TextView valuteName;
    private TextView valuteValue;

    public static CurrencyViewHolder create (@NonNull ViewGroup parent){
        final View view = LayoutInflater.from(parent.getContext()).inflate(LAYOUT, parent, false);
        return new CurrencyViewHolder(view);
    }

    private CurrencyViewHolder(@NonNull View itemView) {
        super(itemView);
        findViews(itemView);
    }

    private void findViews(View itemView) {
        valuteCode = itemView.findViewById(R.id.item_valute_code);
        valuteFlag = itemView.findViewById(R.id.item_image);
        valuteName = itemView.findViewById(R.id.item_valute_name);
        valuteValue = itemView.findViewById(R.id.item_value);

    }

    public void bindItem (@NonNull ValuteItem valuteItem){
        valuteCode.setText(valuteItem.getValuteCode());
        valuteFlag.setImageResource(valuteItem.getFlagPicture());
        String valuteWithNominal = valuteItem.getNominal()+" "+valuteItem.getName().toLowerCase();
        valuteName.setText(valuteWithNominal);
        valuteValue.setText(String.valueOf(valuteItem.getValue()));

    }


}
