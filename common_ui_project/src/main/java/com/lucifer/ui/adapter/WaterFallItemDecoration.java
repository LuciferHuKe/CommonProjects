package com.lucifer.ui.adapter;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by lucifer on 16/3/8.
 */
public class WaterFallItemDecoration extends RecyclerView.ItemDecoration {

    private int space;

    public WaterFallItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if(parent.getChildPosition(view) != 0) {
            outRect.top = space;
        }
    }
}
