package com.daracul.android.currencyapp.network;

import com.daracul.android.currencyapp.model.MyResponse;

import io.reactivex.Single;
import retrofit2.http.GET;


public interface currencyEndpoint {
    @GET("daily.xml")
    Single<MyResponse> currencyObject();

}
