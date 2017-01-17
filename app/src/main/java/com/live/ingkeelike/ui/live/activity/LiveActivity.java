package com.live.ingkeelike.ui.live.activity;

import com.live.ingkeelike.R;
import com.live.ingkeelike.ui.base.BaseActivity;
import com.pili.pldroid.player.widget.PLVideoTextureView;

/**
 * Created by wangguifa on 2017/1/16.
 * 直播页面
 */
public class LiveActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_live;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        String videoPath = "rtmp://live.hkstv.hk.lxdns.com/live/hks";
        PLVideoTextureView mTextureView = (PLVideoTextureView) findViewById(R.id.video_live);
        mTextureView.setVideoPath(videoPath);
        mTextureView.start();
    }
}
