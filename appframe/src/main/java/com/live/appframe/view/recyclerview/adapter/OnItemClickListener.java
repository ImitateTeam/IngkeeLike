package com.live.appframe.view.recyclerview.adapter;

import android.view.View;

import com.live.appframe.view.recyclerview.holder.BaseRecycleViewHolder;

public abstract interface OnItemClickListener {
    public abstract void a(View paramView, BaseRecycleViewHolder paramBaseRecycleViewHolder, int paramInt);
}