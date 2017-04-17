package com.cxria.livetest.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;

/**
 * Created by haiyang-lu on 16-3-7.
 * SharedPreferences的一个工具类，调用setParam就能保存String, Integer, Boolean, Float, Long类型的参数
 * 同样调用getParam就能获取到保存在手机里面的数据
 */
public class SPUtils {
    /**
     * 保存在手机里面的文件名
     */
    private static final String FILE_NAME = "share_date";
    public static final String SPKEY_COOKIE = "cookie";
    public static final String SPKEY_UID = "id";

    private static SPUtils instance;

    private static SharedPreferences sp;

    private SPUtils() {

    }

    public static SPUtils getInstance(Context context) {
        if (instance == null) {
            instance = new SPUtils();
        }
        if(sp==null) {
            sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        }

        return instance;
    }

    /**
     * 保存数据的方法，我们需要拿到保存数据的具体类型，然后根据类型调用不同的保存方法
     * @param key     键
     * @param object  对象
     */
    public void save(String key, Object object) {
        SharedPreferences.Editor editor = sp.edit();

        if (object instanceof String) {
            editor.putString(key, (String) object);
        } else if (object instanceof Integer) {
            editor.putInt(key, (Integer) object);
        } else if (object instanceof Boolean) {
            editor.putBoolean(key, (Boolean) object);
        } else if (object instanceof Float) {
            editor.putFloat(key, (Float) object);
        } else if (object instanceof Long) {
            editor.putLong(key, (Long) object);
        } else {
            editor.putString(key, object.toString());
        }

        editor.apply();
    }

    /**
     * 得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取值
     *
     * @param key          键
     * @param defaultValue 默认值
     * @return 值
     */
    public Object load(String key, Object defaultValue) {
        if (defaultValue instanceof String) {
            return sp.getString(key, (String) defaultValue);
        } else if (defaultValue instanceof Integer) {
            return sp.getInt(key, (Integer) defaultValue);
        } else if (defaultValue instanceof Boolean) {
            return sp.getBoolean(key, (Boolean) defaultValue);
        } else if (defaultValue instanceof Float) {
            return sp.getFloat(key, (Float) defaultValue);
        } else if (defaultValue instanceof Long) {
            return sp.getLong(key, (Long) defaultValue);
        }

        return null;
    }

    /**
     * 移除某个key值已经对应的值
     * @param key
     */
    public void remove(String key)
    {
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        editor.apply();
    }

    /**
     * 清除所有数据
     */
    public void clear()
    {
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.apply();
    }

    /**
     * 查询某个key是否已经存在
     * @param key
     * @return
     */
    public boolean contains(String key)
    {
        return sp.contains(key);
    }

    /**
     * 返回所有的键值对
     * @return map
     */
    public Map<String, ?> getAll()
    {
        return sp.getAll();
    }

}
