package com.daracul.android.currencyapp.currencylist.ui;


import android.os.Bundle;
import android.util.Log;

import com.daracul.android.currencyapp.R;
import com.daracul.android.currencyapp.models.DataUtils;
import com.daracul.android.currencyapp.models.ValuteItem;
import com.daracul.android.currencyapp.models.dto.ValCurs;
import com.daracul.android.currencyapp.models.dto.Valute;
import com.daracul.android.currencyapp.network.RestApi;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Disposable disposable = RestApi.getInstance()
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
        Log.d(LOG_TAG, throwable.getClass().getSimpleName() + " " + throwable.getMessage());
    }

    private void handleResult(List<ValuteItem> valuteItemList) {
        for (ValuteItem valuteItem : valuteItemList){
            Log.d(LOG_TAG, valuteItem.getName() + " "+ valuteItem.getValuteCode() + " " + valuteItem.getFlagPicture() + " " +
            valuteItem.getNominal()+" "+ valuteItem.getValue());
        }
    }

}
