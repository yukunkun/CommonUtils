package com.cxria.livetest.utils;

import android.util.Log;

/**
 * yukun
 */
public class LogUtil {
    public static boolean isDebug = true;

    public static void e(Class<?> clazz, String msg) {
        if(isDebug) {
            Log.e(clazz.getSimpleName(),msg);
        }
    }

    public static void w(Class<?> clazz, String msg) {
        if(isDebug) {
            Log.w(clazz.getSimpleName(),msg);
        }
    }

    public static void i(Class<?> clazz, String msg) {
        if(isDebug) {
            Log.i(clazz.getSimpleName(),msg);
        }
    }

    public static void d(Class<?> clazz, String msg) {
        if(isDebug) {
            Log.d(clazz.getSimpleName(),msg);
        }
    }

    public static void v(Class<?> clazz, String msg) {
        if(isDebug) {
            Log.v(clazz.getSimpleName(),msg);
        }
    }

    public static void e(Class<?> clazz, String tag, String msg) {
        if(isDebug) {
            Log.e(clazz.getSimpleName()+"@"+tag,msg);
        }
    }

    public static void w(Class<?> clazz, String tag, String msg) {
        if(isDebug) {
            Log.w(clazz.getSimpleName()+"@"+tag,msg);
        }
    }

    public static void i(Class<?> clazz, String tag, String msg) {
        if(isDebug) {
            Log.i(clazz.getSimpleName()+"@"+tag,msg);
        }
    }

    public static void d(Class<?> clazz, String tag, String msg) {
        if(isDebug) {
            Log.d(clazz.getSimpleName()+"@"+tag,msg);
        }
    }

    public static void v(Class<?> clazz, String tag, String msg) {
        if(isDebug) {
            Log.v(clazz.getSimpleName()+"@"+tag,msg);
        }
    }

}
