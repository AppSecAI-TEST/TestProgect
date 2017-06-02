package com.tianniu.custom.view.custom_view.locatonSelectPop;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2017/6/1 0001.
 */

public class WrapContentHeightViewPager extends ViewPager {
    private int current;
    private int height = 0;

//    private boolean scrollble = true;

    private boolean isWrapAuto;

    public void setWrapAuto(boolean wrapAuto) {
        isWrapAuto = wrapAuto;
    }

    public WrapContentHeightViewPager(Context context) {
        super(context);
    }

    public WrapContentHeightViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

//        if (isWrapAuto){}
        if (false){
            int pH = View.MeasureSpec.getSize(heightMeasureSpec);
            int id = getCurrentItem();
            AreaViewPageadapter adapter = (AreaViewPageadapter) getAdapter();
            View child = adapter.getIndexView(id);
            if (child != null) {
                child.measure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(pH, View.MeasureSpec.AT_MOST));
                int h = child.getMeasuredHeight();
                height = h;
                heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY);
            }
        }

//        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void resetHeight(int current) {
        this.current = current;
        if (getChildCount() > current) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, height);
            } else {
                layoutParams.height = height;
            }
            setLayoutParams(layoutParams);
        }
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        return super.onTouchEvent(ev);
    }


//    public boolean isScrollble() {
//        return scrollble;
//    }
//
//    public void setScrollble(boolean scrollble) {
//        this.scrollble = scrollble;
//    }


}