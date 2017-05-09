package com.tianniu.custom.utils;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2017/5/8 0008.
 */

public class LayoutUtil {
    public static void setContentView(Activity activity, View view){
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        view.setLayoutParams(layoutParams);
        activity.setContentView(view);
    }
}
