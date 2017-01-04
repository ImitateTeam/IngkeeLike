package com.live.ingkeelike.network.api;

import com.google.gson.GsonBuilder;
import com.live.ingkeelike.constants.Constants;
import com.live.ingkeelike.manager.OkHttpManager;

import java.io.IOException;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yubai on 2017/1/4.
 */

public abstract class BaseMethod {

    public abstract String getBaseUrl();

    public Retrofit getRetrofit(String url) throws IOException, ClassNotFoundException{
        Retrofit builder = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Constants.BASE_URL+url)
                .client(OkHttpManager.getInstance())
                .build();
        return builder;
    }


}
