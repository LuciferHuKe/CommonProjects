package com.lucifer.dao.ui;

import android.content.Context;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by lucifer on 15/8/14.
 */
public class SliderMenuLayout extends ViewGroup {

    private static final int MIN_DRAWER_MARGING = 64;  //dp
    private static final int MIN_FLING_VELOCITY = 400;  //dips for every second

    private int mMinDrawerMargin;  //drawer离容器最右侧距离

    private View mLeftMenuView;
    private View mContentView;

    private ViewDragHelper mHelper;

    private float mLeftMenuOnScreen;  //drawer显示出来占自身百分比

    public SliderMenuLayout(Context context) {
        super(context);
    }

    public SliderMenuLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        final float density = getResources().getDisplayMetrics().density;
        final float minVel = MIN_FLING_VELOCITY * density;

        mMinDrawerMargin = (int) (MIN_DRAWER_MARGING * density + 0.5f);

        mHelper = ViewDragHelper.create(this, 1.0f, new ViewDragHelper.Callback() {

            @Override
            public int clampViewPositionHorizontal(View child, int left, int dx) {
                int newLeft = Math.max(-child.getWidth(), Math.min(left, 0));
                return newLeft;
            }

            @Override
            public boolean tryCaptureView(View child, int pointerId) {
                return child == mLeftMenuView;
            }

            @Override
            public void onEdgeDragStarted(int edgeFlags, int pointerId) {
                mHelper.captureChildView(mLeftMenuView, pointerId);
            }

            @Override
            public void onViewReleased(View releasedChild, float xvel, float yvel) {
                final int childWidth = releasedChild.getWidth();
                float offset = (childWidth + releasedChild.getLeft()) * 1.0f / childWidth;
                mHelper.settleCapturedViewAt(xvel > 0 || xvel == 0 && offset > 0.5f ? 0 : -childWidth,
                        releasedChild.getTop());
                invalidate();
            }

            @Override
            public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
                final int childWidth = changedView.getWidth();
                float offset = (float)(childWidth + left) / childWidth;
                mLeftMenuOnScreen = offset;
                changedView.setVisibility(offset == 0 ? View.INVISIBLE : View.VISIBLE);
                invalidate();
            }

            @Override
            public int getViewHorizontalDragRange(View child) {
                return mLeftMenuView  == child ? child.getWidth() : 0;
            }

        });
        //setup edge_left track
        mHelper.setEdgeTrackingEnabled(ViewDragHelper.EDGE_LEFT);
        //setup minVelocity
        mHelper.setMinVelocity(minVel);
    }

    public SliderMenuLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        View menuView = mLeftMenuView;
        View contentView = mContentView;

        MarginLayoutParams lp = (MarginLayoutParams)contentView.getLayoutParams();
        contentView.layout(lp.leftMargin, lp.topMargin,
                lp.leftMargin + contentView.getMeasuredWidth(),
                lp.topMargin + contentView.getMeasuredHeight());

        final int menuWidth = menuView.getMeasuredWidth();
        int childLeft = -menuWidth + (int)(menuWidth * mLeftMenuOnScreen);
        menuView.layout(childLeft, lp.topMargin, childLeft + menuWidth,
                lp.topMargin + menuView.getMeasuredHeight());

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        setMeasuredDimension(widthSize, heightSize);

        View leftMenuView = getChildAt(1);
        MarginLayoutParams lp = (MarginLayoutParams)leftMenuView.getLayoutParams();

        final int drawerWidthSpec = getChildMeasureSpec(widthMeasureSpec,
                mMinDrawerMargin + lp.leftMargin + lp.rightMargin, lp.width);
        final int drawerHeightSpec = getChildMeasureSpec(heightMeasureSpec,
                lp.topMargin + lp.bottomMargin, lp.height);
        leftMenuView.measure(drawerWidthSpec, drawerHeightSpec);

        View contentView = getChildAt(0);
        lp = (MarginLayoutParams)contentView.getLayoutParams();
        final int contentWidthSpec = MeasureSpec.makeMeasureSpec(
                widthSize - lp.leftMargin - lp.rightMargin, MeasureSpec.EXACTLY);
        final int contentHeightSpec = MeasureSpec.makeMeasureSpec(
                heightSize - lp.topMargin - lp.bottomMargin, MeasureSpec.EXACTLY);
        contentView.measure(contentWidthSpec, contentHeightSpec);

        mLeftMenuView = leftMenuView;
        mContentView = contentView;

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean bShouldInterceptTouchEvent = mHelper.shouldInterceptTouchEvent(ev);
        return bShouldInterceptTouchEvent;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mHelper.processTouchEvent(event);
        return true;
    }

    @Override
    public void computeScroll() {
       if(mHelper.continueSettling(true)) {
           invalidate();
       }
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    }

    public void openDrawer() {
        View menuView = mLeftMenuView;
        mLeftMenuOnScreen = 1.0f;
        mHelper.smoothSlideViewTo(menuView, 0, menuView.getTop());
    }

    public void closeDrawer() {
        View menuView = mLeftMenuView;
        mLeftMenuOnScreen = 0.f;
        mHelper.smoothSlideViewTo(menuView, -menuView.getWidth(), menuView.getTop());
    }

    public LayoutParams generateLayoutParams(AttributeSet attrs)
    {
        return new MarginLayoutParams(getContext(), attrs);
    }

    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams p)
    {
        return new MarginLayoutParams(p);
    }
}
