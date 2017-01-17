package com.live.ingkeelike.ui.live.activity;

import android.content.Context;
import android.content.Intent;

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

    /**
     * 启动直播页面
     * @param context   上下文
     * @param str   传参1
     * @param id    传参2
     */
    public static void startLiveActivity(Context context,String str,int id){
        Intent intent=new Intent(context,LiveActivity.class);
        intent.putExtra("live_str",str);
        intent.putExtra("live_id",id);
        context.startActivity(intent);
    }
}
