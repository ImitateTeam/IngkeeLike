package com.live.ingkeelike.ui.home.fragment;

import android.widget.TextView;

import com.live.ingkeelike.R;
import com.live.ingkeelike.ui.base.BaseFragment;

import butterknife.Bind;

/**
 * 演示Fragment
 * Created by lkq on 2017/1/4.
 */

public class SimpleFragment extends BaseFragment{
    @Bind(R.id.content_tv)
    TextView content_tv;

    //居中TextView显示的内容
    private String mContent;

    public static SimpleFragment newInstance(String title) {
        SimpleFragment simpleFragment = new SimpleFragment();
        simpleFragment.mContent = title;
        return simpleFragment;
    }
    @Override
    protected int getLayoutResource() {
        return R.layout.frag_simple;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        content_tv.setText(mContent);
    }
}
