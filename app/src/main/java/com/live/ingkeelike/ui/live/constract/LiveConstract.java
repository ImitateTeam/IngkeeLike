package com.live.ingkeelike.ui.live.constract;


import com.live.ingkeelike.network.request.LoginBean;
import com.live.ingkeelike.ui.base.BaseModel;
import com.live.ingkeelike.ui.base.BasePresenter;
import com.live.ingkeelike.ui.base.BaseView;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by wangguifa on 2017/1/16.
 */

public interface LiveConstract {

    interface Model extends BaseModel {

        Subscription login(LoginBean bean, Subscriber<String> subscriber);

    }

    interface View extends BaseView {

        //请求成功
        void requestSuccess();

        //请求失败
        void requestError();

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void login(LoginBean bean);

    }

}
