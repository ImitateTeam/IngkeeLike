package com.live.appframe.util.glide;

import android.text.TextUtils;

import java.io.File;

/**
 * Created by Ino on 2017/1/11.
 */
public class FileUtil {
    /**
     * 根据后缀名判断是否为该类型文件
     * @param name
     * @param suffix
     * @return
     */
    public static boolean suffixMatch(String name, String suffix){
        if (!TextUtils.isEmpty(name)) {
            String dot = name.substring(name.length() - 4, name.length());
            return dot.equals(suffix);
        }
        return false;
    }

    public static boolean suffixMatch(File file, String suffix){
        if (file != null) {
            suffixMatch(file.getAbsolutePath(), suffix);
        }
        return false;
    }
}