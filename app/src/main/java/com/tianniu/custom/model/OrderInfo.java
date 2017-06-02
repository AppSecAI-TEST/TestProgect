package com.tianniu.custom.model;


import android.text.format.DateUtils;

import com.tianniu.custom.core.CommonResources;
import com.tianniu.custom.core.JsonTag;

import org.json.JSONObject;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/6/1 0001.
 */

public class OrderInfo  implements Serializable {
    private static final long serialVersionUID = 1L;



    /**
     * 历史原因仍在使用的 构造函数
     *
     * @param order
     */
    public OrderInfo(JSONObject order) {

        try {

            length = order.optString(JsonTag.LENGTH);

            wide = order.optString(JsonTag.WIDE);

            high = order.optString(JsonTag.HIGH);

            weight = order.optString(JsonTag.WEIGHT);

            price = order.optString(JsonTag.PRICE);


            pubDate = order.optLong(JsonTag.PUB_DATE);


            userType = order.optString(JsonTag.USER_TYPE);


            userId = order.optLong(JsonTag.USER_ID);


            startLongitude = order.optString(JsonTag.START_LONGITUDE);


            startLatitude = order.optString(JsonTag.START_LATITUDE);


            destLongitude = order.optString(JsonTag.DEST_LONGITUDE);


            destLatitude = order.optString(JsonTag.DEST_LATITUDE);


            startCoordX = order.optString(JsonTag.START_COORD_X);


            startCoordY = order.optString(JsonTag.START_COORD_Y);


            destCoordX = order.optString(JsonTag.DEST_COORD_X);


            destCoordY = order.optString(JsonTag.DEST_COORD_Y);


            isSuperelevation = order.optString(JsonTag.IS_SUPERELEVATION);


            isCollect = order.optInt(JsonTag.IS_COLLECT);


            telephoneOne = order.optString("telephoneOne");

            telephoneTwo = order.optString("telephoneTwo");


            telephoneThree = order.optString("telephoneThree");


            startDetailAdd = order.optString(JsonTag.START_DETAIL_ADD);


            destDetailAdd = order.optString(JsonTag.DEST_DETAIL_ADD);

            linkMan = order.optString(JsonTag.LINKMAN);


            tsId = order.optInt(JsonTag.TSID);


            status = order.optInt(JsonTag.STATUS);


            startCoord = order.optString(JsonTag.START_COORD);


            destCoord = order.optString(JsonTag.DEST_COORD);


            remark = order.optString(JsonTag.REMARK);


            mVerifyFlag = order.optInt(JsonTag.VERIFY_FLAG);


            distance = order.optString(JsonTag.DISTANCE);


            source = order.optString(JsonTag.SOURCE);


            destPoint = order.optString(JsonTag.DESTPOINT);


            startPoint = order.optString(JsonTag.STARTPOINT);


            pubTime = order.optString(JsonTag.PUB_TIME);


            pubQQ = order.optString(JsonTag.PUB_QQ);


            mtime = order.optLong(JsonTag.TIME);


            resend = order.optString(JsonTag.RESEND);


            taskContent = order.optString(JsonTag.TASK_CONTENT);


            ctime = order.optLong(JsonTag.CTIME);


            id = order.optInt(JsonTag.ID);


            nickName = order.optString(JsonTag.NICK_NAME);


            uploadCellPhone = order.optString(JsonTag.UPLOAD_CELL_PHONE);


            isInfoFee = order.optString("isInfoFee");


            verifyPhotoSign = order.optInt(JsonTag.VERIFYPHOTOSIGN, 0);
            userPart = order.optInt(JsonTag.USERPART, 0);

            regTime = order.optLong("regTime");


            brand=order.optString("brand");
            type=order.optString("type");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getMatchItemId() {
        return matchItemId;
    }

    public void setMatchItemId(String matchItemId) {
        this.matchItemId = matchItemId;
    }

    private String  matchItemId="";
    /**
     * 这个参数只是在界面间传值用，不能作为参数字段传递
     */
    public String getOriginalStandardMsg() {
        return originalStandardMsg;
    }
    /**
     * 这个参数只是在界面间传值用，不能作为参数字段传递
     */
    public void setOriginalStandardMsg(String originalStandardMsg) {
        this.originalStandardMsg = originalStandardMsg;
    }

    /**
     * 这个参数只是在界面间传值用，不能作为参数字段传递
     */
    private  String originalStandardMsg;

    private String isStandard="";//	字符串	是否为标准化数据，0是，1不是


    private String goodNumber="";//	字符串	台数

    private String brand,type;

    public String getIsStandard() {
        return isStandard;
    }

    public void setIsStandard(String isStandard) {
        this.isStandard = isStandard;
    }



    public String getGoodNumber() {
        return goodNumber;
    }

    public void setGoodNumber(String goodNumber) {
        this.goodNumber = goodNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<AgencyMoney> getAgencyMoneyList() {
        return agencyMoneyList;
    }

    public void setAgencyMoneyList(List<AgencyMoney> agencyMoneyList) {
        this.agencyMoneyList = agencyMoneyList;
    }


    private long exTime;//	Long	异常上报时间(毫秒)



    private String exTimeString;//异常上报时间(毫秒)
    private String exParty;//	String	异常上报方身份1车主上报，2货主上报
    private String exType;    //String	异常上报类型 见异常上报类型
    private String exOther;//	String	异常上报类其他原因
    private String exStatus;//	String	异常上报处理状态0初始化1处理中2处理完成


    /**

     异常上报发货方	1	车主爽约
     2	其他
     异常上报车主方	1	发货方爽约
     2	不想拉了
     3	实际情况与特运通上看到的不一致
     4	骗子信息，根本没货
     5	货已拉走
     6	装货时间延长
     7	运价纠纷
     8	其他


     type 2 表示是在货源中  3表示实在接单中
     */
    public String getExTypeString(CommonResources resources) {
        String result="";
        if(!"1".equals(exParty)){
//
//            if("1".equals(exType)){
//                result="车主爽约";
//            }else {
//                result="其他";
//            }
            result=resources.getExPartyGoodsMap().get(exType);
        }else{
            result=resources.getExPartyCarMap().get(exType);
//            if("1".equals(exType)){
//                result="发货方爽约";
//            }else  if("2".equals(exType)){
//                result="不想拉了";
//            }else  if("3".equals(exType)){
//                result="实际情况与特运通上看到的不一致";
//            }else  if("4".equals(exType)){
//                result="骗子信息，根本没货";
//            }else  if("5".equals(exType)){
//                result="货已拉走";
//            }else  if("6".equals(exType)){
//                result="装货时间延长";
//            }else  if("7".equals(exType)){
//                result="运价纠纷";
//            }else{
//                result="其他";
//            }
        }
        return result;
    }

    /**
     * 异常上报处理状态0初始化1处理中2处理完成
     */
    public String getExStatusString() {

        if ("0".equals(exStatus)) {
            return "待处理";
        } else if ("1".equals(exStatus)) {
            return "处理中";
        } else {
            return "处理完成";
        }

    }


    public long getExTime() {
        return exTime;
    }

    public void setExTime(long exTime) {
        this.exTime = exTime;
    }

    public String getExParty() {
        return exParty;
    }

    public void setExParty(String exParty) {
        this.exParty = exParty;
    }

    public String getExType() {
        return exType;
    }

    public void setExType(String exType) {
        this.exType = exType;
    }

    public String getExOther() {
        return exOther;
    }

    public void setExOther(String exOther) {
        this.exOther = exOther;
    }

    public String getExStatus() {
        return exStatus;
    }

    public void setExStatus(String exStatus) {
        this.exStatus = exStatus;
    }


    private List<AgencyMoney> agencyMoneyList;




    private int mVerifyFlag;


    private String startCoord;

    private String destCoord;


    private String linkMan = "";


    private long mtime;


    private String isCar;//String	0否 1是

    private String telephoneOne;    //String	联系人1
    private String telephoneTwo;    //String	联系人2


    private String telephoneThree;    //String	联系人3


    private long id;


    private String tsOrderNo;
    private long tsId;
    private long sortId;
    private long userId;
    private String isInfoFee;
    private long publishTime;//发布日期 (毫秒)
    private long payEndTime;//支付时间 (毫秒)
    private long firstPublishTime;//	long	首次发布时间(毫秒)

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    private long createTime;//下单时间(毫秒)

    /**
     * 下单时间(毫秒)
     */
    public String getCreateTimeString() {

        if (null == createTimeString) {

        }

        return createTimeString;
    }

    private String createTimeString;//下单时间(毫秒)
    /**
     * 首次发布时间(毫秒)
     */
    private String firstPublishTimeString = "";
    private long payUserId;
    private String payLinkPhone;
    private long payAmount;
    private int payNumber;


    private long agreeTime;//同意装货时间(毫秒)
    private long loadTime;//成交时间(毫秒)


    /**
     * 信息费运单状态：0待接单  1有人支付成功 （货主的待同意   ）2装货中（车主是待装货 ）3车主装货完成  4系统装货完成 5异常上报
     */
    private String infoStatus;


    private String pubTime = "";

    private String pubQQ = "";

    /**
     * 状态 1有效（发布中），0无效，2待定（QQ专用），3阻止（QQ专用），4成交，5取消状态
     */
    private int status;


    private String resend = "";

    private String uploadCellPhone = "";

    private String taskContent = "";

    private long ctime;
    /**
     * 来源 0人工  1自动
     */
    private String source = "";


    private String nickName = "";

    private String destPoint = "";

    private String startPoint = "";


    private String distance = "";

    private float currentRange;


    public String section = "";


    private long pubDate;
    private String startLongitude = "";
    private String startLatitude = "";
    private String destLongitude = "";


    private String destLatitude = "";

    private String startCoordX = "";
    private String startCoordY = "";
    private String destCoordX = "";
    private String destCoordY = "";
    private String isSuperelevation = "";
    private int isCollect;


    private String startDetailAdd;//	String	出发地详细地址

    private String destDetailAdd = "";

    private String length = "";
    private String wide = "";
    private String high = "";
    private String weight = "";
    private String price = "";
    private String remark = "";

    private String userType = "";
    /**
     * 照片认证标志0未认证1通过
     */
    private int verifyPhotoSign;

    /**
     * 用户诚信分数
     */
    private int userPart;

    private int verifyFlag;//	Integer	验证标识 0未验证 1验证 信息认证标识共用


    private String cancelTimeString = null;

    private String publishTimeString = null;
    /**
     * 支付时间 (毫秒)
     */
    private String payEndTimeString = null;
    /**
     * 同意装货时间(毫秒)
     */
    private String agreeTimeString = null;


    private long cancelTime;    //Long	撤销日期 (毫秒)
    private int goodStatus;    //Integer	货物状态， 1有效（发布中），0无效，2待定（QQ专用），3阻止（QQ专用），4成交，5撤销状态


    public String getRefuseTimeString() {
        if (null == refuseTimeString) {

        }
        return refuseTimeString;

    }

    /**
     * 0待接单 1接单成功  2货主拒绝 3系统拒绝  4同意装货 5车主装货完成  6系统装货完成 7异常上报
     * @return
     */
    public String getRobStatusString(CommonResources resources) {

        if("0".equals(robStatus)){
            return "待接单";
        }else if("1".equals(robStatus)){
            return "接单成功";
        }else if("2".equals(robStatus)){
            return "发货方拒绝装货";
        }else if("3".equals(robStatus)){
            return "超时自动拒绝装货";
        }else if("4".equals(robStatus)){
            return "同意装货";
        }else if("5".equals(robStatus)){
            return "主动进行装货完成";
        }else if("6".equals(robStatus)){
            return "超过"+resources.getWayBillLoadTime()+"天平台自动装货完成";
        }else{
            return "异常上报";
        }

    }

    private String loadTimeString;



    private long refuseTime;//	Long	拒绝装货时间(毫秒)

    public String getRobStatus() {
        return robStatus;
    }

    public void setRobStatus(String robStatus) {
        this.robStatus = robStatus;
    }

    public long getRefuseTime() {
        return refuseTime;
    }

    public void setRefuseTime(long refuseTime) {
        this.refuseTime = refuseTime;
    }

    private String robStatus;//	String	接单状态0待接单 1接单成功  2货主拒绝 3系统拒绝  4同意装货 5车主装货完成  6系统装货完成 7异常上报

    private String refuseTimeString;
    private String robStatusString;

    private long regTime;

    public long getRegTime() {
        return regTime;
    }

    public void setRegTime(long regTime) {
        this.regTime = regTime;
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

    public String getInfoStatus() {
        return infoStatus;
    }

    public void setInfoStatus(String infoStatus) {
        this.infoStatus = infoStatus;
    }

    public String getIsCar() {
        return isCar;
    }

    public void setIsCar(String isCar) {
        this.isCar = isCar;
    }

    public String getTelephoneThree() {
        return telephoneThree;
    }

    public void setTelephoneThree(String telephoneThree) {
        this.telephoneThree = telephoneThree;
    }

    public String getTelephoneOne() {
        return telephoneOne;
    }

    public void setTelephoneOne(String telephoneOne) {
        this.telephoneOne = telephoneOne;
    }

    public String getTelephoneTwo() {
        return telephoneTwo;
    }

    public void setTelephoneTwo(String telephoneTwo) {
        this.telephoneTwo = telephoneTwo;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    /**
     * 首次发布时间(毫秒)
     */
    public String getFirstPublishTimeString() {
        if (null == firstPublishTimeString) {

        }
        return firstPublishTimeString;

    }


    public String getDestDetailAdd() {
        return destDetailAdd;
    }

    public void setDestDetailAdd(String destDetailAdd) {
        this.destDetailAdd = destDetailAdd;
    }


    public String getStartDetailAdd() {
        return startDetailAdd;
    }

    public void setStartDetailAdd(String startDetailAdd) {
        this.startDetailAdd = startDetailAdd;
    }

    public int getVerifyFlag() {
        return verifyFlag;
    }

    public void setVerifyFlag(int verifyFlag) {
        this.verifyFlag = verifyFlag;
    }

    public long getFirstPublishTime() {
        return firstPublishTime;
    }

    public void setFirstPublishTime(long firstPublishTime) {
        this.firstPublishTime = firstPublishTime;
    }


    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getWide() {
        return wide;
    }

    public void setWide(String wide) {
        this.wide = wide;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public long getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(long cancelTime) {
        this.cancelTime = cancelTime;
    }

    public int getGoodStatus() {
        return goodStatus;
    }

    public void setGoodStatus(int goodStatus) {
        this.goodStatus = goodStatus;
    }


    public String getCancelTimeString() {
        if (null == cancelTimeString) {

        }
        return cancelTimeString;
    }


    /**
     * 发布日期 (毫秒)
     *
     * @return
     */
    public String getPublishTimeString() {

        if (null == publishTimeString) {
        }
        return publishTimeString;
    }


    /**
     * 支付时间 (毫秒)
     *
     * @return
     */
    public String getPayEndTimeString() {
        if (null == payEndTimeString) {
        }
        return payEndTimeString;
    }


    /**
     * 同意装货时间(毫秒)
     *
     * @return
     */
    public String getAgreeTimeString() {
        if (null == agreeTimeString) {
//            agreeTimeString = DateUtils.cargoListItemTimeConvert(agreeTime);
        }
        return agreeTimeString;
    }


    /**
     * 成交时间(毫秒)
     *
     * @return
     */
    public String getLoadTimeString() {
        if (null == loadTimeString) {
        }
        return loadTimeString;
    }


    public String getTsOrderNo() {
        return tsOrderNo;
    }

    public void setTsOrderNo(String tsOrderNo) {
        this.tsOrderNo = tsOrderNo;
    }

    public long getTsId() {
        return tsId;
    }

    public void setTsId(long tsId) {
        this.tsId = tsId;
    }

    public long getSortId() {
        return sortId;
    }

    public void setSortId(long sortId) {
        this.sortId = sortId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getDestPoint() {
        return destPoint;
    }

    public void setDestPoint(String destPoint) {
        this.destPoint = destPoint;
    }

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    public String getIsInfoFee() {
        return isInfoFee;
    }

    public void setIsInfoFee(String isInfoFee) {
        this.isInfoFee = isInfoFee;
    }

    public long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(long publishTime) {
        this.publishTime = publishTime;
    }

    public long getPayEndTime() {
        return payEndTime;
    }

    public void setPayEndTime(long payEndTime) {
        this.payEndTime = payEndTime;
    }

    public long getPayUserId() {
        return payUserId;
    }

    public void setPayUserId(long payUserId) {
        this.payUserId = payUserId;
    }

    public String getPayLinkPhone() {
        return payLinkPhone;
    }

    public void setPayLinkPhone(String payLinkPhone) {
        this.payLinkPhone = payLinkPhone;
    }

    public long getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(long payAmount) {
        this.payAmount = payAmount;
    }

    public int getPayNumber() {
        return payNumber;
    }

    public void setPayNumber(int payNumber) {
        this.payNumber = payNumber;
    }

    public long getAgreeTime() {
        return agreeTime;
    }

    public void setAgreeTime(long agreeTime) {
        this.agreeTime = agreeTime;
    }

    public long getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(long loadTime) {
        this.loadTime = loadTime;
    }

    public String getPubTime() {
        return pubTime;
    }

    public void setPubTime(String pubTime) {
        this.pubTime = pubTime;
    }

    public String getPubQQ() {
        return pubQQ;
    }

    public void setPubQQ(String pubQQ) {
        this.pubQQ = pubQQ;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public long getMtime() {
        return mtime;
    }

    public void setMtime(long mtime) {
        this.mtime = mtime;
    }

    public String getResend() {
        return resend;
    }

    public void setResend(String resend) {
        this.resend = resend;
    }

    public String getUploadCellPhone() {
        return uploadCellPhone;
    }

    public void setUploadCellPhone(String uploadCellPhone) {
        this.uploadCellPhone = uploadCellPhone;
    }

    public long getCtime() {
        return ctime;
    }

    public void setCtime(long ctime) {
        this.ctime = ctime;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }


//

    public int getmVerifyFlag() {
        return mVerifyFlag;
    }

    public void setmVerifyFlag(int mVerifyFlag) {
        this.mVerifyFlag = mVerifyFlag;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public float getCurrentRange() {
        return currentRange;
    }

    public void setCurrentRange(float currentRange) {
        this.currentRange = currentRange;
    }


    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }


    public long getPubDate() {
        return pubDate;
    }

    public void setPubDate(long pubDate) {
        this.pubDate = pubDate;
    }

    public String getStartLongitude() {
        return startLongitude;
    }

    public void setStartLongitude(String startLongitude) {
        this.startLongitude = startLongitude;
    }

    public String getStartLatitude() {
        return startLatitude;
    }

    public void setStartLatitude(String startLatitude) {
        this.startLatitude = startLatitude;
    }

    public String getDestLongitude() {
        return destLongitude;
    }

    public void setDestLongitude(String destLongitude) {
        this.destLongitude = destLongitude;
    }

    public String getDestLatitude() {
        return destLatitude;
    }

    public void setDestLatitude(String destLatitude) {
        this.destLatitude = destLatitude;
    }

    public String getStartCoordX() {
        return startCoordX;
    }

    public void setStartCoordX(String startCoordX) {
        this.startCoordX = startCoordX;
    }

    public String getStartCoordY() {
        return startCoordY;
    }

    public void setStartCoordY(String startCoordY) {
        this.startCoordY = startCoordY;
    }

    public String getDestCoordX() {
        return destCoordX;
    }

    public void setDestCoordX(String destCoordX) {
        this.destCoordX = destCoordX;
    }

    public String getDestCoordY() {
        return destCoordY;
    }

    public void setDestCoordY(String destCoordY) {
        this.destCoordY = destCoordY;
    }

    public String getIsSuperelevation() {
        return isSuperelevation;
    }

    public void setIsSuperelevation(String isSuperelevation) {
        this.isSuperelevation = isSuperelevation;
    }

    public int getIsCollect() {
        return isCollect;
    }

    public void setIsCollect(int isCollect) {
        this.isCollect = isCollect;
    }


    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public int getVerifyPhotoSign() {
        return verifyPhotoSign;
    }

    public void setVerifyPhotoSign(int verifyPhotoSign) {
        this.verifyPhotoSign = verifyPhotoSign;
    }

    public int getUserPart() {
        return userPart;
    }

    public void setUserPart(int userPart) {
        this.userPart = userPart;
    }

    public void setCancelTimeString(String cancelTimeString) {
        this.cancelTimeString = cancelTimeString;
    }

    public void setPublishTimeString(String publishTimeString) {
        this.publishTimeString = publishTimeString;
    }

    public void setPayEndTimeString(String payEndTimeString) {
        this.payEndTimeString = payEndTimeString;
    }

    public void setAgreeTimeString(String agreeTimeString) {
        this.agreeTimeString = agreeTimeString;
    }

    public void setLoadTimeString(String loadTimeString) {
        this.loadTimeString = loadTimeString;
    }

}

