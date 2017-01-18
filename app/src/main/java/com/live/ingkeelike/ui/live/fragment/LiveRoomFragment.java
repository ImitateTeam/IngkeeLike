package com.live.ingkeelike.ui.live.fragment;

import android.os.Bundle;

import com.live.ingkeelike.R;
import com.live.ingkeelike.ui.base.BaseFragment;

/**
 * Created by wangguifa on 2017/1/18
 */

public class LiveRoomFragment extends BaseFragment {

    public static LiveRoomFragment newInstance() {
        Bundle args = new Bundle();
        LiveRoomFragment fragment = new LiveRoomFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_live_room;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}
