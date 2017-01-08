package com.live.ingkeelike.ui.base;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/1/8.
 */

public abstract class DefaultSubscriber<T> extends Subscriber<T> {
    private BaseView view;
    public DefaultSubscriber(BaseView view){
        this.view = view;
    }

    @Override
    public void onCompleted() {
        view.stopLoading();
    }

    @Override
    public void onError(Throwable e) {
        view.showErrorTip(e.getMessage());
    }

    @Override
    public abstract void onNext(T o);
}
