package com.live.ingkeelike.network.response;

import rx.functions.Func1;

/**
 * Created by yubai on 2017/1/3.
 * des:解析获取result里的数据，前提是result是数据返回的指定字段，根据具体的返回字段来命名
 */

public class HttpFun implements Func1<ResponseBean,String> {

    @Override
    public String call(ResponseBean responseBean) {
        return responseBean.getResult();
    }
}
