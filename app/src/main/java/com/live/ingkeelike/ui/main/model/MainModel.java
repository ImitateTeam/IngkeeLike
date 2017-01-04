package com.live.ingkeelike.ui.main.model;

import com.live.ingkeelike.network.api.MainMethod;
import com.live.ingkeelike.network.request.MainBean;
import com.live.ingkeelike.ui.main.constract.MainConstract;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by yubai on 2017/1/3.
 */

public class MainModel implements MainConstract.Model {

    @Override
    public Subscription getListDatas(MainBean bean, Subscriber<String> subscriber) {
        return MainMethod.getInstance().getListDatas(bean, subscriber);
    }
}