
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.drawable.BitmapDrawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;


import com.amap.api.location.AMapLocation;
import com.tianniu.custom.LocationManager;
import com.tianniu.custom.adapter.ViewHolder;
import com.tianniu.custom.core.CommonDefine;
import com.tianniu.custom.model.HostoryLocation;
import com.tianniu.custom.model.LocationInfo;
import com.tianniu.custom.model.SelectedLocation;
import com.tianniu.custom.utils.CheckIsOperate;
import com.tianniu.custom.utils.ScreenUtil;
import com.tianniu.custom.utils.SimpleLocationUtil;
import com.tianniu.custom.view.custom_view.locatonSelectPop.AutoNewLineTextView;
import com.tianniu.custom.view.custom_view.locatonSelectPop.OnAreaSelectorListener;
import com.tianniu.custom.view.custom_view.locatonSelectPop.area_page_about.OnItemClickListener;
import com.tianniu.custom.view.custom_view.locatonSelectPop.area_page_about.SelectorInfo;
import com.tianniu.custom.utils.CommonOperate;
import com.tianniu.custom.utils.FiveList;
import com.tianniu.custom.utils.JsonUtils;
import com.tianniu.custom.view.custom_view.locatonSelectPop.AreaViewPageadapter;
import com.tianniu.custom.view.custom_view.locatonSelectPop.WrapContentHeightViewPager;
import com.tianniu.custom.view.custom_view.locatonSelectPop.area_page_about.CustomPage;
import com.tianniu.up.testprogect.R;

import java.util.List;

/**
 * Created by Administrator on 2017/5/10 0010.
 */

public class CustomSelector implements OnAreaSelectorListener, View.OnClickListener {



    private static final String HOSTORY = "hostorySearch";

    private String[] tabsStr = new String[]{"请选择","请选择","请选择"};
    private PopupWindow popupWindow;
    private WrapContentHeightViewPager viewPager;
    private ViewGroup showView;

    private OnItemClickListener onItemClickListener;
    private AreaViewPageadapter areaViewPageadapter;

    private  SelectorInfo selectorInfo;
    private LayoutInflater mInflater;
    private TabLayout tabs_title;

    private View clean;
    private FiveList mHostory;
    private View hostoryLl;
    private HostAdapter mAdatper;
    private View areaSelectorLL;
    private LocationManager locationManager;


    /**
     * 可选最后条件显示范围，显示全市。
     */
    private boolean isEndPoint;

    private final int PROVINCE = 0 ,CITY = 1,COUNTY =2;
    private CustomPage routineAreaPage;





    private OnAreaSelectorListener onAreaSelectorCallback;

    /**
     * 目的地显示全国
     */
    private TextView aMapLocationInfo;
    private SharedPreferences sharedPreferences;
    private boolean showQuanshi;
    private boolean showRange;
    private View rlSelectorTitle;
    private TextView tvSelectorTip;


    private View ibtnSelectorCancel;
    // private View llLocationTip;
    //   private View pbAreaLocation;
    //  private TextView tvAreaLocation;
    private ListView areaHostoryLv;
    private boolean wrapAuto;
    private View tvNoneTip;


    /**
     * 出发地，要显示全市，以及全县
     */


    public CustomSelector(){

    }


    public  CustomSelector getInstance(SelectorInfo selectorInfo,OnAreaSelectorListener onAreaSelectorListener){
        setSelectorInfo(selectorInfo);
        setOnAreaSelectorCallback(onAreaSelectorListener);
        return this;
    }

    private void setSelectorInfo(SelectorInfo selectorInfo) {
        this.selectorInfo = selectorInfo;
        showQuanshi = selectorInfo.isShowQuanshi();
        showRange = selectorInfo.isShowRange();
        wrapAuto = selectorInfo.isWrapAuto();

        locationManager = LocationManager.getInstance(this.selectorInfo.getContext());
    }

    public void setOnAreaSelectorCallback(OnAreaSelectorListener onAreaSelectorCallback) {
        this.onAreaSelectorCallback = onAreaSelectorCallback;
    }

    public void openSelectorPopAtButtom(View view) {
        //更新内容
        CommonOperate.backgroundAlpha((Activity)view.getContext(),0.5f);
        if (popupWindow != null){
            updateForView();
            popupWindow.setAnimationStyle(R.style.PopupAnimation);

            popupWindow.showAtLocation(showView, Gravity.BOTTOM | Gravity.HORIZONTAL_GRAVITY_MASK, 0, 0);
            return;
        }
        initRootView();
        showEither(true);
        updateForView();

        if (popupWindow == null){
            initPopStyle();// 设置显示的效果
        }

        if (showView.getParent() != null){
            ViewGroup parent = (ViewGroup) showView.getParent();
            parent.removeView(showView);
        }
        popupWindow.setAnimationStyle(R.style.PopupAnimation);
        popupWindow.showAtLocation(showView, Gravity.BOTTOM | Gravity.HORIZONTAL_GRAVITY_MASK, 0, 0);
    }




