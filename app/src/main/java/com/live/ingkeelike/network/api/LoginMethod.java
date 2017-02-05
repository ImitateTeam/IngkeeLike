package com.live.ingkeelike.network.api;

import android.support.annotation.Nullable;

import com.live.ingkeelike.network.request.LoginBean;
import com.live.ingkeelike.network.response.HttpFun;

import java.io.IOException;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by yubai on 2017/1/4.
 * 登录模块接口管理
 */

public class LoginMethod extends BaseMethod{

    private static LoginMethod instance;

    public static LoginMethod getInstance() {

        if (null == instance) {
            synchronized(LoginMethod.class){
                if(null == instance){
                    instance = new LoginMethod();
                }
            }
        }
        return instance;
    }

    private LoginMethod() {

    }

    @Override
    public String getBaseUrl() {
        return  "";
    }

    @Nullable
    private LoginApi getLoginApi(){
            return getRetrofit(getBaseUrl()).create(LoginApi.class);

    }

    /**
     * 用户登录
     * @param bean
     * @return
     */
    public Subscription login(LoginBean bean, Subscriber<String> subscriber){
        return getLoginApi().login(bean)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .map(new HttpFun())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

}
