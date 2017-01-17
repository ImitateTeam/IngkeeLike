package com.live.ingkeelike.ui.home.fragment.hotfragment.view;

<<<<<<< HEAD
=======
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
>>>>>>> origin/master
import android.widget.LinearLayout;
import android.widget.ListView;

import com.live.ingkeelike.R;
import com.live.ingkeelike.ui.base.BaseFragment;
import com.live.ingkeelike.ui.home.fragment.hotfragment.adapter.HotListAdapter;
import com.live.ingkeelike.ui.home.fragment.hotfragment.presenter.HotPresenter;
import com.live.ingkeelike.ui.home.fragment.hotfragment.presenter.IHotPresenter;
<<<<<<< HEAD
=======
import com.live.ingkeelike.ui.live.activity.LiveActivity;
>>>>>>> origin/master

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

<<<<<<< HEAD

    }

    @Override
    protected void initData() {

=======
>>>>>>> origin/master
        hotlist = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            hotlist.add(1+"");
        }

        hotListAdapter = new HotListAdapter(context, hotlist);
        hot_lv.setAdapter(hotListAdapter);
<<<<<<< HEAD
=======
        hot_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(getActivity(), LiveActivity.class);
                startActivity(intent);
            }
        });


//                new () {
//            @Override
//            public void onClick(View v) {
//                Intent intent= new Intent(getActivity(), LiveActivity.class);
//                startActivity(intent);
//            }
//        });
    }

    @Override
    protected void initData() {

>>>>>>> origin/master
    }

    @Override
    public void onLoadData(String path) {

    }
}
