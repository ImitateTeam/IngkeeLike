package com.live.ingkeelike.ui.search.activity;

import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.live.ingkeelike.R;
import com.live.ingkeelike.ui.base.BaseFragmentActivity;
import com.live.ingkeelike.ui.search.contract.SearchContract;
import com.live.ingkeelike.ui.search.fragment.SearchRecommendFragment;
import com.live.ingkeelike.ui.search.fragment.SearchResultFragment;
import com.live.ingkeelike.ui.search.model.SearchModel;
import com.live.ingkeelike.ui.search.presenter.SearchPresenter;

import butterknife.Bind;

public class SearchActivity extends BaseFragmentActivity<SearchPresenter, SearchModel> implements SearchContract.View {

    @Bind(R.id.back)
    ImageButton back;
    @Bind(R.id.btn_cancel)
    Button btnCancel;
    @Bind(R.id.btn_searchicon)
    ImageButton btnSearchicon;
    @Bind(R.id.btn_del)
    ImageButton btnDel;
    @Bind(R.id.edit)
    EditText edit;
    @Bind(R.id.ly_search_head)
    RelativeLayout lySearchHead;
    @Bind(R.id.btn_search)
    Button btnSearch;
    @Bind(R.id.search_container)
    FrameLayout searchContainer;
    @Bind(R.id.activity_search)
    LinearLayout activitySearch;

    private SearchRecommendFragment recommendFragment;
    private SearchResultFragment resultFragment;

    @Override
    public int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        recommendFragment = new SearchRecommendFragment();
        recommendFragment.setPresenter(mPresenter);
        resultFragment = new SearchResultFragment();
        resultFragment.setPresenter(mPresenter);
        addFragment(R.id.search_container, recommendFragment);
    }

    @Override
    public void requestSuccess() {

    }

    @Override
    public void requestError() {

    }

    @Override
    public void showLoading(String title) {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showErrorTip(String msg) {

    }
}
