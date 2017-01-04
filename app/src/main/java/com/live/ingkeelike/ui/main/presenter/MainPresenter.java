package com.live.ingkeelike.ui.main.presenter;

import com.live.ingkeelike.network.request.MainBean;
import com.live.ingkeelike.ui.main.constract.MainConstract;

import rx.Subscriber;

/**
 * Created by yubai on 2017/1/3.
 */

public class MainPresenter extends MainConstract.Presenter {

    @Override
    public void getListDatas(int pageSize, int pageIndex) {
        MainBean bean = new MainBean(pageSize, pageIndex);
        mRxManage.add(mModel.getListDatas(bean, new Subscriber<String>() {

            @Override
            public void onStart() {


            }

            @Override
            public void onCompleted() {
                mView.pullComplete();

            }

            @Override
            public void onError(Throwable e) {
                mView.pullComplete();
                mView.showErrorTip(e.getMessage());

            }

            @Override
            public void onNext(String s) {



            }
        }));
    }
}
