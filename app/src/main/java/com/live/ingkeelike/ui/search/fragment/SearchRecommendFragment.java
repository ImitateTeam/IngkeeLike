package com.live.ingkeelike.ui.search.fragment;

import com.live.ingkeelike.R;
import com.live.ingkeelike.ui.base.BaseFragment;
import com.live.ingkeelike.ui.search.presenter.SearchPresenter;

/**
 * Created by Administrator on 2017/1/8.
 */

public class SearchRecommendFragment extends BaseFragment{
    @Override
    protected int getLayoutResource() {
        return R.layout.frag_search;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        if (mPresenter != null){
            ((SearchPresenter)mPresenter).search("");
        }
    }

    public void setPresenter(SearchPresenter presenter){
        mPresenter = presenter;
    }
}
