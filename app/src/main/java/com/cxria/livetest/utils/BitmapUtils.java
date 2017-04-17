package com.cxria.livetest.utils;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/**
 * Created by yukun on 17-4-17.
 */
public class BitmapUtils {
    public static BitmapUtils mBitmapUtils=new BitmapUtils();

    public static BitmapUtils getInstance(){
        if(mBitmapUtils==null){
             mBitmapUtils=new BitmapUtils();
        }
        return mBitmapUtils;
    }

    /**
     *
     * @param b bitmap对象
     * @param x x放大的倍数
     * @param y y放大的倍数
     * @return
     */
    public static Bitmap bigBitmap(Bitmap b, float x, float y) {
        int w=b.getWidth();
        int h=b.getHeight();
        float sx=(float)x/w;//要强制转换，不转换我的在这总是死掉。
        float sy=(float)y/h;
        Matrix matrix = new Matrix();
        matrix.postScale(x, y); // 长和宽放大缩小的比例
        Bitmap resizeBmp = Bitmap.createBitmap(b, 0, 0, w,
                h, matrix, true);
        return resizeBmp;
    }

}
