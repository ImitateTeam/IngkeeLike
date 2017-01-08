package com.live.ingkeelike.manager;

import android.content.Context;
import android.content.Intent;

/**
 * 统一处理所有Activity的跳转
 * Created by Administrator on 2017/1/7.
 */

public class ActivityJumpManager {
    public static void goLiveActivity(Context context){
        Intent intent = new Intent(context, null);
        startActivity(context, intent);
    }

    public static void startActivity(Context context, Intent intent){
        context.startActivity(intent);
    }
}
