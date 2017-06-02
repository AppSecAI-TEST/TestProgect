package com.tianniu.custom.model;

import android.text.TextUtils;

import com.tianniu.custom.core.JsonTag;
import com.tianniu.custom.utils.LLog;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/6/1 0001.
 */

public class PersonInfo implements Serializable{
    private static final String TAG = "PersonInfo";
    private String cellPhone;
    private String contactNum;
    private long ctime;
    private int id;
    private String head_url = "";
    private String idCard;
    private int infoUploadFlag;
    private long mtime;
    private String password;
    private String pcSign;
    public String qq;
    private String qqModTimes;
    private int serveDays;
    private int phoneServeDays;

    private String ticket;
    private String trueName;
    private String userName;
    private int userSign;
    private int userType;
    public String nickName="";
    public int infoPublishFlag;
    private int phoneOpenFlag;

    private String currentLable;

    public String getCurrentLable() {
        return currentLable;
    }

    public void setCurrentLable(String currentLable) {
        this.currentLable = currentLable;
    }

    /**
     * 真实姓名 身份证号码,照片认证失败原因
     */
    private String realName,identity,failureReason;



    /**
     * 实名验证标示，0 未认证，1认证成功 2 认证失败。
     * 证件照地址
     */
    private String status,mainurl;

    /**
     * 0是否，1是是
     */
    private int isCar;

    /**
     * 板车相关身份标签
     */
    private String bcarIdentityLables;

    /**
     * 设备相关身份标签
     */
    private String scarIdentityLables;




    public String getBcarIdentityLables() {
        return bcarIdentityLables;
    }

    public void setBcarIdentityLables(String bcarIdentityLables) {
        this.bcarIdentityLables = bcarIdentityLables;
    }

    public String getScarIdentityLables() {
        return scarIdentityLables;
    }

