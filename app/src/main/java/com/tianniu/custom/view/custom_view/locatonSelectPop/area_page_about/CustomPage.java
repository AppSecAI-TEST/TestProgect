package com.tianniu.custom.view.custom_view.locatonSelectPop.area_page_about;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tianniu.custom.OpApplication;
import com.tianniu.custom.core.CommonResources;
import com.tianniu.custom.model.LocationInfo;
import com.tianniu.custom.model.SearchDistanceParam;
import com.tianniu.custom.model.SelectedLocation;
import com.tianniu.custom.view.custom_view.GridSpacingItemDecoration;
import com.tianniu.custom.view.custom_view.locatonSelectPop.OnAreaSelectorListener;
import com.tianniu.up.testprogect.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/10 0010.
 */

public class CustomPage implements AreaPage{
    /**
     * 外部回调数据
     */
    private OnAreaSelectorListener onAreaSelectorListener;

    private List<View> areaViews;
    private LayoutInflater mInflater;

    private SearchDistanceParam startDistanceDefaultValue;
    private SearchDistanceParam destDistanceDefaultValue;
    private List<SearchDistanceParam> mStartDistances;
    private List<SearchDistanceParam> mDestDistances;
    private View rangeView;


    private final int PROVINCE = 0,CITY = 1,COUNTY = 2,NEARBY = 9;


    /**
     * 传递的参数
     */
    private SelectorInfo selectorInfo;
    private RangeAdapter rangeAdapter;

    private  String selectedToponymy;
    private SelectedLocation selectedArea;
    private SelectorGridAdapter provinceAadpter;
    private SelectorGridAdapter countyAdapter;
    private SelectorGridAdapter cityAdapter;
    private ViewGroup cityView;
    private ViewGroup provinceView;
    private ViewGroup countyView;
    /**
     * 是否显示范围，默认不显示
     */
    private  boolean showRange;
    private  boolean showNearby;
    private  boolean showQuanguo;
    private RecyclerView provinceRecyclerView;
    private RecyclerView cityRecyclerView;
    private RecyclerView countyRecyclerView;
    private Handler mhandler;
    private TextView tvAreaRangeTitle;
    private RecyclerView recyclerView;
    private boolean showQuansheng;
    private LocationInfo currentQuansheng;
    private boolean isZhixia;
    private Context context;


    public CustomPage() {

    }

    public void initParam(SelectorInfo selectorInfo, OnAreaSelectorListener onAreaSelectorListener){
        this.selectorInfo =selectorInfo;
        this.showQuanguo = selectorInfo.isShowQuanguo();
        this.showRange = selectorInfo.isShowRange();
        this.showNearby = selectorInfo.isShowNearby();
        showQuansheng = selectorInfo.isShowQuansheng();
        this.selectedToponymy = selectorInfo.getSelectedToponymy();
        this.selectedArea = selectorInfo.getSelectLocation();

        if (selectedArea == null){
            selectedArea = new SelectedLocation();
            selectorInfo.setSelectLocation(selectedArea);
        }

        this.context = selectorInfo.getContext();
        if (mInflater == null){
            mInflater = LayoutInflater.from(context);
        }
        this.onAreaSelectorListener = onAreaSelectorListener;
        initResouse();
    }




    private void initResouse() {
        OpApplication application = (OpApplication) ((Activity)context).getApplication();
        CommonResources commonResources = application.getCommonResources();
        if (startDistanceDefaultValue == null)
            startDistanceDefaultValue = commonResources.getStartDistanceDefaultValue();
        if (destDistanceDefaultValue == null)
            destDistanceDefaultValue = commonResources.getDestDistanceDefaultValue();
        if (mStartDistances == null)
            mStartDistances = commonResources.getStartDistances();
        if (mDestDistances == null)
            mDestDistances = commonResources.getDestDistances();
        openRangeSelector(null);//提前初始化view
    }


