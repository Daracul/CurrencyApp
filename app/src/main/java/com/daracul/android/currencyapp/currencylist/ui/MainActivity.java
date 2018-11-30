package com.daracul.android.currencyapp.currencylist.ui;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.daracul.android.currencyapp.R;
import com.daracul.android.currencyapp.currencylist.ui.adapter.CurrencyAdapter;
import com.daracul.android.currencyapp.models.DataUtils;
import com.daracul.android.currencyapp.models.ValuteItem;
import com.daracul.android.currencyapp.models.dto.ValCurs;
import com.daracul.android.currencyapp.models.dto.Valute;
import com.daracul.android.currencyapp.network.RestApi;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = "myLogs";
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private CurrencyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();
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

    private void setupUI() {
        findViews();
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        adapter = new CurrencyAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void findViews() {
        progressBar = findViewById(R.id.progress);
        recyclerView = findViewById(R.id.recycler);

    }

    private void handleError(Throwable throwable) {
        Log.d(LOG_TAG, throwable.getClass().getSimpleName() + " " + throwable.getMessage());
    }

    private void handleResult(List<ValuteItem> valuteItemList) {
        float temp = valuteItemList.get(0).getValue();
        for (int i=0;i<valuteItemList.size();i++){
           valuteItemList.get(i).setValue(valuteItemList.get(i).getValue()/temp);
        }
        progressBar.setVisibility(View.GONE);
        adapter.replaceItems(valuteItemList);
        for (ValuteItem valuteItem : valuteItemList){
            Log.d(LOG_TAG, valuteItem.getName() + " "+ valuteItem.getValuteCode() + " " + valuteItem.getFlagPicture() + " " +
            valuteItem.getNominal()+" "+ valuteItem.getValue());
        }
    }

}
