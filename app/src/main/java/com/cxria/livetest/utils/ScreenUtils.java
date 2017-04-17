package com.cxria.livetest.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.AudioManager;
import android.view.View;
import android.view.WindowManager;

/**
 * yuklun
 *
 * Screen StringUtil to get width height dp egg.
 */
public class ScreenUtils {
    private static ScreenUtils mUtils = new ScreenUtils();
    public static ScreenUtils instance(){
        return mUtils;
    }

    /**
     * @return screen width
     */
    public int getWidth(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        return  width;
    }

    /**
     * @return screen height
     */
    public int getHeight(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int height = wm.getDefaultDisplay().getHeight();
        return height;
    }

    /**
     * 用于获取状态栏的高度。 使用Resource对象获取（推荐这种方式）
     *
     * @return 返回状态栏高度的像素值。
     */
    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen",
                "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    /**
     * 获取当前屏幕截图，包含状态栏
     *
     * @param activity 当前activity
     * @return
     */
    public  Bitmap snapShotWithStatusBar(Activity activity) {
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bmp = view.getDrawingCache();
        int width = getWidth( activity);
        int height = getHeight(activity);
        Bitmap bp = null;
        bp = Bitmap.createBitmap(bmp, 0, 0, width, height);
        view.destroyDrawingCache();
        return bp;

    }
    /**
     * 获取当前屏幕截图，不包含状态栏
     *
     * @param activity 当前activity
     * @return
     */
    public  Bitmap snapShotWithoutStatusBar(Activity activity) {
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bmp = view.getDrawingCache();
        Rect frame = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;

        int width = getWidth(activity);
        int height = getHeight(activity);
        Bitmap bp = null;
        bp = Bitmap.createBitmap(bmp, 0, statusBarHeight, width, height
                - statusBarHeight);
        view.destroyDrawingCache();
        return bp;

    }

    /**
     * 获取系统最大音量
     *
     * @param context
     * @return
     */
    public static int getMaxVolume(Context context){
        AudioManager audiomanager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        // 获取系统最大音量
        int maxVolume = audiomanager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int streamVolume = audiomanager.getStreamVolume(AudioManager.STREAM_MUSIC);
        audiomanager.setStreamVolume(AudioManager.STREAM_MUSIC,(int)(streamVolume),0);
        return maxVolume;
    }
    /**
     * 获取系统最大音量
     *
     * @param context
     * @return
     */
    public static int getCurrentVolume(Context context){
        AudioManager audiomanager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        // 获取系统最大音量
        int streamVolume = audiomanager.getStreamVolume(AudioManager.STREAM_MUSIC);
        return streamVolume;
    }

    /**
     * 设置当前音量
     *
     * @param context
     * @param currentVolume 要设置的当前音量
     */
    public static void setCurrentVolume(Context context,int currentVolume){
        AudioManager audiomanager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        // 获取系统最大音量
        audiomanager.setStreamVolume(AudioManager.STREAM_MUSIC,(int)(currentVolume),0);
    }

    /**
     * 改变屏幕亮度
     * @param activity 页面
     * @param value 0到1.0
     */
    private void changeBrightness(Activity activity,float value) {
        WindowManager.LayoutParams layoutParams = activity.getWindow().getAttributes();
        layoutParams.screenBrightness = value;
        activity.getWindow().setAttributes(layoutParams);
    }

    /**
     *  dp 转 px
     * @param context
     * @param dp dp值
     * @return
     */
    public static int dp2Px(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    /**
     *  px 转 dp
     * @param context
     * @param px px值
     * @return
     */
    public static int px2Dp(Context context, float px) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (px / scale + 0.5f);
    }
}
