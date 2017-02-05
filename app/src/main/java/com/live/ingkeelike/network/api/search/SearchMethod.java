package com.live.ingkeelike.network.api.search;

import android.support.annotation.Nullable;

import com.live.ingkeelike.network.api.BaseMethod;
import com.live.ingkeelike.network.request.LoginBean;
import com.live.ingkeelike.network.response.HttpFun;

import java.io.IOException;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/1/8.
 */

public class SearchMethod extends BaseMethod{
    private static class  SearchMethodHolder{
        public static SearchMethod instance = new SearchMethod();
    }

    public static SearchMethod getInstance(){
        return SearchMethodHolder.instance;
    }

    @Override
    public String getBaseUrl() {
        return null;
    }

    @Nullable
    private SearchApi getSearchAPI(){
            return getRetrofit(getBaseUrl()).create(SearchApi.class);
    }

    /**
     * 搜索
     * @param target
     * @return
     */
    public Subscription searchLiveOrUser(String target, Subscriber<String> subscriber){
        return getSearchAPI().searchLiveOrUser(target)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .map(new HttpFun())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 搜索
     * @return
     */
    public Subscription recommendLiveOrUser(Subscriber<String> subscriber){
        return getSearchAPI().recommendLiveOrUser()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .map(new HttpFun())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
