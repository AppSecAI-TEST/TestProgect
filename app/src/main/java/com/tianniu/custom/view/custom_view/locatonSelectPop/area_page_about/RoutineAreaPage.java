package com.tianniu.custom.view.custom_view.locatonSelectPop.area_page_about;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.tianniu.custom.model.LocationInfo;

import java.util.List;

/**
 * 常规选择地区页面
 * Created by Administrator on 2017/5/10 0010.
 */

public class RoutineAreaPage extends DressingPage {


    private final CustomPage customPagestomPage;

    public RoutineAreaPage(AreaPage areaPage) {
        super(areaPage);
        customPagestomPage = (CustomPage) areaPage;
    }

    @Override
    public List<View> generationRootView(List<LocationInfo> areas) {
        return super.generationRootView(areas);
    }

    @Override
    public void notifyUpdate(int position, List<LocationInfo> locationInfos) {
        super.notifyUpdate(position, locationInfos);
    }
}
