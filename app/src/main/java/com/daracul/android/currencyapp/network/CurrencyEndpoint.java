package com.daracul.android.currencyapp.network;

import com.daracul.android.currencyapp.models.dto.ValCurs;

import io.reactivex.Single;
import retrofit2.http.GET;


public interface CurrencyEndpoint {
    @GET("daily.xml")
    Single<ValCurs> currencyObject();

}
