package com.live.ingkeelike.ui.home.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.live.ingkeelike.R;
import com.live.ingkeelike.ui.base.BaseFragment;
import com.live.ingkeelike.ui.base.BaseFragmentAdapter;
import com.live.ingkeelike.ui.home.fragment.hotfragment.view.HotFragment;
import com.live.ingkeelike.ui.home.fragment.nearbyfragment.view.NearbyFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;

/**
 * 首页Fragment
 * Created by lkq on 2017/1/4.
 */

public class HomeFragment extends BaseFragment {
    @Bind(R.id.home_tl)
    TabLayout home_tl;
    @Bind(R.id.home_vp)
    ViewPager home_vp;

    private List<Fragment> fragments=new ArrayList<>();
    private String[] titles={"关注","热门","附近","才艺","好声音"};

    @Override
    protected int getLayoutResource() {
        return R.layout.frag_home;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {

    }

    protected void initData() {
        fragments.add(SimpleFragment.newInstance(titles[0]));

        //添加热门页
        fragments.add(new HotFragment());
        //添加附近页
        fragments.add(new NearbyFragment());

        fragments.add(SimpleFragment.newInstance(titles[3]));
        fragments.add(SimpleFragment.newInstance(titles[4]));

//        for (int i = 2; i < titles.length; i++) {
//            fragments.add(SimpleFragment.newInstance(titles[i]));
//        }

        home_vp.setAdapter(new BaseFragmentAdapter(getChildFragmentManager(),fragments, Arrays.asList(titles)));
        home_tl.setupWithViewPager(home_vp);
    }
}
