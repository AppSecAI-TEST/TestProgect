package com.tianniu.custom.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tianniu.custom.OpApplication;
import com.tianniu.up.testprogect.R;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class CommonOperate {


    /**
     * 根据坐标获取相对应的子控件
     * <p/>
     * 在重写ViewGroup使用
     *
     * @return 目标View
     */
    public static View getViewAtViewGroup(View v, int x, int y) {
        return findViewByXY(v, x, y);
    }

    private static View findViewByXY(View view, int x, int y) {
        View targetView = null;
        if (view instanceof ViewGroup) {
            // 父容器,遍历子控件
            ViewGroup v = (ViewGroup) view;
            for (int i = 0; i < v.getChildCount(); i++) {
                targetView = findViewByXY(v.getChildAt(i), x, y);
                if (targetView != null) {
                    break;
                }
            }
        } else {
            targetView = getTouchTarget(view, x, y);
        }
        return targetView;

    }

    private static View getTouchTarget(View view, int x, int y) {
        View targetView = null;
        // 判断view是否可以聚焦
        ArrayList<View> TouchableViews = view.getTouchables();
        for (View child : TouchableViews) {
            if (isTouchPointInView(child, x, y)) {
                targetView = child;
                break;
            }
        }
        return targetView;
    }

    private static boolean isTouchPointInView(View view, int x, int y) {
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        int left = location[0];
        int top = location[1];
        int right = left + view.getMeasuredWidth();
        int bottom = top + view.getMeasuredHeight();
        if (view.isClickable() && y >= top && y <= bottom && x >= left
                && x <= right) {
            return true;
        }
        return false;
    }




	public static void setBackgroundDrawable(View v, Drawable drawable) {
		if (VERSION.SDK_INT >= 19) {
			Class cls = v.getClass();
			Method method;
			try {
				method = cls.getMethod("setBackground", Drawable.class);
				method.invoke(v, drawable);
			} catch (NoSuchMethodException e) {

				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			// v.setBackground(drawable);


        } else {
            v.setBackgroundDrawable(drawable);
        }
    }

    public static int computItemHeight(Context context, int layoutID) {
        View item = LayoutInflater.from(context).inflate(layoutID, null);

        int nw = View.MeasureSpec.makeMeasureSpec(1024, View.MeasureSpec.AT_MOST);
        item.measure(nw, nw);
        int measuredHeight = item.getMeasuredHeight();
        int me = measuredHeight;
        return measuredHeight;
    }

    public static int getViewHeight(View view) {

        int nw = View.MeasureSpec.makeMeasureSpec(1024, View.MeasureSpec.AT_MOST);
        view.measure(nw, nw);
        int measuredHeight = view.getMeasuredHeight();
        int me = measuredHeight;
        return measuredHeight;
    }

    public static int getViewWidth(View view) {

        int nw = View.MeasureSpec.makeMeasureSpec(1024, View.MeasureSpec.AT_MOST);
        view.measure(nw, nw);
        int measuredWidth = view.getMeasuredWidth();
        int me = measuredWidth;
        return measuredWidth;
    }


    private static FrameLayout popupshadow = null;
    private static WindowManager mWindowManager = null;

    /**
     * 设置添加屏幕的背景透明度
     *
     * @param bgAlpha
     */
    public static void backgroundAlpha(Activity activity, float bgAlpha) {
        if (activity == null) {
            return;
        }


        FrameLayout fl=null;
        if( activity.getWindow().getDecorView() instanceof FrameLayout){
            fl=(FrameLayout)     activity.getWindow().getDecorView();
        }else {
            fl = (FrameLayout) activity.getWindow().findViewById(Window.ID_ANDROID_CONTENT);
        }
        if (bgAlpha == 1) {
                OpApplication.removeWindowShow(activity);//
            if (popupshadow != null) {

              //  FrameLayout fl = (FrameLayout) activity.getWindow().findViewById(Window.ID_ANDROID_CONTENT);
                fl.removeView(popupshadow);
                popupshadow = null;
            }

        } else {
            OpApplication.addWindowShow(activity);//添加有窗口显示的标志位
            if (popupshadow == null) {

                popupshadow = new FrameLayout(activity);
                setBackgroundDrawable(popupshadow,  ContextCompat.getDrawable(activity,R.color.Lavender_gray));
                mWindowManager = (WindowManager) activity.getSystemService(Context.WINDOW_SERVICE);
                popupshadow.setAlpha(bgAlpha);

               // FrameLayout fl = (FrameLayout) activity.getWindow().findViewById(Window.ID_ANDROID_CONTENT);
                fl.addView(popupshadow, fl.getChildCount(), new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
            }
        }

    }


    public static void backgroundAlpha(Activity activity, float bgAlpha,View v) {
        if (activity == null) {
            return;
        }
        FrameLayout fl=null;
        if( activity.getWindow().getDecorView() instanceof FrameLayout){
             fl=(FrameLayout)     activity.getWindow().getDecorView();
        }else {
            fl = (FrameLayout) activity.getWindow().findViewById(Window.ID_ANDROID_CONTENT);
        }


        if (bgAlpha == 1) {
            OpApplication.removeWindowShow(activity);//删除有窗口显示的标志位
            if (popupshadow != null) {
             //   FrameLayout fl = (FrameLayout) activity.getWindow().findViewById(Window.ID_ANDROID_CONTENT);

                fl.removeView(popupshadow);
                popupshadow = null;
            }

        } else {

            OpApplication.addWindowShow(activity);//添加有窗口显示的标志位
            if (popupshadow == null) {


                popupshadow = new FrameLayout(activity);

                LinearLayout ll=new LinearLayout(activity);
                FrameLayout.LayoutParams llp=new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.MATCH_PARENT);
                setBackgroundDrawable(ll,  ContextCompat.getDrawable(activity,R.color.Lavender_gray));
                if(v!=null) {
                    int location[] = new int[2];
                    v.getLocationInWindow(location);
                    if(location!=null&&location.length>=2) {
                       int tt= fl.getTop();
                      llp.topMargin=location[1]-tt+v.getHeight();

                    }
                }
                ll.setLayoutParams(llp);
                popupshadow.addView(ll);

                mWindowManager = (WindowManager) activity.getSystemService(Context.WINDOW_SERVICE);
                popupshadow.setAlpha(bgAlpha);

                fl.addView(popupshadow, fl.getChildCount(), new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
            }
        }

    }






    /**
     * 将一个浮点数转换成一位小数，如果最后一位是点0，那么删除.0
     *
     * @return
     */
    public static String doubleConvert(double d) {
        if (d <= 0) {
            return "0";
        }
        try {
            double test = d % ((int) d);
            if (test == 0) {
                return ((int) d) + "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d + "";
    }


    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);

    /**
     * 动态生成View ID
     * API LEVEL 17 以上View.generateViewId()生成
     * API LEVEL 17 以下需要手动生成
     */
    public static int generateViewId() {

      //  if (Build.VERSION.SDK_INT < 17) {
            for (; ; ) {
                final int result = sNextGeneratedId.get();
                // aapt-generated IDs have the high byte nonzero; clamp to the range under that.
                int newValue = result + 1;
                if (newValue > 0x00FFFFFF) newValue = 1; // Roll over to 1, not 0.
                if (sNextGeneratedId.compareAndSet(result, newValue)) {
                    return result;
                }
            }
//        } else {
//            return View.generateViewId();
//        }
    }


    public static void addTextViewEllipsizeByLength(TextView tv,int length){

        if(tv==null){
            return;
        }
        String text=tv.getText().toString();
        if(text.length()>length){
            text=text.substring(0,length)+"...";
            tv.setText(text);
        }

    }


    public static void getViewLocation(View v){

        int height=getViewHeight(v);
        int width=getViewWidth(v);

    }

}
