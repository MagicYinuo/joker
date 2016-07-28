package com.tai.joker.joker.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * sharedpreference 工具类
 * Created by Administrator on 2016/7/28.
 */
public class SPUtil {
    private Context context;
    private SharedPreferences.Editor editor;
    private SharedPreferences sp;

    public SPUtil(Context context) {
        this.context = context;
        sp = this.context.getSharedPreferences("common", Context.MODE_APPEND);
        editor = sp.edit();
    }

    public void getInstance(Context context, String filename) {
        this.context = context;
        sp = context.getSharedPreferences(filename, Context.MODE_APPEND);
        editor = sp.edit();
    }

    public void puBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }

    public boolean getBoolean(String key, boolean defValue) {
        return sp.getBoolean(key, defValue);
    }

    public void puInt(String key, int value) {
        editor.putInt(key, value);
        editor.commit();
    }

    public int getInt(String key, int defValue) {
        return sp.getInt(key, defValue);
    }

}


