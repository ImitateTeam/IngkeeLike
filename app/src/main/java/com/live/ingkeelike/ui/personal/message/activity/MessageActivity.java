package com.live.ingkeelike.ui.personal.message.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.live.ingkeelike.R;
import com.live.ingkeelike.ui.base.BaseActivity;
import com.live.ingkeelike.ui.base.BaseFragmentAdapter;
import com.live.ingkeelike.ui.home.fragment.SimpleFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;

/**
 * 消息界面
 * Created by yuan on 2017/1/13.
 */
public class MessageActivity extends BaseActivity {

    @Bind(R.id.mess_tl)
    TabLayout mess_tl;

    @Bind(R.id.mess_vp)
    ViewPager mess_vp;

    private List<Fragment> fragments = new ArrayList<>();
    private String[] titles = {"好友", "未关注"};


    @Override
    public int getLayoutId() {
        return R.layout.activity_message;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        initData();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        for (int i = 0; i < titles.length; i++) {
            fragments.add(SimpleFragment.newInstance(titles[i]));
        }
        mess_vp.setAdapter(new BaseFragmentAdapter(getSupportFragmentManager(),fragments, Arrays.asList(titles)));
        mess_tl.setupWithViewPager(mess_vp);
    }
}
