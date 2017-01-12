package com.live.ingkeelike.ui.home.fragment.nearbyfragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.live.ingkeelike.R;

import java.util.List;

/**
 * Created by alo on 2017/1/10.
 */

public class NearbyListAdapter extends BaseAdapter {

    private List<String> nearbylist;
    private Context context;

    public NearbyListAdapter(Context context, List<String> nearbylist) {
        this.nearbylist = nearbylist;
        this.context = context;
    }

    @Override
    public int getCount() {
        return nearbylist.size();
    }

    @Override
    public Object getItem(int position) {
        return nearbylist.get(position);
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
            convertView = LayoutInflater.from(context).inflate(R.layout.nearby_list_item, null);
            viewHolder.nearby_list_item_iv_head = (ImageView) convertView.findViewById(R.id.nearby_list_item_iv_head);
            viewHolder.nearby_list_item_iv_rank = (ImageView) convertView.findViewById(R.id.nearby_list_item_iv_rank);
            viewHolder.nearby_list_item_tv_distance = (TextView) convertView.findViewById(R.id.nearby_list_item_tv_distance);
            convertView.setTag(viewHolder);
        } else {
            viewHolder= (ViewHolder) convertView.getTag();
        }

        viewHolder.nearby_list_item_iv_head.setImageResource(R.mipmap.runningman);
        viewHolder.nearby_list_item_iv_rank.setImageResource(R.drawable.rank_1);
        viewHolder.nearby_list_item_tv_distance.setText(0+"km");

        return convertView;
    }

    class ViewHolder{
        ImageView nearby_list_item_iv_head,nearby_list_item_iv_rank;
        TextView nearby_list_item_tv_distance;
    }
}
