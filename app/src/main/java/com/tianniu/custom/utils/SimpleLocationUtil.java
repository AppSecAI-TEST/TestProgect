package com.tianniu.custom.utils;

import android.app.Application;
import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationClientOption.AMapLocationMode;
import com.amap.api.location.AMapLocationListener;

public class SimpleLocationUtil {




    private AMapLocation location;
    private AMapLocationClientOption aMapLocationClientOption;

    public AMapLocation getLocation() {
        return location;
    }

    public void setLocation(AMapLocation location) {
        this.location = location;
    }





    private Application mApplication;
    public AMapLocationClient aMapLocationClient;

    public SimpleLocationUtil(Application mApplication) {
        super();
        this.mApplication = mApplication;
        ininParams(60000);
    }

    public SimpleLocationUtil(Application mApplication, int time) {
        super();
        this.mApplication = mApplication;
        ininParams(time);
    }
    /**
     * 初始化参数
     */
    private void ininParams(int time) {
        aMapLocationClient = new AMapLocationClient(mApplication);

        // 设置定位参数配置
        aMapLocationClientOption = new AMapLocationClientOption();
        aMapLocationClientOption.setLocationMode(AMapLocationMode.Battery_Saving);// Battery_saving
        // 节电模式
        // Hight
        // accuracy高精度模式
        // device
        // sensors
        // 设备传感器模式
        aMapLocationClientOption.setNeedAddress(true);// 是否需要地址信息
        aMapLocationClientOption.setOnceLocation(false);// 是否只定位一次，默认false
        aMapLocationClientOption.setWifiActiveScan(true);// 是否强制刷新wifi
        aMapLocationClientOption.setMockEnable(false);// 是否允许模拟位置
        aMapLocationClientOption.setInterval(time);// 设置定位时间间隔
        aMapLocationClientOption.setLocationCacheEnable(false);
        aMapLocationClient.setLocationOption(aMapLocationClientOption);

    }




    /**
     *
     */
    public void getLocation(final OnLocationListener onLocationListener) {

        aMapLocationClient.setLocationListener(new AMapLocationListener() {

            @Override
            public void onLocationChanged(AMapLocation amapLocation) {
                if (amapLocation != null) {
                    if (amapLocation.getErrorCode() == 0) {
                        onLocationListener.onLocationSucceed(amapLocation);//回调结果
                        // 定位成功回调信息，设置相关消息
//						amapLocation.getLocationType();// 获取当前定位结果来源，如网络定位结果，详见定位类型表
//						amapLocation.getLatitude();// 获取纬度
//						amapLocation.getLongitude();// 获取经度
//						amapLocation.getAccuracy();// 获取精度信息
//						SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//						Date date = new Date(amapLocation.getTime());
//						df.format(date);// 定位时间
//						amapLocation.getAddress();// 地址，如果option中设置isNeedAddress为false，则没有此结果
//						amapLocation.getCountry();// 国家信息
//						amapLocation.getProvince();// 省信息
//						amapLocation.getCity();// 城市信息
//						amapLocation.getDistrict();// 城区信息
//						amapLocation.getRoad();// 街道信息
//						amapLocation.getCityCode();// 城市编码
//						amapLocation.getAdCode();// 地区编码
                        //	aMapLocationClient.stopLocation();
                    } else {
                        onLocationListener.onLocationFail("location Error, ErrCode:" + amapLocation.getErrorCode() + ", errInfo:" + amapLocation.getErrorInfo());
                        // 显示错误信息ErrCode是错误码，errInfo是错误信息，详见错误码表。
                        Log.e("AmapError", "location Error, ErrCode:" + amapLocation.getErrorCode() + ", errInfo:" + amapLocation.getErrorInfo());
                    }
                }
            }
        });
        aMapLocationClient.startLocation();
    }


    public void onStopLocation() {
        if (aMapLocationClient != null) {
            aMapLocationClient.stopLocation();
        }
    }

    public void  setRequestTimeout(long lon){
        if (aMapLocationClientOption != null){
            aMapLocationClientOption.setHttpTimeOut(lon);
            aMapLocationClient.setLocationOption(aMapLocationClientOption);
        }
    }


    public void onDestroyLocation() {
        if (aMapLocationClient != null) {
            aMapLocationClient.stopLocation();
            aMapLocationClient.onDestroy();
        }
    }

    public void stopLocation(){
        if (aMapLocationClient != null) {
            aMapLocationClient.stopLocation();
        //    aMapLocationClient.onDestroy();
        }
    }

    public void startLocation() {
       // if (aMapLocationClient != null && !aMapLocationClient.isStarted()) {
            aMapLocationClient.startLocation();
      //  }
    }

    public interface OnLocationListener {
        void onLocationSucceed(AMapLocation aMapLocation);

        void onLocationFail(String errorInfo);
    }

}
