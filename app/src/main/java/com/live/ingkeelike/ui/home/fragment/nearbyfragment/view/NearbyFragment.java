package com.live.ingkeelike.ui.home.fragment.nearbyfragment.view;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.GridView;

import com.live.ingkeelike.R;
import com.live.ingkeelike.ui.base.BaseFragment;
import com.live.ingkeelike.ui.home.fragment.nearbyfragment.adapter.NearbyListAdapter;
import com.live.ingkeelike.ui.home.fragment.nearbyfragment.presenter.INearbyPresenter;
import com.live.ingkeelike.ui.home.fragment.nearbyfragment.presenter.NearbyPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by alo on 2017/1/10.
 */

public class NearbyFragment extends BaseFragment implements INearbyView {

    @Bind(R.id.nearby_gv)
    GridView nearby_gv;
    @Bind(R.id.nearby_swipeLayout)
    SwipeRefreshLayout nearby_swipeLayout;

    private INearbyPresenter iNearbyPresenter;
    private List<String> nearbylist;
    private NearbyListAdapter nearbyListAdapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.frag_nearby;
    }

    @Override
    public void initPresenter() {
        iNearbyPresenter = new NearbyPresenter(this);

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

        nearbylist = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            nearbylist.add(1 + "");
        }

        nearbyListAdapter = new NearbyListAdapter(context, nearbylist);
        nearby_gv.setAdapter(nearbyListAdapter);

        nearby_swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
               onRefreshData("附近主播");
            }
        });
    }

    @Override
    public void onLoadData(String path) {

    }

    @Override
    public void onRefreshData(final String path) {
        showToast(path+"正在刷新···");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showToast(path+"刷新结束");
                nearby_swipeLayout.setRefreshing(false);
            }
        }, 2000);
    }
}
