package com.live.ingkeelike.ui.home.fragment.nearbyfragment.presenter;

import com.live.ingkeelike.ui.home.fragment.nearbyfragment.view.INearbyView;

/**
 * Created by alo on 2017/1/10.
 */

public class NearbyPresenter implements INearbyPresenter {
    INearbyView INearbyView;

    public NearbyPresenter(INearbyView INearbyView) {
        this.INearbyView = INearbyView;
    }

    @Override
    public void doLoadData(String path) {

    }

    @Override
    public void doRefreshData(String path) {

    }
}
