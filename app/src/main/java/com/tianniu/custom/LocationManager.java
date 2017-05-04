package com.tianniu.custom;


import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import android.content.Context;

import com.tianniu.custom.model.LocationDatabaseHelper;
import com.tianniu.custom.model.LocationInfo;
import com.tianniu.custom.model.SelectedLocation;

public class LocationManager {

    private static LocationManager mLocationHandler;
    private Context mContext;
    private LocationManager(Context context) {
        mContext = context;
    }


    public synchronized static LocationManager getInstance(Context context) {
        if (mLocationHandler == null) {
            mLocationHandler = new LocationManager(context);
        }
        return mLocationHandler;
    }

    public void initLoationInfoFordb(){
        LocationDatabaseHelper helper=new LocationDatabaseHelper(mContext);
        helper.loadInitLocationDatabases(mContext);
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


    private List<LocationInfo> provinces;


    private Map<String, SoftReference<List<LocationInfo>>> cityMap = new HashMap<String, SoftReference<List<LocationInfo>>>();
    private Map<String, SoftReference<List<LocationInfo>>> areaMap = new HashMap<String, SoftReference<List<LocationInfo>>>();

    public List<LocationInfo> getProvinces(){
        if(provinces ==null){
            provinces=getProvinceListFromDB();
        }
        return provinces;
    }

    public List<LocationInfo> getCity(String key) {
        SoftReference<List<LocationInfo>> srList = cityMap.get(key);
        if (srList != null) {

            List<LocationInfo> cityList = srList.get();
            if (cityList != null) {
                return cityList;
            }
        }

        //只要走到这里，说明没有获取正确的数据，需要重新获取
        List<LocationInfo> cityList = getCityListFromDB(key);

        SoftReference<List<LocationInfo>> temp = new SoftReference<List<LocationInfo>>(cityList);

        cityMap.put(key, temp);
        return cityList;
    }


    public List<LocationInfo> getArea(String key) {
        SoftReference<List<LocationInfo>> srList = areaMap.get(key);
        if (srList != null) {

            List<LocationInfo> areaList = srList.get();
            if (areaList != null) {
                return areaList;
            }
        }

        //只要走到这里，说明没有获取正确的数据，需要重新获取
        List<LocationInfo> areaList = getAreaListFromDB(key);

        SoftReference<List<LocationInfo>> temp = new SoftReference<List<LocationInfo>>(areaList);

        areaMap.put(key, temp);
        return areaList;
    }

    private List<LocationInfo> getAreaListFromDB(String key) {
        LocationDatabaseHelper helper=new LocationDatabaseHelper(mContext);
        return helper.getAreaListFromDB(key);
    }

    private List<LocationInfo> getCityListFromDB(String key) {
        LocationDatabaseHelper helper=new LocationDatabaseHelper(mContext);
        return helper.getCityListFromDB(key);
    }


    private List<LocationInfo> getProvinceListFromDB() {
        LocationDatabaseHelper helper=new LocationDatabaseHelper(mContext);
        return helper.getProvinceListFromDB();
    }

}
