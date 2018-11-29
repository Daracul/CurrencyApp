package com.daracul.android.currencyapp;


import android.os.Bundle;
import android.util.Log;
import com.daracul.android.currencyapp.model.ValCurs;
import com.daracul.android.currencyapp.model.Valute;
import com.daracul.android.currencyapp.network.RestApi;
import java.util.List;
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
                .subscribe(new Consumer<ValCurs>() {
                               @Override
                               public void accept(ValCurs valCurs) throws Exception {
                                   List<Valute> valuteList = valCurs.getValuteList();
                                   for (Valute valute:valuteList){
                                       Log.d(LOG_TAG, valute.getID()+" "+valute.getValue()+" "+ valute.getName() + " " + valute.getCharCode()+ " " + valute.getNominal());
                                   }
                                   Log.d(LOG_TAG,valCurs.getDate());
                                   Log.d(LOG_TAG,valCurs.getName());
                               }
                           },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                Log.d(LOG_TAG, throwable.getClass().getSimpleName() + " " + throwable.getMessage());
                            }
                        });
    }

}
