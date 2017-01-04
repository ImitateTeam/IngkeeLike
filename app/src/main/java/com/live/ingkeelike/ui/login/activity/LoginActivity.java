package com.live.ingkeelike.ui.login.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.live.ingkeelike.R;
import com.live.ingkeelike.network.request.LoginBean;
import com.live.ingkeelike.ui.base.BaseActivity;
import com.live.ingkeelike.ui.login.constract.LoginConstract;
import com.live.ingkeelike.ui.login.model.LoginModel;
import com.live.ingkeelike.ui.login.presenter.LoginPresenter;
import com.live.ingkeelike.ui.main.activity.MainActivity;

import butterknife.Bind;

/**
 * Created by yubai on 2017/1/3.
 */

public class LoginActivity extends BaseActivity<LoginPresenter, LoginModel> implements LoginConstract.View {


    @Bind(R.id.et_input_phone)
    EditText etInputPhone;
    @Bind(R.id.et_input_password)
    EditText etInputPassword;
    @Bind(R.id.btn_login)
    Button btnLogin;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LoginBean bean = new LoginBean(etInputPhone.getText().toString(), etInputPassword.getText().toString());
                mPresenter.login(bean);
            }
        });
    }

    @Override
    public void requestSuccess() {
        startActivity(new Intent(mContext, MainActivity.class));
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

        toast(msg);
    }

}
