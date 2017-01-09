package com.live.appframe.view.recyclerview.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.live.appframe.view.recyclerview.holder.BaseRecycleViewHolder;

public abstract class InkeBaseRecyclerAdapter extends BaseRecyclerAdapter<WrapTypeData> {
    public InkeBaseRecyclerAdapter(Context context) {
        super(context);
    }

    public BaseRecycleViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int position) {
        return null;
    }

    public void onBindViewHolder(BaseRecycleViewHolder paramBaseRecycleViewHolder, int position) {
        paramBaseRecycleViewHolder.bindData(getData().get(position).getData(), position);
    }

    public int getItemCount() {
        if (getData() == null)
            return 0;
        return getData().size();
    }

    public int getItemViewType(int position) {
        return getData().get(position).getViewType();
    }
}