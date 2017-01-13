package com.live.ingkeelike.network.api.search;

import com.live.ingkeelike.network.response.ResponseBean;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * 搜索用户、直播等
 * Created by Administrator on 2017/1/8.
 */

interface SearchAPI {
    /**
     * 搜索用户、直播
     * @param target
     * @return
     */
    @POST
    Observable<ResponseBean> searchLiveOrUser(@Body String target);

    /**
     * 获取推荐的用户、直播
     * @return
     */
    @POST
    Observable<ResponseBean> recommendLiveOrUser();
}
