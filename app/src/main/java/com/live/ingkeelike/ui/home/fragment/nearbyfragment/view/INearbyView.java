package com.live.ingkeelike.ui.home.fragment.nearbyfragment.view;

/**
 * Created by alo on 2017/1/10.
 */

public interface INearbyView {
    /**
     * 加载数据
     */
    void onLoadData(String path);
    /**
     * 下拉刷新
     */
    void onRefreshData(String path);
}
