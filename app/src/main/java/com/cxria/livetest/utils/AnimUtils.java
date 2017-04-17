package com.cxria.livetest.utils;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;

import com.cxria.livetest.R;


/**
 * Created by yukun on 17-3-10.
 */
public class AnimUtils {
    /**
     * 旋转的动画
     * @param context
     * @param view
     */
    public static void setBackUp(Context context, View view){
        Animation operatingAnim = AnimationUtils.loadAnimation(context, R.anim.back_anim);
        LinearInterpolator lin = new LinearInterpolator();
        operatingAnim.setInterpolator(lin);
        operatingAnim.setFillAfter(true);
        view.startAnimation(operatingAnim);
    }

    /**
     * 旋转的动画
     * @param context
     * @param view
     */
    public static void setBackDown(Context context, View view){
        Animation operatingAnim = AnimationUtils.loadAnimation(context, R.anim.back_anim_back);
        LinearInterpolator lin = new LinearInterpolator();
        operatingAnim.setInterpolator(lin);
        operatingAnim.setFillAfter(true);
        view.startAnimation(operatingAnim);
    }

    /**
     * 颜色渐变的动画
     * @param context
     * @param view
     */
    public static void setTitleUp(Context context, final View view){

        ValueAnimator animator = ValueAnimator.ofInt(0x00ffffff,0xC9101010);
        animator.setEvaluator(new ArgbEvaluator());
        animator.setDuration(1000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int)animation.getAnimatedValue();
                view.setBackgroundColor(curValue);
            }
        });

        animator.start();
    }

    /**
     * 颜色渐变的动画
     * @param context
     * @param view
     */
    public static void setTitleDown(Context context, final View view){

        ValueAnimator animator = ValueAnimator.ofInt(0xC9101010,0x00ffffff);
        animator.setEvaluator(new ArgbEvaluator());
        animator.setDuration(1000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int)animation.getAnimatedValue();
                view.setBackgroundColor(curValue);
            }
        });

        animator.start();
    }

}
