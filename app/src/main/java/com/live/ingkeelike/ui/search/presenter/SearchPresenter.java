package com.live.ingkeelike.ui.search.presenter;

import com.live.ingkeelike.network.request.LoginBean;
import com.live.ingkeelike.ui.base.DefaultSubscriber;
import com.live.ingkeelike.ui.login.constract.LoginConstract;
import com.live.ingkeelike.ui.search.contract.SearchContract;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/1/7.
 */

public class SearchPresenter extends SearchContract.Presenter {
    @Override
    public void search(String target) {
        mRxManage.add(mModel.search(target, new DefaultSubscriber<String>(mView) {
            @Override
            public void onNext(String o) {
                // TODO: 2017/1/8 binddata
                mView.stopLoading();
            }
        }));
    }

    @Override
    public void recommend() {
        mRxManage.add(mModel.recommend(new DefaultSubscriber<String>(mView) {
            @Override
            public void onNext(String o) {
                // TODO: 2017/1/8 binddata
                mView.stopLoading();
            }
        }));
    }
}