    /**
     * 设置地区信息
     * @param areaType
     * @param locationInfo
     */
    private void setAreaInfo(boolean showRange,int areaType,LocationInfo locationInfo){
        switch (areaType){
            case PROVINCE:
                LocationInfo pro = selectedArea.getPro();
                if (pro == locationInfo){
                    return;
                }else {
                    selectedArea.setPro(locationInfo);
                    selectedArea.setCity(null);
                    selectedArea.setCounty(null);
                }

                break;
            case CITY:
                LocationInfo city = selectedArea.getCity();
                if (city == locationInfo){
                    return;
                }else {
                    selectedArea.setCity(locationInfo);
                    selectedArea.setCounty(null);
                }
                if (showRange){
                    LocationInfo county = selectedArea.getCounty();
                    if (county == locationInfo){
                        return;
                    }else {
                        selectedArea.setCounty(locationInfo);
                        selectedArea.setX(locationInfo.getPx());
                        selectedArea.setY(locationInfo.getPy());
                    }
                    break;
                }
                break;
            case COUNTY:
                LocationInfo county = selectedArea.getCounty();
                if (county == locationInfo){
                    return;
                }else {
                    selectedArea.setCounty(locationInfo);
                    selectedArea.setX(locationInfo.getPx());
                    selectedArea.setY(locationInfo.getPy());
                }
                break;
        }
        selectorInfo.setSelectLocation(selectedArea);
    }


