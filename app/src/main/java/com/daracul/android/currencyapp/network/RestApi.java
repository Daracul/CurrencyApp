package com.daracul.android.currencyapp.network;

import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;

import androidx.annotation.NonNull;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public final class RestApi {
    private static final String URL = "https://www.cbr-xml-daily.ru/";
    private static RestApi sRestApi;
    private final currencyEndpoint currencyEndpoint;


    public static synchronized RestApi getInstance() {
        if (sRestApi == null) {
            sRestApi = new RestApi();
        }
        return sRestApi;
    }


    private RestApi() {
        final Retrofit retrofit = buildRetrofitClient();

        //init endpoints here. It's can be more then one endpoint
        currencyEndpoint = retrofit.create(currencyEndpoint.class);
    }

    @NonNull
    private Retrofit buildRetrofitClient() {
        return new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(SimpleXmlConverterFactory.createNonStrict(
                        new Persister(new AnnotationStrategy())
                ))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public currencyEndpoint currency() {
        return currencyEndpoint;
    }
}
