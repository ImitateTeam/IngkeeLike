package com.live.ingkeelike.ui.search.contract;


import com.live.ingkeelike.network.request.LoginBean;
import com.live.ingkeelike.ui.base.BaseModel;
import com.live.ingkeelike.ui.base.BasePresenter;
import com.live.ingkeelike.ui.base.BaseView;

import rx.Subscriber;
import rx.Subscription;

public interface SearchContract {

    interface Model extends BaseModel {

        Subscription search(String target, Subscriber<String> subscriber);
        Subscription recommend(Subscriber<String> subscriber);

    }

    interface View extends BaseView {

        //请求成功
        void requestSuccess();

        //请求失败
        void requestError();

    }

    abstract class Presenter extends BasePresenter<View,Model> {

        public abstract void search(String target);
        public abstract void recommend();

    }

}
