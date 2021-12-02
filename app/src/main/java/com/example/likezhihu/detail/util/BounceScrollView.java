package com.example.likezhihu.detail.util;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;

import com.example.likezhihu.detail.R;

public class BounceScrollView extends NestedScrollView {

    private static final float DEFAULT_DAMPING_COEFFICIENT = 4.0f;
    private static final int DEFAULT_SCROLL_THRESHOLD = 20;
    private static final long DEFAULT_BOUNCE_DELAY = 400;

    private boolean isHorizontal;
    private float mDamping;
    private boolean mIncrementalDamping;
    private boolean isLoad = false;
    private boolean isPull = false;
    private long mBounceDelay;
    private int mTriggerOverScrollThreshold;
    private boolean mDisableBounce;
    boolean onePointerTouch = true;
    boolean towPointerTouch = false;
    private boolean hasNoMoreData = false;
    //是否是第一页
    private boolean isFrist = false;

    private Interpolator mInterpolator;
    private View mChildView;
    private float mStart;
    private float mPreDelta;
    private int mOverScrolledDistance;
    private ObjectAnimator mAnimator;
    private OnScrollListener mScrollListener;
    private OnOverScrollListener mOverScrollListener;

    public BounceScrollView(@NonNull Context context) {
        this(context, null);
    }

