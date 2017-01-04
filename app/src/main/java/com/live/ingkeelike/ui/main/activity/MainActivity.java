package com.live.ingkeelike.ui.main.activity;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.live.ingkeelike.R;
import com.live.ingkeelike.ui.base.BaseActivity;
import com.live.ingkeelike.ui.main.adapter.NormalRecyclerViewAdapter;
import com.live.ingkeelike.ui.main.constract.MainConstract;
import com.live.ingkeelike.ui.main.model.MainModel;
import com.live.ingkeelike.ui.main.presenter.MainPresenter;

import java.util.ArrayList;

import butterknife.Bind;

public class MainActivity extends BaseActivity<MainPresenter,MainModel> implements MainConstract.View{

    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;

    private int pageSize;
    private int pageIndex;
    private ArrayList<String> datas = new ArrayList<>();
    private NormalRecyclerViewAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this,mModel);

    }

    @Override
    public void initView() {

        mPresenter.getListDatas(pageSize,pageIndex);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));//这里用线性显示 类似于listview
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));//这里用线性宫格显示 类似于grid view
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));//这里用线性宫格显示 类似于瀑布流

        adapter = new NormalRecyclerViewAdapter(this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void showDatas(ArrayList<String> strings) {
        adapter.setDatas(strings);
    }

    @Override
    public void pullComplete() {

    }

    @Override
    public void showPullHeaderView() {

    }

    @Override
    public void showPullFooterView() {

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
