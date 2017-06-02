package com.tianniu.custom.model;

/**
 * Created by Administrator on 2017/6/1 0001.
 */

public class HostoryLocation {
    private SelectedLocation mStartLocation;

    private String mStartLocationName = "";

    private SelectedLocation mDestLocation;
    private String mDestLocationName ="";






    public String getmStartLocationName() {
        return mStartLocationName;
    }
    public void setmStartLocationName(String mStartLocationName) {
        this.mStartLocationName = mStartLocationName;
    }
    public String getmDestLocationName() {
        return mDestLocationName;
    }
    public void setmDestLocationName(String mDestLocationName) {
        this.mDestLocationName = mDestLocationName;
    }
    public SelectedLocation getmStartLocation() {
        return mStartLocation;
    }
    public void setmStartLocation(SelectedLocation mStartLocation) {
//		this.mStartLocation = mStartLocation;
        if (null ==this.mStartLocation) {
            this.mStartLocation = new SelectedLocation();
        }
        this.mStartLocation.setPro(mStartLocation.getPro());
        this.mStartLocation.setCity(mStartLocation.getCity());
        this.mStartLocation.setCounty(mStartLocation.getCounty());
        this.mStartLocation.setRange(mStartLocation.getRange());
    }
    public SelectedLocation getmDestLocation() {
        return mDestLocation;
    }
    public void setmDestLocation(SelectedLocation mDestLocation) {
//		this.mDestLocation = mDestLocation;
        if (null == this.mDestLocation) {
            this.mDestLocation = new SelectedLocation();
        }
        this.mDestLocation.setPro(mDestLocation.getPro());
        this.mDestLocation.setCity(mDestLocation.getCity());
        this.mDestLocation.setCounty(mDestLocation.getCounty());
        this.mDestLocation.setRange(mDestLocation.getRange());
    }
    @Override
    public String toString() {
        return "HostoryLocation [mStartLocationName=" + mStartLocationName + ", mDestLocationName=" + mDestLocationName + "]";
    }
    public void setAll(HostoryLocation defHostory) {
        this.setmStartLocation(defHostory.getmStartLocation());
        this.setmStartLocationName(defHostory.getmStartLocationName());
        this.setmDestLocation(defHostory.getmDestLocation());
        this.setmDestLocationName(defHostory.getmDestLocationName());
    }
}

