package com.daracul.android.currencyapp.currencylist.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.daracul.android.currencyapp.R;
import com.daracul.android.currencyapp.models.ValuteItem;
import com.squareup.picasso.Picasso;

import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CurrencyViewHolder extends RecyclerView.ViewHolder {
    private static final int LAYOUT = R.layout.item_currency;

    private TextView valuteCode;
    private ImageView valuteFlag;
    private TextView valuteName;
    private TextView valuteValue;
    private final View itemView;

    public static CurrencyViewHolder create(@NonNull ViewGroup parent) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(LAYOUT, parent, false);
        return new CurrencyViewHolder(view);
    }

    private CurrencyViewHolder(@NonNull View itemView) {
        super(itemView);
        this.itemView = itemView;
        findViews(itemView);
    }

    private void findViews(View itemView) {
        valuteCode = itemView.findViewById(R.id.item_valute_code);
        valuteFlag = itemView.findViewById(R.id.item_image);
        valuteName = itemView.findViewById(R.id.item_valute_name);
        valuteValue = itemView.findViewById(R.id.item_value);

    }

    public void bindItem(@NonNull ValuteItem valuteItem, final CurrencyAdapter.OnItemClickListener currencyClickListener) {
        valuteCode.setText(valuteItem.getValuteCode());
//        valuteFlag.setImageResource(valuteItem.getFlagPicture());
        Picasso.get()
                .load(valuteItem.getFlagPicture())
                .placeholder(R.drawable.valute)
                .error(R.drawable.valute)
                .into(valuteFlag);
        String valuteWithNominal = valuteItem.getNominal() + " " + valuteItem.getName();
        valuteName.setText(valuteWithNominal);
        String formattedValue = String.format(Locale.getDefault(), "%.3f", valuteItem.getValue());
        valuteValue.setText(formattedValue);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = getAdapterPosition();
                if (currencyClickListener != null && position != RecyclerView.NO_POSITION) {
                    currencyClickListener.onItemClick(position);
                }
            }
        });

    }


}
