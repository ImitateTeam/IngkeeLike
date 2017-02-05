package com.live.ingkeelike.network.api;

import com.live.ingkeelike.manager.RetrofitManager;


import retrofit2.Retrofit;

/**
 * Created by yubai on 2017/1/4.
 */

public abstract class BaseMethod {

    public abstract String getBaseUrl();

    public Retrofit getRetrofit(String url){
        return RetrofitManager.getInstance().getRetrofit(url);
    }


}
