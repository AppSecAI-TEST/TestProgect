package com.tianniu.custom.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/17 0017.
 */

public class PersonInfo implements Serializable {
    private String cellPhone;
    private double ctime;
    private double endTime;
    private int id;
    private int identityType;
    private int infoPublishFlag;
    private int infoUploadFlag;
    /**
     * 是否绑定银行卡
     */
    private int isBank;
    /**
     * 是否完善车辆信息
     */
    private int isCar;

    private int killBill;
    private int phoneOpenFlag;
    private int phoneServeDays;
    private int qqBoxFlag;
    private String scarIdentityLables;
    private double systemTime;
    private String ticket;
    private String trueName;
    private int userClass;
    private int userIdentityStatus;
    private String userName;
    private int userPart;
    private int userSign;
    private int userType;
    private int verifyFlag;
    private int verifyPhotoSign;


    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public double getCtime() {
        return ctime;
    }

    public void setCtime(double ctime) {
        this.ctime = ctime;
    }

    public double getEndTime() {
        return endTime;
    }

    public void setEndTime(double endTime) {
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdentityType() {
        return identityType;
    }

    public void setIdentityType(int identityType) {
        this.identityType = identityType;
    }

    public int getInfoPublishFlag() {
        return infoPublishFlag;
    }

    public void setInfoPublishFlag(int infoPublishFlag) {
        this.infoPublishFlag = infoPublishFlag;
    }

    public int getInfoUploadFlag() {
        return infoUploadFlag;
    }

    public void setInfoUploadFlag(int infoUploadFlag) {
        this.infoUploadFlag = infoUploadFlag;
    }

    public int getIsBank() {
        return isBank;
    }

    public void setIsBank(int isBank) {
        this.isBank = isBank;
    }

    public int getIsCar() {
        return isCar;
    }

    public void setIsCar(int isCar) {
        this.isCar = isCar;
    }

    public int getKillBill() {
        return killBill;
    }

    public void setKillBill(int killBill) {
        this.killBill = killBill;
    }

    public int getPhoneOpenFlag() {
        return phoneOpenFlag;
    }

    public void setPhoneOpenFlag(int phoneOpenFlag) {
        this.phoneOpenFlag = phoneOpenFlag;
    }

    public int getPhoneServeDays() {
        return phoneServeDays;
    }

    public void setPhoneServeDays(int phoneServeDays) {
        this.phoneServeDays = phoneServeDays;
    }

    public int getQqBoxFlag() {
        return qqBoxFlag;
    }

    public void setQqBoxFlag(int qqBoxFlag) {
        this.qqBoxFlag = qqBoxFlag;
    }

    public String getScarIdentityLables() {
        return scarIdentityLables;
    }

    public void setScarIdentityLables(String scarIdentityLables) {
        this.scarIdentityLables = scarIdentityLables;
    }

    public double getSystemTime() {
        return systemTime;
    }

    public void setSystemTime(double systemTime) {
        this.systemTime = systemTime;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public int getUserClass() {
        return userClass;
    }

    public void setUserClass(int userClass) {
        this.userClass = userClass;
    }

    public int getUserIdentityStatus() {
        return userIdentityStatus;
    }

    public void setUserIdentityStatus(int userIdentityStatus) {
        this.userIdentityStatus = userIdentityStatus;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserPart() {
        return userPart;
    }

    public void setUserPart(int userPart) {
        this.userPart = userPart;
    }

    public int getUserSign() {
        return userSign;
    }

    public void setUserSign(int userSign) {
        this.userSign = userSign;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public int getVerifyFlag() {
        return verifyFlag;
    }

    public void setVerifyFlag(int verifyFlag) {
        this.verifyFlag = verifyFlag;
    }

    public int getVerifyPhotoSign() {
        return verifyPhotoSign;
    }

    public void setVerifyPhotoSign(int verifyPhotoSign) {
        this.verifyPhotoSign = verifyPhotoSign;
    }
}
