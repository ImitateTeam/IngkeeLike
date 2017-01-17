package com.live.ingkeelike.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.live.ingkeelike.manager.RxManager;
import com.live.ingkeelike.util.ClassUtil;

import butterknife.ButterKnife;

/**
 * Created by yubai on 2017/1/3.
 */
public abstract class BaseFragment<T extends BasePresenter, E extends BaseModel> extends Fragment {

    protected View rootView;
    public T mPresenter;
    public E mModel;
    public RxManager mRxManager;
    protected Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null)
            rootView = inflater.inflate(getLayoutResource(), container, false);
        mRxManager = new RxManager();
        ButterKnife.bind(this, rootView);
        mPresenter = ClassUtil.getT(this, 0);
        mModel= ClassUtil.getT(this,1);
        context = getActivity();
        if(mPresenter!=null){
            mPresenter.mContext=this.getActivity();
        }
        initPresenter();
        initData();
        initView();
        return rootView;
    }

    //获取布局文件
    protected abstract int getLayoutResource();
    //简单页面无需mvp就不用管此方法即可,完美兼容各种实际场景的变通
    public abstract void initPresenter();
    //初始化view
    protected abstract void initView();
    //初始化数据
    protected abstract void initData();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
        if (mPresenter != null)
            mPresenter.onDestroy();
        mRxManager.clear();
    }


}