    public BounceScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BounceScrollView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        setOverScrollMode(View.OVER_SCROLL_NEVER);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.BounceScrollView, 0, 0);
        mDamping = a.getFloat(R.styleable.BounceScrollView_damping, DEFAULT_DAMPING_COEFFICIENT);
        int orientation = a.getInt(R.styleable.BounceScrollView_scrollOrientation, 0);
        isHorizontal = orientation == 1;
        mIncrementalDamping = a.getBoolean(R.styleable.BounceScrollView_incrementalDamping, false);
        mBounceDelay = a.getInt(R.styleable.BounceScrollView_bounceDelay, (int) DEFAULT_BOUNCE_DELAY);
        mTriggerOverScrollThreshold = a.getInt(R.styleable.BounceScrollView_triggerOverScrollThreshold, DEFAULT_SCROLL_THRESHOLD);
        mDisableBounce = a.getBoolean(R.styleable.BounceScrollView_disableBounce, false);
        boolean enable = a.getBoolean(R.styleable.BounceScrollView_nestedScrollingEnabled, true);
        a.recycle();

        setNestedScrollingEnabled(enable);
        mInterpolator = new DefaultQuartOutInterpolator();
    }

    @Override
    public boolean canScrollVertically(int direction) {
        return !isHorizontal;
    }

    @Override
    public boolean canScrollHorizontally(int direction) {
        return isHorizontal;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (mChildView == null && getChildCount() > 0 || mChildView != getChildAt(0)) {
            mChildView = getChildAt(0);
        }
        return super.onInterceptTouchEvent(ev);
    }

    private int mScrollPointerId = 0;

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (mChildView == null || mDisableBounce)
            return super.onTouchEvent(ev);

        // 默认active的Index
        int actionIndex = ev.getActionIndex();

        switch (ev.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                mScrollPointerId = ev.getPointerId(0);
//                Log.e("tenda", "ACTION_DOWN firstPointId:" + firstPointId);
                mStart = isHorizontal ? ev.getX() : ev.getY();
                onePointerTouch = true;
                towPointerTouch = false;
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                //第二个手指按下
//                Log.e("tenda", "ACTION_POINTER_DOWN getPointerCount:" + ev.getPointerCount());
                if (ev.getPointerCount() <= 2) {
                    mScrollPointerId = ev.getPointerId(actionIndex);
                    mStart = isHorizontal ? ev.getX(mScrollPointerId) : ev.getY(mScrollPointerId);
//                    Log.e("tenda", "ACTION_POINTER_DOWN secondPointId:" + secondPointId + " firstPointId:" + firstPointId);
                    onePointerTouch = false;
                    towPointerTouch = true;
                } else {
                    cancelTouch();
                }
                break;
            case MotionEvent.ACTION_MOVE:
                float now, delta;
                float dampingDelta;

                // 通过pointerID拿到需要处理的Index。
                final int index = ev.findPointerIndex(mScrollPointerId);
                if (index < 0) {
                    Log.e("BounceScrollView", "Error processing scroll; pointer index for id "
                            + mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                    return false;
                }

//                Log.e("tenda", "ACTION_MOVE pointcount:" + ev.getPointerCount());
//                if (towPointerTouch) {
                now = isHorizontal ? ev.getX(index) : ev.getY(index);
//                    Log.e("tenda", "ACTION_MOVE ev0:" + ev.getY(0));
//                Log.e("tenda", "ACTION_MOVE now1:" + now);
//                } else {
//                    now = isHorizontal ? ev.getX() : ev.getY();
//                    Log.e("tenda", "ACTION_MOVE now:" + now);
//                }

                delta = mStart - now;
//                Log.e("tenda", "/ calculateDamping:" + calculateDamping());
                dampingDelta = (delta / calculateDamping());
                mStart = now;

//                boolean onePointerTouch = true;
                if (mPreDelta <= 0 && dampingDelta > 0) {
                    onePointerTouch = false;
                } else if (mPreDelta >= 0 && dampingDelta < 0) {
                    onePointerTouch = false;
                } else {
                    onePointerTouch = true;
                }
//                if (towPointerTouch) {
//                    onePointerTouch = false;
//                }
                mPreDelta = dampingDelta;
//                Log.e("tenda", "delta:" + delta + "dampingDelta:" + dampingDelta);
                if (onePointerTouch && canMove(dampingDelta)) {
                    mOverScrolledDistance += dampingDelta;
//                    Log.e("tenda", "canMove true mOverScrolledDistance:" + mOverScrolledDistance);
                    if (isLoad) {
                        if (mOverScrolledDistance >= 500) {
                            mOverScrolledDistance = 500;
                        }
                        if (getScrollY() == 0) {
                            //已经到最顶部
                            break;
                        }
                    }
                    if (isPull) {
                        if (mOverScrolledDistance <= -200) {
                            mOverScrolledDistance = -200;
                        }
                        if (getScrollY() > 0) {
                            //已经到最底部
                            break;
                        }
                    }
                    if (isHorizontal) {
                        mChildView.setTranslationX(-mOverScrolledDistance);
                    } else {
                        mChildView.setTranslationY(-mOverScrolledDistance);
                    }
                    if (mOverScrollListener != null) {
//                        mOverScrollListener.onOverScrolling(mOverScrolledDistance <= 0, Math.abs(mOverScrolledDistance));
                        if (canMoveFromStart()) {
                            //下拉
                            isPull = true;
                            mOverScrollListener.onPulling(mOverScrolledDistance);
                        } else {
                            //上拉
                            isLoad = true;
                            mOverScrollListener.onOverScrolling(mOverScrolledDistance <= 0, mOverScrolledDistance);
                        }
                    }
                } else {
                    if (isLoad) {
//                        Log.e("tenda", "mPreDelta:" + mPreDelta + " dampingDelta:" + dampingDelta);
//                        Log.e("tenda", " isLoad * calculateDamping:" + calculateDamping());
                        dampingDelta = delta;
                        mOverScrolledDistance += dampingDelta;
//                        Log.e("tenda", "canMove false isLoad mOverScrolledDistance:" + mOverScrolledDistance);
                        mOverScrollListener.onOverScrolling(mOverScrolledDistance <= 0, mOverScrolledDistance);
                    } else if (isPull) {
//                        Log.e("tenda", "isPull * calculateDamping:" + calculateDamping());
                        dampingDelta = delta;
                        mOverScrolledDistance += dampingDelta;
//                        Log.e("tenda", "canMove false isPull mOverScrolledDistance:" + mOverScrolledDistance);
                        mOverScrollListener.onPulling(mOverScrolledDistance);
                    }
                }

//                if (mOverScrollListener != null) {
////                        mOverScrollListener.onOverScrolling(mOverScrolledDistance <= 0, Math.abs(mOverScrolledDistance));
//                    mOverScrollListener.onOverScrolling(mOverScrolledDistance <= 0, mOverScrolledDistance);
//                }

                break;
            case MotionEvent.ACTION_UP:
                //最后一个手指松开
//                Log.e("tenda", "ACTION_UP");
                towPointerTouch = false;
                onePointerTouch = false;
                cancelTouch();
                break;
            case MotionEvent.ACTION_POINTER_UP:
                //第二个手指松开
                onPointerUp(ev);
                towPointerTouch = false;
                onePointerTouch = true;
                break;
            case MotionEvent.ACTION_CANCEL:
                onePointerTouch = true;
                towPointerTouch = false;
                cancelTouch();
                break;
        }

        return super.onTouchEvent(ev);
    }

    // 处理pointer up的情况。
    private void onPointerUp(MotionEvent e) {
        // 离开屏幕的触摸点index
        final int actionIndex = e.getActionIndex();
        // 如果离开的那个点的id正好是我们接管触摸的那个那个点，那么我们就需要重新再找一个pointer来接管，反之不用管。
        if (e.getPointerId(actionIndex) == mScrollPointerId) {
            // Pick a new pointer to pick up the slack.
            // 如果离开屏幕的点index是0，那就用index 为 1 的点，反之就直接用0。
            final int newIndex = actionIndex == 0 ? 1 : 0;
            // 重置id和初始化initX和initY。
            mScrollPointerId = e.getPointerId(newIndex);
        }
    }

    public void cancelTouch() {
//        Log.e("tenda", "cancelTouch isLoad " + isLoad + " hasNoMoreData " + hasNoMoreData);
        cancelAnimator();
        if (mOverScrolledDistance > 100 && isLoad && !hasNoMoreData) {
            if (mOverScrollListener != null) {
                isLoad = false;
                mOverScrollListener.onShowNext();
                finishAnim();
            }
        } else {
            if (mOverScrolledDistance < -150 && isPull && !towPointerTouch) {
                if (mOverScrollListener != null) {
                    isPull = false;
                    mOverScrollListener.onShowBefore();
                    finishAnim();
                }
            } else {
                if (isHorizontal) {
                    mAnimator = ObjectAnimator.ofFloat(mChildView, View.TRANSLATION_X, 0);
                } else {
                    mAnimator = ObjectAnimator.ofFloat(mChildView, View.TRANSLATION_Y, 0);
                }
                mAnimator.setDuration(mBounceDelay).setInterpolator(mInterpolator);
                if (mOverScrollListener != null) {
                    mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            float value = (float) animation.getAnimatedValue();
                            if (isLoad) {
                                mOverScrollListener.onOverScrolling(value <= 0, (int) value);
                                isLoad = false;
                            } else if (isPull) {
                                mOverScrollListener.onPulling((int) value);
                                isPull = false;
                            }
                        }
                    });
                }
                mAnimator.start();
            }
        }
        mPreDelta = 0;
        mOverScrolledDistance = 0;
    }

    private void finishAnim() {
        if (isHorizontal) {
            mAnimator = ObjectAnimator.ofFloat(mChildView, View.TRANSLATION_X, 0);
        } else {
            mAnimator = ObjectAnimator.ofFloat(mChildView, View.TRANSLATION_Y, 0);
        }
        mAnimator.setDuration(0);
        mAnimator.start();
    }

    private float calculateDamping() {
        float ratio;
        if (isHorizontal) {
            ratio = Math.abs(mChildView.getTranslationX()) * 1.0f / mChildView.getMeasuredWidth();
        } else {
            ratio = Math.abs(mChildView.getTranslationY()) * 1.0f / mChildView.getMeasuredHeight();
        }
        ratio += 0.2;

        if (mIncrementalDamping) {
            return mDamping / (1.0f - (float) Math.pow(ratio, 2));
        } else {
            return mDamping;
        }
    }

    private boolean canMove(float delta) {
        return delta < 0 ? canMoveFromStart() : canMoveFromEnd();
    }

    private boolean canMoveFromStart() {
        if (isHorizontal) {
            return getScrollX() == 0;
        } else {
            if (getScrollY() == 0 && !isFrist) {
                return true;
            }
        }
        return false;
    }

    private boolean canMoveFromEnd() {
        if (isHorizontal) {
            int offset = mChildView.getMeasuredWidth() - getWidth();
            offset = offset < 0 ? 0 : offset;
            return getScrollX() == offset;
        } else {
            int offset = mChildView.getMeasuredHeight() - getHeight();
            offset = offset < 0 ? 0 : offset;
            return getScrollY() == offset;
        }
    }

    private void cancelAnimator() {
        if (mAnimator != null && mAnimator.isRunning()) {
            mAnimator.cancel();
        }
    }

    @Override
    protected void onScrollChanged(int scrollX, int scrollY, int oldl, int oldt) {
        super.onScrollChanged(scrollX, scrollY, oldl, oldt);

        if (mScrollListener != null) {
            mScrollListener.onScrolling(scrollX, scrollY);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();

        cancelAnimator();
    }

    public void setScrollHorizontally(boolean horizontal) {
        this.isHorizontal = horizontal;
    }

    public boolean isScrollHorizontally() {
        return isHorizontal;
    }

    public float getDamping() {
        return mDamping;
    }

    public void setDamping(@FloatRange(from = 0, to = 100) float damping) {
        if (mDamping > 0) {
            mDamping = damping;
        }
    }

    public long getBounceDelay() {
        return mBounceDelay;
    }

    public void setBounceDelay(long bounceDelay) {
        if (bounceDelay >= 0) {
            mBounceDelay = bounceDelay;
        }
    }

    public void setIncrementalDamping(boolean incrementalDamping) {
        mIncrementalDamping = incrementalDamping;
    }

    public boolean isIncrementalDamping() {
        return mIncrementalDamping;
    }

    public boolean isDisableBounce() {
        return mDisableBounce;
    }

    public void setDisableBounce(boolean disable) {
        mDisableBounce = disable;
    }

    public void setBounceInterpolator(@NonNull Interpolator interpolator) {
        mInterpolator = interpolator;
    }

    public int getTriggerOverScrollThreshold() {
        return mTriggerOverScrollThreshold;
    }

    public void setTriggerOverScrollThreshold(int threshold) {
        if (threshold >= 0) {
            mTriggerOverScrollThreshold = threshold;
        }
    }

    public void setOnScrollListener(OnScrollListener scrollListener) {
        mScrollListener = scrollListener;
    }

    public void setOnOverScrollListener(OnOverScrollListener overScrollListener) {
        mOverScrollListener = overScrollListener;
    }

    public void setFrist(boolean frist) {
        isFrist = frist;
    }

    public void setHasNoMoreData(boolean hasNoMoreData) {
        this.hasNoMoreData = hasNoMoreData;
    }


    private static class DefaultQuartOutInterpolator implements Interpolator {

        @Override
        public float getInterpolation(float input) {
            return (float) (1.0f - Math.pow(1 - input, 4));
        }
    }


    public interface OnScrollListener {
        void onScrolling(int scrollX, int scrollY);
    }


    public interface OnOverScrollListener {
        /**
         * @param fromStart LTR, the left is start; RTL, the right is start.
         */
        void onOverScrolling(boolean fromStart, int overScrolledDistance);

        void onPulling(int overScrolledDistance);

        void onShowNext();

        void onShowBefore();
    }
}
