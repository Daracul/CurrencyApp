package com.daracul.android.currencyapp.currencylist.ui;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.daracul.android.currencyapp.R;
import com.daracul.android.currencyapp.common.MvpAppCompatActivity;
import com.daracul.android.currencyapp.currencylist.ui.adapter.CurrencyAdapter;
import com.daracul.android.currencyapp.currencylist.ui.mvp.CurrencyPresenter;
import com.daracul.android.currencyapp.currencylist.ui.mvp.CurrencyView;
import com.daracul.android.currencyapp.models.DataUtils;
import com.daracul.android.currencyapp.models.ValuteItem;
import com.daracul.android.currencyapp.models.dto.ValCurs;
import com.daracul.android.currencyapp.models.dto.Valute;
import com.daracul.android.currencyapp.network.RestApi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends MvpAppCompatActivity implements CurrencyView {

    private static final String LOG_TAG = "myLogs";
    @InjectPresenter
    CurrencyPresenter currencyPresenter;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private TextView emptyTV;
    private CurrencyAdapter adapter;

    @ProvidePresenter
    CurrencyPresenter currencyPresenter(){
        return new CurrencyPresenter(RestApi.getInstance());
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();

    }

    @Override
    protected void onStart() {
        super.onStart();
        setupUX();
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindUX();
    }

    private void unbindUX() {
        adapter.setOnClickCurrencyListener(null);
    }

    private void setupUX() {
        adapter.setOnClickCurrencyListener(new CurrencyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                currencyPresenter.swapCurrency(position);
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
        recyclerView.setHasFixedSize(true);
    }

    private void findViews() {
        progressBar = findViewById(R.id.progress);
        recyclerView = findViewById(R.id.recycler);
        emptyTV = findViewById(R.id.empty);

    }



    @Override
    public void showData(@NonNull List<ValuteItem> valuteItems) {
        progressBar.setVisibility(View.GONE);
        adapter.replaceItems(valuteItems);
        recyclerView.scrollToPosition(0);
    }

    @Override
    public void showError(@NonNull Throwable throwable) {
        Log.d(LOG_TAG, throwable.getClass().getSimpleName() + " " + throwable.getMessage());
        progressBar.setVisibility(View.GONE);
        emptyTV.setText(R.string.error_message);
        emptyTV.setVisibility(View.VISIBLE);

    }
}
