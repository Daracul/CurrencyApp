package com.daracul.android.currencyapp.currencylist.ui.mvp;

import com.arellomobile.mvp.MvpView;
import com.daracul.android.currencyapp.models.ValuteItem;

import java.util.List;

import androidx.annotation.NonNull;

public interface CurrencyView extends MvpView {

     void showData(@NonNull List<ValuteItem> valuteItems);
     void showError(@NonNull Throwable throwable);
}
