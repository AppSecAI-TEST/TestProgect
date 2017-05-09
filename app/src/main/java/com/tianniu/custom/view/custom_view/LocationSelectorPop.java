package com.tianniu.custom.view.custom_view;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;


import com.tianniu.custom.LocationManager;
import com.tianniu.custom.adapter.OnItemClickListener;
import com.tianniu.custom.adapter.SelectorPopAdapter;
import com.tianniu.custom.api.OnLocationSelectorListener;
import com.tianniu.custom.model.LocationInfo;
import com.tianniu.custom.model.SelectedLocation;
import com.tianniu.custom.utils.CommonOperate;
import com.tianniu.up.testprogect.R;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;


public class LocationSelectorPop {
    protected static final String TAG = "LocationSelector";
    private LocationManager locationManager;
    private TabLayout tabs_title;
    private ViewPager vpContent;
    private MyPageadapter myPageadapter;
    private TabLayout.OnTabSelectedListener onTabSelectedListener;

    private final int PROVINCE = 0 ,CITY = 1,COUNTY =2;


    public boolean isShowQuanGuo() {
        return isShowQuanGuo;
    }

    public void setShowQuanGuo(boolean showQuanGuo) {
        isShowQuanGuo = showQuanGuo;
    }

    private boolean isShowQuanGuo=false;

    public boolean isRemoveCityFromCounty() {
        return removeCityFromCounty;
    }

    public void setRemoveCityFromCounty(boolean removeCityFromCounty) {
        this.removeCityFromCounty = removeCityFromCounty;
    }

    private boolean removeCityFromCounty=false;

    private List<LocationInfo> cityInfos;
    private List<LocationInfo> countInfos;
    private List<LocationInfo> mAllLocationInfos;
    private Context mContext;
    private SelectedLocation mSelectedLocation;

    private View mPositionView;
    private OnLocationSelectorListener mOnLocationSelectorListener;

    public static int screen_w = 0;
    public static int screen_h = 0;
    public PopupWindow mLocationPop;
    private LinearLayout showView;


    private Button reset_btn;

    private String locationFlag;

    private int itemHeight=0;
    /**
     * 省份信息
     */
    private List<LocationInfo> provinces;


    public LocationSelectorPop(Context context, View positionView, OnLocationSelectorListener onLocationSelectorListener) {
        this.mContext = context;
        this.mPositionView = positionView;
        this.mOnLocationSelectorListener = onLocationSelectorListener;
        mSelectedLocation = new SelectedLocation();
//        itemHeight=computItemHeight();
    }

 
    public void setToponymeFlag(String toponyme) {
        this.locationFlag = toponyme;
    }

    public String getToponymeFlag() {
        return locationFlag;
    }

    public void setmPositionView(View mPositionView) {
        this.mPositionView = mPositionView;
    }


    private boolean isSetToCancel=false;
    public void setResetBtnTextToCancel(){
        isSetToCancel=true;
    }
    public boolean getIsShow() {
        return mLocationPop.isShowing();
    }

    private View llQuanguo;
    private View llQuanguo2;
    private View llQuanguo3;
    private List<View> locationViews = new ArrayList<View>(3);
    private List<RecyclerView> recyclerViews = new ArrayList<RecyclerView>(3);

    private String[] tabsStr = new String[]{"请选择省","请选择市","请选择县"};


    /**
     * 更新页面数据
     * @param viewPager
     * @param locationInfo
     */
    private void updatePageAdapter(ViewPager viewPager,LocationInfo locationInfo){
        String tempName = locationInfo.getName();
        tabsStr[vpContent.getCurrentItem()] = tempName;
        List<LocationInfo> areas = null;
        int pageCount = vpContent.getAdapter().getCount();
        int currentItem = viewPager.getCurrentItem();
        switch (currentItem){
            case PROVINCE:
                areas = locationManager.getCity(locationInfo.getName());
                break;
            case CITY:
                areas = locationManager.getArea(locationInfo.getName());
                break;
            case COUNTY:
                mLocationPop.dismiss();
                return;
        }
        switch (pageCount) {
            case 1://仅包含省
                generatePage(areas, tempName);
                break;
            case 2://包含市
                if (currentItem == CITY){
                    generatePage(areas, tempName);
                }else {
                    SelectorPopAdapter adapter = (SelectorPopAdapter) recyclerViews.get(pageCount-1).getAdapter();
                    adapter.updateData(areas,tempName);
                }

                break;
            case 3://包含三列省市县
                if (currentItem ==PROVINCE){ //在第一列的时候删除第三列数据
                    tabsStr = new String[]{tempName,"请选择市","请选择县"};
                    MyPageadapter adapter = (MyPageadapter)viewPager.getAdapter();
                    locationViews.remove(locationViews.size()-1);
                    adapter.updateInfo(locationViews);
                    recyclerViews.remove(recyclerViews.size()-1);
                }
                SelectorPopAdapter recyclerAdapter = (SelectorPopAdapter) recyclerViews.get(currentItem+1).getAdapter();
                recyclerAdapter.updateData(areas,tempName);
                break;
        }
        updateTabs();
    }


    /**
     * 生产page页面
     * @param locations  页面需要的数据集
     * @param selectedToponymy   选择标识
     * @return
     */
    private void generatePage(List<LocationInfo> locations,final String selectedToponymy){

        if (locations == null || locations.size() == 0){
            return ;
        }
        RecyclerView recyclerView = new RecyclerView(mContext);
        recyclerView.setLayoutManager(new GridLayoutManager(mContext,4));
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(mContext,5,10));

