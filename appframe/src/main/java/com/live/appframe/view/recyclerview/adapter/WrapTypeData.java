package com.live.appframe.view.recyclerview.adapter;

public class WrapTypeData {
    private int viewType;
    private Object data;

    public WrapTypeData(int paramInt, Object paramObject) {
        this.viewType = paramInt;
        this.data = paramObject;
    }

    public int getViewType() {
        return this.viewType;
    }

    public Object getData() {
        return this.data;
    }
}