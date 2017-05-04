package com.tianniu.custom.model;


import java.io.Serializable;

import android.content.Context;

public class SelectedLocation implements Serializable {
    private LocationInfo mPro;
    private LocationInfo mCity;
    private LocationInfo mCounty;
    private float mX;
    private float mY;
    private String mRange;
    private String mTytCoordXy;


    /**
     * @param mPro
     * @param mCity
     * @param mCounty
     * @param mX
     * @param mY
     * @param mRange
     * @param mContext
     */
    public SelectedLocation(LocationInfo mPro, LocationInfo mCity, LocationInfo mCounty, float mX, float mY, String mRange, Context mContext) {
        super();
        this.mPro = mPro;
        this.mCity = mCity;
        this.mCounty = mCounty;
        this.mX = mX;
        this.mY = mY;
        this.mRange = mRange;
        this.mTytCoordXy = mX + "," + mY;
    }

    public SelectedLocation() {
    }

    public LocationInfo getPro() {
        return mPro;
    }

    public void setPro(LocationInfo pro) {
        mPro = pro;
    }

    public LocationInfo getCity() {
        return mCity;
    }

    public void setCity(LocationInfo city) {
        mCity = city;
    }

    public LocationInfo getCounty() {
        return mCounty;
    }

    public void setCounty(LocationInfo county) {
        mCounty = county;
    }

    public String getRange() {
        return mRange;
    }

    public void setRange(String range) {
        mRange = range;
    }

    public float getX() {
        return mX;
    }

    public void setX(float x) {
        mX = x;
    }

    public float getY() {
        return mY;
    }

    public void setY(float y) {
        mY = y;
    }

    public String getmTytCoordXy() {
        return mTytCoordXy;
    }

    public void setmTytCoordXy(String mTytCoordXy) {
        this.mTytCoordXy = mTytCoordXy;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (mPro != null) {
            sb.append("省：" + mPro.getName());
        }
        if (mCity != null) {
            sb.append("  市：" + mCity.getName());
        }
        if (mCounty != null) {
            sb.append("  区县：" + mCounty.getName());
        }
        sb.append("范围：" + mRange);
        sb.append("x： " + mX);
        sb.append("y： " + mY);
        // sb.append(mContext.getString(R.string.kilometre));
        return sb.toString();
    }

    public void setLocation(SelectedLocation mCarStartLocation) {
        if (null == mCarStartLocation) {
            return;
        }
        this.setCity(mCarStartLocation.getCity());
        this.setPro(mCarStartLocation.getPro());
        this.setCounty(mCarStartLocation.getCounty());
        this.setRange(mCarStartLocation.getRange());
    }



    public String getFullAddress(){
        String pro="";
        String city="";
        String county="";
        if(mPro!=null){
            pro=mPro.getName();
        }

        if(mCity!=null){
            city=mCity.getName();
        }
        if(mCounty!=null){
            county=mCounty.getName();
        }


        String result="";
        result +=pro;
        if(city.contains(pro)){
            result =city;
        }else{
            result +=city;
        }


        if(!result.contains(county)){
            result +=county;
        }
        return result;
    }
}
