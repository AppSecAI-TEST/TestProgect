package com.tianniu.custom.view.custom_view.locatonSelectPop;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.tianniu.custom.LocationManager;
import com.tianniu.custom.adapter.OnItemClickListener;
import com.tianniu.custom.model.LocationInfo;

import java.util.List;

/**
 * Created by Administrator on 2017/5/10 0010.
 */

public class DressingSelector implements AreaSelector {

    private AreaSelector areaSelector;

    public DressingSelector(AreaSelector areaSelector) {
        this.areaSelector = areaSelector;
    }

    @Override
    public View generataonPopView() {
        return areaSelector.generataonPopView();
    }

    @Override
    public void updateItemPageContent(List<View> areaViews) {

    }


    @Override
    public void updateTopTablayout(String[] lableTexts) {

    }



    @Override
    public void openSelector() {
        areaSelector.openSelector();
    }

    @Override
    public void dismissSelector() {
        areaSelector.openSelector();
    }




    @Override
    public ViewPager getViewPage() {
        return areaSelector.getViewPage();
    }
}
