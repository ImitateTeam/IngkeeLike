package com.live.ingkeelike.manager;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by yubai on 2017/1/3.
 */

public class OkHttpManager {

    private static OkHttpManager singleton;
    public static OkHttpManager getInstance(){
        if (singleton == null) {
            synchronized (OkHttpManager.class) {
                if (singleton == null) {
                    singleton = new OkHttpManager();
                }
            }
        }
        return singleton;
    }

    public OkHttpClient getOkhttp(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .connectTimeout(15, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {

                        Request request = chain.request();
                        request = request.newBuilder()
                                .header("Content-Type", "application/json")
                                .header("Accept-Encoding", "gzip,deflate")
                                .header("Charset", "UTF-8")
                                .header("Accept", "application/json")
                                .method(request.method(), request.body())
                                .build();
                        return chain.proceed(request);
                    }
                })
                .build();
        return client;
    }



}
