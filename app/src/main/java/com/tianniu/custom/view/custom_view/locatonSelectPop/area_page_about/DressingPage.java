package com.tianniu.custom.view.custom_view.locatonSelectPop.area_page_about;

import android.view.View;

import com.tianniu.custom.model.LocationInfo;

import java.util.List;

/**
 * Created by Administrator on 2017/5/10 0010.
 */

public class DressingPage implements AreaPage {

    private AreaPage areaPage;

    public DressingPage(AreaPage areaPage) {
        this.areaPage = areaPage;
    }


    @Override
    public List<View> generationRootView(List<LocationInfo> areas) {
        return areaPage.generationRootView(areas);
    }

    @Override
    public void openRangeSelector(int showPosition) {
        areaPage.openRangeSelector(showPosition);
    }


    @Override
    public void notifyUpdate(int position, List<LocationInfo> locationInfos) {
        areaPage.notifyUpdate(position,locationInfos);
    }


}
