package com.live.ingkeelike.network.api;

import com.live.ingkeelike.network.request.LoginBean;
import com.live.ingkeelike.network.response.ResponseBean;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by yubai on 2017/1/3.
 * des：登录接口
 */

public interface LoginApi {


    /**
     * 用户登录
     * @param bean
     * @return
     */
    @POST
    Observable<ResponseBean> login(@Body LoginBean bean);

}