    /**
     * 生成页面
     * @param pageIndex
     * @param locations
     * @return
     */
    public List<View> generationRootView(boolean quanshi,int pageIndex, List<LocationInfo> locations,String selectedToponymy) {
        if (areaViews == null){
            areaViews = new ArrayList<>();
        }

        ViewGroup rootView = null;
        SelectorGridAdapter adapter = null;
        RecyclerView recyclerView = null;
        switch (pageIndex){
            case PROVINCE:
                provinceView = (ViewGroup) mInflater.inflate(R.layout.ll_page_selector_item, null);
                rootView = provinceView;
                provinceRecyclerView = (RecyclerView)rootView.findViewById(R.id.recyclerView_area);
                recyclerView = provinceRecyclerView;
                provinceAadpter = new SelectorGridAdapter(quanshi,pageIndex,context, locations, selectedToponymy);
                adapter = provinceAadpter;
                break;
            case CITY:
                cityView = (ViewGroup) mInflater.inflate(R.layout.ll_page_selector_item, null);
                rootView = cityView;
                cityRecyclerView = (RecyclerView)rootView.findViewById(R.id.recyclerView_area);
                recyclerView = cityRecyclerView;
                cityAdapter = new SelectorGridAdapter(quanshi,pageIndex,context, locations, selectedToponymy);
                adapter = cityAdapter;

                break;
            case COUNTY:
                countyView = (ViewGroup) mInflater.inflate(R.layout.ll_page_selector_item, null);
                rootView = countyView;
                countyRecyclerView = (RecyclerView)rootView.findViewById(R.id.recyclerView_area);
                recyclerView = countyRecyclerView;
                countyAdapter = new SelectorGridAdapter(quanshi,pageIndex,context, locations, selectedToponymy);
                adapter = countyAdapter;
                break;
        }
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(context,4));
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(context,0,0));
        recyclerView.setAdapter(adapter);
        areaViews.add(rootView);

        return areaViews;
    }




    /**
     * @param endPoint
     * @param areas
     * @param flag
     */
    public List<View>  notifyUpdateCounty(boolean endPoint,List<LocationInfo> areas,String flag) {

        if (countyView!= null && countyAdapter != null){
            countyAdapter.updateData(endPoint,areas,flag);
            if (areaViews.size()==2){
                areaViews.add(countyView);
            }
        }else {
            generationRootView(endPoint,COUNTY,areas,flag);
        }
        if (endPoint && showRange){
            openRangeSelector(countyView);
        }else {
            closeRangeSelector(provinceView);
        }
        return areaViews;
    }

    /**
     * @param endPoint
     * @param areas
     * @param flag
     */
    public List<View> notifyUpdateCity(boolean isZhixia,boolean endPoint, List<LocationInfo> areas, String flag) {
        if (selectorInfo.isShowQuansheng() && !isZhixia){
            if (currentQuansheng == null){
                currentQuansheng = new LocationInfo();
            }
            if (areas.get(0).getName().equals("全省")){
                areas.remove(0);
            }
            if (!areas.get(0).getName().equals("全省")){
                LocationInfo pro = provinceAadpter.getCurrentLocation();
                if (pro != null){
                    currentQuansheng = pro;
                    LocationInfo locationInfo = new LocationInfo();
                    locationInfo.setmCoord(pro.getmCoord());
                    locationInfo.setmLatidude(pro.getmLatidude());
                    locationInfo.setmLongitude(pro.getmLongitude());
                    locationInfo.setPx(pro.getPx());
                    locationInfo.setPy(pro.getPy());
                    locationInfo.setmName("全省");
                    areas.add(0, locationInfo);
                }
            }

        }else {
            if (areas.get(0).getName().equals("全省")){
                areas.remove(0);
            }
        }

        if (cityView != null && cityAdapter != null) {
            cityAdapter.updateData(endPoint, areas, flag);
            if (areaViews.size() == 1) areaViews.add(CITY, cityView);
        } else {
            generationRootView(endPoint, CITY, areas,flag);
        }


        if (endPoint && showRange) {
            openRangeSelector(cityView);
            if (areaViews != null && areaViews.size() == 3) { //城市界面显示范围，肯定就是直辖
                areaViews.remove(countyView);
                countyAdapter = null;
                countyView = null;
            }
        } else {
            closeRangeSelector(cityView);
        }
        return areaViews;
    }

    /**
     * @param endPoint
     * @param areas
     * @param flag
     */
    public List<View> notifyUpdateProvince(boolean endPoint,List<LocationInfo> areas,@NonNull String flag) {
        if (showQuanguo){
            if (!areas.get(0).getName().equals("全国")){ //添加全国Item
                LocationInfo quanguo = new LocationInfo();
                quanguo.setmName("全国");
                areas.add(0,quanguo);
            }
        }else {
            if (areas.get(0).getName().equals("全国")){
                areas.remove(0);
            }
        }

        if (showNearby){
            if (!areas.get(0).getName().equals("附近")){ //板车维修
                LocationInfo nearby = new LocationInfo();
                nearby.setmName("附近");
                areas.add(0,nearby);
            }
        }else {
            if (areas.get(0).getName().equals("附近")){
                areas.remove(0);
            }
        }

        if (provinceView != null && provinceAadpter != null){
            provinceAadpter.updateData(endPoint,areas,flag);
        }else {
            generationRootView(endPoint,PROVINCE,areas,flag);
        }
        if (endPoint && showRange){
            openRangeSelector(provinceView);
        }else {
            closeRangeSelector(provinceView);
        }
        if (areaViews != null  && areaViews.size() == 3){
            areaViews.remove(countyView);
        }
        return areaViews;
    }

    /**
     * 初始到1个页面
     */
    public List<View> initSingleView() {
        if (areaViews != null){
            areaViews.clear();
            areaViews.add(provinceView);
        }
        return areaViews;
    }




    /**
     * grid 地区adapter
     */
    public class SelectorGridAdapter extends  RecyclerView.Adapter{
        private Context mContext;
        private List<LocationInfo> mItemInfos = new ArrayList<>();
        private TextView hostoryView;
        private String mSelectedStr;
        private int pageIndex;
        private  boolean isEndPoint;
        private LocationInfo currentLocation;

        private SelectorGridAdapter(boolean showuanshi,int pageIndex,Context mContext, List<LocationInfo> infos, String selected) {
            this.mContext = mContext;
            this.isEndPoint = showuanshi;
            mItemInfos.clear();
            this.pageIndex = pageIndex;
            if (infos != null){
                mItemInfos.addAll(infos);
            }
            this.mSelectedStr =selected;
        }


        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View itemView = layoutInflater.inflate(R.layout.pop_text_item, parent, false);
            TextView areaTv = (TextView) itemView.findViewById(R.id.tv_area_info);

            return new ViewHolder(itemView);
        }

        /**
         *
         * @param currentView
         */
        private void setItemViewStatus(TextView currentView){

            if (hostoryView == currentView){
                return;
            }
            currentView.setSelected(true);
            currentView.setTextColor(ContextCompat.getColor(context,R.color.dialog_btn_color));

            if (hostoryView != null){
                hostoryView.setSelected(false);
                hostoryView.setTextColor(ContextCompat.getColor(context,R.color.black_text));
            }
            hostoryView = currentView;

            if (hostoryView == currentView){
                return;
            }
            currentView.setBackgroundResource(R.drawable.gray_border_selected);
            currentView.setSelected(true);
            TextView textView = (TextView) currentView.findViewById(R.id.tv_area_info);
            textView.setTextColor(ContextCompat.getColor(context,R.color.dialog_btn_color));

            if (hostoryView != null){
                hostoryView.setBackgroundResource(android.R.color.transparent);
                hostoryView.setSelected(false);
                TextView hostoryText = (TextView)  hostoryView.findViewById(R.id.tv_area_info);
                hostoryText.setTextColor(ContextCompat.getColor(context,R.color.black_text));
            }
            hostoryView = currentView;
        }


        @Override
        public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
            View itemView = holder.itemView;
            LocationInfo locationInfo = mItemInfos.get(position);
            String contentStr = locationInfo.getName();

            TextView textView = (TextView)itemView.findViewById(R.id.tv_area_info);
            textView.setBackgroundResource(R.drawable.area_select_item_background);
            textView.setText(contentStr);

            if (isEndPoint ){
                if (position == 0 ){
                    textView.setText("全市");
                }
            }

            if (contentStr.equals("全国") && TextUtils.isEmpty(mSelectedStr)){
                setItemViewStatus(textView);
                currentLocation = locationInfo;
                setAreaInfo(isEndPoint,pageIndex,locationInfo);
            }else{
                if (!TextUtils.isEmpty(mSelectedStr) && mSelectedStr.contains(contentStr)){
                    currentLocation = locationInfo;
                    setItemViewStatus(textView);
                }
            }


            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    TextView textView = (TextView)v.findViewById(R.id.tv_area_info);
                    setItemViewStatus(textView);
                    String areaName = textView.getText().toString();
                    LocationInfo locationInfo = mItemInfos.get(holder.getAdapterPosition());
                    currentLocation = locationInfo;
                    if (areaName.equals("全国")){
                        selectedArea.setPro(null);
                        selectedArea.setCity(null);
                        selectedArea.setCounty(null);
                        selectorInfo.setSelectLocation(selectedArea);
                        onAreaSelectorListener.onSelectedArea(selectorInfo);
                        return;
                    }
                    if (areaName.equals("全省")){
                        selectedArea.setPro(currentQuansheng);
                        selectedArea.setCity(currentQuansheng);
                        selectedArea.setCounty(currentQuansheng);
                        selectorInfo.setSelectLocation(selectedArea);
                        onAreaSelectorListener.onSelectedArea(selectorInfo);
                        return;
                    }
                    setAreaInfo(isEndPoint,pageIndex,locationInfo);
                    onAreaSelectorListener.onSelectLocationListener(selectedArea);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mItemInfos.size();
        }


        public void updateData(boolean showQuanshi,List<LocationInfo> infos, String selected) {
            this.isEndPoint =showQuanshi;
            mItemInfos.clear();
            if (infos != null){
                mItemInfos.addAll(infos);
            }
            this.mSelectedStr =selected;
            notifyDataSetChanged();
        }

        public LocationInfo getCurrentLocation() {
            return currentLocation;
        }


        class ViewHolder extends RecyclerView.ViewHolder{
            public ViewHolder(View itemView) {
                super(itemView);
            }
        }
    }

    private void closeRangeSelector(View areaView){

        if (areaView == null){
            return;
        }
        ViewGroup layout = (ViewGroup) areaView.findViewById(R.id.ll_range_selector);
        if (layout != null) {
            if (rangeView.getParent() != null) {
                ((ViewGroup)rangeView.getParent()).removeView(rangeView);
            }
            layout.setVisibility(View.GONE);
        }
    }

    /**
     * 显示范围
     */
    public void openRangeSelector(View areaView) {
        if (rangeView == null) {
            rangeView = mInflater.inflate(R.layout.ll_range_selector, null);
            tvAreaRangeTitle = (TextView) rangeView.findViewById(R.id.tv_area_range_title);
        }
        if(rangeAdapter == null && recyclerView ==null){
            recyclerView = (RecyclerView) rangeView.findViewById(R.id.rv_range_selector);
            recyclerView.setLayoutManager(new GridLayoutManager(this.context, 4));
            recyclerView.addItemDecoration(new GridSpacingItemDecoration(this.context, 0, 0));

            rangeAdapter = new RangeAdapter(selectedArea.getRange());
            rangeAdapter.setCurrentData();
            recyclerView.setAdapter(rangeAdapter);
        }else {
            rangeAdapter.update(selectedArea.getRange());
        }

        if (areaView == null){
            return;
        }
        ViewGroup layout = (ViewGroup) areaView.findViewById(R.id.ll_range_selector);
        layout.setVisibility(View.VISIBLE);
        if (layout != null) {
            if (rangeView.getParent() != null) {
                ((ViewGroup)rangeView.getParent()).removeView(rangeView);
            }
            layout.addView(rangeView);
        }
    }

    private void setTwinkle(final View obj){
        obj.setBackgroundResource(R.drawable.area_scope_recording);
        final AnimationDrawable animationDrawable = (AnimationDrawable) obj.getBackground();
        animationDrawable.start();

        if (mhandler  == null) {
            mhandler = new Handler(){
                @Override
                public void handleMessage(Message msg) {
                    switch (msg.what){
                        case 999:
                            animationDrawable.stop();
                            obj.setBackgroundResource(R.color.white);
//                            obj.setBackgroundResource(R.color.transparent);
                            break;
                    }
                }
            };
        }
        mhandler.sendEmptyMessageDelayed(999,600);
    }




    /**
     * 地区范围选择
     */
    private class RangeAdapter extends RecyclerView.Adapter{
        private String mSelectedStr="300";
        private TextView hostoryView;
        private  int startOrEnd;

        public RangeAdapter(String selectedStr) {
            startOrEnd = selectorInfo.getStartOrEnd();
            if (TextUtils.isEmpty(selectedStr)){
                if (startOrEnd == 0){
                    this.mSelectedStr = startDistanceDefaultValue.getDistance();
                }else {
                    this.mSelectedStr = destDistanceDefaultValue.getDistance();
                }
            }else {
                this.mSelectedStr = selectedStr;
            }

            if(TextUtils.isEmpty( this.mSelectedStr)){
                this.mSelectedStr="300";
            }
            selectedArea.setRange(mSelectedStr); //设置默认范围
        }

        List<SearchDistanceParam> tempList = new ArrayList<SearchDistanceParam>();

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View itemView = layoutInflater.inflate(R.layout.pop_text_item, parent, false);
            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder,final int position) {
            View itemView = holder.itemView;
            TextView textView = (TextView)itemView.findViewById(R.id.tv_area_info);
            String contentStr = tempList.get(position).getDistanceDisplayText();
            textView.setBackgroundResource(R.drawable.area_select_item_background);
            if (contentStr.equals(mSelectedStr+"公里")){
                tvAreaRangeTitle.setText(startOrEnd == 0? "出发地范围为以上选定区域"+mSelectedStr+"公里":"目的地范围为以上选定区域"+mSelectedStr+"公里");
                setItemViewStatus(textView);
            }

            textView.setText(contentStr);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setItemViewStatus((TextView) v);
                    String distance = tempList.get(position).getDistance();
                    if (!TextUtils.isEmpty(distance)){
                        selectedArea.setRange(distance);
                    }
                    if (selectedArea.getCounty() == null){
                        RecyclerView recyclerView = (RecyclerView) areaViews.get(areaViews.size() - 1).findViewById(R.id.recyclerView_area);
                        setTwinkle(recyclerView);
                        return;
                    }
                    onAreaSelectorListener.onSelectedArea(selectorInfo);
                }
            });
        }

        /**
         *
         * @param currentView
         */
        private void setItemViewStatus(TextView currentView){
            if (hostoryView == currentView){
                return;
            }
            currentView.setSelected(true);
            currentView.setTextColor(ContextCompat.getColor(context,R.color.dialog_btn_color));

            if (hostoryView != null){
                hostoryView.setSelected(false);
                hostoryView.setTextColor(ContextCompat.getColor(context,R.color.black_text));
            }
            hostoryView = currentView;
        }

        @Override
        public int getItemCount() {
            return tempList.size();
        }

        public void update(String range) {
            setCurrentData();
            tvAreaRangeTitle.setText(startOrEnd == 0? "出发地范围为以上选定区域"+mSelectedStr+"公里":"目的地范围为以上选定区域"+mSelectedStr+"公里");
            startOrEnd = selectorInfo.getStartOrEnd();
            if (TextUtils.isEmpty(range)){
                if (startOrEnd == 0){
                    this.mSelectedStr = startDistanceDefaultValue.getDistance();
                }else {
                    this.mSelectedStr = destDistanceDefaultValue.getDistance();
                }
            }else {
                this.mSelectedStr = range;
            }
            selectedArea.setRange(mSelectedStr); //设置默认范围


            notifyDataSetChanged();
        }


        class ViewHolder extends RecyclerView.ViewHolder{
            public ViewHolder(View itemView) {
                super(itemView);
            }
        }

        public void setCurrentData() {
            if (mStartDistances == null || mStartDistances.size() == 0){
                initResouse();
            }
            tempList.clear();
            if (selectorInfo.getStartOrEnd() == 0) {
                tempList.addAll(mStartDistances);
            } else {
                tempList.addAll(mDestDistances);
            }
        }
    }

}

