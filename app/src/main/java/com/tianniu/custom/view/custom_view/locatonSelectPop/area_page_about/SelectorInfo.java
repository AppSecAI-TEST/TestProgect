package com.tianniu.custom.view.custom_view.locatonSelectPop.area_page_about;

import android.content.Context;
import android.view.View;

import com.tianniu.custom.model.SelectedLocation;

/**
 * Created by Administrator on 2017/6/1 0001.
 */

public class SelectorInfo {
    private Context context;
    private View positionView;
    /**
     * 0 ,出发，1，目的地
     */
    private int startOrEnd = 0;
    private SelectedLocation selectLocation;
    private String selectedToponymy;

    private boolean showQuanguo;
    private boolean showQuansheng;
    private boolean showQuanshi;
    private boolean showRange;
    private boolean showNearby;
    private boolean showAreaTitle;

    private boolean isWrapAuto;
    private String selectorTitle;

    public String getSelectorTitle() {
        return selectorTitle;
    }

    public void setSelectorTitle(String selectorTitle) {
        this.selectorTitle = selectorTitle;
    }

    public boolean isWrapAuto() {
        return isWrapAuto;
    }

    public void setWrapAuto(boolean wrapAuto) {
        isWrapAuto = wrapAuto;
    }

    public boolean isShowAreaTitle() {
        return showAreaTitle;
    }

    public void setShowAreaTitle(boolean showAreaTitle) {
        this.showAreaTitle = showAreaTitle;
    }

    public boolean isShowNearby() {
        return showNearby;
    }

    public void setShowNearby(boolean showNearby) {
        this.showNearby = showNearby;
    }

    public boolean isShowRange() {
        return showRange;
    }

    public void setShowRange(boolean showRange) {
        this.showRange = showRange;
    }

    public boolean isShowQuanguo() {
        return showQuanguo;
    }

    public void setShowQuanguo(boolean showQuanguo) {
        this.showQuanguo = showQuanguo;
    }

    public boolean isShowQuansheng() {
        return showQuansheng;
    }

    public void setShowQuansheng(boolean showQuansheng) {
        this.showQuansheng = showQuansheng;
    }

    public boolean isShowQuanshi() {
        return showQuanshi;
    }

    public void setShowQuanshi(boolean showQuanshi) {
        this.showQuanshi = showQuanshi;
    }

    public int getStartOrEnd() {
        return startOrEnd;
    }

    public void setStartOrEnd(int startOrEnd) {
        this.startOrEnd = startOrEnd;
    }

    public String getSelectedToponymy() {
        return selectedToponymy;
    }

    public String getLocationName(SelectedLocation location) {

        if (location == null) {
            return "";
        }
        if (location.getCounty() == null) {
            return "";
        }

        if (location.getCity().getName().contains(location.getPro().getName())) {
            if (location.getCounty().getName().contains(location.getCity().getName())) {
                String name = location.getCounty().getName();
                if (location.getCounty().getName().startsWith("全")) {
                    name = location.getCounty().getName().substring(1);
                }
                return name;
            } else {

                String name = location.getCounty().getName();
                if (location.getCounty().getName().startsWith("全")) {
                    name = location.getCounty().getName().substring(1);
                }
                return (location.getCity().getName() + name);
            }
        } else {

            if (location.getCounty().getName().contains(location.getCity().getName())) {
                String name = location.getCounty().getName();
                if (location.getCounty().getName().startsWith("全")) {
                    name = location.getCounty().getName().substring(1);
                }
                return location.getPro().getName() + name;
            } else {
                String name = location.getCounty().getName();
                if (location.getCounty().getName().startsWith("全")) {
                    name = location.getCounty().getName().substring(1);
                }
                return (location.getPro().getName() + location.getCity().getName() + name);

            }

        }
    }



    public void setSelectedToponymy(String selectedToponymy) {
        this.selectedToponymy = selectedToponymy;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public View getPositionView() {
        return positionView;
    }

    public void setPositionView(View positionView) {
        this.positionView = positionView;
    }

    public SelectedLocation getSelectLocation() {
        return selectLocation;
    }

    public void setSelectLocation(SelectedLocation areaLocation) {
        if (selectLocation == null){
            selectLocation = new SelectedLocation();
        }
        if (areaLocation == null){
            return;
        }
        selectLocation.setPro(areaLocation.getPro());
        selectLocation.setCity(areaLocation.getCity());
        selectLocation.setCounty(areaLocation.getCounty());
        selectLocation.setRange(areaLocation.getRange());
        selectLocation.setX(areaLocation.getX());
        selectLocation.setY(areaLocation.getY());
    }
}
