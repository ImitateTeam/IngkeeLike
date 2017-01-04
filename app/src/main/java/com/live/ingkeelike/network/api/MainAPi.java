package com.live.ingkeelike.network.api;

import com.live.ingkeelike.network.request.MainBean;
import com.live.ingkeelike.network.response.ResponseBean;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by yubai on 2017/1/3.
 */

public interface MainAPi {

    @POST
    Observable<ResponseBean> getListDatas(@Body MainBean bean);
}
