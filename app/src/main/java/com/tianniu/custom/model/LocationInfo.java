package com.tianniu.custom.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

public class LocationInfo implements Serializable {

    public static final int TYPE_PRO = 0;
    public static final int TYPE_CITY = TYPE_PRO + 1;
    public static final int TYPE_COUNTY = TYPE_CITY + 1;
    public static final int TYPE_TOWN = TYPE_COUNTY + 1;

    public static final String TAG_PRO = "pro";
    public static final String TAG_RF = "RF";
    public static final String TAG_PX = "px";
    public static final String TAG_PY = "py";
    public static final String TAG_LONGITUDE = "longitude";
    public static final String TAG_LATITUDE = "latitude";
    public static final String TAG_CITY = "city";
    public static final String TAG_COUNTY = "county";
    public static final String TAG_TOWN = "Town";

    private static final long serialVersionUID = 4582770278268012774L;


    private int mLocationType = TYPE_PRO;
    private String mName;
    private String mRF;



    private float mPx;
    private float mPy;
    private float mLongitude;
    private float mLatidude;
    public List<LocationInfo> mChildInfos;


    private String mCoord;
    private String mLonlat;

    /**
     * @param mLocationType
     * @param mName
     * @param mPx
     * @param mPy
     * @param mChildInfos
     */
    public LocationInfo(int mLocationType, String mName, float mPx, float mPy, float mLongitude, float mLatidude, List<LocationInfo> mChildInfos) {
        super();
        this.mLocationType = mLocationType;
        this.mName = mName;
        this.mPx = mPx;
        this.mPy = mPy;
        this.mLongitude = mLongitude;
        this.mLatidude = mLatidude;
        this.mChildInfos = mChildInfos;
    }

    public LocationInfo(String mName) {
        super();
        this.mName = mName;
    }


    public LocationInfo() {
        super();

    }

    public LocationInfo(JSONObject info, Context context, LocationInfo parent) {
        try {
            String tag = null;
            if (info.has(TAG_PRO)) {
                mLocationType = TYPE_PRO;
                mName = info.getString(TAG_PRO);

                tag = TAG_CITY;
            } else if (info.has(TAG_CITY)) {
                mLocationType = TYPE_CITY;
                mName = info.getString(TAG_CITY);
                tag = TAG_COUNTY;
            } else if (info.has(TAG_COUNTY)) {
                mLocationType = TYPE_COUNTY;
                mName = info.getString(TAG_COUNTY);
                tag = TAG_TOWN;
            } else if (info.has(TAG_TOWN)) {
                mLocationType = TYPE_TOWN;
                mName = info.getString(TAG_TOWN);
            }

            if (info.has(TAG_RF)) {
                mRF = info.getString(TAG_RF);
            }

            if (info.has(TAG_PX)) {
                String px = info.getString(TAG_PX);
                if (!px.equals("非数字")) {
                    mPx = Float.parseFloat(px);
                }
            }

            if (info.has(TAG_PY)) {
                String py = info.getString(TAG_PY);
                if (!py.equals("非数字")) {
                    mPy = Float.parseFloat(py);
                }
            }

            if (info.has(TAG_LONGITUDE)) {
                String longtude = info.getString(TAG_LONGITUDE);
                if (!longtude.equals("非数字")) {
                    mLongitude = Float.parseFloat(longtude);
                }
            }

            if (info.has(TAG_LATITUDE)) {
                String latitude = info.getString(TAG_LATITUDE);
                if (!latitude.equals("非数字")) {
                    mLatidude= Float.parseFloat(latitude);
                }
            }
            mCoord = mPx+","+mPy;
            mLonlat = mLongitude+","+mLatidude;

            if (tag != null && info.has(tag)) {
                mChildInfos = new ArrayList<LocationInfo>();
                Object locations = info.get(tag);
                if (locations instanceof JSONObject) {
                    mChildInfos.add(new LocationInfo((JSONObject) locations, context, this));
                } else {
                    JSONArray locationArray = (JSONArray) locations;
                    for (int i = 0; i < locationArray.length(); i++) {
                        mChildInfos.add(new LocationInfo(locationArray.getJSONObject(i), context, this));
                    }
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (mLocationType != TYPE_PRO) {
            //LocationManager.getInstance(context).addLocationInfo(this);
        }

        if (mLocationType == TYPE_TOWN) {
            mPx = parent.getPx();
            mPy = parent.getPy();
        }

        //	mParent = parent;
    }

    public void setmLocationType(int mLocationType) {
        this.mLocationType = mLocationType;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setmRF(String mRF) {
        this.mRF = mRF;
    }

    public void setmPx(float mPx) {
        this.mPx = mPx;
    }

    public void setmPy(float mPy) {
        this.mPy = mPy;
    }

    @Override
    public String toString() {
        return "LocationInfo [mLocationType=" + mLocationType + ", mName=" + mName + ", mRF=" + mRF + ", mPx=" + mPx + ", mPy=" + mPy + ", mLongitude=" + mLongitude
                 + ", mLatidude=" + mLatidude + ", mChildInfos=" + mChildInfos + ", mParent="  + ", mCoord=" + mCoord + ", mLonlat=" + mLonlat + "]";
    }

    public float getmLongitude() {
        return mLongitude;
    }

    public void setmLongitude(float mLongitude) {
        this.mLongitude = mLongitude;
    }

    public float getmLatidude() {
        return mLatidude;
    }

    public void setmLatidude(float mLatidude) {
        this.mLatidude = mLatidude;
    }

    public int getLocationType() {
        return mLocationType;
    }

    public String getName() {
        return mName;
    }

    public String getRF() {
        return mRF;
    }

    public float getPx() {
        return mPx;
    }

    public float getPy() {
        return mPy;
    }


    public void setPx(float px) {
        mPx=px;
    }

    public void setPy(float py) {
        mPy=py;
    }
    public String getmCoord() {
        return  mPx+","+mPy;
    }

    public void setmCoord(String mCoord) {
        this.mCoord = mCoord;
    }




    public String getmLonlat() {
        return  mLongitude+","+mLatidude;
    }

    public void setmLonlat(String mLonlat) {
        this.mLonlat = mLonlat;
    }



    public List<LocationInfo> getChildInfos() {
        return mChildInfos;
    }


}
