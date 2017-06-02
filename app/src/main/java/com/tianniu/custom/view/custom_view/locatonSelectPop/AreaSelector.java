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

public interface AreaSelector {


    /**
     * 生成rootview
     */
    View generataonPopView();

    /**
     * 更新页面数据
     */
    void updateItemPageContent(List<View> areaViews);

    /**
     * 更新顶部标签
     */
    void updateTopTablayout(String[] lableTexts);

    /**
     * 打开选择器
     */
    void openSelector();

    /**
     * 关闭选择器
     */
    void dismissSelector();


    ViewPager getViewPage();

}