        LayoutInflater mInflater = LayoutInflater.from(mContext);
        ViewGroup itemView = (ViewGroup)mInflater.inflate(R.layout.ll_location_selector_item, null);
        SelectorPopAdapter selectorPopAdapter = new SelectorPopAdapter(mContext, locations, selectedToponymy, new OnItemClickListener() {
            @Override
            public void onItemClickListener(View v, LocationInfo locationInfo) {
                v.setBackgroundResource(R.color.color_dark_material_metaphor);
                updatePageAdapter(vpContent,locationInfo);
            }
        });

        recyclerViews.add(recyclerView);
        recyclerView.setAdapter(selectorPopAdapter);
        itemView.addView(recyclerView);
        locationViews.add(itemView);
        PagerAdapter adapter = vpContent.getAdapter();
        if (adapter !=null){
            adapter.notifyDataSetChanged();
            vpContent.setCurrentItem(vpContent.getCurrentItem()+1);
        }

    }

    /**
     * 更新顶部标签
     */
    private void updateTabs(){
        if (tabs_title == null) {
            tabs_title = (TabLayout) showView.findViewById(R.id.tabs_title);
            tabs_title.setTabGravity(TabLayout.GRAVITY_CENTER);
        }
        tabs_title.setupWithViewPager(vpContent);
        for (int i = 0; i < tabs_title.getTabCount(); i++) {
            TabLayout.Tab tabAt = tabs_title.getTabAt(i);


            TextView textView = new TextView(mContext);
            textView.setGravity(Gravity.CENTER);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(160, ViewGroup.LayoutParams.MATCH_PARENT);
            textView.setLayoutParams(layoutParams);
            textView.setBackgroundResource(R.drawable.select_range_buttom);
            tabAt.setCustomView(textView);
            tabAt.select();
            textView.setText(tabsStr[i]);

//            tabAt.setCustomView(R.layout.tabs_location_select);
//            TextView tabText = (TextView) tabAt.getCustomView().findViewById(R.id.tv_tabtext);
//            tabAt.select();
//            tabText.setText(tabsStr[i]);
        }
    }

    private void initPopupWindow() {
        LayoutInflater mInflater = LayoutInflater.from(mContext);;
        showView = (LinearLayout) mInflater.inflate(R.layout.pop_location_selector, null);
        vpContent = (ViewPager)showView.findViewById(R.id.vp_content);
        locationManager = LocationManager.getInstance(mContext);
        provinces = locationManager.getProvinces();

        generatePage(provinces, "");
        myPageadapter = new MyPageadapter(locationViews);
        vpContent.setAdapter(myPageadapter);
        updateTabs();


        initPopStyle(showView);// 设置显示的效果
    }


    private class MyPageadapter extends PagerAdapter{

        private List<View> views;

        public MyPageadapter(List<View> views) {
            this.views = views;
        }

        @Override
        public int getCount() {
            return views.size();
        }



        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = (views.get(position));
            container.addView(view,0);
            return views.get(position);
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(locationViews.get(position));
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return (view == object);
        }

        public void updateInfo(List<View> locationViews) {
            this.views = locationViews;
            notifyDataSetChanged();
        }
    }


    private void initDataAndShow(boolean isIndex) {
//        initToponymeIndex();

        int[] r=new int[2];
        mPositionView.getLocationInWindow(r);
        mLocationPop.showAtLocation(mPositionView, Gravity.TOP, r[0], r[1]+mPositionView.getMeasuredHeight());

        //mLocationPop.showAsDropDown(mPositionView, 0, 0);// 设置显
    }

    private int proIndex;
    private int cityIndex;
    private int countIndex;



    public void showLocationPop() {
        if (mLocationPop == null) {
            initPopupWindow();
        }

        CommonOperate.backgroundAlpha((FragmentActivity)showView.getContext(),0.5f);

        // 关闭监听
        mLocationPop.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                if(onDismissListener!=null) {
                    onDismissListener.onDismiss();
                }
                CommonOperate.backgroundAlpha((FragmentActivity)showView.getContext(),1.0f);
            }
        });
        mLocationPop.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);//2016
        mLocationPop.setAnimationStyle(R.style.PopupWindowAnimation);
        mLocationPop.showAsDropDown(mPositionView,0,0);
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.onDismissListener = onDismissListener;
    }

    private PopupWindow.OnDismissListener onDismissListener;
    public void initPopStyle(View view) {
        FragmentActivity viewContext = (FragmentActivity) view.getContext();
        WindowManager windowManager = viewContext.getWindowManager();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        screen_w = displayMetrics.widthPixels;
        screen_h = displayMetrics.heightPixels;

        mLocationPop = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        // mLocationPop.setBackgroundDrawable(((Activity)mContext).getResources().getDrawable(R.drawable.choosearea_bg_mid));

        mLocationPop.setBackgroundDrawable(new BitmapDrawable(null,""));
        mLocationPop.setOutsideTouchable(true);
        mLocationPop.update();
        mLocationPop.setTouchable(true);
		/* 设置点击menu以外其他地方以及返回键退出 */
        mLocationPop.setFocusable(true);
        /**
         * 1.解决再次点击MENU键无反应问题 2.sub_view是PopupWindow的子View
         */
        view.setFocusableInTouchMode(true);
    }





    @Deprecated
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


}
