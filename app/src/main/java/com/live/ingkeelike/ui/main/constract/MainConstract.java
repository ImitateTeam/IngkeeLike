package com.live.ingkeelike.ui.main.constract;

import com.live.ingkeelike.network.request.MainBean;
import com.live.ingkeelike.ui.base.BaseModel;
import com.live.ingkeelike.ui.base.BasePresenter;
import com.live.ingkeelike.ui.base.BaseView;

import java.util.ArrayList;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by yubai on 2017/1/3.
 */

public interface MainConstract {

    interface Model extends BaseModel {

        Subscription getListDatas(MainBean bean, Subscriber<String> subscriber);
    }

    interface View extends BaseView {

        void showPullHeaderView();

        void showPullFooterView();

        void pullComplete();

        void showDatas(ArrayList<String> strings);
    }

    abstract class Presenter extends BasePresenter<View,Model> {

        public abstract void getListDatas(int pageSize,int pageIndex);
    }

}