    public View openAreaHostory() {
        View view = generataonTopView();
        generationAreaHostory();
        showEither(false);
        return view;
    }

    /**
     * @param isShow true 显示地区   false 显示历史记录
     */
    private void showEither(boolean  isShow){
        areaSelectorLL.setVisibility(isShow ? View.VISIBLE :View.GONE);
        hostoryLl.setVisibility(isShow ? View.GONE : View.VISIBLE);
    }

    public void generationAreaHostory(){
        if (areaHostoryLv ==null){
            if (mHostory == null){
                mHostory = new FiveList();
            }
            areaHostoryLv = (ListView) hostoryLl.findViewById(R.id.lv_search_hostory);
            clean = mInflater.inflate(R.layout.item_clear_hostory, null);
            tvNoneTip = hostoryLl.findViewById(R.id.tv_none_data);
            areaHostoryLv.addFooterView(clean);
            clean.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {


                }
            });
            String hostoryStr = sharedPreferences.getString(HOSTORY, null);// 读出上次存储的历史
            if (hostoryStr != null) {
                List<HostoryLocation> list = JsonUtils.stringToList(hostoryStr);
                if (list.size() > 5) {
                    for (int i = 4; i >= 0; i--) {
                        mHostory.add(list.get(i));
                    }
                } else {
                    mHostory.addAll(list);
                }
            }
        }


        if (mHostory.getList().size() < 1) {
            tvNoneTip.setVisibility(View.VISIBLE);
            areaHostoryLv.setVisibility(View.GONE);
            return;
        }else {
            View tvNoneTip = hostoryLl.findViewById(R.id.tv_none_data);
            tvNoneTip.setVisibility(View.GONE);
            areaHostoryLv.setVisibility(View.VISIBLE);
        }


        if (mAdatper == null) {
            mAdatper = new HostAdapter(selectorInfo.getContext(), mHostory.getList());
            areaHostoryLv.setAdapter(mAdatper);
        } else {
            clean.setVisibility(View.VISIBLE);
            mAdatper.refreshData(mHostory.getList());
        }

    }

    /**
     * 添加历史记录
     */
    public void addHostory(SelectedLocation mStartSelectLocation,String startName,SelectedLocation mEndSelectLocation,String endName) {
        if (mHostory == null) {
            mHostory = new FiveList();
        }
        for (HostoryLocation hostoryLocation : mHostory.getList()) {
            SelectedLocation startLocation = hostoryLocation.getmStartLocation();
            SelectedLocation endLocation = hostoryLocation.getmDestLocation();
            String s = hostoryLocation.getmStartLocationName() + hostoryLocation.getmDestLocationName();
            if (TextUtils.isEmpty(endName)){
                endName = "全国";
            }
            if (s.equals(startName+endName)){
                if (startLocation != null){
                    startLocation.setRange(mStartSelectLocation.getRange());
                }
                if (endLocation != null){
                    endLocation.setRange(mEndSelectLocation.getRange());
                }
                return;
            }
        }

        HostoryLocation hostoryLocation = new HostoryLocation();
        if (mStartSelectLocation.getCounty() == null && mEndSelectLocation.getCounty() == null) {
            return;
        }

        if (mStartSelectLocation.getCounty() != null) {
            hostoryLocation.setmStartLocation(mStartSelectLocation);
            hostoryLocation.setmStartLocationName(startName);
        }

        if (mEndSelectLocation != null) {
            if (mEndSelectLocation.getCounty() != null) {
                hostoryLocation.setmDestLocation(mEndSelectLocation);
                hostoryLocation.setmDestLocationName(endName);
            }
        }
        mHostory.add(hostoryLocation);
    }

    public void saveHostory(){
        if (sharedPreferences == null){
            sharedPreferences = selectorInfo.getContext().getSharedPreferences(CommonDefine.SETTING, Context.MODE_PRIVATE);
        }
        if (mHostory != null){
            String json = JsonUtils.listToJson(mHostory.getList());
            sharedPreferences.edit().putString(HOSTORY, json).commit();
        }
    }

    public View generataonTopView() {
        return showView == null ? initRootView():showView;
    }

    public void updateItemPageContent(List<View> areaViews) {
        if (areaViews == null){
            return;
        }
        if (areaViewPageadapter != null && viewPager != null){
            areaViewPageadapter.updateInfo(areaViews);
        }else {
            viewPager = (WrapContentHeightViewPager)showView.findViewById(R.id.vp_content);
            areaViewPageadapter = new AreaViewPageadapter(areaViews);
            viewPager.setAdapter(areaViewPageadapter);
            viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    viewPager.requestLayout();
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        }
        viewPager.setWrapAuto(false);
    }

    /**
     * 仅仅获取要显示的view
     * @return
     */
    public View openSelectorTopView(){
        View view = generataonTopView();
        showEither(true);
        return view;
    }

    private void updateForView(){
        isDismissed=false;
        stopAnima();
        generationAreaHostory();//初始化历史
        routineAreaPage.initParam(selectorInfo,this);

        if("位置刷新失败,请检查网络".equals(locationFailedMessage)){

            aMapLocationInfo.setText(locationFailedMessage);
        }else{
            if(mAmapLocation!=null){
                String locationName = getLocationName(mAmapLocation);
                aMapLocationInfo.setText(locationName);
            }else{
                aMapLocationInfo.setText("正在获取...");
                startLocation();
            }

        }



        setShowTitle();

        SelectedLocation currentArea = selectorInfo.getSelectLocation();
        String selectedToponymy = selectorInfo.getSelectedToponymy();
        if (currentArea != null && currentArea.getPro() != null){
            showLastAreaRecord(currentArea);
        }else if (!TextUtils.isEmpty(selectedToponymy)){
            showLastAreaRecordForStr(selectedToponymy);
        }else {
//            startLocation(); //没有记录则进行高德定位
            routineAreaPage.initSingleView();
            tabsStr[0] = "请选择";
            isEndPoint = false;
            List<LocationInfo> provinces = locationManager.getProvinces();
            updateItemPageContent(routineAreaPage.notifyUpdateProvince(isEndPoint,provinces,""));
            updateTopTablayout(tabsStr);
        }
    }

    private void setShowTitle(){
        String selectorTitle = selectorInfo.getSelectorTitle();
        if (!TextUtils.isEmpty(selectorTitle)){
            rlSelectorTitle.setVisibility(View.VISIBLE);
            tvSelectorTip.setText(selectorTitle);
            ibtnSelectorCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dismissSelector();
                }
            });
        }else {
            rlSelectorTitle.setVisibility(View.GONE);
        }


    }




    /**
     * 显示历史
     * @param locationInfo
     */
    private void showLastAreaRecord(SelectedLocation locationInfo){
        tabsStr = new String[]{"请选择","请选择","请选择"};
        isEndPoint = false;   //默认不现实范围
        // aMapLocationInfo.setText(myLocation); //下方显示当前位置名称


        LocationInfo pro = locationInfo.getPro();
        LocationInfo city = locationInfo.getCity();
        LocationInfo county = locationInfo.getCounty();
        String areaName = null;

        List<View> views = null;

        List<LocationInfo> areas = locationManager.getProvinces();


        if (pro != null){
            isEndPoint = false;
            areaName = pro.getName();
            if (TextUtils.isEmpty(areaName)){
                areaName = selectorInfo.getSelectedToponymy();
            }
            views = routineAreaPage.notifyUpdateProvince(isEndPoint,areas,areaName);
            tabsStr[PROVINCE] = areaName;
        }else {
            routineAreaPage.initSingleView();
            tabsStr[PROVINCE] = selectorInfo.getStartOrEnd() == 0 ? "请选择":"全国";
            tabsStr[CITY] = "请选择";
            tabsStr[COUNTY] = "请选择";
            views = routineAreaPage.notifyUpdateProvince(isEndPoint, areas, areaName);
            updateItemPageContent(views);
            updateTopTablayout(tabsStr);
            return;
        }



        if (city != null){
            areaName = pro.getName();
            areas = locationManager.getCity(areaName);
            isEndPoint = areas == null;

            if (showQuanshi && areas.size() != 0){
                if (areas.size() == 1){ //判断是否直辖
                    areas = locationManager.getArea(areas.get(0).getName());
                    isEndPoint = areas.size() != 0 ;
                    zhixia = true;
                    areaName= city.getName();
                    String countyName = county.getName();
                    if (!TextUtils.isEmpty(countyName)){
                        areaName = countyName;
                    }
                    tabsStr[CITY] = areaName.contains(pro.getName()) ? "全市":areaName;
                    if (TextUtils.isEmpty(areaName)){
                        areaName = selectorInfo.getSelectedToponymy();
                    }
                    views = routineAreaPage.notifyUpdateCity(zhixia,isEndPoint, areas, areaName);
                    updateItemPageContent(views);
                    updateTopTablayout(tabsStr);
                    return;
                }else {
                    zhixia =false;
                }
            }
            if (selectorInfo.isShowQuansheng()){
                if (city == pro){
                    tabsStr[CITY] = "全省";
                    views =routineAreaPage.notifyUpdateCity(zhixia,isEndPoint, areas, "全省");
                    updateItemPageContent(views);
                    updateTopTablayout(tabsStr);
                    return;
                }
            }

            areaName = city.getName();
            if (TextUtils.isEmpty(areaName)){
                areaName = selectorInfo.getSelectedToponymy();
            }
            views =routineAreaPage.notifyUpdateCity(zhixia,isEndPoint, areas, areaName);
            tabsStr[CITY] = areaName;
        }
        if (county != null){
            areas = locationManager.getArea(areaName);
            isEndPoint = true;
            if (TextUtils.isEmpty(areaName)){
                areaName = selectorInfo.getSelectedToponymy();
            }
            tabsStr[COUNTY] = areaName.equals(county.getName())? "全市" : county.getName();
            views = routineAreaPage.notifyUpdateCounty(isEndPoint, areas,  county.getName());
        }
        updateItemPageContent(views);
        updateTopTablayout(tabsStr);

    }


    private int  countIndex ,cityIndex,proIndex ;
    private void showLastAreaRecordForStr(String selectedToponymy) {
        List<View> views = null;
        List<LocationInfo> areas;
        SelectedLocation selectLocation = selectorInfo.getSelectLocation();
        if (TextUtils.isEmpty(selectedToponymy)){
            countIndex =cityIndex=proIndex = 0;
        }else {
            areas = locationManager.getProvinces();
            for (int j2 = 0; j2 < areas.size(); j2++) {
                String proName = areas.get(j2).getName();
                if (selectedToponymy.contains(proName)) {
                    views = routineAreaPage.notifyUpdateProvince(isEndPoint, areas, proName);
                    proIndex = j2;
                    tabsStr[PROVINCE] = proName;
                    selectLocation.setPro(areas.get(proIndex));
                    areas = LocationManager.getInstance(selectorInfo.getContext()).getCity(proName);//得到城市
                    if (areas.size() == 1){ //判断是否直辖
                        selectLocation.setCity(areas.get(0));
                        String cityName = areas.get(0).getName();
                        areas = locationManager.getArea(cityName);
                        isEndPoint = areas.size() != 0 ;

                        zhixia = true;
                        tabsStr[CITY] = selectedToponymy.equals(cityName) ? "全市":selectedToponymy;
                        views = routineAreaPage.notifyUpdateCity(zhixia,isEndPoint, areas, selectedToponymy);
                        for (LocationInfo area : areas) {
                            if (selectedToponymy.equals(area.getName())){
                                selectLocation.setCounty(area);
                            }
                        }
                        updateItemPageContent(views);
                        updateTopTablayout(tabsStr);
                        return;
                    }else {
                        zhixia =false;
                        isEndPoint = false;
                    }
                    selectedToponymy = selectedToponymy.replace(proName,"");

                    for (int j = 0; j < areas.size(); j++) {
                        String cityName = areas.get(j).getName();
                        if (selectedToponymy.contains(cityName)) {
                            views = routineAreaPage.notifyUpdateCity(zhixia,isEndPoint, areas, cityName);
                            cityIndex = j;
                            selectLocation.setCity(areas.get(cityIndex));
                            areas = locationManager.getArea(cityName);//得到区县
                            tabsStr[CITY] = cityName;
                            isEndPoint = true;


                            for (int i = 0; i < areas.size(); i++) {
                                String countyName = areas.get(i).getName();
                                if (selectedToponymy.equals(countyName)){
                                    tabsStr[COUNTY] = "全市";
                                    views = routineAreaPage.notifyUpdateCounty(isEndPoint, areas, countyName);
                                    selectLocation.setCounty(areas.get(i));
                                    break;
                                }else if (selectedToponymy.replace(cityName, "").contains(countyName)){
                                    views = routineAreaPage.notifyUpdateCounty(isEndPoint, areas, countyName);
                                    countIndex = i;
                                    selectLocation.setCounty(areas.get(i));
                                    tabsStr[COUNTY] = countyName;
                                }
                            }
                            break;
                        }else {
                            cityIndex = 0;
                        }
                    }
                    break;
                }else {
                    proIndex = 0;
                }
            }
        }

        updateItemPageContent(views);
        updateTopTablayout(tabsStr);
    }


    /**
     * 更新顶部标签
     */
    public void updateTopTablayout(String[] lableTexts) {
        if (tabs_title == null){
            tabs_title = (TabLayout) showView.findViewById(R.id.tabs_title);
            tabs_title.setupWithViewPager(viewPager);
            tabs_title.setTabGravity(TabLayout.GRAVITY_CENTER);
        }

        for (int i = 0; i < tabs_title.getTabCount(); i++) {
            if (i == tabsStr.length){
                break;
            }
            TabLayout.Tab tabAt = tabs_title.getTabAt(i);
            TextView customView = (AutoNewLineTextView)tabAt.getCustomView();
            if (customView == null){
//                customView = new AutoNewLineTextView(selectorInfo.getContext());
//                customView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,14);

                View root = mInflater.inflate(R.layout.pop_text_item, null);
                customView = (AutoNewLineTextView)root.findViewById(R.id.tv_area_info);
                customView.setLines(2);
                customView.setEllipsize(TextUtils.TruncateAt.END);
                ColorStateList textViewSelectColor = CommonOperate.getTextViewSelectColor(customView.getContext(), R.xml.text_select_status_color);
                customView.setTextColor(textViewSelectColor);
                customView.setGravity(Gravity.CENTER);

                int screenWidth = ScreenUtil.getScreenWidth(selectorInfo.getContext());
                int itemWidth = (screenWidth - (ScreenUtil.dip2px(selectorInfo.getContext(),12) * 2)) / 4;
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(itemWidth - 2, ViewGroup.LayoutParams.MATCH_PARENT);
                customView.setLayoutParams(layoutParams);

                customView.setBackgroundResource(i == 0 ? R.drawable.tablayout_buttom_first_position:R.drawable.tablayout_buttom);
                tabAt.setCustomView(customView);
            }

            customView.setText(lableTexts[i]);
            tabAt.select();
        }
        for (int i = 0; i < tabs_title.getTabCount(); i++) {
            TabLayout.Tab tabAt = tabs_title.getTabAt(i);
            AutoNewLineTextView customView = (AutoNewLineTextView)tabAt.getCustomView();
            tabAt.select();
            customView.setSelected(tabAt.isSelected());
        }
    }


    /**
     * 初始化布局
     * @return
     */
    private View initRootView() {
        mInflater = LayoutInflater.from(selectorInfo.getContext());
        showView = (ViewGroup) mInflater.inflate(R.layout.pop_location_selector, null);
        if (routineAreaPage == null){
            routineAreaPage = new CustomPage(); //生成子页面view
        }
        routineAreaPage.initParam(selectorInfo,this);

        View tv_location_fresh = showView.findViewById(R.id.tv_location_fresh);
        tv_location_fresh.setOnClickListener(this);

        sharedPreferences = selectorInfo.getContext().getSharedPreferences(CommonDefine.SETTING, Context.MODE_PRIVATE);

        aMapLocationInfo = (TextView) showView.findViewById(R.id.tv_location_info);
        aMapLocationInfo.setOnClickListener(this);
        areaSelectorLL = showView.findViewById(R.id.ll_arealayout);
        ViewStub vs = (ViewStub) showView.findViewById(R.id.vs_area_hostory);
        hostoryLl = vs.inflate();

        rlSelectorTitle = showView.findViewById(R.id.rl_selector_title);
        tvSelectorTip = (TextView)showView.findViewById(R.id.tv_selector_top);
        ibtnSelectorCancel = showView.findViewById(R.id.ibtn_selector_cancel);


        return showView;
    }





    /**
     * 设置POP显示效果
     */
    public void initPopStyle() {
        FragmentActivity viewContext = (FragmentActivity) showView.getContext();
        WindowManager windowManager = viewContext.getWindowManager();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int screen_w = displayMetrics.widthPixels;
        int screen_h = displayMetrics.heightPixels;
        popupWindow = new PopupWindow(showView, LinearLayout.LayoutParams.MATCH_PARENT,(int)(screen_h * 0.7),true);
        // mLocationPop.setBackgroundDrawable(((Activity)mContext).getResources().getDrawable(R.drawable.choosearea_bg_mid));

        popupWindow.setBackgroundDrawable(new BitmapDrawable(null,""));
        popupWindow.setOutsideTouchable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.update();
        popupWindow.setTouchable(true);
		/* 设置点击menu以外其他地方以及返回键退出 */
        popupWindow.setFocusable(true);
        /**
         * 1.解决再次点击MENU键无反应问题 2.sub_view是PopupWindow的子View
         */
        showView.setFocusableInTouchMode(true);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                dismissSelector();
            }
        });
    }


    private boolean isDismissed=false;
    public void dismissSelector() {
        if (selectorInfo !=null){
            SelectedLocation selectLocation = selectorInfo.getSelectLocation();
            if (selectLocation != null){
                if (!isCheckSelected(selectLocation)){
                    selectLocation.setCity(null);
                    selectLocation.setCounty(null);
                    selectLocation.setPro(null);
                }
            }
        }

        isDismissed=true;

        if (popupWindow != null){
            popupWindow.dismiss();
        }
        CommonOperate.backgroundAlpha((Activity)selectorInfo.getContext(),1f,flag);
        closeTopView();
    }

    public ViewPager getViewPage() {
        return viewPager;
    }


    /**
     * 选择完成
     * @return
     */
    private boolean isCheckSelected(SelectedLocation selectLocation){
        //todo 全国的话，判断条件会不同
        if (selectLocation.getCounty() == null){
            return false;
        }
        if (!zhixia){
            if (selectLocation.getCity() == null){
                return false;
            }
        }
        if (selectLocation.getPro() == null){
            return false;
        }
        if (showRange){
            if (TextUtils.isEmpty(selectLocation.getRange())){
                return false;
            }
        }
        selectorInfo.setSelectLocation(selectLocation);
        return true;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    /**
     * 选择完成
     * @param selectedArea
     */
    @Override
    public void onSelectedArea(SelectorInfo selectedArea) {
        dismissSelector();
        onAreaSelectorCallback.onSelectedArea(selectedArea);
    }

    /**
     * 无用
     * @param hostoryLocation
     */
    @Override
    public void onSelectedHostroy(HostoryLocation hostoryLocation) {
        dismissSelector();
    }

    @Override
    public void onSelectedcancel(SelectorInfo selectorInfo) {

    }
    private String zhixiashi = "北京市天津市上海市重庆市";
    private boolean zhixia;




    @Override
    public void onSelectLocationListener(SelectedLocation selectLocation) {
        boolean showQuanshi = selectorInfo.isShowQuanshi();
        isEndPoint = false;

        List<LocationInfo> areas = null;
        String areaName = "";
        LocationInfo pro = selectLocation.getPro();
        LocationInfo city = selectLocation.getCity();
        LocationInfo county = selectLocation.getCounty();
        int currentItem = viewPager.getCurrentItem();

        switch (currentItem){
            case PROVINCE:
                updateItemPageContent(routineAreaPage.initSingleView());

                if (pro.getName().equals("附近")){  //仅针对附近单独处理点击
                    onAreaSelectorCallback.onSelectedArea(selectorInfo);
                    dismissSelector();
                    return;
                }

                areaName = pro.getName();
                tabsStr[PROVINCE] = areaName;
                areas = locationManager.getCity(areaName);
                isEndPoint = areas == null;
                if (showQuanshi && areas.size() != 0){
                    if (areas.size() == 1){
                        areaName = areas.get(0).getName();
                        selectorInfo.getSelectLocation().setCity(areas.get(0)); //遇上直辖市，填充城市
                        areas = locationManager.getArea(areaName);
                        tabsStr[CITY] = zhixiashi.contains(areaName)? "全市": areaName;
                        isEndPoint = areas.size() != 0 ;
                        zhixia = true;
                    }else {
                        zhixia =false;

                    }
                }
                tabsStr[CITY] = "请选择";
                break;
            case CITY:

                if (showQuanshi && zhixia){
                    boolean checkSelected = isCheckSelected(selectLocation);
                    if (checkSelected){
                        onAreaSelectorCallback.onSelectedArea(selectorInfo);
                        dismissSelector();
                    }
                    return;
                }
                areaName = city.getName();
                areas = locationManager.getArea(areaName);
                isEndPoint = true;
                break;
            case COUNTY:
                boolean selected = isCheckSelected(selectLocation);
                if (selected){
                    onAreaSelectorCallback.onSelectedArea(selectorInfo);
                    dismissSelector();
                    return;
                }
                areaName = county.getName();

                break;
        }

        List<View> views = null;
        int pageCount = viewPager.getAdapter().getCount();
        tabsStr[viewPager.getCurrentItem()] = areaName;
        switch (pageCount) {
            case 1://仅包含省
                views =routineAreaPage.notifyUpdateCity(zhixia,isEndPoint,areas,"");
                break;
            case 2://包含市
                tabsStr[COUNTY] ="请选择";
                if (currentItem == CITY){
                    views = routineAreaPage.notifyUpdateCounty(isEndPoint,areas,"");//""未选择
                }else if (currentItem == PROVINCE){
                    views = routineAreaPage.notifyUpdateCity(zhixia,isEndPoint,areas,"");
                }
                break;
            case 3://包含三列省市县
                if (currentItem ==PROVINCE){
                    tabsStr[PROVINCE] =areaName;
                    tabsStr[CITY] ="请选择";
                    tabsStr[COUNTY] ="请选择";
                    views = routineAreaPage.notifyUpdateCity(zhixia,isEndPoint, areas, "");

                }else if (currentItem == CITY && areas.size() > 0){
                    tabsStr[COUNTY] ="请选择";
                    views = routineAreaPage.notifyUpdateCounty(isEndPoint, areas, "");
                }else if (currentItem == COUNTY){

                }
                break;
        }
        updateItemPageContent(views);
        updateTopTablayout(tabsStr);
    }

    private void startLocationAnime(){
        if(showView!=null) {
            View zhuanquan = showView.findViewById(R.id.iv_zhuanquan);
            final RotateAnimation animation = new RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF,
                     0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            animation.setDuration(1000);//设置动画持续时间
            animation.setRepeatCount(RotateAnimation.INFINITE);

            zhuanquan.clearAnimation();
            zhuanquan.startAnimation(animation);
        }
    }

    private void searchAmapLocation(boolean succeed,boolean isOver, final String areaName){


        if (isOver){
            // pbAreaLocation.setVisibility(View.GONE);
            // tvAreaLocation.setVisibility(View.VISIBLE);
            if (succeed){
                //  tvAreaLocation.setText("当前位置\n"+areaName);
            }else {
                //  tvAreaLocation.setText(areaName);
            }
//            llLocationTip.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    llLocationTip.setVisibility(View.GONE);
//                }
//            },1000);
        }else {
            //  llLocationTip.setVisibility(View.VISIBLE);
            // pbAreaLocation.setVisibility(View.VISIBLE);
            //  tvAreaLocation.setVisibility(View.INVISIBLE);
        }

    }
    private void stopAnima(){
        if(showView!=null) {
            View zhuanquan = showView.findViewById(R.id.iv_zhuanquan);
            zhuanquan.clearAnimation();
        }
    }


    private boolean isLocationing=false;
    private void startLocation(){
        startLocationAnime();
        isLocationing=true;
        if (simpleLocationUtil == null){
            simpleLocationUtil = new SimpleLocationUtil(((Activity) selectorInfo.getContext()).getApplication());
        }


        simpleLocationUtil.getLocation(new SimpleLocationUtil.OnLocationListener() {


            boolean oneTime=false;
            @Override
            public void onLocationSucceed(AMapLocation aMapLocation) {



                if(oneTime){
                    return;
                }
                oneTime=true;
                if(isDismissed){
                    return;
                }
                if (aMapLocation == null){
                    return;
                }
                isLocationing=false;

                stopAnima();
                simpleLocationUtil.onStopLocation();
                String province = aMapLocation.getProvince();
                if (zhixiashi.contains(province) ){
                    if(province.endsWith("市")){
                        province = province.substring(0, province.length() - 1);
                    }
                }

                String city = aMapLocation.getCity();
                String district = aMapLocation.getDistrict();


                mAmapLocation = new SelectedLocation();
                mAmapLocation.setPro(new LocationInfo());
                mAmapLocation.setCity(new LocationInfo());
                mAmapLocation.setCounty(new LocationInfo());

                mAmapLocation.getPro().setmName(province);
                mAmapLocation.getCity().setmName(city);
                mAmapLocation.getCounty().setmName(district);
                locationFailedMessage="";
                //  showLastAreaRecord(mAmapLocation);
                String locationName = getLocationName(mAmapLocation);
                // myLocation=locationName;
                aMapLocationInfo.setText(locationName);
                searchAmapLocation(true,true,locationName);
            }

            @Override
            public void onLocationFail(String errorInfo) {

                if(oneTime){
                    return;
                }
                oneTime=true;
                if(isDismissed){
                    return;
                }
                stopAnima();
                mAmapLocation=null;
                simpleLocationUtil.onStopLocation();
                locationFailedMessage="位置刷新失败,请检查网络";
                aMapLocationInfo.setText("位置刷新失败,请检查网络");
                searchAmapLocation(false,true,"位置刷新失败,请检查网络");
                //   ToastUtil.showCenterToast(selectorInfo.getContext(),"定位失败");
                isLocationing=false;

            }
        });
    }

    //点击定位
    SimpleLocationUtil simpleLocationUtil;
    private static SelectedLocation mAmapLocation;
    private static String locationFailedMessage="";
    @Override
    public void onClick(View view) {
        if ( ! CheckIsOperate.checkViewIsClick(view,(Activity)view.getContext())){ //不可频繁点击
            //    ToastUtil.showCenterToast(selectorInfo.getContext(),"点击频繁");
            return;
        }
        switch (view.getId()){
            case R.id.tv_location_fresh:
                if(!isLocationing) {
                    searchAmapLocation(false, false, "");

                    startLocation();
                }
                break;
            case R.id.tv_location_info:
                if (!TextUtils.isEmpty(aMapLocationInfo.getText().toString())){
                    selectorInfo.setSelectLocation(mAmapLocation);
                    onAreaSelectorCallback.onSelectedArea(selectorInfo);
                    dismissSelector();
                }
                break;
        }
    }

    /**
     * 闪烁动画
     * @param view
     */
    private void twinkle(View view){
        AlphaAnimation alphaAnimation= new AlphaAnimation(0.1f, 1.0f);
        alphaAnimation.setDuration(3000);
        alphaAnimation.setRepeatCount(Animation.INFINITE);
        alphaAnimation.setRepeatMode(Animation.REVERSE);
        view.setAnimation(alphaAnimation);
        alphaAnimation.start();
    }


    private class HostAdapter extends BaseAdapter {

        private Context mContext;
        private List<HostoryLocation> mList;

        public HostAdapter(Context mContext, List<HostoryLocation> mMap) {
            super();
            this.mContext = mContext;
            this.mList = mMap;
        }

        public void refreshData(List<HostoryLocation> myLinkedHashMap) {
            this.mList = myLinkedHashMap;
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public Object getItem(int position) {
            if (mList.size() > position) {
                return mList.get(position);
            }
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            LayoutInflater inflate = LayoutInflater.from(mContext);
            if (convertView == null) {
                convertView = inflate.inflate(R.layout.item_hostory, null);
            }
            TextView mStartName = ViewHolder.get(convertView,R.id.tv_start_area);
            TextView mEndName =ViewHolder.get(convertView,R.id.tv_end_area);
            TextView mStartRange =ViewHolder.get(convertView,R.id.tv_start_range);
            TextView mEndRange =ViewHolder.get(convertView,R.id.tv_end_range);
            View search_hostory_delect =ViewHolder.get(convertView,R.id.ibtn_hostory_delect);

            final HostoryLocation mHostary = (HostoryLocation) mList.get(position);
            SelectedLocation start = mHostary.getmStartLocation();
            SelectedLocation end = mHostary.getmDestLocation();
            if (start != null){
                mStartName.setText(mHostary.getmStartLocationName());
                mStartRange.setText(start.getRange()+"公里");
                mStartRange.setVisibility(View.VISIBLE);
            }else {
                mHostary.setmStartLocationName("全国");
                mStartName.setText("全国");
                mStartRange.setVisibility(View.GONE);
            }

            if (end != null){
                mEndName.setText(mHostary.getmDestLocationName());
                mEndRange.setText(end.getRange()+"公里");
                mEndRange.setVisibility(View.VISIBLE);
            }else {
                mHostary.setmDestLocationName("全国");
                mEndName.setText("全国");
                mEndRange.setVisibility(View.GONE);
            }


            search_hostory_delect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mList.remove(position);
                    generationAreaHostory();
                }
            });
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onAreaSelectorCallback.onSelectedHostroy(mHostary);
                    dismissSelector();
//                    YouMengUtils.updateIdOnNewPageAndEvent(v.getContext(),PAGE_NAME,"openGoodsItem");  TODO
                }
            });

            return convertView;
        }



    }




    private FrameLayout contentView;
    private  View maskView;
    private View ContentView;
    private boolean isUnfold;
    private View flag;
    private FrameLayout rootView;
    private View popcontent;


    /**
     * 顶部popwin
     * @param postionView
     */
    public void extractionViewForPop(final View postionView ){
        CommonOperate.backgroundAlpha(((Activity)postionView.getContext()),0.5f,postionView);
        if (popupWindow != null){
            updateForView();
            popupWindow.showAsDropDown(postionView,0,0);
            return;
        }
        if (showView == null){
            initRootView();
            showEither(true);
        }
        if (showView.getParent() != null){
            ViewGroup parent = (ViewGroup) showView.getParent();
            parent.removeView(showView);
        }
        if (popupWindow == null){
            initPopStyle();// 设置显示的效果
        }
        if (flag == postionView){
            if (isUnfold){
                dismissSelector();
                return;
            }
        }else {
            routineAreaPage.initSingleView();
        }
        updateForView();
        flag = postionView;
        this.popcontent = showView;
        isUnfold =true;  //TODO 展开
        postionView.setSelected(true);
        //更新内容
        popupWindow.setAnimationStyle(R.style.PopupWindowAnimation);
        popupWindow.showAsDropDown(postionView,0,0);
    }

    private Animation.AnimationListener animationListener;
    /**
     * 顶部view
     * @param popView
     * @param postionView
     */
    public void extractionView(final View popView,final View postionView ){
        if (flag == postionView){
            if (isUnfold){
                dismissSelector();
                return;
            }
        }else {
            updateItemPageContent( routineAreaPage.initSingleView());
            if (viewPager != null){
                viewPager.requestLayout();
            }
        }
        updateForView(); //更新view数据

        flag = postionView;
        this.popcontent = popView;
        popcontent.setVisibility(View.VISIBLE);
        if (contentView == null){
            contentView = new FrameLayout(flag.getContext()){};
            contentView.setLayoutParams( new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = ((Activity)contentView.getContext()).getWindowManager();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int screen_w = displayMetrics.widthPixels;
            int screen_h = displayMetrics.heightPixels;
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,(int)(screen_h*0.7));
            popcontent.setLayoutParams(layoutParams);

            //遮罩颜色
            maskView = new View(flag.getContext());
            int maskColor = 0x88888888;
            maskView.setBackgroundColor(maskColor);
            maskView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
            rootView = (FrameLayout) ((Activity)flag.getContext()).getWindow().getDecorView();
            isUnfold =true;  //TODO 展开
            postionView.setSelected(isUnfold);
        }

        int[] ints = new int[2];
        flag.getLocationInWindow(ints);
        contentView.setY(ints[1]+flag.getHeight()-1);
        maskView.setY(flag.getHeight());


        CommonOperate.backgroundAlpha(((Activity)postionView.getContext()),0.5f,postionView);
        addVeiw(contentView,maskView);
        addVeiw(contentView,popView);
        addVeiw(rootView,contentView);
        contentView.bringChildToFront(popView);
        contentView.updateViewLayout(popView,popView.getLayoutParams());
        popView.setAnimation(AnimationUtils.loadAnimation(flag.getContext(), R.anim.dd_menu_in)); //展开菜单
        rootView.bringChildToFront(contentView);
        isUnfold =true;  //TODO 展开
        maskView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAreaSelectorCallback.onSelectedcancel(null);
                dismissSelector();
            }
        });
        postionView.setSelected(isUnfold);
    }


    private void addVeiw(ViewGroup group,View v){
        if (v.getParent() == null){
            group.addView(v);
        }
        v.setVisibility(View.VISIBLE);
    }

    private void removeContentView(View v){

        rootView.removeView(v);
    }

    /**
     * 隐藏顶部弹出view
     */
    private void closeTopView(){
        if (contentView == null)
            return;
        maskView.setVisibility(View.GONE);
        popcontent.setVisibility(View.GONE);
        popcontent.setAnimation(AnimationUtils.loadAnimation(contentView.getContext(), R.anim.dd_menu_out));
        isUnfold = false;
        if (flag !=null){
            flag.setSelected(false);
        }
//        removeContentView(contentView);
    }


    public String getLocationName(SelectedLocation location) {

        if (location == null || location.getPro() == null) {
            return "";
        }
        if("全国".equals(location.getPro().getName())){
            return "全国";
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

    public interface OnAdapterListener{
        void onAdaperListener();
    }

    public void onDesttroy(){
        if (rootView != null){
            rootView.removeAllViews();
            rootView = null;
            if (contentView!=null){
                contentView.removeAllViews();
                contentView =null;
            }
        }
    }



}