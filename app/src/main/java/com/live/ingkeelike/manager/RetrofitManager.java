package com.live.ingkeelike.manager;


import com.live.ingkeelike.constants.Constants;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yubai on 2017/2/5.
 */

public class RetrofitManager {

    private static RetrofitManager singleton;
    public static RetrofitManager getInstance(){
        if (singleton == null) {
            synchronized (RetrofitManager.class) {
                if (singleton == null) {
                    singleton = new RetrofitManager();
                }
            }
        }
        return singleton;
    }

    public Retrofit getRetrofit(String url){
        Retrofit builder = new Retrofit.Builder()
                .client(OkHttpManager.getInstance().getOkhttp())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Constants.BASE_URL+url)
                .build();
        return builder;
    }
}
