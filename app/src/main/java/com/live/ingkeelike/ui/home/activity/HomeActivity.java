package com.live.ingkeelike.ui.home.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.live.ingkeelike.R;
import com.live.ingkeelike.constants.Constants;
import com.live.ingkeelike.ui.base.BaseActivity;
import com.live.ingkeelike.ui.home.fragment.HomeFragment;
import com.live.ingkeelike.ui.home.fragment.SimpleFragment;

import butterknife.Bind;

/**
 * 主页Activity
 * Created by lkq on 2017/1/4.
 */

public class HomeActivity extends BaseActivity {
    //底部切换按钮的容器
    @Bind(R.id.home_tab_rg)
    RadioGroup home_tab_rg;
    //“首页”切换按钮
    @Bind(R.id.home_rbtn)
    RadioButton home_rbtn;

    //存放Fragment的数组，一边管理
    private Fragment[] fragments;
    //当前选中的RadioButton的位置
    private int position;

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFragment(savedInstanceState);
    }

    /**
     * 初始化Fragment
     *
     * @param savedInstanceState 保存状态的Bundle
     */
    private void initFragment(Bundle savedInstanceState) {
        HomeFragment homefragment;
        SimpleFragment simpleFragment;
        //当当前Activity被系统销毁时，Fragment可能会重叠，这里做下判断处理
        if (savedInstanceState != null) {
            homefragment= (HomeFragment) getSupportFragmentManager().findFragmentByTag(HomeFragment.class.getSimpleName());
            simpleFragment= (SimpleFragment) getSupportFragmentManager().findFragmentByTag(SimpleFragment.class.getSimpleName());
            fragments=new Fragment[]{homefragment,simpleFragment};
            position = savedInstanceState.getInt(Constants.HomeActivityContants.POSTION, 0);
            switchTo(position);
        } else {
            //正常情况
            homefragment=new HomeFragment();
            simpleFragment=SimpleFragment.newInstance("我的");
            fragments=new Fragment[]{homefragment,simpleFragment};
            //默认点击首页
            home_rbtn.performClick();
        }
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        setListener();
    }

    /**
     * 设置监听
     */
    private void setListener() {
        home_tab_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.home_rbtn:
                        position = Constants.HomeActivityContants.HOME_POSITION;
                        break;
                    case R.id.mine_rbtn:
                        position = Constants.HomeActivityContants.MINE_POSITION;
                        break;
                    default:
                        break;
                }
                switchTo(position);
            }
        });
    }

    /**
     * 切换Fragment的方法
     */
    private void switchTo(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment toFragment = fragments[position];
        if (toFragment == null) {
            return;
        }
        //判断Fragment是否被add过,没有被add的话就将它add
        if (!fragments[position].isAdded()) {
            transaction.add(R.id.container_fl, toFragment, toFragment.getClass().getSimpleName());
        }

        //将点击的位置的Fragment显示出来，其余的hide
        for (int i = 0; i < fragments.length; i++) {
            if (i == position) {
                transaction.show(toFragment);
            } else {
                if (fragments[i] != null) {
                    transaction.hide(fragments[i]);
                }

            }
        }
        transaction.commitAllowingStateLoss();
    }
}
