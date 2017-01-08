package com.live.ingkeelike.ui.search.model;

import com.live.ingkeelike.network.api.search.SearchMethod;
import com.live.ingkeelike.ui.search.contract.SearchContract;

import rx.Subscriber;
import rx.Subscription;

public class SearchModel implements SearchContract.Model {

    @Override
    public Subscription search(String target, Subscriber<String> subscriber) {
        return SearchMethod.getInstance().searchLiveOrUser(target,subscriber);
    }

    @Override
    public Subscription recommend(Subscriber<String> subscriber) {
        return SearchMethod.getInstance().recommendLiveOrUser(subscriber);
    }
}
