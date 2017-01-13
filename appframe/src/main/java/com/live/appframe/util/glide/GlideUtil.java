package com.live.appframe.util.glide;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawable;

/**
 * gif自动播放
 * Created by Ino on 2017/1/10.
 */
public class GlideUtil {
    private static Context mContext;

    public static void init(Context context){
        mContext = context;
    }

    //------------------------------------------------------

    public static void loadImage(String url, ImageView imageView){
        loadImage(mContext, url, imageView);
    }

    public static void loadImage(String url, ImageView imageView, final ProgressBar progressBar){
        loadImage(mContext, url, imageView, progressBar);
    }

    public static void loadImage(Context context, String url, ImageView imageView){
        loadImage(context, url, imageView, null);
    }

    public static void loadImage(Context context, String url, ImageView imageView, final ProgressBar progressBar){
        loadImage(context, url, imageView, progressBar, null);
    }

    //------------------------------------------------------

    public static void loadCircleImage(String url, ImageView imageView){
        loadCircleImage(mContext, url, imageView);
    }

    public static void loadCircleImage(String url, ImageView imageView, ProgressBar progressBar){
        loadCircleImage(mContext, url, imageView, progressBar);
    }

    public static void loadCircleImage(Context context, String url, ImageView imageView){
        loadCircleImage(context, url, imageView, null);
    }

    public static void loadCircleImage(Context context, String url, ImageView imageView, ProgressBar progressBar){
        loadImage(context, url, imageView, progressBar, new GlideCircleTransform(context));
    }

    //------------------------------------------------------

    public static void loadRoundImage(String url, ImageView imageView){
        loadRoundImage(mContext, url, imageView);
    }

    public static void loadRoundImage(String url, ImageView imageView, ProgressBar progressBar){
        loadRoundImage(mContext, url, imageView, progressBar);
    }

    public static void loadRoundImage(Context context, String url, ImageView imageView){
        loadRoundImage(context, url, imageView, null);
    }

    public static void loadRoundImage(Context context, String url, ImageView imageView, ProgressBar progressBar){
        loadImage(context, url, imageView, progressBar, new GlideRoundTransform(context));
    }

    public static void loadImage(final Context context, final String url, final ImageView imageView, final ProgressBar progressBar, final BitmapTransformation transformation){
        int width = imageView.getWidth();
        int height = imageView.getHeight();
        if (width <= 0 || height <= 0){
            imageView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onGlobalLayout() {
                    imageView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    load(context, url, imageView, progressBar, transformation);
                }
            });
        } else {
            load(context, url, imageView, progressBar, transformation);
        }
    }

    private static void load(Context context, String url, final ImageView imageView, final ProgressBar progressBar, BitmapTransformation transformation){
        if (transformation == null) {
            if (FileUtil.suffixMatch(url, ".gif")) {
                Glide.with(context).load(url).asGif().listener(new GlideRequestListener<String, GifDrawable>(progressBar)).fitCenter().crossFade().into(imageView);
            } else {
                Glide.with(context).load(url).listener(new GlideRequestListener<String, GlideDrawable>(progressBar)).fitCenter().crossFade().into(imageView);
            }
        } else {
            Glide.with(context).load(url).transform(transformation).listener(new GlideRequestListener<String, GlideDrawable>(progressBar)).into(imageView);
        }
    }
}