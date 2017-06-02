package com.tianniu.custom.model;

/**
 * Created by Administrator on 2017/6/1 0001.
 */

public class SearchDistanceParam {
    private static final long serialVersionUID = 665250229928209946L;


    private String distance="300";
    private String distanceDisplayText;
    private int isDefault;
    /**
     * 查询时传递的参数
     * @return
     */
    public String getDistance() {
        return distance;
    }
    public void setDistance(String distance) {
        this.distance = distance;
    }
    /**
     * 显示给用的用的字段
     * @return
     */
    public String getDistanceDisplayText() {
        return distanceDisplayText;
    }
    public void setDistanceDisplayText(String distanceDisplayText) {
        this.distanceDisplayText = distanceDisplayText;
    }
    /**
     * 如果是1表示是默认值
     * @return
     */
    public int getIsDefault() {
        return isDefault;
    }
    public void setIsDefault(int isDefault) {
        this.isDefault = isDefault;
    }
}
