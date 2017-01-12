package com.live.ingkeelike.ui.home.fragment.nearbyfragment.presenter;

/**
 * Created by alo on 2017/1/10.
 */

public interface INearbyPresenter {
    /**
     * 加载数据
     */
    void doLoadData(String path);
    /**
     * 下拉刷新
     */
    void doRefreshData(String path);
}
