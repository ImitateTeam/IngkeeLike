package com.live.appframe.view.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.live.appframe.R;
import com.live.appframe.view.recyclerview.holder.BaseRecycleViewHolder;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerAdapter<FT> extends RecyclerView.Adapter<BaseRecycleViewHolder> {
    protected List<FT> data = new ArrayList();
    protected LayoutInflater inflater;
    private OnItemClickListener OnItemClickListener;

    public BaseRecyclerAdapter(Context paramContext) {
        this.inflater = LayoutInflater.from(paramContext);
    }

    public abstract BaseRecycleViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt);//onCreateViewHolder

    public List<FT> getData() {
        return this.data;
    }

    public void setData(List<FT> paramList) {
        this.data = paramList;
    }

    public void setOnItemClick(OnItemClickListener paramc) {
        this.OnItemClickListener = paramc;
    }
}