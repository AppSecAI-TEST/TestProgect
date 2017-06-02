package com.tianniu.custom.view.custom_view.locatonSelectPop;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/10 0010.
 */

public class AreaViewPageadapter extends PagerAdapter {

    private List<View> views  = new ArrayList<>(3);;
    public AreaViewPageadapter(List<View> views) {
        if (views != null){
            this.views.addAll(views);
        }
    }

    @Override
    public int getCount() {
        return views == null ? 0 :views.size();
    }

    public View getIndexView(int position){
        return views.get(position);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = (views.get(position));
        container.addView(view);
        return views.get(position);
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
    }



    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

    public void updateInfo(List<View> locationViews) {
        if (locationViews !=null){
            this.views.clear();
            notifyDataSetChanged();
            this.views.addAll(locationViews);
        }
        notifyDataSetChanged();
    }


}
