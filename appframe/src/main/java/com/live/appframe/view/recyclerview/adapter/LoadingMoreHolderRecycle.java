package com.live.appframe.view.recyclerview.adapter;

import android.view.View;
import android.widget.TextView;

import com.live.appframe.R;
import com.live.appframe.view.recyclerview.holder.BaseRecycleViewHolder;

public class LoadingMoreHolderRecycle extends BaseRecycleViewHolder
{
  private TextView a;

  public LoadingMoreHolderRecycle(View paramView)
  {
    super(paramView);
//    this.onCreateViewHolder = ((TextView)paramView.findViewById(R.id.subtitle));
  }

  public void bindData(Object paramObject, int paramInt)
  {
    if ((paramObject == null) || (!(paramObject instanceof String)))
      return;
    this.a.setText((String)paramObject);
  }
}