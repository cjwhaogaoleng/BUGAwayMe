package com.example.bugawayme.myViewPager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class BannerViewPager extends ViewPager {
    private float downX, downY;
    public BannerViewPager(@NonNull Context context) {
        super(context);
    }

    public BannerViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        boolean intercept = super.onInterceptTouchEvent(e);
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = e.getX();
                downY = e.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                // 只要横向大于竖向，就拦截掉事件。
                // 部分机型点击事件（slopx==slopy==0），会触发MOVE事件。
                // 所以要加判断(slopX > 0 || sloy > 0)
                float horizon=e.getX() - downX;

                float slopX = Math.abs(e.getX() - downX);
                float slopY = Math.abs(e.getY() - downY);
                //  Log.log("slopX=" + slopX + ", slopY="  + slopY);
                if((slopX > 0 || slopY > 0) && slopX >= slopY){
                    int currentIndex=getCurrentItem();
                    int size=this.getAdapter().getCount();
                    if (currentIndex==0){
                        if (horizon>0){//向左滑动
                            requestDisallowInterceptTouchEvent(true);
                            intercept = true;
                        }
                    }
                    if (currentIndex==size-1){
                        if (horizon<0){//向右滑动
                            requestDisallowInterceptTouchEvent(true);
                            intercept = true;
                        }
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                intercept = false;
                break;
        }

        return intercept;
    }
}