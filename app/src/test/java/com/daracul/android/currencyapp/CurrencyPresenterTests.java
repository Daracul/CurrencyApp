package com.daracul.android.currencyapp;

import android.view.View;

import com.daracul.android.currencyapp.currencylist.ui.mvp.CurrencyPresenter;
import com.daracul.android.currencyapp.currencylist.ui.mvp.CurrencyView;
import com.daracul.android.currencyapp.models.DataUtils;
import com.daracul.android.currencyapp.models.ValuteItem;
import com.daracul.android.currencyapp.network.RestApi;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class CurrencyPresenterTests {
    private CurrencyPresenter presenter;
    private RestApi restApi;
    private List<ValuteItem> valuteItems;

    @Before
    public void setUp() {
        valuteItems = new ArrayList<>();
        valuteItems.add(DataUtils.createRouble());
        for (int i = 0; i < 11; i++) {
            ValuteItem valuteItem = Mockito.mock(ValuteItem.class);
            valuteItems.add(valuteItem);
        }
        restApi = RestApi.getInstance();
        presenter = new CurrencyPresenter(restApi);
    }


    @Test
    public void presenter_handleError() {
        Throwable throwable = Mockito.mock(Throwable.class);
        presenter.getViewState().showError(throwable);
    }

    @Test
    public void presenter_handleResult() {
        presenter.handleResult(valuteItems);
    }

    @Test
    public void presenter_swapCurrencyAndSendToView() {
        presenter.handleResult(valuteItems);
        presenter.swapCurrency(4);
        presenter.getViewState().showData(valuteItems);
    }
}