    public void setScarIdentityLables(String scarIdentityLables) {
        this.scarIdentityLables = scarIdentityLables;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getMainurl() {
        return mainurl;
    }

    public void setMainurl(String mainurl) {
        this.mainurl = mainurl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIsCar() {
        return isCar;
    }

    public void setIsCar(int isCar) {
        this.isCar = isCar;
    }

    /**
     * 1是验证，0是未验证，2，验证中
     */
    private int verifyFlag;
    /**
     * 照片认证，与实名同理
     */
    private int verifyPhotoSign;


    public int getUserClass() {
        return userClass;
    }

    public void setUserClass(int userClass) {
        this.userClass = userClass;
    }

    public int getIdentityType() {
        return identityType;
    }

    public void setIdentityType(int identityType) {
        this.identityType = identityType;
    }

    public int getUserIdentityStatus() {
        return userIdentityStatus;
    }

    public void setUserIdentityStatus(int userIdentityStatus) {
        this.userIdentityStatus = userIdentityStatus;
    }

    private int userClass;//	数字	用户分类1、发货方2、车辆方 见 source user_class，如果该值为空，则用户还没有保存一级身份
    private int identityType;//	数字	用户身份见source表 user_identity_types，如果该值为空，则用户还没有保存一级身份
    private int userIdentityStatus;//	数字	用户身份认证标志0未认证1通过2认证中3认证失败


    public int getVerifyPhotoSign() {
        return verifyPhotoSign;
    }

    public void setVerifyPhotoSign(int verifyPhotoSign) {
        this.verifyPhotoSign = verifyPhotoSign;
    }

    public int getVerifyFlag() {
        return verifyFlag;
    }

    public void setVerifyFlag(int verifyFlag) {
        this.verifyFlag = verifyFlag;
    }

    public int getPhoneServeDays() {
        return phoneServeDays;
    }

    public void setPhoneServeDays(int phoneServeDays) {
        this.phoneServeDays = phoneServeDays;
    }

    public int getPhoneOpenFlag() {
        return phoneOpenFlag;
    }

    public void setPhoneOpenFlag(int phoneOpenFlag) {
        this.phoneOpenFlag = phoneOpenFlag;
    }

    public PersonInfo() {}
    public PersonInfo(JSONObject info) {
        try {
            if (info.has(JsonTag.ID)) {
                this.id = info.getInt(JsonTag.ID);
            }
            if (info.has(JsonTag.TICKET)) {
                this.ticket = info.getString(JsonTag.TICKET);
            }
            if(info.has(JsonTag.IS_CAR)){
                int optInt = info.optInt(JsonTag.IS_CAR);
                this.isCar=optInt;
            }
            LLog.i(TAG, "PersonInfo" + info);
            if (info.has(JsonTag.CELLPHONE)) {
                this.cellPhone = info.getString(JsonTag.CELLPHONE);
                LLog.i(TAG, "PersonInfo cellPhone " + cellPhone);
            }
            if (info.has(JsonTag.QQ_MINI)) {
                this.qq = info.getString(JsonTag.QQ_MINI);
                LLog.i(TAG, "PersonInfo qq " + qq);
            }
            if (info.has(JsonTag.SERVE_DAYS)) {
                this.serveDays = info.getInt(JsonTag.SERVE_DAYS);
                LLog.i(TAG, "PersonInfo serveDays " + serveDays);
            }
            if (info.has(JsonTag.PHONE_OPEN_FLAG)) {
                this.phoneOpenFlag = info.getInt(JsonTag.PHONE_OPEN_FLAG);
                LLog.i(TAG, "PersonInfo phoneOpenFlag " + phoneOpenFlag);
            }
            if (info.has(JsonTag.PHONE_SERVER_DAYS)) {
                this.phoneServeDays = info.getInt(JsonTag.PHONE_SERVER_DAYS);
                LLog.i(TAG, "PersonInfo phoneServeDays " + phoneServeDays);
            }
            if (info.has(JsonTag.USER_NAME)) {
                this.userName = info.optString(JsonTag.USER_NAME,"");
                this.userName=this.userName.trim();//oh yean f**k space
                LLog.i(TAG, "PersonInfo userName " + userName);
            }
            if (info.has(JsonTag.TRUE_NAME)) {
                this.trueName = info.getString(JsonTag.TRUE_NAME);
                LLog.i(TAG, "PersonInfo trueName " + trueName);
            }
            if (info.has(JsonTag.VERIFY_FLAG)) {
                this.verifyFlag = info.getInt(JsonTag.VERIFY_FLAG);
                LLog.i(TAG, "PersonInfo verifyFlag " + verifyFlag);
            }
            if (info.has(JsonTag.INFO_PUBLISH_FLAG)) {
                this.infoPublishFlag = info.getInt(JsonTag.INFO_PUBLISH_FLAG);
                LLog.i(TAG, "PersonInfo infoPublishFlag " + infoPublishFlag);
            }
            if (info.has(JsonTag.USERSIGN)) {
                this.userSign = info.getInt(JsonTag.USERSIGN);
                LLog.i(TAG, "PersonInfo userSign " + userSign);
            }

            if (info.has(JsonTag.HEAD_URL)) {
                this.head_url = info.getString(JsonTag.HEAD_URL);
            }


            if (info.has(JsonTag.NICK_NAME)) {
                this.nickName = info.getString(JsonTag.NICK_NAME);
            }
            if (info.has(JsonTag.REAL_NAME)) {
                this.realName = info.getString(JsonTag.REAL_NAME);
            }
            if (info.has(JsonTag.IDENTITY)) {
                this.identity = info.getString(JsonTag.IDENTITY);
            }

            if (info.has(JsonTag.BCAR_DIENTITY_LABLES)) {
                this.bcarIdentityLables = info.getString(JsonTag.BCAR_DIENTITY_LABLES);
            }
            if (info.has(JsonTag.SCAR_DIENTITY_LABLES)) {
                this.scarIdentityLables = info.getString(JsonTag.SCAR_DIENTITY_LABLES);
            }

            this.ctime=info.optLong(JsonTag.CTIME);
            this.userType=info.optInt(JsonTag.USER_TYPE);
            this.verifyPhotoSign=info.optInt(JsonTag.VERIFYPHOTOSIGN);


            this.userClass=info.optInt("userClass");//	数字	用户分类1、发货方2、车辆方 见 source user_class，如果该值为空，则用户还没有保存一级身份
            this.identityType=info.optInt("identityType",-1);//	数字	用户身份见source表 user_identity_types，如果该值为空，则用户还没有保存一级身份
            this.userIdentityStatus=info.optInt("userIdentityStatus",-1);//	数字0未认证1通过2认证中3认证失败


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getCellPhone() {
        if(TextUtils.isEmpty(cellPhone)){
            return "";
        }
        return cellPhone;
    }



    @Override
    public String toString() {
        return "PersonInfo [cellPhone=" + cellPhone + ", contactNum=" + contactNum + ", ctime=" + ctime + ", id=" + id + ", head_url=" + head_url + ", idCard=" + idCard
                 + ", infoUploadFlag=" + infoUploadFlag + ", mtime=" + mtime + ", password=" + password + ", pcSign=" + pcSign + ", qq=" + qq + ", qqModTimes=" + qqModTimes
                 + ", serveDays=" + serveDays + ", phoneServeDays=" + phoneServeDays + ", ticket=" + ticket + ", trueName=" + trueName + ", userName=" + userName + ", userSign="
                 + userSign + ", userType=" + userType + ", nickName=" + nickName + ", infoPublishFlag=" + infoPublishFlag + ", phoneOpenFlag=" + phoneOpenFlag + ", status="
                 + status + ", mainurl=" + mainurl + ", isCar=" + isCar + ", verifyFlag=" + verifyFlag + "]";
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public long getCtime() {
        return ctime;
    }

    public void setCtime(long ctime) {
        this.ctime = ctime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public int getInfoUploadFlag() {
        return infoUploadFlag;
    }

    public void setInfoUploadFlag(int infoUploadFlag) {
        this.infoUploadFlag = infoUploadFlag;
    }

    public long getMtime() {
        return mtime;
    }

    public void setMtime(long mtime) {
        this.mtime = mtime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPcSign() {
        return pcSign;
    }

    public void setPcSign(String pcSign) {
        this.pcSign = pcSign;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getQqModTimes() {
        return qqModTimes;
    }

    public void setQqModTimes(String qqModTimes) {
        this.qqModTimes = qqModTimes;
    }

    public int getServeDays() {
        return serveDays;
    }

    public void setServeDays(int serveDays) {
        this.serveDays = serveDays;
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

    public String getUserName() {
        if(TextUtils.isEmpty(userName)){
            return "";
        }
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getNickname() {
        return nickName;
    }

    public void setNickname(String nickname) {
        this.nickName = nickname;
    }

    public int getInfoPublishFlag() {
        return infoPublishFlag;
    }

    public void setInfoPublishFlag(int infoPublishFlag) {
        this.infoPublishFlag = infoPublishFlag;
    }

    public String getHead_url() {
        return head_url;
    }

    public void setHead_url(String head_url) {
        this.head_url = head_url;
    }


}

