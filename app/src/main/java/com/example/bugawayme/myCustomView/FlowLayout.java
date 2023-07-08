package com.example.bugawayme.myCustomView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class FlowLayout extends ViewGroup {

    private static final String TAG = "FlowLayout";

    //将来设的子view之间的间距
    private final int mHorizontalSpace = dp2sp(16);
    private final int mVerticalSpace = dp2sp(20);

    private List<List<View>> allLines;//一行一行的记每一行的view，用于layout
    List<Integer> lineHeight;//记录每一行的行高，用于layout


    //new的时候调用
    //new TextView(this)
    public FlowLayout(Context context) {
        super(context);
        initMeasurePara();

    }

    //在布局中使用时
    //反射
    public FlowLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
//        initMeasurePara();


    }

    //在布局中使用时，但是要调用style
    public FlowLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        initMeasurePara();

    }


    protected void initMeasurePara() {
        allLines = new ArrayList<>();
        lineHeight = new ArrayList<>();
    }

    //度量，具体规划
    //通过测量子view的大小，决定自己的大小
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        initMeasurePara();

        //度量子

        int childCount = getChildCount();

        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();

        //目前viewGroup自己的宽和高(受子view的影响）
        int selfWidth = MeasureSpec.getSize(widthMeasureSpec);
        int selfHeight = MeasureSpec.getSize(heightMeasureSpec);

        @SuppressLint("DrawAllocation") List<View> lineViews = new ArrayList<>();

        //测量每行的高度和每行的长度
        int lineWidthUsed = 0;
        int lineHeightUsed = 0;

        //获取最后的总高度和最大长度作为viewGroup的宽和高
        int parentNeedWidth = 0;
        int parentNeedHeight = 0;


        for (int i = 0; i < childCount; i++) {

            View childView = getChildAt(i);
            //可以获取子view的
            // android:layout_width="wrap_content"
            // android:layout_height="wrap_content"
            LayoutParams childViewLayoutParams = childView.getLayoutParams();

            //通过父亲的宽和子的宽在去掉padding就可以
            // 获得子的宽
            int childWidthMeasureSpec = getChildMeasureSpec(widthMeasureSpec,
                    paddingLeft + paddingRight, childViewLayoutParams.width);

            int childHeightMeasureSpec = getChildMeasureSpec(heightMeasureSpec,
                    paddingTop + paddingBottom, childViewLayoutParams.height);

            //触发childView的孩子去度量
            childView.measure(childWidthMeasureSpec, childHeightMeasureSpec);


//            在子view调用measure后，自动调用setMeasuredDimension（），getMeasuredWidth才会有值
            // getMeasuredWidth是onMeasured方法进行完后获取相应的值
//            getWidth()是在layout（）完后才能获取相应的值
            int childMeasuredWidth = childView.getMeasuredWidth();
            int childMeasuredHeight = childView.getMeasuredHeight();



            //判断有没有超出宽度
            if (lineWidthUsed + childMeasuredWidth > selfWidth) {

                allLines.add(lineViews);
                lineHeight.add(lineHeightUsed);

                parentNeedWidth = Math.max(parentNeedWidth, lineWidthUsed + mHorizontalSpace);
                parentNeedHeight = lineHeightUsed + parentNeedHeight + mVerticalSpace;

                lineViews = new ArrayList<>();
                lineWidthUsed = 0;
                lineHeightUsed = 0;

            }

            //每行都有自己的宽和高
            lineViews.add(childView);
            lineWidthUsed += childMeasuredWidth + mHorizontalSpace;
            lineHeightUsed = Math.max(lineHeightUsed, childMeasuredHeight);

            //处理最后一行
            if (i == childCount - 1) {

                allLines.add(lineViews);
                lineHeight.add(lineHeightUsed);

                parentNeedWidth = Math.max(parentNeedWidth, lineWidthUsed + mHorizontalSpace);
                parentNeedHeight = lineHeightUsed + parentNeedHeight + mVerticalSpace;
            }


        }
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        int realWidth = (widthMode == MeasureSpec.EXACTLY) ? selfWidth : parentNeedWidth;
        int realHeight = (heightMode == MeasureSpec.EXACTLY) ? selfHeight : parentNeedHeight;


        //确定自己的大小
        setMeasuredDimension(realWidth, realHeight);


    }


    //布局，所有的子view的布局
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {

        int curL = getPaddingLeft();
        int curT = getPaddingTop();

        int lineCount = allLines.size();
        for (int i = 0; i < lineCount; i++) {
            List<View> lineViews = allLines.get(i);//获取一行的view
            for (int j = 0; j < lineViews.size(); j++) {
                View view = lineViews.get(j);

                int leftPoint = curL;
                int topPoint = curT;

                int rightPoint = leftPoint + view.getMeasuredWidth();
                int bottomPoint = topPoint + view.getMeasuredHeight();

                view.layout(leftPoint, topPoint, rightPoint, bottomPoint);
                curL = rightPoint + mHorizontalSpace;
            }
            curT = curT + lineHeight.get(i) + mVerticalSpace;
            curL = getPaddingLeft();
        }

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public static int dp2sp(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem().getDisplayMetrics());
    }


    public static class mLayoutParams extends MarginLayoutParams {

        private int mLeft, mRight, mTop, mBottom;

        public mLayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
        }
    }
}
