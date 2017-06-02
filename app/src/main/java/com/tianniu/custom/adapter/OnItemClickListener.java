package com.tianniu.custom.adapter;

import android.view.View;

import com.tianniu.custom.model.LocationInfo;

/**
 * Created by Administrator on 2016/4/8.
 */
public interface OnItemClickListener {
    void onAreaItemClickListener(View v, LocationInfo locationInfo);

    void onRangeItemClickListener(String range);
}
