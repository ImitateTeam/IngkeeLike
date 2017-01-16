package com.live.ingkeelike.ui.live.presenter;

import com.live.ingkeelike.network.request.LoginBean;
import com.live.ingkeelike.ui.login.constract.LoginConstract;

import rx.Subscriber;

/**
 * Created by wangguifa on 2017/1/16.
 */

public class LivePresenter extends LoginConstract.Presenter {

    @Override
    public void login(LoginBean bean) {
        mRxManage.add(mModel.login(bean, new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                mView.showErrorTip(e.getMessage());

            }

            @Override
            public void onNext(String s) {

                mView.requestSuccess();
            }
        }));
    }
}
