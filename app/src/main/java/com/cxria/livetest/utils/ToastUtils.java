package com.cxria.livetest.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Toast提示
 */
public class ToastUtils {


    /**
     * 短时提醒Toast
     */
    public static void showShortToast(Context context, String hint) {
        Toast.makeText(context, hint, Toast.LENGTH_SHORT).show();
    }

    /**
     * 长时提醒Toast
     */
    public static void showLongToast(Context context, String hint) {
        Toast.makeText(context, hint, Toast.LENGTH_LONG).show();
    }

    public static void showShortToast(String hint) {
//        Toast.makeText(AppApplication.getAppInstance(), hint, Toast.LENGTH_SHORT).show();
    }

    public static void showLongToast(String hint) {
//        Toast.makeText(AppApplication.getAppInstance(), hint, Toast.LENGTH_LONG).show();
    }

    /**
     * 视频页面的提示Toast
     */
    public static void showVideoOptionToast(Context context, String hint, int type) {
//        View view = LayoutInflater.from(context).inflate(R.layout.toast, null);
//        //成功还是失败的文字
//        TextView tv = (TextView) view.findViewById(R.id.tv_toast);
//        tv.setText(hint);
//        //打钩还是打叉
//        ImageView im = (ImageView) view.findViewById(R.id.im_toast);
//        if (type == 1) {
//            im.setImageDrawable(context.getResources().getDrawable(R.mipmap.zx_icon_operation_of_the_echo_successful_default));
//        } else {
//            im.setImageDrawable(context.getResources().getDrawable(R.mipmap.zx_icon_operation_of_the_echo_failure_default));
//        }
//        //显示Toast
//        Toast toast = new Toast(context);
//        //位置
//        toast.setGravity(Gravity.CENTER, 0, 60);
//        //时长
//        toast.setDuration(Toast.LENGTH_SHORT);
//        //设置view
//        toast.setView(view);
//        //显示
//        toast.show();
    }

    /**
     * 视频页面的提示Toast
     */
    public static void showVideoOptionToast(String hint, int type) {
//        View view = LayoutInflater.from(AppApplication.getAppInstance()).inflate(R.layout.toast, null);
//        //成功还是失败的文字
//        TextView tv = (TextView) view.findViewById(R.id.tv_toast);
//        tv.setText(hint);
//        //打钩还是打叉
//        ImageView im = (ImageView) view.findViewById(R.id.im_toast);
//        if (type == 1) {
//            im.setImageDrawable(AppApplication.getAppInstance().getResources().getDrawable(R.mipmap.zx_icon_operation_of_the_echo_successful_default));
//        } else {
//            im.setImageDrawable(AppApplication.getAppInstance().getResources().getDrawable(R.mipmap.zx_icon_operation_of_the_echo_failure_default));
//        }
//        //显示Toast
//        Toast toast = new Toast(AppApplication.getAppInstance());
//        //位置
//        toast.setGravity(Gravity.CENTER, 0, 60);
//        //时长
//        toast.setDuration(Toast.LENGTH_SHORT);
//        //设置view
//        toast.setView(view);
//        //显示
//        toast.show();
    }
}
