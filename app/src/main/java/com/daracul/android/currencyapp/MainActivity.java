package com.daracul.android.currencyapp;


import android.os.Bundle;
import android.util.Log;

import com.daracul.android.currencyapp.model.MyResponse;
import com.daracul.android.currencyapp.network.RestApi;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
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
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MyResponse>() {
                               @Override
                               public void accept(MyResponse myResponse) throws Exception {
                                   Log.d(LOG_TAG,myResponse.getValCurs().getDate());

                               }
                           },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                Log.d(LOG_TAG, throwable.getClass().getSimpleName() +" "+ throwable.getMessage());
                            }
                        });
    }
}
