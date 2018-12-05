package com.daracul.android.currencyapp.network;

import com.daracul.android.currencyapp.models.dto.ValCurs;

import io.reactivex.Single;
import retrofit2.http.GET;


public interface CurrencyEndpoint {
    @GET("XML_daily.asp")
    Single<ValCurs> currencyObject();

}
