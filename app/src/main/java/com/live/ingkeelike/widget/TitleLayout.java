package com.live.ingkeelike.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.live.ingkeelike.R;

/**
 * 标题栏layout
 * Created by Yuan on 2017/1/17.
 */
public class TitleLayout extends RelativeLayout {

    private Context context;

    private TextView rightTitleTV;

    public TitleLayout(Context context) {
        super(context);
        this.context = context;
        initLayout(null);
    }


    public TitleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initLayout(attrs);
    }

    public TitleLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayout(attrs);
    }

    /**
     * 初始化标题，右边title，是否有返回键
     *
     * @param attrs
     */
    private void initLayout(AttributeSet attrs) {
        View v = View.inflate(context, R.layout.view_title, this);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.TitleLayout);
        TextView titleTV = (TextView) v.findViewById(R.id.title_text);
        rightTitleTV = (TextView) v.findViewById(R.id.title_right_text);
        ImageView backImg = (ImageView) v.findViewById(R.id.title_back);
        if (attrs != null) {
            String title = array.getString(R.styleable.TitleLayout_title_txt);
            String rightTitle = array.getString(R.styleable.TitleLayout_rightTitle_txt);
            boolean hasBack = array.getBoolean(R.styleable.TitleLayout_hasBack, true);
            titleTV.setText(title);
            if (hasBack) {
                backImg.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (context instanceof Activity) {
                            ((Activity) context).finish();
                        }
                    }
                });
            } else {
                backImg.setVisibility(View.GONE);
            }
            if (rightTitle != null && !"".equals(rightTitle)) {
                rightTitleTV.setVisibility(View.VISIBLE);
                rightTitleTV.setText(rightTitle);
            }
        }
        array.recycle();
    }

    /**
     * 设置右边文字的点击事件
     * @param listener
     */
    public void setOnRightTextClickListener(OnClickListener listener) {
        rightTitleTV.setOnClickListener(listener);
    }

}