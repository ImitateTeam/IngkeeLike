package com.live.ingkeelike.ui.search.adapter;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.live.appframe.view.recyclerview.adapter.InkeBaseRecyclerAdapter;
import com.live.appframe.view.recyclerview.adapter.WrapTypeData;
import com.live.appframe.view.recyclerview.holder.BaseRecycleViewHolder;
import com.live.ingkeelike.R;
import com.live.ingkeelike.manager.ActivityJumpManager;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends InkeBaseRecyclerAdapter {
    public SearchAdapter(Context paramContext) {
        super(paramContext);
    }

    public BaseRecycleViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt) {
        switch (paramInt) {
            default:
                return null;
            case 1:
                return new LiveHolder(this.inflater.inflate(R.layout.search_live_item, paramViewGroup, false));
            case 2:
                return new UserTitleHolder(this.inflater.inflate(R.layout.search_user_title_item, paramViewGroup, false));
            case 3:
        }
        return new UserHolder(this.inflater.inflate(R.layout.search_user_item, paramViewGroup, false));
    }

    public class LiveHolder extends BaseRecycleViewHolder
            implements View.OnClickListener {
        private String b = "";
        private Context c;
        private String d = "";
        private ArrayList<String> e = new ArrayList();
        private TextView f;
        private TextView g;
        private RecyclerView h;
        private List<WrapTypeData> i;
        private a j;

        public LiveHolder(View parent) {
            super(parent);
            this.c = itemView.getContext();
            this.f = ((TextView) itemView.findViewById(R.id.tv_title));
            this.g = ((TextView) itemView.findViewById(R.id.tv_more));
            this.g.setOnClickListener(this);
            this.h = ((RecyclerView) itemView.findViewById(R.id.recyclerView));
            LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(this.c);
            localLinearLayoutManager.setOrientation(0);
            this.h.setLayoutManager(localLinearLayoutManager);
            this.h.addItemDecoration(new Diveder(itemView.getContext(), 16, 16));
        }

        public void bindData(Object paramObject, int paramInt) {
        }

        public void onClick(View paramView) {
            //startActivity
        }

        private class a extends InkeBaseRecyclerAdapter {
            public a(Context arg2) {
                super(arg2);
            }

            public BaseRecycleViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt) {
                switch (paramInt) {
                    default:
                        return null;
                    case 4:
                }
                View contentView = this.inflater.inflate(R.layout.search_live_grid_item, paramViewGroup, false);
                return new VisitCountItemHolder(contentView);
            }
        }

        private class Diveder extends RecyclerView.ItemDecoration {
            private int b;
            private int c;

            public Diveder(Context paramInt1, int paramInt2, int arg4) {
//                this.inflater = p.onCreateViewHolder(paramInt1, paramInt2);
//                int txt_desc;
//                this.OnItemClickListener = p.onCreateViewHolder(paramInt1, txt_desc);
            }

            public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState) {
//                int txt_desc = paramRecyclerView.getChildAdapterPosition(paramView);
//                int j = paramRecyclerView.getAdapter().getItemCount();
//                int k;
//                if (txt_desc == 0) {
//                    k = this.inflater;
//                    paramRect.left = k;
//                    if (txt_desc != j - 1)
//                        break label66;
//                }
//                label66:
//                for (int m = this.inflater; ; m = this.OnItemClickListener / 2) {
//                    paramRect.right = m;
//                    return;
//                    k = this.OnItemClickListener / 2;
//                    break;
//                }
            }
        }

        private class VisitCountItemHolder extends BaseRecycleViewHolder implements View.OnClickListener {
            private SimpleDraweeView sdv_portrait;
            private TextView txt_count;
            private LiveEntity liveEntity;

            public VisitCountItemHolder(View parentView) {
                super(parentView);
                this.sdv_portrait = ((SimpleDraweeView) itemView.findViewById(R.id.sdv_portrait));
                this.txt_count = ((TextView) itemView.findViewById(R.id.txt_count));
                itemView.setOnClickListener(this);
            }

            public void bindData(Object data, int viewType) {
            }

            public void onClick(View view) {
                ActivityJumpManager.goLiveActivity(view.getContext());
            }
        }
    }

    public class UserHolder extends BaseRecycleViewHolder implements View.OnClickListener {
        private SimpleDraweeView user_portrait;
        private ImageView img_add;
        private ImageView img_gender;
        private ImageView img_level;
        private ImageView img_living;
        private TextView tv_nick;
        private TextView txt_desc;

        public UserHolder(View parentView) {
            super(parentView);
            itemView.setOnClickListener(this);
            this.user_portrait = ((SimpleDraweeView) itemView.findViewById(R.id.user_portrait));
            this.img_add = ((ImageView) itemView.findViewById(R.id.img_add));
            this.img_add.setOnClickListener(this);
            this.img_living = ((ImageView) itemView.findViewById(R.id.img_living));
            this.img_living.setOnClickListener(this);
            this.img_gender = ((ImageView) itemView.findViewById(R.id.img_gender));
            this.img_level = ((ImageView) itemView.findViewById(R.id.img_level));
            this.tv_nick = ((TextView) itemView.findViewById(R.id.tv_nick));
            this.txt_desc = ((TextView) itemView.findViewById(R.id.txt_desc));
        }

        public void bindData(Object paramObject, int paramInt) {
        }

        public void onClick(View paramView) {
        }
    }

    public class UserTitleHolder extends BaseRecycleViewHolder {
        private TextView tv_title;

        public UserTitleHolder(View parent) {
            super(parent);
            this.tv_title = ((TextView) itemView.findViewById(R.id.tv_title));
        }

        public void bindData(Object data, int viewType) {
        }
    }
}