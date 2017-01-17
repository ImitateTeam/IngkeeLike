package com.live.ingkeelike.ui.home.fragment.hotfragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.live.ingkeelike.R;

import java.util.List;

/**
 * Created by alo on 2017/1/10.
 */

public class HotListAdapter extends BaseAdapter {

    private List<String> hotlist;
    private Context context;

    public HotListAdapter(Context context, List<String> hotlist) {
        this.hotlist = hotlist;
        this.context = context;
    }

    @Override
    public int getCount() {
        return hotlist.size();
    }

    @Override
    public Object getItem(int position) {
        return hotlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.hot_list_item, null);
            viewHolder.hot_lv_item_iv = (ImageView) convertView.findViewById(R.id.hot_list_item_iv);
            convertView.setTag(viewHolder);
        } else {
            viewHolder= (ViewHolder) convertView.getTag();
        }

        viewHolder.hot_lv_item_iv.setImageResource(R.mipmap.runningman);

        return convertView;
    }

    class ViewHolder{
        ImageView hot_lv_item_iv;
    }
}
