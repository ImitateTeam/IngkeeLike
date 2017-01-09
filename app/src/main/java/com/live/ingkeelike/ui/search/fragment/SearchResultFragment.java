package com.live.ingkeelike.ui.search.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.live.ingkeelike.R;
import com.live.ingkeelike.ui.base.BaseFragment;
import com.live.ingkeelike.ui.search.presenter.SearchPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/1/8.
 */

public class SearchResultFragment extends BaseFragment {
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

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
