package com.daracul.android.currencyapp.currencylist.ui.mvp;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.daracul.android.currencyapp.models.CurrencyMapper;
import com.daracul.android.currencyapp.models.DataUtils;
import com.daracul.android.currencyapp.models.ValuteItem;
import com.daracul.android.currencyapp.models.dto.ValCurs;
import com.daracul.android.currencyapp.network.RestApi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.annotation.NonNull;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class CurrencyPresenter extends MvpPresenter<CurrencyView> {

    private static final int USD_POSITION = 11;
    private RestApi restApi;
    private Disposable disposable;
    private List<ValuteItem> valuteItemList = new ArrayList<>();
    private boolean repeat;

    public CurrencyPresenter(@NonNull RestApi instance) {
        this.restApi = instance;
    }

    @Override
    protected void onFirstViewAttach() {
        valuteItemList.add(DataUtils.createRouble());
        loadCurrencies();
    }


    private void loadCurrencies() {
        disposable = restApi
                .currency()
                .currencyObject()
                .map(new Function<ValCurs, List<ValuteItem>>() {
                    @Override
                    public List<ValuteItem> apply(ValCurs valCurs) throws Exception {
                        return CurrencyMapper.map(valCurs);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<ValuteItem>>() {
                               @Override
                               public void accept(List<ValuteItem> valuteItems) throws Exception {
                                   handleResult(valuteItems);
                               }
                           },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                handleError(throwable);
                            }
                        });
    }

    private void handleError(Throwable throwable) {
        getViewState().showError(throwable);
    }

    public void handleResult(@NonNull List<ValuteItem> valuteItemList) {
        this.valuteItemList.addAll(valuteItemList);
        getViewState().setActionBar(ValuteItem.getDate());
        swapCurrency(USD_POSITION);
    }

    public void swapCurrency(int position) {
        float temp = valuteItemList.get(position).getValue();
        for (int i = 0; i < valuteItemList.size(); i++) {
            if (!repeat){
                valuteItemList.get(i).setValue(1/(valuteItemList.get(i).getValue() / temp));
            } else valuteItemList.get(i).setValue(valuteItemList.get(i).getValue() / temp);
        }
        repeat = true;
        Collections.swap(valuteItemList, 0, position);
        getViewState().showData(valuteItemList);


    }

    @Override
    public void onDestroy() {
        if (disposable != null) {
            disposable.dispose();
        }
        super.onDestroy();
    }
}
