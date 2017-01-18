package com.live.ingkeelike.ui.live.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.live.ingkeelike.R;
import com.live.ingkeelike.ui.base.BaseActivity;
import com.live.ingkeelike.ui.live.adapter.VerticalViewPagerAdapter;
import com.live.ingkeelike.ui.live.fragment.LiveRoomFragment;
import com.pili.pldroid.player.widget.PLVideoTextureView;

import java.util.ArrayList;

import butterknife.Bind;
import fr.castorflex.android.verticalviewpager.VerticalViewPager;

/**
 * Created by wangguifa on 2017/1/16.
 * 直播页面
 */
public class LiveActivity extends BaseActivity {

    @Bind(R.id.vertical_viewpager)
    VerticalViewPager mVerticalViewPager;

    private int mCurrentItemPosition; // 当前item
    private static final String DEFAULT_TEST_URL = "rtmp://live.hkstv.hk.lxdns.com/live/hks";
    private ArrayList<String> mVideoUrls = new ArrayList<>();
    private FragmentManager mFragmentManager;
    private RelativeLayout mRoomContainer;
    private FrameLayout mFragmentContainer;
    private PLVideoTextureView mLiveTextureView;
    private int mRoomId = -1;
    private boolean mInit = false;
    private LiveRoomFragment mLiveRoomFragment;

    /**
     * 启动直播页面
     *
     * @param context 上下文
     * @param str     传参1
     * @param id      传参2
     */
    public static void startLiveActivity(Context context, String str, int id) {
        Intent intent = new Intent(context, LiveActivity.class);
        intent.putExtra("live_str", str);
        intent.putExtra("live_id", id);
        context.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_live;
    }

    @Override
    public void initView() {
        mLiveRoomFragment = LiveRoomFragment.newInstance();
        mRoomContainer = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.room_layout, null);
        mFragmentContainer = (FrameLayout) mRoomContainer.findViewById(R.id.fragment_container);
        mLiveTextureView = (PLVideoTextureView) mRoomContainer.findViewById(R.id.live_texture_view);
        // 设置视频全屏
        mLiveTextureView.setDisplayAspectRatio(PLVideoTextureView.ASPECT_RATIO_PAVED_PARENT);
        mFragmentManager = getSupportFragmentManager();

        for (int i = 0; i < 10; i++) { // 添加十个直播地址
            mVideoUrls.add(DEFAULT_TEST_URL);
        }

        VerticalViewPagerAdapter mVerticalViewPagerAdapter = new VerticalViewPagerAdapter(mVideoUrls);
        mVerticalViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mCurrentItemPosition = position;
            }
        });
        mVerticalViewPager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                ViewGroup viewGroup = (ViewGroup) page;
                if ((position < 0 && viewGroup.getId() != mCurrentItemPosition)) {
                    View roomContainer = viewGroup.findViewById(R.id.room_layout);
                    if (roomContainer != null && roomContainer.getParent() != null && roomContainer.getParent() instanceof ViewGroup) {
                        ((ViewGroup) (roomContainer.getParent())).removeView(roomContainer);
                    }
                }
                // 满足此种条件，表明需要加载直播视频，以及聊天室了
                if (viewGroup.getId() == mCurrentItemPosition && position == 0 && mCurrentItemPosition != mRoomId) {
                    if (mRoomContainer.getParent() != null && mRoomContainer.getParent() instanceof ViewGroup) {
                        ((ViewGroup) (mRoomContainer.getParent())).removeView(mRoomContainer);
                    }
                    loadLiveRoom(viewGroup, mCurrentItemPosition);
                }
            }
        });
        mVerticalViewPager.setAdapter(mVerticalViewPagerAdapter);
    }

    private void loadLiveRoom(ViewGroup viewGroup, int position) {
        if (!mInit) { // 直播间的fragment只加载一次，以后复用
            mFragmentManager.beginTransaction().add(mFragmentContainer.getId(), mLiveRoomFragment).commitAllowingStateLoss();
            mInit = true;
        }
        mLiveTextureView.setVideoPath(mVideoUrls.get(position));
        mLiveTextureView.start();
        viewGroup.addView(mRoomContainer);
        mRoomId = position;
    }

    @Override
    public void initPresenter() {

    }
}
