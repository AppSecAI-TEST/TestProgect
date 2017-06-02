package com.tianniu.custom.core;

import com.tianniu.custom.model.SearchDistanceParam;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/1 0001.
 */

public class CommonResources  implements Serializable {

    private static final long serialVersionUID = 8098618851235373476L;

    public String getTurnPicturesTitleLinks() {
        return turnPicturesTitleLinks;
    }

    public void setTurnPicturesTitleLinks(String turnPicturesTitleLinks) {
        this.turnPicturesTitleLinks = turnPicturesTitleLinks;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public String getServerLocations() {
        return serverLocations;
    }

    public void setServerLocations(String serverLocations) {
        this.serverLocations = serverLocations;
    }

    /**
     * 切换服务器用的
     */
    private String accountPassword;
    /**
     * 切换服务器用的
     */
    private String serverLocations;
    public String getDrivingSchool() {
        return drivingSchool;
    }

    public void setDrivingSchool(String drivingSchool) {
        this.drivingSchool = drivingSchool;
    }


    public String getNoPublishBcarJobTip() {
        return noPublishBcarJobTip;
    }

    public void setNoPublishBcarJobTip(String noPublishBcarJobTip) {
        this.noPublishBcarJobTip = noPublishBcarJobTip;
    }

    public String getNoPublishBcarRecruitTip() {
        return noPublishBcarRecruitTip;
    }

    public void setNoPublishBcarRecruitTip(String noPublishBcarRecruitTip) {
        this.noPublishBcarRecruitTip = noPublishBcarRecruitTip;
    }

    public String getCarNewsPageSize() {
        return carNewsPageSize;
    }

    public void setCarNewsPageSize(String carNewsPageSize) {
        this.carNewsPageSize = carNewsPageSize;
    }

    public String getCarNewsListPicture() {
        return carNewsListPicture;
    }

    public void setCarNewsListPicture(String carNewsListPicture) {
        this.carNewsListPicture = carNewsListPicture;
    }

    public String getNoPublishScarRecruitTip() {
        return noPublishScarRecruitTip;
    }

    public void setNoPublishScarRecruitTip(String noPublishScarRecruitTip) {
        this.noPublishScarRecruitTip = noPublishScarRecruitTip;
    }

    public String getNoPublishScarJobTip() {
        return noPublishScarJobTip;
    }

    public void setNoPublishScarJobTip(String noPublishScarJobTip) {
        this.noPublishScarJobTip = noPublishScarJobTip;
    }


    public String getDeliverGoodsNotify() {
        return deliverGoodsNotify;
    }

    public void setDeliverGoodsNotify(String deliverGoodsNotify) {
        this.deliverGoodsNotify = deliverGoodsNotify;
    }

    public long getMoreCarSwitchWaitTime() {
        return moreCarSwitchWaitTime;
    }

    public void setMoreCarSwitchWaitTime(long moreCarSwitchWaitTime) {
        this.moreCarSwitchWaitTime = moreCarSwitchWaitTime;
    }

    /**
     * APP找货多车切换停留时间(秒)
     */
    private long moreCarSwitchWaitTime;

    private String deliverGoodsNotify;

    private String noPublishBcarJobTip;//您尚未发布任何板车求职信息	字符串	未发布大板车求职提示语
    private String noPublishBcarRecruitTip;//	您尚未发布任何板车招聘信息	字符串	未发布大板车招聘提示语
    private String noPublishScarJobTip;//	您尚未发布任何设备求职信息	字符串	未发布设备求职提示语
    private String noPublishScarRecruitTip;//	您尚未发布任何设备招聘信息	字符串	未发布设备招聘提示语


    private String carNewsListPicture;//	http://www.teyuntong.com/plat/picture/car/news/list.png	字符串	新车资讯列表页图片地址
    private String carNewsPageSize;//	5	字符串	新车资讯查询条数

    private String turnPicturesTitleLinks;

    private String drivingSchool;

    public String getCarNewsListPictureLinkUrl() {
        return carNewsListPictureLinkUrl;
    }

    public void setCarNewsListPictureLinkUrl(String carNewsListPictureLinkUrl) {
        this.carNewsListPictureLinkUrl = carNewsListPictureLinkUrl;
    }

    private String carNewsListPictureLinkUrl;//	标题:http://www.teyuntong.com	字符串	新车资讯列表也图片链接

    /**
     * 轮播图前缀地址
     */
    private String turnPicturesPrefix;
    /**
     * 轮播图,以分号分隔
     */
    private String turnPictures;


    /**
     * 附近高速路搜索范围(单位 公里)
     */
    private int nearbyHignWaySearchRange=15000;

    /**
     * 附近住宿搜索范围(单位 公里)
     */
    private int nearbyAccommodationSearchRange=5000;
    /**
     * 附近银行搜索范围(单位 公里)
     */
    private int nearbyBankSearchRange=5000;
    /**
     * 附近餐饮搜索范围(单位 公里)
     */
    private int nearbyHignRestaurantRange=5000;
    /**
     * 	附近洗浴搜索范围(单位 公里)
     */
    private int nearbyBathSearchRange=5000;

    /**
     * 附近加油站搜索范围(单位 公里)
     */

    private int nearbyGasStationSearchRange=5000;

    /**
     * 帮助说明
     */
    public String helpUrl="";
    /**
     * 隐私协议
     */
    public String agreementUrl="";
    /**
     * 帮保定用户保险
     */
    public String insureUrl="";
    /**
     * 非保定用户保险
     */
    public String insureOtherUrl="";
    /**
     * 关于我们
     */
    public String aboutUsUrL="";
    /**
     * 有奖推荐
     */
    public String praiseRecommendUrl="";
    /**
     * 帮助说明
     */
    public String userAuthUrl="";
    /**
     * 帮助说明
     */
    public String twoDimensionUrl="";
    /**
     * 使用说明页面地址
     */
    public String instructionUrl="";
    /**
     * 车辆认证协议
     */
    public String carAuthUrl="";
    /**
     * 司机奖励策略图
     */
    public String praiseDriverPic="";
    /**
     * 车主奖励策略图
     */
    public String praiseCarPic="";
    /**
     * 货主奖励策略图
     */
    public String praiseGoodsPic="";
    /**
     * 使用说明页面地址
     */
    public String praiseDriverUrl="";
    /**
     * 使用说明页面地址
     */
    public String praiseCarUrl="";
    /**
     * 使用说明页面地址
     */
    public String praiseGoodsUrl="";
    /**
     * 客户端每隔多少秒允许请求一次单位秒
     */
    public int refreshIntervalTime = 10;

    /**
     * 地图地址
     */
    public String serverMapUrl="";



    public String weatherUrl="";

    public String prefixPicture="";
    /**
     * 给个默认值
     */
    public List<SearchDistanceParam> startDistances=new ArrayList<SearchDistanceParam>(0);

    /**
     * 给个默认值
     */
    public List<SearchDistanceParam> destDistances=new ArrayList<SearchDistanceParam>(0);


    /**
     * 是否将排序日志上传到服务器
     * 1是可用
     */
    public int sortAcitonLog=1;

    /**
     * 是否将打电话日志上传到服务器
     * 1是可用
     */
    public int callPhoneActionLog=1;


    /**
     * 客户端上拉，下拉最大条数
     */
    public int slideMaxSize;

    /**
     * 客户端首次查询最大条数
     */
    public int firstQuerySize;

    /**
     * 自动刷新间隔时间(单位s)
     */
    public int autoRefreshIntervalTime;


    public int switchIntervalTime;


    /**
     * 易付宝URL
     * @return
     */
    private String epayurl;

    /**
     *
     */
    private String vipMessage0;

    /**
     * 非会员0天提示语
     */
    private String trialMessage0;

    /**
     * 会员N天提示语(客户端将*替换成空格)
     */
    private String vipMessageN;

    /**
     * 非会员N天提示语(客户端将*替换成空格)
     */
    private String trialMessageN;
    /**
     * 会员提醒天数N值
     */
    private int vipDaysN;
    /**
     * 非会员提醒天数N值
     */
    private int trialDaysN;
    /**
     * 会员0天提示开关(0关 1开)
     */
    private int vipMesageSwitch0;

    /**
     * 会员N天提示开关(0关 1开)
     */
    private int vipMesageSwitchN;
    /**
     * 非会员0天提示开关(0关 1开)
     */
    private int trialMesageSwitch0;

    /**
     * 非会员N天提示开关(0关 1开)
     */
    private int trialMesageSwitcN;

    /**
     * URL延时请求列表(以英文分号为分割符)
     */
    private String delayUrls;

    public String getDelayUrlsNew() {
        return delayUrlsNew;
    }

    public void setDelayUrlsNew(String delayUrlsNew) {
        this.delayUrlsNew = delayUrlsNew;
    }

    /**
     * URL延时请求列表(以英文分号为分割符)
     */
    private String delayUrlsNew;
    /**
     * URL延时请求列表对应的延时时间(秒)
     */
    private int delayUrlTime;
    /**
     * 消息图片前缀
     */
    private String messagePrefixPic;
    /**
     * 消息详情需要传ID的值
     */
    private String messageInfoPage;
    /**
     * 列表消息每页大小
     */
    private int messagePageSize;


    /**
     * 大板车招聘查询条数
     */
    private int bCarRecruitPageSize;


    /**
     * 商户列表数据条数
     */
    private int merchantPageSize=15;//	15	数字	商户列表数据条数
    /**
     * 商户列表附近公里数
     */
    private int merchantNeighborRange=100;//	100	数字	商户列表附近公里数
    /**
     * 商户地图附近公里数
     */
    private int merchantMapNeighborRange=100;//	100	数字	商户地图附近公里数
    /**
     * 商户地图移动公里数
     */
    private int merchantMapMoveRange=5;//	5	数字	商户地图移动公里数
    /**
     * 维修师列表数据条数
     */
    private int merchantServicePageSize=15;//	15	数字	维修师列表数据条数
    /**
     * 维修师列表附近公里数
     */
    private int merchantServiceNeighborRange=100;//	100	数字	维修师列表附近公里数
    /**
     * 维修师地图附近公里数
     */
    private int merchantServiceMapNeighborRange=100;//	100	数字	维修师地图附近公里数
    /**
     * 维修师地图移动公里数
     */
    private int merchantServiceMapMoveRange=1;//	数字	维修师地图移动公里数
    /**
     * 实时位置采集间隔时间，单位分钟
     */
    private int currentLocationCollectionIntervalTime=10;//	10	数字	实时位置采集间隔时间，单位分钟
    /**
     * 	重卡维修 、重卡修理、重卡汽修、重汽维修、重汽修理、重汽汽修	字符串	板车维修高德关键字
     */
    private String bcarMerchantAmapKeyWord="";//	重卡维修 、重卡修理、重卡汽修、重汽维修、重汽修理、重汽汽修	字符串	板车维修高德关键字
    /**
     * 	重卡配件、重汽配件	字符串	板车配件商高德关键字
     */
    private String bcarMaintainerAmapKeyWord="";//	重卡配件、重汽配件	字符串	板车配件商高德关键字

    /**
     * 挖机维修、挖掘机维修、装载机维修、铲车维修、工程机械维修、工程机械修理	字符串	设备维修高德关键字
     */
    private String scarMerchantAmapKeyWord="";//	挖机维修、挖掘机维修、装载机维修、铲车维修、工程机械维修、工程机械修理	字符串	设备维修高德关键字
    /**
     * 	挖机配件、挖掘机配件、装载机配件、铲车配件、工程机械配件	字符串	设备配件商高德关键字
     */
    private String scarMaintainerAmapKeyWord="";//	挖机配件、挖掘机配件、装载机配件、铲车配件、工程机械配件	字符串	设备配件商高德关键字

    /**
     * 维修师图片:链接
     */
    private String maintainerPic;

    /**
     * 维修师技能数量限制
     * @return
     */
    public int maintainerMaxTechnicalNumber;


    /**
     * 新增key为server_notify_pic，值为http://www.teyuntong.com/plat/picture/server_notify.png#http://xxxx#1#1#1
     * 接口文档1.73
     * 格式为”图片url#点击图片需要跳转的地址#app页面标示符#关闭状态值#页面打开方式”
     *
     */
    private String serverNotiyPic;

    /**
     * APP发货新手帮助链接
     */
    private String appFahuoXinshouHelp;

    /**
     * 提现规则页面
     */
    private String withdrawCashRegular;
    /**
     * 货源帮助
     */
    private String goodsHelp;
    /**
     * 接单帮助
     */
    private String acceptOdersHelp;
    /**
     * 担保申明
     */
    private String GuaranteeDeclare;


    public int getNoticeLoopCheckTime() {
        return noticeLoopCheckTime;
    }

    public void setNoticeLoopCheckTime(int noticeLoopCheckTime) {
        this.noticeLoopCheckTime = noticeLoopCheckTime;
    }

    /**
     *通知循环检测时间(单位s)
     */
    private int noticeLoopCheckTime;

    public int getCashWithdrawalMinimumAmount() {
        return cashWithdrawalMinimumAmount;
    }

    public void setCashWithdrawalMinimumAmount(int cashWithdrawalMinimumAmount) {
        this.cashWithdrawalMinimumAmount = cashWithdrawalMinimumAmount;
    }

    /**
     * 提现最小金额
     */
    private int cashWithdrawalMinimumAmount;

    public String getWithdrawCashRegular() {
        return withdrawCashRegular;
    }

    public void setWithdrawCashRegular(String withdrawCashRegular) {
        this.withdrawCashRegular = withdrawCashRegular;
    }

    public String getGoodsHelp() {
        return goodsHelp;
    }

    public void setGoodsHelp(String goodsHelp) {
        this.goodsHelp = goodsHelp;
    }

    public String getAcceptOdersHelp() {
        return acceptOdersHelp;
    }

    public void setAcceptOdersHelp(String acceptOdersHelp) {
        this.acceptOdersHelp = acceptOdersHelp;
    }

    public String getGuaranteeDeclare() {
        return GuaranteeDeclare;
    }

    public void setGuaranteeDeclare(String guaranteeDeclare) {
        GuaranteeDeclare = guaranteeDeclare;
    }

    public String getAppFahuoXinshouHelp() {
        return appFahuoXinshouHelp;
    }

    public void setAppFahuoXinshouHelp(String appFahuoXinshouHelp) {
        this.appFahuoXinshouHelp = appFahuoXinshouHelp;
    }

    public String getServerNotiyPic() {
        return serverNotiyPic;
    }

    public void setServerNotiyPic(String serverNotiyPic) {
        this.serverNotiyPic = serverNotiyPic;
    }

    public int getMaintainerMaxTechnicalNumber() {
        return maintainerMaxTechnicalNumber;
    }

    public void setMaintainerMaxTechnicalNumber(int maintainerMaxTechnicalNumber) {
        this.maintainerMaxTechnicalNumber = maintainerMaxTechnicalNumber;
    }

    public int getbCarRecruitPageSize() {
        return bCarRecruitPageSize;
    }

    public void setbCarRecruitPageSize(int bCarRecruitPageSize) {
        this.bCarRecruitPageSize = bCarRecruitPageSize;
    }

    public int getbCarJobPageSize() {
        return bCarJobPageSize;
    }

    public void setbCarJobPageSize(int bCarJobPageSize) {
        this.bCarJobPageSize = bCarJobPageSize;
    }

    public int getbCarRecruitSwitchTime() {
        return bCarRecruitSwitchTime;
    }

    public void setbCarRecruitSwitchTime(int bCarRecruitSwitchTime) {
        this.bCarRecruitSwitchTime = bCarRecruitSwitchTime;
    }

    public int getbCarJobSwitchTime() {
        return bCarJobSwitchTime;
    }

    public void setbCarJobSwitchTime(int bCarJobSwitchTime) {
        this.bCarJobSwitchTime = bCarJobSwitchTime;
    }

    public int getHomePageSwitchTime() {
        return homePageSwitchTime;
    }

    public void setHomePageSwitchTime(int homePageSwitchTime) {
        this.homePageSwitchTime = homePageSwitchTime;
    }

    public int getWordBookVersion() {
        return wordBookVersion;
    }

    public void setWordBookVersion(int wordBookVersion) {
        this.wordBookVersion = wordBookVersion;
    }

    /**
     * 大板车求职查询条数
     */
    private int bCarJobPageSize;

    private int bCarRecruitSwitchTime;

    private int bCarJobSwitchTime;

    private int homePageSwitchTime;

    private int wordBookVersion;


    private String exPartyGoods;//	1,车主爽约;2,其他	String	异常上报发货方
    private String exPartyCar;//	1,发货方爽约;2,不想拉了;3,实际情况与特运通上看到的不一致;4,骗子信息，根本没货;5,货已拉走;6,装货时间延长;7,运价纠纷;8,其他	String	异常上报车主方
    private int wayBillLoadTime;//	3	Integer	系统第几天自动完成装货的提醒天数



    public void setTeyuntongAddress(String teyuntongAddress) {
        this.teyuntongAddress = teyuntongAddress;
    }

    public String getTeyuntongAddress() {
        return teyuntongAddress;
    }

    /**
     * 公司地址
     */
    private String teyuntongAddress;
    public String getMessagePrefixPic() {
        return messagePrefixPic;
    }
    public void setMessagePrefixPic(String messagePrefixPic) {
        this.messagePrefixPic = messagePrefixPic;
    }
    public String getMessageInfoPage() {
        return messageInfoPage;
    }
    public void setMessageInfoPage(String messageInfoPage) {
        this.messageInfoPage = messageInfoPage;
    }
    public int getMessagePageSize() {
        return messagePageSize;
    }
    public void setMessagePageSize(int messagePageSize) {
        this.messagePageSize = messagePageSize;
    }
    public int getSwitchIntervalTime() {
        return switchIntervalTime;
    }
    public void setSwitchIntervalTime(int switchIntervalTime) {
        this.switchIntervalTime = switchIntervalTime;
    }
    public int getSlideMaxSize() {
        return slideMaxSize;
    }
    public void setSlideMaxSize(int slideMaxSize) {
        this.slideMaxSize = slideMaxSize;
    }
    public int getFirstQuerySize() {
        return firstQuerySize;
    }
    public void setFirstQuerySize(int firstQuerySize) {
        this.firstQuerySize = firstQuerySize;
    }
    public int getAutoRefreshIntervalTime() {
        return autoRefreshIntervalTime;
    }
    public void setAutoRefreshIntervalTime(int autoRefreshIntervalTime) {
        this.autoRefreshIntervalTime = autoRefreshIntervalTime;
    }
    public int getCallPhoneActionLog() {
        return callPhoneActionLog;
    }
    public void setCallPhoneActionLog(int callPhoneActionLog) {
        this.callPhoneActionLog = callPhoneActionLog;
    }
    public int getSortAcitonLog() {
        return sortAcitonLog;
    }
    public void setSortAcitonLog(int sortAcitonLog) {
        this.sortAcitonLog = sortAcitonLog;
    }

    public String getMaintainerPic() {
        return maintainerPic;
    }

    public void setMaintainerPic(String maintainerPic) {
        this.maintainerPic = maintainerPic;
    }

    /**
     * 如果没有找到默认值，则返回null。注意检查
     * @return
     */
    public SearchDistanceParam getStartDistanceDefaultValue(){
        return getDistanceDefaultValue(startDistances);
    }
    /**
     * 如果没有找到默认值，则返回null。注意检查
     * @return
     */
    public SearchDistanceParam getDestDistanceDefaultValue(){
        return getDistanceDefaultValue(destDistances);
    }

    private SearchDistanceParam getDistanceDefaultValue(List<SearchDistanceParam> list){
        if(list!=null&&list.size()>0){
            int size=list.size();
            for(int i=0;i<size;i++){
                SearchDistanceParam sdp=list.get(i);
                if(sdp.getIsDefault()==1){
                    return sdp;
                }
            }
        }

        return new SearchDistanceParam();

    }

    public List<SearchDistanceParam> getStartDistances() {
        return startDistances;
    }

    public void setStartDistances(List<SearchDistanceParam> startDistances) {
        this.startDistances = startDistances;
    }

    public List<SearchDistanceParam> getDestDistances() {
        return destDistances;
    }

    public void setDestDistances(List<SearchDistanceParam> destDistances) {
        this.destDistances = destDistances;
    }

    public String getWeatherUrl() {
        return weatherUrl;
    }

    public void setWeatherUrl(String weatherUrl) {
        this.weatherUrl = weatherUrl;
    }

    public String getPrefixPicture() {
        return prefixPicture;
    }

    public void setPrefixPicture(String prefixPicture) {
        this.prefixPicture = prefixPicture;
    }

    public String getServerMapUrl() {
        return serverMapUrl;
    }

    public void setServerMapUrl(String serverMapUrl) {
        this.serverMapUrl = serverMapUrl;
    }

    public String getHelpUrl() {
        return helpUrl;
    }

    public void setHelpUrl(String helpUrl) {
        this.helpUrl = helpUrl;
    }

    public String getAgreementUrl() {
        return agreementUrl;
    }

    public void setAgreementUrl(String agreementUrl) {
        this.agreementUrl = agreementUrl;
    }

    public String getInsureUrl() {
        return insureUrl;
    }

    public void setInsureUrl(String insureUrl) {
        this.insureUrl = insureUrl;
    }

    public String getInsureOtherUrl() {
        return insureOtherUrl;
    }

    public void setInsureOtherUrl(String insureOtherUrl) {
        this.insureOtherUrl = insureOtherUrl;
    }

    public String getPraiseRecommendUrl() {
        return praiseRecommendUrl;
    }

    public void setPraiseRecommendUrl(String praiseRecommendUrl) {
        this.praiseRecommendUrl = praiseRecommendUrl;
    }

    public String getUserAuthUrl() {
        return userAuthUrl;
    }

    public void setUserAuthUrl(String userAuthUrl) {
        this.userAuthUrl = userAuthUrl;
    }

    public String getTwoDimensionUrl() {
        return twoDimensionUrl;
    }

    public void setTwoDimensionUrl(String twoDimensionUrl) {
        this.twoDimensionUrl = twoDimensionUrl;
    }

    public String getAboutUsUrL() {
        return aboutUsUrL;
    }

    public void setAboutUsUrL(String aboutUsUrL) {
        this.aboutUsUrL = aboutUsUrL;
    }

    public String getInstructionUrl() {
        return instructionUrl;
    }

    public void setInstructionUrl(String instructionUrl) {
        this.instructionUrl = instructionUrl;
    }

    public String getCarAuthUrl() {
        return carAuthUrl;
    }

    public void setCarAuthUrl(String carAuthUrl) {
        this.carAuthUrl = carAuthUrl;
    }

    public String getPraiseDriverPic() {
        return praiseDriverPic;
    }

    public void setPraiseDriverPic(String praiseDriverPic) {
        this.praiseDriverPic = praiseDriverPic;
    }

    public String getPraiseCarPic() {
        return praiseCarPic;
    }

    public void setPraiseCarPic(String praiseCarPic) {
        this.praiseCarPic = praiseCarPic;
    }

    public String getPraiseGoodsPic() {
        return praiseGoodsPic;
    }

    public void setPraiseGoodsPic(String praiseGoodsPic) {
        this.praiseGoodsPic = praiseGoodsPic;
    }

    public String getPraiseDriverUrl() {
        return praiseDriverUrl;
    }

    public void setPraiseDriverUrl(String praiseDriverUrl) {
        this.praiseDriverUrl = praiseDriverUrl;
    }

    public String getPraiseCarUrl() {
        return praiseCarUrl;
    }

    public void setPraiseCarUrl(String praiseCarUrl) {
        this.praiseCarUrl = praiseCarUrl;
    }

    public String getPraiseGoodsUrl() {
        return praiseGoodsUrl;
    }

    public void setPraiseGoodsUrl(String praiseGoodsUrl) {
        this.praiseGoodsUrl = praiseGoodsUrl;
    }

    public int getRefreshIntervalTime() {
        return refreshIntervalTime;
    }

    public void setRefreshIntervalTime(int refreshIntervalTime) {
        this.refreshIntervalTime = refreshIntervalTime;
    }

    public String getTurnPicturesPrefix() {
        return turnPicturesPrefix;
    }

    public void setTurnPicturesPrefix(String turnPicturesPrefix) {
        this.turnPicturesPrefix = turnPicturesPrefix;
    }

    public String getTurnPictures() {
        return turnPictures;
    }

    public void setTurnPictures(String turnPictures) {
        this.turnPictures = turnPictures;
    }

    public static CommonResources obtain(JSONArray jas){
        CommonResources resources = new CommonResources();
        for (int i = 0; i < jas.length(); i++) {
            try {

                JSONObject js = jas.getJSONObject(i);


                String field=js.optString(JsonTag.NAME);

                if("help_url".equals(field)){
                    resources.setHelpUrl(js.optString(JsonTag.VALUE));
                }else if("agreement_url".equals(field)){
                    // 隐私协议
                    resources.setAgreementUrl(js.optString(JsonTag.VALUE));
                }else if("insure_url".equals(field)){
                    // 保定用户保险页面地址
                    resources.setInsureUrl(js.optString(JsonTag.VALUE));
                }else if("insure_other_url".equals(field)){
                    // 非保定用户保险页面地址
                    resources.setInsureOtherUrl(js.optString(JsonTag.VALUE));
                }else if("about_us_url".equals(field)){
                    // 关于我们页面地址
                    resources.setAboutUsUrL(js.optString(JsonTag.VALUE));
                }else if("praise_recommend_url".equals(field)){
                    // 有奖推荐活动页面地址
                    resources.setPraiseRecommendUrl(js.optString(JsonTag.VALUE));
                }else if("user_auth_url".equals(field)){
                    // 用户实名认证说明地址
                    resources.setUserAuthUrl(js.optString(JsonTag.VALUE));
                }else if("two_dimension_url".equals(field)){
                    // 二维码页面地址
                    resources.setTwoDimensionUrl(js.optString(JsonTag.VALUE));
                }else if("instruction_url".equals(field)){
                    resources.setInstructionUrl(js.optString(JsonTag.VALUE));
                }else if("car_auth_url".equals(field)){
                    // 车辆认证协议
                    resources.setCarAuthUrl(js.optString(JsonTag.VALUE));
                }else if("user_auth_url".equals(field)){
                    // 用户认证协议"
                    resources.setUserAuthUrl(js.optString(JsonTag.VALUE));
                }else if("refresh_interval_time".equals(field)){
                    // 客户端每隔多少秒允许请求一次单位秒
                    resources.setRefreshIntervalTime(js.optInt(JsonTag.VALUE));
                }else if("praise_driver_pic".equals(field)){
                    // 司机奖励政策宣传图
                    resources.setPraiseDriverPic(js.optString(JsonTag.VALUE));
                }else if("praise_car_pic".equals(field)){
                    // 车主奖励政策宣传图
                    resources.setPraiseCarPic(js.optString(JsonTag.VALUE));
                }else if("praise_goods_pic".equals(field)){
                    // 货主奖励政策宣传图
                    resources.setPraiseGoodsPic(js.optString(JsonTag.VALUE));
                }else if("praise_driver_url".equals(field)){
                    // 司机奖励链接地址
                    resources.setPraiseDriverUrl(js.optString(JsonTag.VALUE));
                }else if("praise_car_url".equals(field)){
                    // 车主奖励链接地址
                    resources.setPraiseCarUrl(js.optString(JsonTag.VALUE));
                }else if("praise_goods_url".equals(field)){
                    // 货主奖励地址
                    resources.setPraiseGoodsUrl(js.optString(JsonTag.VALUE));
                }else if("server_map_url".equals(field)){
                    // 地图
                    resources.setServerMapUrl(js.optString(JsonTag.VALUE));
                }else if("prefix_picture".equals(field)){
                    resources.setPrefixPicture(js.optString(JsonTag.VALUE));
                    CommonDefine.URL_BASE_IMG = resources.getPrefixPicture();
                }else if("weather_url".equals(field)){
                    resources.setWeatherUrl(js.optString(JsonTag.VALUE));
                }else if("startDistance".equals(field)){

                    resources.setStartDistances(getDistance(js.optString(JsonTag.VALUE)));
                    //JSONArray tArray=js.optJSONArray(JsonTag.VALUE);
                    //还未实现
                }else if("destDistance".equals(field)){
                    resources.setDestDistances(getDistance(js.optString(JsonTag.VALUE)));
                }else if("sortAcitonLog".equals(field)){
                    resources.setSortAcitonLog(js.optInt(JsonTag.VALUE, 0));
                }else if("callPhoneActionLog".equals(field)){
                    resources.setCallPhoneActionLog(js.optInt(JsonTag.VALUE, 0));
                }else if("slideMaxSize".equals(field)){
                    resources.setSlideMaxSize(js.optInt(JsonTag.VALUE, 30));
                }else if("firstQuerySize".equals(field)){
                    resources.setFirstQuerySize(js.optInt(JsonTag.VALUE, 100));
                }else if("autoRefreshIntervalTime".equals(field)){
                    resources.setAutoRefreshIntervalTime(js.optInt(JsonTag.VALUE, 40));
                }else if("switchIntervalTime".equals(field)){
                    resources.setSwitchIntervalTime(js.optInt(JsonTag.VALUE, 60));
                }else if("nearbyHignWaySearchRange".equals(field)){
                    resources.setNearbyHignWaySearchRange(js.optInt(JsonTag.VALUE,15));
                }else if("nearbyAccommodationSearchRange".equals(field)){
                    resources.setNearbyAccommodationSearchRange(js.optInt(JsonTag.VALUE,5));
                }else if("nearbyBankSearchRange".equals(field)){
                    resources.setNearbyBankSearchRange(js.optInt(JsonTag.VALUE,5));
                }else if("nearbyHignRestaurantRange".equals(field)){
                    resources.setNearbyHignRestaurantRange(js.optInt(JsonTag.VALUE,5));
                }else if("nearbyBathSearchRange".equals(field)){
                    resources.setNearbyBathSearchRange(js.optInt(JsonTag.VALUE,5));
                }else if("nearbyGasStationSearchRange".equals(field)){
                    resources.setNearbyGasStationSearchRange(js.optInt(JsonTag.VALUE,5));
                }else if("epayurl".equals(field)){
                    resources.setEpayurl(js.optString(JsonTag.VALUE,""));
                }else if("vipMessage0".equals(field)){
                    resources.setVipMessage0(js.optString(JsonTag.VALUE,""));
                }else if("trialMessage0".equals(field)){
                    resources.setTrialMessage0(js.optString(JsonTag.VALUE,""));
                }else if("vipMessageN".equals(field)){
                    resources.setVipMessageN(js.optString(JsonTag.VALUE,""));
                }else if("trialMessageN".equals(field)){
                    resources.setTrialMessageN(js.optString(JsonTag.VALUE,""));
                }else if("vipDaysN".equals(field)){
                    resources.setVipDaysN(js.optInt(JsonTag.VALUE,3));
                }else if("trialDaysN".equals(field)){
                    resources.setTrialDaysN(js.optInt(JsonTag.VALUE,3));
                }else if("vipMesageSwitch0".equals(field)){
                    resources.setVipMesageSwitch0(js.optInt(JsonTag.VALUE,1));
                }else if("vipMesageSwitchN".equals(field)){
                    resources.setVipMesageSwitchN(js.optInt(JsonTag.VALUE,1));
                }else if("trialMesageSwitch0".equals(field)){
                    resources.setTrialMesageSwitch0(js.optInt(JsonTag.VALUE,1));
                }else if("trialMesageSwitcN".equals(field)){
                    resources.setTrialMesageSwitcN(js.optInt(JsonTag.VALUE,1));
                }else if("delayUrls".equals(field)){
                    resources.setDelayUrls(js.optString(JsonTag.VALUE,""));
                }else if("delayUrlTime".equals(field)){
                    resources.setDelayUrlTime(js.optInt(JsonTag.VALUE,1));
                }else if("customerServicePhone".equals(field)){
                    CommonDefine.TYT_SERVICE=js.optString(JsonTag.VALUE,"400-6688-998");
                }else if("messagePrefixPic".equals(field)){
                    resources.setMessagePrefixPic(js.optString(JsonTag.VALUE,""));
                }else if("messageInfoPage".equals(field)){
                    resources.setMessageInfoPage(js.optString(JsonTag.VALUE,""));
                }else if("messagePageSize".equals(field)){
                    resources.setMessagePageSize(js.optInt(JsonTag.VALUE,1));
                }else if("teyuntongAddress".equals(field)){
                    resources.setTeyuntongAddress(js.optString(JsonTag.VALUE,""));
                }else if("bCarRecruitPageSize".equals(field)){
                    resources.setbCarRecruitPageSize(js.optInt(JsonTag.VALUE,30));
                }else if("bCarJobPageSize".equals(field)){
                    resources.setbCarJobPageSize(js.optInt(JsonTag.VALUE,30));
                }else if("bCarRecruitSwitchTime".equals(field)){
                    resources.setbCarRecruitSwitchTime(js.optInt(JsonTag.VALUE,10));
                }else if("bCarJobSwitchTime".equals(field)){
                    resources.setbCarJobSwitchTime(js.optInt(JsonTag.VALUE,10));
                }else if("homePageSwitchTime".equals(field)){
                    resources.setHomePageSwitchTime(js.optInt(JsonTag.VALUE,10));
                }else if("wordBookVersion".equals(field)) {
                    resources.setWordBookVersion(js.optInt(JsonTag.VALUE, 1));

                }else if("turnPicturesPrefix".equals(field)){
                    resources.setTurnPicturesPrefix(js.optString(JsonTag.VALUE,""));
                }else if("turnPictures".equals(field)){
                    resources.setTurnPictures(js.optString(JsonTag.VALUE,""));

                }else if("turnPicturesTitleLinks".equals(field)){
                    resources.setTurnPicturesTitleLinks(js.optString(JsonTag.VALUE,""));
                }else if("drivingSchool".equals(field)){
                    resources.setDrivingSchool(js.optString(JsonTag.VALUE,""));
                }else if("carNewsListPicture".equals(field)){
                    resources.setCarNewsListPicture(js.optString(JsonTag.VALUE,""));
                }else if("carNewsPageSize".equals(field)){
                    resources.setCarNewsPageSize(js.optString(JsonTag.VALUE,""));
                }else if("noPublishBcarJobTip".equals(field)){
                    resources.setNoPublishBcarJobTip(js.optString(JsonTag.VALUE,""));
                }else if("noPublishBcarRecruitTip".equals(field)){
                    resources.setNoPublishBcarRecruitTip(js.optString(JsonTag.VALUE,""));
                }else if("noPublishScarJobTip".equals(field)){
                    resources.setNoPublishScarJobTip(js.optString(JsonTag.VALUE,""));
                }else if("noPublishScarRecruitTip".equals(field)){
                    resources.setNoPublishScarRecruitTip(js.optString(JsonTag.VALUE,""));
                }else if("carNewsListPictureLinkUrl".equals(field)){
                    resources.setCarNewsListPictureLinkUrl(js.optString(JsonTag.VALUE,""));
                }else if("merchantPageSize".equals(field)){
                    resources.setMerchantPageSize(js.optInt(JsonTag.VALUE));
                }else if("merchantNeighborRange".equals(field)){
                    resources.setMerchantNeighborRange(js.optInt(JsonTag.VALUE));
                }else if("merchantMapNeighborRange".equals(field)){
                    resources.setMerchantMapNeighborRange(js.optInt(JsonTag.VALUE));
                }else if("merchantMapMoveRange".equals(field)){
                    resources.setMerchantMapMoveRange(js.optInt(JsonTag.VALUE));
                }else if("merchantServicePageSize".equals(field)){
                    resources.setMerchantServicePageSize(js.optInt(JsonTag.VALUE));
                }else if("merchantServiceNeighborRange".equals(field)){
                    resources.setMerchantServiceNeighborRange(js.optInt(JsonTag.VALUE));
                }else if("merchantServiceMapNeighborRange".equals(field)){
                    resources.setMerchantServiceMapNeighborRange(js.optInt(JsonTag.VALUE));
                }else if("merchantServiceMapMoveRange".equals(field)){
                    resources.setMerchantServiceMapMoveRange(js.optInt(JsonTag.VALUE));
                }else if("currentLocationCollectionIntervalTime".equals(field)){
                    resources.setCurrentLocationCollectionIntervalTime(js.optInt(JsonTag.VALUE));
                }else if("bcarMerchantAmapKeyWord".equals(field)){
                    resources.setBcarMerchantAmapKeyWord(js.optString(JsonTag.VALUE,""));
                }else if("bcarMaintainerAmapKeyWord".equals(field)){
                    resources.setBcarMaintainerAmapKeyWord(js.optString(JsonTag.VALUE,""));
                }else if("scarMerchantAmapKeyWord".equals(field)){
                    resources.setScarMerchantAmapKeyWord(js.optString(JsonTag.VALUE,""));
                }else if("scarMaintainerAmapKeyWord".equals(field)){
                    resources.setScarMaintainerAmapKeyWord(js.optString(JsonTag.VALUE,""));
                }else if("maintainerPic".equals(field)){
                    resources.setMaintainerPic(js.optString(JsonTag.VALUE,""));
                }else if("maintainerMaxTechnicalNumber".equals(field)){
                    resources.setMaintainerMaxTechnicalNumber(js.optInt(JsonTag.VALUE));
                }else if("server_notify_pic".equals(field)){
                    resources.setServerNotiyPic(js.optString(JsonTag.VALUE,""));
                }else if("deliver_goods_notify".equals(field)){
                    resources.setDeliverGoodsNotify(js.optString(JsonTag.VALUE,""));
                }else if("delayUrlsNew".equals(field)){
                    resources.setDelayUrlsNew(js.optString(JsonTag.VALUE,""));
                }else if("appFahuoXinshouHelp".equals(field)){
                    resources.setAppFahuoXinshouHelp(js.optString(JsonTag.VALUE,""));
                }else if("moreCarSwitchWaitTime".equals(field)){
                    resources.setMoreCarSwitchWaitTime(js.optLong(JsonTag.VALUE,10));

                }else if("withdrawCashRegular".equals(field)){ //提现规则页面
                    resources.setWithdrawCashRegular(js.optString(JsonTag.VALUE,""));
                }else if("goodsHelp".equals(field)){//货源帮助页面
                    resources.setGoodsHelp(js.optString(JsonTag.VALUE,""));
                }else if("acceptOdersHelp".equals(field)){//接单帮助页面
                    resources.setAcceptOdersHelp(js.optString(JsonTag.VALUE,""));
                }else if("guaranteeDeclare".equals(field)){//担保申明页面
                    resources.setGuaranteeDeclare(js.optString(JsonTag.VALUE,""));
                }else if("ex_party_goods".equals(field)){	//1,车主爽约;2,其他	String	异常上报发货方
                    resources.setExPartyGoods(js.optString(JsonTag.VALUE,""));


                    String[] keyValue=resources.getExPartyGoods().split("\\|");

                    for(int k=0;k<keyValue.length;k++){
                        String[] lll=keyValue[k].split("#");
                        resources.getExPartyGoodsMap().put(lll[0],lll[1]);
                    }

                }else if("ex_party_car".equals(field)){
                    resources.setExPartyCar(js.optString(JsonTag.VALUE,""));
                    String[] keyValue=resources.getExPartyCar().split("\\|");

                    for(int k=0;k<keyValue.length;k++){

                        String[] lll=keyValue[k].split("#");
                        resources.getExPartyCarMap().put(lll[0],lll[1]);
                    }


                }else if("way_bill_load_time".equals(field)){
                    resources.setWayBillLoadTime(js.optInt(JsonTag.VALUE));
                }else if("noticeLoopCheckTime".equals(field)){
                    resources.setNoticeLoopCheckTime(js.optInt(JsonTag.VALUE));
                }else if("cashWithdrawalMinimumAmount".equals(field)){
                    resources.setCashWithdrawalMinimumAmount(js.optInt(JsonTag.VALUE));
                }else if("accountPassword".equals(field)){
                    resources.setAccountPassword(js.optString(JsonTag.VALUE));
                }else if("serverLocations".equals(field)){
                    resources.setServerLocations(js.optString(JsonTag.VALUE));
                }




				/*

	private String ex_party_car;//	1,发货方爽约;2,不想拉了;3,实际情况与特运通上看到的不一致;4,骗子信息，根本没货;5,货已拉走;6,装货时间延长;7,运价纠纷;8,其他	String	异常上报车主方
	private int way_bill_load_time;
				 */

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        String tttt=resources.getAccountPassword();
        String sfsfsf=resources.getServerLocations();
        String sfs=tttt;
        String sfssss=tttt;
        return resources;
    }



    public String getExPartyGoods() {
        return exPartyGoods;
    }
    /**
     * key 是int value 是text文案
     * @return
     */
    private Map<String,String> exPartyGoodsMap=new HashMap<String,String>();
    public void setExPartyGoods(String exPartyGoods) {
        this.exPartyGoods = exPartyGoods;
    }

    /**
     * key 是int value 是text文案
     * @return
     */
    public Map<String, String> getExPartyCarMap() {
        return exPartyCarMap;
    }

    public void setExPartyCarMap(Map<String, String> exPartyCarMap) {
        this.exPartyCarMap = exPartyCarMap;
    }

    public Map<String, String> getExPartyGoodsMap() {
        return exPartyGoodsMap;
    }

    public void setExPartyGoodsMap(Map<String, String> exPartyGoodsMap) {
        this.exPartyGoodsMap = exPartyGoodsMap;
    }

    private Map<String,String> exPartyCarMap=new HashMap<String,String>();
    public String getExPartyCar() {
        return exPartyCar;
    }

    public void setExPartyCar(String exPartyCar) {
        this.exPartyCar = exPartyCar;
    }

    public int getWayBillLoadTime() {
        return wayBillLoadTime;
    }

    public void setWayBillLoadTime(int wayBillLoadTime) {
        this.wayBillLoadTime = wayBillLoadTime;
    }

    public int getMerchantPageSize() {
        return merchantPageSize;
    }

    public void setMerchantPageSize(int merchantPageSize) {
        this.merchantPageSize = merchantPageSize;
    }

    public int getMerchantNeighborRange() {
        return merchantNeighborRange;
    }

    public void setMerchantNeighborRange(int merchantNeighborRange) {
        this.merchantNeighborRange = merchantNeighborRange;
    }

    public int getMerchantMapNeighborRange() {
        return merchantMapNeighborRange;
    }

    public void setMerchantMapNeighborRange(int merchantMapNeighborRange) {
        this.merchantMapNeighborRange = merchantMapNeighborRange;
    }

    public int getMerchantMapMoveRange() {
        return merchantMapMoveRange;
    }

    public void setMerchantMapMoveRange(int merchantMapMoveRange) {
        this.merchantMapMoveRange = merchantMapMoveRange;
    }

    public int getMerchantServicePageSize() {
        return merchantServicePageSize;
    }

    public void setMerchantServicePageSize(int merchantServicePageSize) {
        this.merchantServicePageSize = merchantServicePageSize;
    }

    public int getMerchantServiceNeighborRange() {
        return merchantServiceNeighborRange;
    }

    public void setMerchantServiceNeighborRange(int merchantServiceNeighborRange) {
        this.merchantServiceNeighborRange = merchantServiceNeighborRange;
    }

    public int getMerchantServiceMapNeighborRange() {
        return merchantServiceMapNeighborRange;
    }

    public void setMerchantServiceMapNeighborRange(int merchantServiceMapNeighborRange) {
        this.merchantServiceMapNeighborRange = merchantServiceMapNeighborRange;
    }

    public int getMerchantServiceMapMoveRange() {
        return merchantServiceMapMoveRange;
    }

    public void setMerchantServiceMapMoveRange(int merchantServiceMapMoveRange) {
        this.merchantServiceMapMoveRange = merchantServiceMapMoveRange;
    }

    public int getCurrentLocationCollectionIntervalTime() {
        return currentLocationCollectionIntervalTime;
    }

    public void setCurrentLocationCollectionIntervalTime(int currentLocationCollectionIntervalTime) {
        this.currentLocationCollectionIntervalTime = currentLocationCollectionIntervalTime;
    }

    public String getBcarMerchantAmapKeyWord() {
        return bcarMerchantAmapKeyWord;
    }

    public void setBcarMerchantAmapKeyWord(String bcarMerchantAmapKeyWord) {
        this.bcarMerchantAmapKeyWord = bcarMerchantAmapKeyWord;
    }

    public String getBcarMaintainerAmapKeyWord() {
        return bcarMaintainerAmapKeyWord;
    }

    public void setBcarMaintainerAmapKeyWord(String bcarMaintainerAmapKeyWord) {
        this.bcarMaintainerAmapKeyWord = bcarMaintainerAmapKeyWord;
    }

    public String getScarMerchantAmapKeyWord() {
        return scarMerchantAmapKeyWord;
    }

    public void setScarMerchantAmapKeyWord(String scarMerchantAmapKeyWord) {
        this.scarMerchantAmapKeyWord = scarMerchantAmapKeyWord;
    }

    public String getScarMaintainerAmapKeyWord() {
        return scarMaintainerAmapKeyWord;
    }

    public void setScarMaintainerAmapKeyWord(String scarMaintainerAmapKeyWord) {
        this.scarMaintainerAmapKeyWord = scarMaintainerAmapKeyWord;
    }

    public String getEpayurl() {
        return epayurl;
    }
    public void setEpayurl(String epayurl) {
        this.epayurl = epayurl;
    }
    public String getVipMessage0() {
        return vipMessage0;
    }
    public void setVipMessage0(String vipMessage0) {
        this.vipMessage0 = vipMessage0;
    }
    public String getTrialMessage0() {
        return trialMessage0;
    }
    public void setTrialMessage0(String trialMessage0) {
        this.trialMessage0 = trialMessage0;
    }
    public String getVipMessageN() {
        return vipMessageN;
    }
    public void setVipMessageN(String vipMessageN) {
        this.vipMessageN = vipMessageN;
    }
    public String getTrialMessageN() {
        return trialMessageN;
    }
    public void setTrialMessageN(String trialMessageN) {
        this.trialMessageN = trialMessageN;
    }
    public int getVipDaysN() {
        return vipDaysN;
    }
    public void setVipDaysN(int vipDaysN) {
        this.vipDaysN = vipDaysN;
    }
    public int getTrialDaysN() {
        return trialDaysN;
    }
    public void setTrialDaysN(int trialDaysN) {
        this.trialDaysN = trialDaysN;
    }
    public int getVipMesageSwitch0() {
        return vipMesageSwitch0;
    }
    public void setVipMesageSwitch0(int vipMesageSwitch0) {
        this.vipMesageSwitch0 = vipMesageSwitch0;
    }
    public int getVipMesageSwitchN() {
        return vipMesageSwitchN;
    }
    public void setVipMesageSwitchN(int vipMesageSwitchN) {
        this.vipMesageSwitchN = vipMesageSwitchN;
    }
    public int getTrialMesageSwitch0() {
        return trialMesageSwitch0;
    }
    public void setTrialMesageSwitch0(int trialMesageSwitch0) {
        this.trialMesageSwitch0 = trialMesageSwitch0;
    }
    public int getTrialMesageSwitcN() {
        return trialMesageSwitcN;
    }
    public void setTrialMesageSwitcN(int trialMesageSwitcN) {
        this.trialMesageSwitcN = trialMesageSwitcN;
    }
    public String getDelayUrls() {
        return delayUrls;
    }
    public void setDelayUrls(String delayUrls) {
        this.delayUrls = delayUrls;
    }
    public int getDelayUrlTime() {
        return delayUrlTime;
    }
    public void setDelayUrlTime(int delayUrlTime) {
        this.delayUrlTime = delayUrlTime;
    }
    private static List<SearchDistanceParam> getDistance(String stArray) throws JSONException {
        List<SearchDistanceParam> result=new ArrayList<SearchDistanceParam>(0);
        if(stArray.equals("")){
            return result;
        }

        String[] itemArrays=stArray.split(";");
        for(int i=0;i<itemArrays.length;i++){
            SearchDistanceParam distance=new SearchDistanceParam();
            String[] items=itemArrays[i].split(",");
            distance.setDistance(items[0]);
            distance.setDistanceDisplayText(items[1]);
            distance.setIsDefault(Integer.valueOf(items[2]));
            result.add(distance);
        }
        return result;
    }
    /**
     * 附近高速路搜索范围
     * @return
     */
    public int getNearbyHignWaySearchRange() {
        return nearbyHignWaySearchRange;
    }
    /**
     * 附近高速路搜索范围
     * @return
     */
    public void setNearbyHignWaySearchRange(int nearbyHignWaySearchRange) {
        this.nearbyHignWaySearchRange = nearbyHignWaySearchRange;
    }
    /**
     * 附近住宿搜索范围
     * @return
     */
    public int getNearbyAccommodationSearchRange() {
        return nearbyAccommodationSearchRange;
    }
    /**
     * 附近住宿搜索范围
     * @return
     */
    public void setNearbyAccommodationSearchRange(int nearbyAccommodationSearchRange) {
        this.nearbyAccommodationSearchRange = nearbyAccommodationSearchRange;
    }
    /**
     * 附近银行搜索范围
     * @return
     */
    public int getNearbyBankSearchRange() {
        return nearbyBankSearchRange;
    }
    /**
     * 附近银行搜索范围
     * @return
     */
    public void setNearbyBankSearchRange(int nearbyBankSearchRange) {
        this.nearbyBankSearchRange = nearbyBankSearchRange;
    }
    /**
     * 附近餐饮搜索范围
     * @return
     */
    public int getNearbyHignRestaurantRange() {
        return nearbyHignRestaurantRange;
    }
    /**
     * 附近餐饮搜索范围
     * @return
     */
    public void setNearbyHignRestaurantRange(int nearbyHignRestaurantRange) {
        this.nearbyHignRestaurantRange = nearbyHignRestaurantRange;
    }
    /**
     * 附近洗浴搜索范围
     * @return
     */
    public int getNearbyBathSearchRange() {
        return nearbyBathSearchRange;
    }
    /**
     * 附近洗浴搜索范围
     * @return
     */
    public void setNearbyBathSearchRange(int nearbyBathSearchRange) {
        this.nearbyBathSearchRange = nearbyBathSearchRange;
    }
    /**
     * 附近加油站搜索范围
     * @return
     */
    public int getNearbyGasStationSearchRange() {
        return nearbyGasStationSearchRange;
    }
    /**
     * 附近加油站搜索范围
     * @param nearbyGasStationSearchRange
     */
    public void setNearbyGasStationSearchRange(int nearbyGasStationSearchRange) {
        this.nearbyGasStationSearchRange = nearbyGasStationSearchRange;
    }
    @Override
    public String toString() {
        return "TytPublicUrl [helpUrl=" + helpUrl + ", agreementUrl=" + agreementUrl + ", insureUrl=" + insureUrl + ", insureOtherUrl=" + insureOtherUrl + ", aboutUsUrL="
                 + aboutUsUrL + ", praiseRecommendUrl=" + praiseRecommendUrl + ", userAuthUrl=" + userAuthUrl + ", twoDimensionUrl=" + twoDimensionUrl + ", instructionUrl="
                 + instructionUrl + ", carAuthUrl=" + carAuthUrl + ", praiseDriverPic=" + praiseDriverPic + ", praiseCarPic=" + praiseCarPic + ", praiseGoodsPic=" + praiseGoodsPic
                 + ", praiseDriverUrl=" + praiseDriverUrl + ", praiseCarUrl=" + praiseCarUrl + ", praiseGoodsUrl=" + praiseGoodsUrl + ", refreshIntervalTime=" + refreshIntervalTime
                 + "]";
    }



}
