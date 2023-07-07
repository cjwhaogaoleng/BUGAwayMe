package com.example.bugawayme.myViewPager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;

/**
 * @author linzewu
 * @date 16-7-12
 */
public class CompatibleViewPager extends ViewPager {
    public CompatibleViewPager(Context context) {
        super(context);
    }

    public CompatibleViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected boolean canScroll(View v, boolean checkV, int dx, int x, int y) {

        if (v instanceof ViewGroup) {
            final ViewGroup group = (ViewGroup) v;
            final int scrollX = v.getScrollX();
            final int scrollY = v.getScrollY();
            final int count = group.getChildCount();
            // Count backwards - let topmost views consume scroll distance first.
            for (int i = count - 1; i >= 0; i--) {
                // TODO: Add versioned support here for transformed views.
                // This will not work for transformed views in Honeycomb+
                final View child = group.getChildAt(i);
                if (x + scrollX >= child.getLeft() && x + scrollX < child.getRight() &&
                        y + scrollY >= child.getTop() && y + scrollY < child.getBottom() &&
                        canScroll(child, true, dx, x + scrollX - child.getLeft(),
                                y + scrollY - child.getTop())) {
                    return true;
                }
            }
        }

        if (checkV) {
            if (v instanceof ViewPager) {
                return ((ViewPager)v).canScrollHorizontally(-dx);
            } else {
                return ViewCompat.canScrollHorizontally(v, -dx);
            }
        } else {
            return false;
        }
    }
}