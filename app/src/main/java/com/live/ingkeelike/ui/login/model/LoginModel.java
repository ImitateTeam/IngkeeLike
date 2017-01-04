package com.live.ingkeelike.ui.login.model;

import com.live.ingkeelike.network.api.LoginMethod;
import com.live.ingkeelike.network.request.LoginBean;
import com.live.ingkeelike.ui.login.constract.LoginConstract;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by yubai on 2017/1/3.
 */

public class LoginModel implements LoginConstract.Model {

    @Override
    public Subscription login(LoginBean bean, Subscriber<String> subscriber) {
        return LoginMethod.getInstance().login(bean,subscriber);
    }

}
