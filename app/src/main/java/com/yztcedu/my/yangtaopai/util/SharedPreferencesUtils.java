package com.yztcedu.my.yangtaopai.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.preference.PreferenceManager;

/**
 * Created by Administrator on 2016/12/6.
 * 保存数据到手机
 */

public class SharedPreferencesUtils {


    /**
     *
     * @param context  上下文
     * @param key  key 值
     * @param data   保存的数据
     */
    public static void saveData(Context context,String key, boolean data) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean(key, data);
        edit.commit();
    }

    /**
     *
     * @param context  上下文作用是 获取一个 SharedPreferences
     * @param key   key 值
     */
    public static boolean getData(Context context,String key) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(key, false);  //false  代表默认值
    }

}
