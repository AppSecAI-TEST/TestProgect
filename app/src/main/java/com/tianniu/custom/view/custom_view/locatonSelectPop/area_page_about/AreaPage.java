package com.tianniu.custom.view.custom_view.locatonSelectPop.area_page_about;

import android.view.View;

import com.tianniu.custom.model.LocationInfo;

import java.util.List;

/**
 * Created by Administrator on 2017/5/10 0010.
 */

public interface AreaPage {
    List<View> generationRootView(List<LocationInfo> areas);

    void openRangeSelector(int showPosition);


    void notifyUpdate(int position,List<LocationInfo> locationInfos);
}
