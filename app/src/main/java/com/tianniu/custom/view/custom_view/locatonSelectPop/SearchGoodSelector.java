package com.tianniu.custom.view.custom_view.locatonSelectPop;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.tianniu.custom.LocationManager;
import com.tianniu.custom.adapter.OnItemClickListener;
import com.tianniu.custom.model.LocationInfo;
import com.tianniu.custom.view.custom_view.locatonSelectPop.area_page_about.CustomPage;
import com.tianniu.custom.view.custom_view.locatonSelectPop.area_page_about.RoutineAreaPage;

import java.util.List;

/**
 * Created by Administrator on 2017/5/10 0010.
 */

public class SearchGoodSelector extends DressingSelector implements OnItemClickListener{

    private  AreaSelector customSelector;
    private String[] tabsStr = new String[]{"请选择省","请选择市","请选择县"};
    private ViewPager viewPage;

    private final int PROVINCE = 0 ,CITY = 1,COUNTY =2;

    private LocationManager locationManager;

    private SelectorInfo selectorInfo;
    private List<View> areaViews;

    private RoutineAreaPage routineAreaPage;

    private boolean isOpenRange;


    public SearchGoodSelector(SelectorInfo selectorInfo,AreaSelector areaSelector) {
        super(areaSelector);
        this.selectorInfo = selectorInfo;
        customSelector = areaSelector;
        locationManager = LocationManager.getInstance(selectorInfo.getContext());
    }


    /**
     * 生成选择页面
     * @param position 生成range选择的位置
     * @param areas
     * @return
     */
    private List<View> generateItemPage(int position,List<LocationInfo> areas){
        if (routineAreaPage == null){
            CustomPage customPage = new CustomPage(selectorInfo.getContext(), selectorInfo.getSelectedToponymy(),this);
            routineAreaPage = new RoutineAreaPage(customPage);
        }

        areaViews = routineAreaPage.generationRootView(areas);
        if (isOpenRange){//根据条件，是否打开范围选择器
             routineAreaPage.openRangeSelector(position);
        }
        return areaViews;
    }

    @Override
    public void openSelector() {
        super.openSelector(); //打开pop
        //更新内容
        List<LocationInfo> provinces = locationManager.getProvinces();
        customSelector.updateItemPageContent(generateItemPage(PROVINCE,provinces));
        customSelector.updateTopTablayout(tabsStr);
        viewPage = customSelector.getViewPage();

    }


    @Override
    public void onAreaItemClickListener(View v, LocationInfo locationInfo) {
        isOpenRange = false;
        String tempName = locationInfo.getName();
        tabsStr[viewPage.getCurrentItem()] = tempName;
        List<LocationInfo> areas = null;
        int pageCount = viewPage.getAdapter().getCount();
        int currentItem = viewPage.getCurrentItem();

        switch (currentItem){
            case PROVINCE:
                areas = locationManager.getCity(locationInfo.getName());
                isOpenRange = areas == null;
                break;
            case CITY:
                areas = locationManager.getArea(locationInfo.getName());
                isOpenRange = true;
                break;
            case COUNTY:
//                customSelector.dismissSelector();
                return;
        }
        switch (pageCount) {
            case 1://仅包含省
                customSelector.updateItemPageContent(generateItemPage(currentItem+1,areas));
                break;
            case 2://包含市
                if (currentItem == CITY){
                    customSelector.updateItemPageContent(generateItemPage(currentItem+1,areas));
                }else {
                    routineAreaPage.notifyUpdate(1,areas);
                }
                break;
            case 3://包含三列省市县
                routineAreaPage.notifyUpdate(2,areas);
                if (currentItem ==PROVINCE){ //在第一列的时候删除第三列数据
                    tabsStr = new String[]{tempName,"请选择市","请选择县"};
                    AreaViewPageadapter adapter = (AreaViewPageadapter)viewPage.getAdapter();
                    areaViews.remove(areaViews.size()-1);
                    adapter.updateInfo(areaViews);
                }
                break;
        }
        customSelector.updateTopTablayout(tabsStr);
    }

    @Override
    public void onRangeItemClickListener(String range) {

    }





    @Override
    public void dismissSelector() {
        super.dismissSelector();
    }


}
