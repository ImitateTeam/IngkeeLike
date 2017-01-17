package com.live.appframe.view.recyclerview.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.live.appframe.view.recyclerview.adapter.OnItemClickListener;

public abstract class BaseRecycleViewHolder extends RecyclerView.ViewHolder {
    private static long b = 0L;
    private OnItemClickListener onItemClickListener;

    public BaseRecycleViewHolder(View paramView) {
        super(paramView);
    }

    public Context a() {
        return this.itemView.getContext();
    }

    public BaseRecycleViewHolder a(OnItemClickListener listener) {
        onItemClickListener = listener;
        if (listener != null)
            this.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramView) {
                    if (System.currentTimeMillis() - BaseRecycleViewHolder.b < 500L) {
                        Log.w("BaseRecycleViewHolder", "click too quick!you must click after one seconds");
                        return;
                    }
                    BaseRecycleViewHolder.b = System.currentTimeMillis();
                    onItemClickListener.a(BaseRecycleViewHolder.this.itemView, BaseRecycleViewHolder.this, BaseRecycleViewHolder.this.getLayoutPosition());
                }
            });
        return this;
    }

    public abstract void bindData(Object paramObject, int paramInt);
}