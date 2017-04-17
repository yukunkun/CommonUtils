package com.cxria.livetest.widget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by haiyang-lu on 16-7-20.
 */
public class RecyclerItemDecoration extends RecyclerView.ItemDecoration {
    int left;
    int top;
    int right;
    int bottom;

    public RecyclerItemDecoration(int left, int top, int right, int bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {
//        if (parent.getChildLayoutPosition(view) == 0 || parent.getChildLayoutPosition(view) == 1) {
//            outRect.top = 0;
//            outRect.bottom = 0;
//        } else {
//            outRect.top = space / 2;
//            outRect.bottom = space / 2;
//        }
        outRect.top = top;
        outRect.bottom = bottom;
        outRect.left=left;
        outRect.right=right;

    }
}