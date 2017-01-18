package com.live.ingkeelike.ui.live.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.live.ingkeelike.R;

import java.util.ArrayList;

/**
 * Created by wangguifa on 2017/1/18.
 * 竖向滑动的ViewPager
 */
public class VerticalViewPagerAdapter extends PagerAdapter {

    private ArrayList<String> mVideoUrls;


    public VerticalViewPagerAdapter(ArrayList<String> mVideoUrls) {
        this.mVideoUrls = mVideoUrls;
    }

    @Override
    public int getCount() {
        return mVideoUrls.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.live_room_item, null);
        view.setId(position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(container.findViewById(position));
    }
}
