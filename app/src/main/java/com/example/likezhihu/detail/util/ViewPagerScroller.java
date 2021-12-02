package com.example.likezhihu.detail.util;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

// 自定义的Scroller
public class ViewPagerScroller extends Scroller {
    private int mDuration = 1000;

    public ViewPagerScroller(Context context) {
        super(context);
    }

    public ViewPagerScroller(Context context, Interpolator interpolator) {
        super(context, interpolator);
    }

    public ViewPagerScroller(Context context, Interpolator interpolator, boolean flywheel) {
        super(context, interpolator, flywheel);
    }


    @Override
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        super.startScroll(startX, startY, dx, dy, mDuration);
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy) {
        super.startScroll(startX, startY, dx, dy, mDuration);
    }

    // 方法支持代码动态设定动画时间，实现改变ViewPager切换位置的滑动速度
    public void setDuration(int time) {
        mDuration = time;
    }
}
