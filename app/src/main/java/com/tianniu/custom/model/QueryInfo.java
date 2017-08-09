package com.tianniu.custom.model;

/**
 * Created by liulong on 2017/8/9.
 */

public class QueryInfo {

//    private long id;
//    private long userId;
//    private String startPoint;
//    private String destPoint;
//    private String taskContent;
//    private int status;
//    private String startCoord;
//    private String destCoord;
//    private int verifyFlag;
//    private String price;
//    private String startDetailAdd;
//    private String startLatitude;
//    private String startLongitude;
//    private String destDetailAdd;
//    private String destLongitude;
//    private String destLatitude;
//    private long pubDate;
//    private String remark;
//    private String distance;
//    private String isInfoFee;
//    private String nickName;
//    private long regTime;
//    private String weight;


    private int userId;
    private String ticket;

    private String startCoord;
    private String startLonLat;
    private int queryType;

    private String startDistance;
    private String destDistance;
    private String headCity;

    /**
     * 非必填
     */
    private String headNo;
    private String querySign;
    /**
     * 非必填
     */
    private int sortType;
    private String destCoord;
    private String destLonLat;
    private String carId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getStartCoord() {
        return startCoord;
    }

    public void setStartCoord(String startCoord) {
        this.startCoord = startCoord;
    }

    public String getDestCoord() {
        return destCoord;
    }

    public void setDestCoord(String destCoord) {
        this.destCoord = destCoord;
    }

    public String getStartLonLat() {
        return startLonLat;
    }

    public void setStartLonLat(String startLonLat) {
        this.startLonLat = startLonLat;
    }

    public String getDestLonLat() {
        return destLonLat;
    }

    public void setDestLonLat(String destLonLat) {
        this.destLonLat = destLonLat;
    }

    public int getQueryType() {
        return queryType;
    }

    public void setQueryType(int queryType) {
        this.queryType = queryType;
    }

    public String getQuerySign() {
        return querySign;
    }

    public void setQuerySign(String querySign) {
        this.querySign = querySign;
    }

    public String getStartDistance() {
        return startDistance;
    }

    public void setStartDistance(String startDistance) {
        this.startDistance = startDistance;
    }

    public String getDestDistance() {
        return destDistance;
    }

    public void setDestDistance(String destDistance) {
        this.destDistance = destDistance;
    }

    public String getHeadCity() {
        return headCity;
    }

    public void setHeadCity(String headCity) {
        this.headCity = headCity;
    }

    public String getHeadNo() {
        return headNo;
    }

    public void setHeadNo(String headNo) {
        this.headNo = headNo;
    }

    public int getSortType() {
        return sortType;
    }

    public void setSortType(int sortType) {
        this.sortType = sortType;
    }
}
