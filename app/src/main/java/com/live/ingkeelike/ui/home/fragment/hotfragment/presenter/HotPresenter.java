package com.live.ingkeelike.ui.home.fragment.hotfragment.presenter;

import com.live.ingkeelike.ui.home.fragment.hotfragment.view.IHotView;

/**
 * Created by alo on 2017/1/10.
 */

public class HotPresenter implements IHotPresenter {
    IHotView iHotView;

    public HotPresenter(IHotView iHotView) {
        this.iHotView = iHotView;
    }

    @Override
    public void doLoadData(String path) {

    }
}
