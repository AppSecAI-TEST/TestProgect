package com.tianniu.custom.view.custom_view.locatonSelectPop;

import com.tianniu.custom.model.HostoryLocation;
import com.tianniu.custom.model.SelectedLocation;
import com.tianniu.custom.view.custom_view.locatonSelectPop.area_page_about.SelectorInfo;

/**
 * Created by Administrator on 2017/6/1 0001.
 */
public interface OnAreaSelectorListener {

    void onSelectedArea(SelectorInfo selectedArea);
    void onSelectedHostroy(HostoryLocation hostoryLocation);
    void onSelectedcancel(SelectorInfo selectorInfo);
    void onSelectLocationListener(SelectedLocation selectorInfo);
}
