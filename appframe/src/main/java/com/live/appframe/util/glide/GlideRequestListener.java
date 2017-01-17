package com.live.appframe.util.glide;

import android.view.View;

import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

/**
 * Created by Ino on 2017/1/10.
 */
public class GlideRequestListener<T, R> implements RequestListener<T, R> {
    private View progressBar;

    public GlideRequestListener(View progressBar) {
        this.progressBar = progressBar;
        if (progressBar != null){
            progressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public boolean onException(Exception e, T model, Target<R> target, boolean isFirstResource) {
        if (progressBar != null){
            progressBar.setVisibility(View.GONE);
        }
        return false;
    }

    @Override
    public boolean onResourceReady(R resource, T model, Target<R> target, boolean isFromMemoryCache, boolean isFirstResource) {
        if (progressBar != null){
            progressBar.setVisibility(View.GONE);
        }
        return false;
    }
}