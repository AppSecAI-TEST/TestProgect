package com.tianniu.custom.view.custom_view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;


import com.tianniu.custom.api.OnLocationSelectorListener;
import com.tianniu.custom.model.LocationInfo;
import com.tianniu.custom.model.SelectedLocation;
import com.tianniu.custom.utils.CommonOperate;
import com.tianniu.up.testprogect.R;

import java.util.List;


public class LocationSelectorPop {
    protected static final String TAG = "LocationSelector";



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
//    private ListView proList, cityList, countList;
    private LinearLayout showView;

    //    private LocationAdapter4 locationAdapter2;
//    private LocationAdapter4 locationAdapter3;
//    private LocationAdapter4 locationAdapter;
    private Button reset_btn;

    private String locationFlag;

    private int itemHeight=0;

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

    private void initPopupWindow() {
        LayoutInflater mInflater = LayoutInflater.from(mContext);;
        showView = (LinearLayout) mInflater.inflate(R.layout.pop_location_selector, null);
        ViewPager vpContent = (ViewPager)showView.findViewById(R.id.vp_content);
        vpContent.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return 0;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return false;
            }
        });

        initPopStyle(showView);// 设置显示的效果


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
        CommonOperate.backgroundAlpha((Activity)showView.getContext(),0.5f);


        // 关闭监听
        mLocationPop.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                if(onDismissListener!=null) {
                    onDismissListener.onDismiss();
                }
                CommonOperate.backgroundAlpha((Activity)showView.getContext(),1.0f);
            }
        });
        //  mLocationPop
        mLocationPop.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);//2016
        mLocationPop.setAnimationStyle(R.style.PopupWindowAnimation);





    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.onDismissListener = onDismissListener;
    }

    private PopupWindow.OnDismissListener onDismissListener;
    public void initPopStyle(View view) {
        Activity viewContext = (Activity) view.getContext();
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
