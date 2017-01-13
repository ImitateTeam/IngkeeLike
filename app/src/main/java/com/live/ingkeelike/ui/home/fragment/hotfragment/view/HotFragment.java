package com.live.ingkeelike.ui.home.fragment.hotfragment.view;

import android.widget.LinearLayout;
import android.widget.ListView;

import com.live.ingkeelike.R;
import com.live.ingkeelike.ui.base.BaseFragment;
import com.live.ingkeelike.ui.home.fragment.hotfragment.adapter.HotListAdapter;
import com.live.ingkeelike.ui.home.fragment.hotfragment.presenter.HotPresenter;
import com.live.ingkeelike.ui.home.fragment.hotfragment.presenter.IHotPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by alo on 2017/1/10.
 */

public class HotFragment extends BaseFragment implements IHotView {

    @Bind(R.id.hot_lv)
    ListView hot_lv;
    @Bind(R.id.hot_swipeLayout)
    LinearLayout hot_swipeLayout;

    private IHotPresenter hotPresenter;
    private List<String> hotlist;
    private HotListAdapter hotListAdapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.frag_hot;
    }

    @Override
    public void initPresenter() {
        hotPresenter = new HotPresenter(this);

    }

    @Override
    protected void initView() {

        hotlist = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            hotlist.add(1+"");
        }

        hotListAdapter = new HotListAdapter(context, hotlist);
        hot_lv.setAdapter(hotListAdapter);

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onLoadData(String path) {

    }
}
