package com.live.ingkeelike.ui.personal.setting.activity;

import android.view.View;
import android.widget.Toast;

import com.live.ingkeelike.R;
import com.live.ingkeelike.ui.base.BaseActivity;
import com.live.ingkeelike.widget.TitleLayout;

import butterknife.Bind;

/**
 * 设置界面
 * Created by Yuan on 2017/1/17.
 */
public class SettingActivity extends BaseActivity {

    @Bind(R.id.title_layout)
    TitleLayout title;

    @Override
    public int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        title.setOnRightTextClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "aa", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
