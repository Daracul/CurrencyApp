package com.daracul.android.currencyapp.currencylist.ui;

import com.daracul.android.currencyapp.models.DataUtils;
import com.daracul.android.currencyapp.models.ValuteItem;
import com.daracul.android.currencyapp.models.dto.ValCurs;
import com.daracul.android.currencyapp.models.dto.Valute;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;

public class CurrencyMapper {
    private CurrencyMapper() {
        throw new AssertionError("Must be no instance");
    }

    public static List<ValuteItem> map (@NonNull ValCurs valCursDTO){
        ArrayList<ValuteItem> valuteItemArrayList = new ArrayList<>();
        for (Valute valute : valCursDTO.getValuteList()){
            valuteItemArrayList.add(new ValuteItem(DataUtils.convertValueToFloat(valute.getValue()),
                    Integer.parseInt(valute.getNominal()),
                    valute.getCharCode(),
                    valute.getName()));
        }
        return valuteItemArrayList;
    }


}
