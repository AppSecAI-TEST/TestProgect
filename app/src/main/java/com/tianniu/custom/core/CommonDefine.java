package com.tianniu.custom.core;

import android.util.SparseIntArray;

import com.tianniu.up.testprogect.BuildConfig;



public class CommonDefine {
    public static final String WIXIN_APPID="wx5d2fb6abfbeae5f0";
    /**
     * 标签
     */
    public static String IDENTITY_LABEL = "identity_lable_json";

    /**
     * 首页标题排序server_menu
     */
    public static String IDENTITY_LABEL_SERVER_MENU="server_menu";

    public static String CLIENT_VERSION = "3009";
    public static final String VERSION_STRING = "v3.0.0.9";

    public static final String UNION_PAY_MODE = "00"; // 01测试 //00正式

    public static final int NUMBER_FOR_BACKGROUND_THREAD = 7;
    // public static final int NUMBER_FOR_BACKGROUND_THREAD =
    // Runtime.getRuntime().availableProcessors();

    public static final String RULE_PHONE = "^13[0-9]{1}[0-9]{8}$|15[0125689]{1}[0-9]{8}$|18[0-3,5-9]{1}[0-9]{8}$";
    public static final String RULE_TEL = "(?:(\\(\\+?86\\))(0[0-9]{2,3}\\-?)?([2-9][0-9]{6,7})+(\\-[0-9]{1,4})?)|"
             + "(?:(86-?)?(0[0-9]{2,3}\\-?)?([2-9][0-9]{6,7})+(\\-[0-9]{1,4})?)";

    public static final int ENCRYPTION_DEFULT = 0;
    public static final int ENCRYPTION_OPEN = 1;

    public static final int CAR_WASTER = 1;
    public static final int GOODS_WASTER = 3;
    public static final int DRIVER_WASTER = 7;
    public static final int GOODS_DEPOT = 2;

    public static final int RENEW_PAY_TYPE = 1;// 支付方式
    public static final int RENEW_OPEN_YEAR_OR_PRICE = 2;

    public static final String SETTING = "Setting";


    public static final String CUSTEOM_RECRUITMENT_RESOURCE = "custom_recruitment_resource";
    public static final String SETTING_RECEIVE_MSG_HINT="SETTING_TB_RECEIVE_MSG_HINT";
    public static final String SETTING_SOUND_HINT = "SETTING_TB_SOUND_HINT";
    public static final String SETTING_VIBRATE_HINT = "SETTING_TB_VIBRATE_HINT";
    public static final String SETTING_SEARCH_CARGO_SOUND_HINT = "SETTING_TB_SEARCH_CARGO_SOUND_HINT";
    public static final String SETTING_VERSION_CHECK = "SETTING_LL_VERSION_CHECK";
    /**
     * 未读的推送消息数
     */
    @Deprecated
    public static final String SETTING_UNREADMESSAGECOUNT = "SETTING_UnreadMessageCount";


    public static final String USER_ID = "user_id";
    public static final String IS_SAVE_ACCOUNT = "IsSaveAccount";
    public static final String IS_AUTO_LOGIN = "IsAutoLogin";
    public static final String IS_CHECK_VERSION = "IsCheckVersion";
    public static final String ACCOUNT = "Account";
    public static final String SERVE_DAYS = "ServeDays";
    public static final String PHONE_OPEN_FLAG = "phoneOpenFlag";
    public static final String PHONE_SERVER_DAYS = "phoneServeDays";
    public static final String PASSWORD = "Password";
    public static final String TICKET = "Ticket";
    public static final String IS_RESEND = "IsResend";
    public static final String IS_NOTIFY = "IsNotify";
    public static final String RESEND_TIME = "ResendTime";
    public static final String PUBLISH_FLAG = "infoPublishFlag";
    public static final String IS_TICKET_ERR = "IsTicketErr";
    public static final String USER_TYPE = "userType";
    public static final String LOGIN_TIME = "loginTime";
    public static final String UPLOAD_TIME = "uploadTime";
    public static final String TOADAYMORRING = "todayMorning";
    public static final String RE_RElEASE = "ReRelease";
    public static final String TRANSPORT_EXIST = "transport exist";
    public static final String IS_UPDATE_PASSWORD = "IsUpdatePassword";

    public static final String RELEASE_PHONE = "ReleasePhone";
    public static String TYT_SERVICE = "400-6688-998";
    public static final String URL_DIRECTION = "direction";

    public static final String URL_CHECK_NUMBER = "https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=";

    public static final String URL_PROTOCAL = "http://www.teyuntong.com/phone/agreement.html";
    public static final String URL_ABOUT = "http://www.teyuntong.com/phone/us.html";
    public static final String URL_GUIDE = "http://www.teyuntong.com/phone/use.html";
    public static final String URL_INSURANCE_BAODING = "http://www.teyuntong.com/phone/insure.html";
    public static final String URL_INSURANCE = "http://www.teyuntong.com/phone/insure_other.html";



    // private static final String URL_BASE_TEST =
    // "http://tyt7.vipsinaapp.com/";115.28.212.207/api

    // private static final String URL_BASE_TEST =
    // "http://182.92.229.222:8081/plat/plat/";
    private static final String URL_BASE_TEST = "http://182.92.229.222/plat/plat/";

    private static final String URL_BASE_REAL = "http://www.teyuntong.cn/plat/plat/";

    private static final String URL_BASE_OTHER_TEST = "http://182.92.229.222:8081/plat/plat/";

    /**
     * 各种图片的前缀地址，在登录后，从服务器获取具体的路径
     */
    public static String URL_BASE_IMG = "http://182.92.229.222/plat/fore";

    // private static final String URL_PROXY = "http://115.28.212.207/api/";
    // private static final String URL_BASE_REAL = "http://115.28.212.207/api/";
    public static final String URL_BASE;



    /**
     * 20160705
     * 这个区分于URL_BASE_TEST和URL_BASE_REAL  因为之前的域名后面添加了项目名，导致后来服务器增加新的项目，后面的内容改变了。特意增加了这个只有域名的常量
     *
     */
    private static final String PAYMENT_URL_BASE_TEST_JUST_DOMAIN = "http://182.92.229.222:8082/";
    /**
     * 20160705
     * 这个区分于URL_BASE_TEST和URL_BASE_REAL  因为之前的域名后面添加了项目名，导致后来服务器增加新的项目，后面的内容改变了。特意增加了这个只有域名的常量
     */
    private static final String PAYMENT_URL_BASE_REAL_JUST_DOMAIN = "http://www.teyuntong.cn/";
    /**
     * 20160705
     * 这个区分于URL_BASE_TEST和URL_BASE_REAL  因为之前的域名后面添加了项目名，导致后来服务器增加新的项目，后面的内容改变了。特意增加了这个只有域名的常量
     */
    private static final String PAYMENT_URL_DOMAIN;


    /**
     *测试支付域名
     * 20161124
     */
    private static final String PAYMENT_URL_BASE_TEST= "http://182.92.229.222:8082/";
    /**
     *真实支付域名
     * 20161124
     */
    private static final String PAYMENT_URL_BASE_REAL= "http://www.teyuntong.cn/";

    /**
     *获取支付结果页面 测试环境
     */
    private static final String PAYMENT_URL_PARMAS_TEST= "tytpc/infoPayment/commonPay/getPaymentResult";
    /**
     *获取支付结果页面 真实环境
     */
    private static final String PAYMENT_URL_PARMAS_REAL= "tytpc/infoPayment/commonPay/getPaymentResult";

    /**
     * 信息费支付结果查询
     */
    public static final String URL_PAYMENT_GET_INFORMATION_FEES_RESULT ;


    /**
     * 查询货物状态url后缀
     */
    public static  String URL_GET_GOODS_STATE;


    private static final String PARAM_GET_GOODS_STATES_TEST = "tytpc/infoPayment/commonPay/getGoodStatus";
    private static final String PARAM_GET_GOODS_STATES_REAL = "tytpc/infoPayment/commonPay/getGoodStatus";

    static {
        if (BuildConfig.IS_DEBUG) {
            //	if(false){
            URL_BASE = URL_BASE_TEST;
            PAYMENT_URL_DOMAIN = PAYMENT_URL_BASE_TEST_JUST_DOMAIN;
            URL_PAYMENT_GET_INFORMATION_FEES_RESULT = PAYMENT_URL_BASE_TEST + PAYMENT_URL_PARMAS_TEST;
            URL_GET_GOODS_STATE = PAYMENT_URL_BASE_TEST + PARAM_GET_GOODS_STATES_TEST;
            // URL_BASE = URL_PROXY;
            URL_WALLET_BASE =URL_BASE_OTHER_TEST;
        } else {
            PAYMENT_URL_DOMAIN = PAYMENT_URL_BASE_REAL_JUST_DOMAIN;
            URL_BASE = URL_BASE_REAL;
            URL_PAYMENT_GET_INFORMATION_FEES_RESULT =PAYMENT_URL_BASE_REAL + PAYMENT_URL_PARMAS_REAL;
            URL_GET_GOODS_STATE = PAYMENT_URL_BASE_REAL + PARAM_GET_GOODS_STATES_REAL;
            URL_WALLET_BASE = URL_BASE_REAL;

        }
    }

    /**
     * 钱包url
     */
    public static  String URL_WALLET_BASE;

    /**
     * 获取钱包余额
     */
    public static final String URL_GET_WALLET_BALANCE = URL_WALLET_BASE + "wallet/remaining";

    /**
     * 获取钱包明细
     */
    public static final String URL_GET_PORPERTY_DETAIL = URL_WALLET_BASE + "wallet/list";

    /**
     * 提线
     */
    public static final String URL_GET_WITHDRAW_DEPOSIT= URL_WALLET_BASE + "wallet/withdraw";


    public static final String URL_USER_UPLOAD_ICON = URL_BASE + "user/head/save";
    public static final String URL_CAR_IDENTITY = URL_BASE + "car/identity/save";
    public static final String URL_USER_IDENTITY = URL_BASE + "user/identity/save";// 旧的接口
    public static final String URL_UPDATE = URL_BASE + "version/check";
    public static final String URL_LOGIN = URL_BASE + "user/login";
    public static final String URL_SIMULATED_LOGIN = URL_BASE + "user/simulatedLogin";

    public static final String URL_REGISTER = URL_BASE + "user/save";
    public static final String URL_QUERY = URL_BASE + "transport/search";

    public static final String URL_CHECK_TICKET = URL_BASE + "user/checkTicket";

    public static final String URL_COMMEND_AWARD = URL_BASE + "user/recommend/save";
    public static final String URL_CANCEL_KEEP = URL_BASE + "transport/collect/delete";
    public static final String URL_CUSTOM_URL = URL_BASE + "resource/global/get";
    public static final String URL_CAR_LIST = URL_BASE + "car/identity/get";
    public static final String URL_CAR_ATTS_INFO = URL_BASE + "car/get";
    public static final String URL_RELEASE = URL_BASE + "transport/save";
    public static final String URL_GET_MY_RELEASE = URL_BASE + "transport/history";
    public static final String URL_GET_ORDER_INFO = URL_BASE + "transport/get";
    public static final String URL_INFO_QUERY = URL_BASE + "user/get";
    public static final String URL_USER_INFO_UPDATE = URL_BASE + "user/password/forget";
    public static final String URL_INFO_UPDATE = URL_BASE + "transport/update";
    public static final String URL_INFO_FEEDBACK = URL_BASE + "user/advice/save";
    public static final String URL_INFO_REPORT = URL_BASE + "complaint/save";// 投诉

    public static final String URL_QUERY_RELEASE = URL_BASE + "transport/mypub";
    public static final String URL_QUERY_USER_AUTH = URL_BASE + "user/identity/get";// 旧查询

    public static final String URL_KEEP_RELEASE = URL_BASE + "transport/collect/save";
    public static final String URL_KEEP_QUERY = URL_BASE + "transport/collect/get";
    public static final String URL_KEEP_UPDATE = URL_BASE + "collect/update";

    public static final String URL_INVITE_FRIENDS = URL_BASE + "inviteFriends/save";
    public static final String URL_SEND_TO_SERVER = URL_BASE + "linkman/save";

    public static final String URL_RENEW_SOURCE_GET = URL_BASE + "resource/get";
    public static final String URL_RENEW_UNIONPAY_ORDER_SAVE = URL_BASE + "unionpay/order/save";
    public static final String URL_GET_IS_PAY = URL_BASE + "alipay/isPay";
    public static final String URL_GET_UPDATE_USER_INFO = URL_BASE + "user/info";

    public static final String URL_UPDATE_LOCATION_INFO = URL_BASE + "collect/user/location/save";

    public static final String URL_SENDGOODSCHECK = URL_BASE + "user/sendGoodsCheck";

    public static final String URL_GET_MESSAGE_LIST = URL_BASE + "message/list";

    /**
     * 检查服务器是否升级地址
     */
    public static final String URL_CHECK_SERVERS_UPDATE = "http://www.teyuntong.com/app/upgradeFile/upgrade.txt";//upgrade2222.txt
    /**
     * 实名认证新街口 160107
     */
    public static final String URL_IDENTITY_NAME_ID_CARD = URL_BASE + "user/identity/info/save";// 新接口
    public static final String URL_IDENTITY_USER_ICON = URL_BASE + "user/identity/photo/save";// 新接口
    public static final String URL_IDENTITY_GET_STATE = URL_BASE + "user/identity/info";// 新接口

    /**
     * 记录排序的日志
     */
    public static final String URL_TRANSPORT_SORTLOG = URL_BASE + "transport/sortlog";

    /**
     * 记录拨打电话
     */

    public static final String URL_CALL_PHONE = URL_BASE + "user/call/phone";
	/*
	 * 2015-08-24 start
	 */
    /**
     * 保存电话号码
     */
    public static final String URL_SAVE_TELBOOK = URL_BASE + "user/telbook/save";
    /**
     * 获取用户电话列表
     */
    public static final String URL_GET_TELBOOK_LIST = URL_BASE + "user/telbook/get";
    /**
     * 用户联系人电话删除
     */
    public static final String URL_DELETE_TELBOOK = URL_BASE + "user/telbook/delete";

    /**
     * 获取语音验证码借口
     */
    public static final String URL_SENDVOICEVERIFY = URL_BASE + "verify/sendVoiceVerify";

    /**
     * 发货限制规则查询接口
     */
    public static final String URL_STTLIMIT_LIST=URL_BASE+"/sttLimit/list";

	/*
	 * 2015-08-24 end
	 */

	/*
	 * 20150910 start
	 */
    /**
     * 修改昵称
     */
    public static final String URL_USERNAME_SAVE = URL_BASE + "user/username/save";
	/*
	 * 20150910 end
	 */

	/*
	 * 20150916 transport/vary start
	 */
    /**
     * 查询变动货物信息列表
     */
    public static final String URL_TRANSPORT_VARY = URL_BASE + "transport/vary";
	/*
	 * 20150916 transport/vary end
	 */


	/*
	 * 20160309 消息相关 start
	 */

    /**
     * 查询最新消息数
     */
    public static final String URL_MESSAGE_NEWMSGNBR= URL_BASE +"message/newMsgNbr";
    /**
     * 清空消息数
     */
    public static final String URL_MESSAGE_CLEARMSGNBR= URL_BASE +"message/clearMsgNbr";

    /**
     * 删除消息
     */
    public static final String URL_MESSAGE_DEL=URL_BASE+"message/del";
    /**
     * 设置消息已读状态
     */
    public static final String URL_MESSAGE_UPDATEREAD=URL_BASE+"message/updateRead";
    /**
     * 查询我的消息列表接口
     */
    public static final String URL_MESSAGE_LIST=URL_BASE+"message/list";


    /**
     * 设置通知消息已读状态
     */
    public static final String URL_NOTIFY_LIST=URL_BASE+"notify/updateRead";

    /**
     * 未登录个推信息采集
     */
    public static final String URL_NOTIFY_COLLECTION=URL_BASE+"notify/collection";

    /**
     * 渠道采集
     */
    public static final String URL_CHANNEL_UPLOAD =URL_BASE+"channel/collection";


    /**
     *招聘发布资源
     */
    public static final String URL_RECRUITMENT_CUSTMO_RESOURCE=URL_BASE+"wordbook/list";

    /**
     *招聘列表查询
     */
    public static final String URL_BCAR_RECRUIT_LIST=URL_BASE+"bcar/recruit/list";
    /**
     * 我的招聘列表
     */
    public static final String URL_BCAR_RECRUIT_MYPUBLISH=URL_BASE+"bcar/recruit/myPublish";
    /**
     * 求职列表查询
     */
    public static final String URL_BCAR_JOB_LIST=URL_BASE+"bcar/job/list";

    /**
     * 我的求职列表
     */
    public static final String URL_BCAR_JOB_MYPUBLISH=URL_BASE+"bcar/job/myPublish";

    /**
     * 求职发布
     */
    public static final String URL_BCAR_JOB_HUNTER_RELEASE=URL_BASE+"bcar/job/save";
    /**
     * 求职编辑
     */
    public static final String URL_BCAR_JOB_HUNTER_UPDATE=URL_BASE+"bcar/job/update";
    /**
     * 招聘发布
     */
    public static final String URL_BCAR_RECRUIT_RELEASE=URL_BASE+"bcar/recruit/save";
    /**
     * 招聘编辑
     */
    public static final String URL_BCAR_RECRUIT_UPDATE=URL_BASE+"bcar/recruit/update";
    /**
     * 求职详情
     */
    public static final String URL_BCAR_JOB_HUNTER_INFO=URL_BASE+"bcar/job/info";



    /**
     * 招聘详情
     */
    public static final String URL_BCAR_RECRUIT_INFO=URL_BASE+"bcar/recruit/info";
    /**
     * 招聘置顶
     */
    public static final String URL_BCAR_RECRUIT_TOP=URL_BASE+"bcar/recruit/top";
    /**
     * 求职置顶
     */
    public static final String URL_BCAR_JOB_TOP=URL_BASE+"bcar/job/top";
    /**
     * 求职删除
     */
    public static final String URL_BCAR_JOB_DEL=URL_BASE+"bcar/job/del";
    /**
     * 招聘删除
     */
    public static final String URL_BCAR_RECRUIT_DEL=URL_BASE+"bcar/recruit/del";

    /**
     *板车发布数量
     */
    public static final String URL_BCAR_JOB_MYPUBLISHANBR=URL_BASE+"bcar/job/myPublishaNbr";


    /*************************************************
     * 设备
     */
    /**
     * 设备求职详情
     */
    public static final String URL_SCAR_JOB_HUNTER_INFO=URL_BASE+"scar/job/info";
    /**
     * 设备求职发布
     */
    public static final String URL_SCAR_JOB_HUNTER_RELEASE=URL_BASE+"scar/job/save";
    /**
     * 设备求职修改
     */
    public static final String URL_SCAR_JOB_HUNTER_UPDATE=URL_BASE+"scar/job/update";

    /**
     * 设备 招聘详情*******
     */
    public static final String URL_SCAR_RECRUIT_INFO=URL_BASE+"scar/recruit/info";
    /**
     * 设备 招聘发布
     */
    public static final String URL_SCAR_RECRUIT_RELEASE=URL_BASE+"scar/recruit/save";
    /**
     * 设备 招聘修改
     */
    public static final String URL_SCAR_RECRUIT_UPDATE=URL_BASE+"scar/recruit/update";


    /**
     * 设备求职	列表查询
     */
    public static final String URL_SCAR_JOB_LIST=URL_BASE+"scar/job/list";
    /**
     * 设备招聘	列表查询
     */
    public static final String URL_SCAR_RECRUIT_LIST=URL_BASE+"scar/recruit/list";

    /**
     * 我的设备求职	列表
     */
    public static final String URL_SCAR_RECRUIT_MYPUBLISH=URL_BASE+"scar/recruit/myPublish";


    /**
     * 我的设备招聘	列表
     */
    public static final String URL_SCAR_JOB_MYPUBLISH=URL_BASE+"scar/job/myPublish";



    /**
     * 设备招聘置顶
     */
    public static final String URL_SCAR_RECRUIT_TOP=URL_BASE+"scar/recruit/top";
    /**
     * 设备求职置顶
     */
    public static final String URL_SCAR_JOB_TOP=URL_BASE+"scar/job/top";
    /**
     * 设备求职删除
     */
    public static final String URL_SCAR_JOB_DEL=URL_BASE+"scar/job/del";
    /**
     * 设备招聘删除
     */
    public static final String URL_SCAR_RECRUIT_DEL=URL_BASE+"scar/recruit/del";


    /**
     * 身份标签列表
     */
    public static final String URL_GET_IDENTITY_LABLE_ALL=URL_BASE+"user/identityLabels/list";

    /**
     * 修改用户标签
     */
    public static final String URL_UPDATE_IDENTITY_LABLE=URL_BASE+"user/identityLabels/update";


    /**
     * 新的招聘求职数量
     */
    public static final String URL_BCAR_JOB_NEWJOBNBR=URL_BASE+"bcar/job/newJobNbr";


    /**
     * 新车资讯列表
     */
    public static final String URL_CAR_NEWS_LIST=URL_BASE+"car/news/list";


    /**
     * 日志
     */
    public static final String URL_BROWSELOG_SAVE=URL_BASE+"browseLog/save";


    /**
     * 商户列表查询
     */
    public static final String URL_MERCHANT_QUERY=URL_BASE+"merchant/query";


    /**
     * 我的商户列表
     */
    public static final String URL_MERCHANT_MYPUBLISH=URL_BASE+"merchant/myPublish";
    /**
     * 商户详情
     */
    public static final String URL_MERCHANT_DETAIL=URL_BASE+"merchant/detail";

    /**
     * 添加商户
     */
    public static final String URL_MERCHANT_SAVE=URL_BASE+"merchant/save";

    /**
     *维修师添加
     */
    public static final String URL_MAINTAINER_SAVE = URL_BASE + "maintainer/save";


    /**
     * 查询维修师
     */
    public static final String URL_MAINTAINER_QUERY=URL_BASE+"maintainer/query";

    /**
     * 更新维修师状态
     */
    public static final String URL_MAINTAINER_UPDATESTATUS=URL_BASE+"maintainer/updateStatus";
    /**
     * 维修师详情
     */
    public static final String URL_MAINTAINER_DETAIL=URL_BASE+"maintainer/detail";

    /**
     * 发短信
     */
    public static final String URL_STATISTIC_SHORTMESSAGE=URL_BASE+"statistic/shortMessage";

    /**
     * 维修师 打电话记录
     */
    public static final String URL_STATISTIC_CALLPHONE=URL_BASE+"statistic/callPhone";


    /**
     * 我的维修师
     */
    public static final String URL_MAINTAINER_MYINFO=URL_BASE+"maintainer/myInfo";


    /**
     *维修师添加
     */
    public static final String URL_MAINTAINER_UPDATE = URL_BASE + "maintainer/update";

    /**
     *短信验证新街口
     */
    public static final String URL_STATISTIC_SHORT_MESSAGE = URL_BASE + "verificationCode/send";


    /**
     * 上传位置信息，新接口20160623
     */
    public static final String URL_STATISTIC_CURRENTLOCATION=URL_BASE + "statistic/currentLocation";

    /**
     * 获取我的收藏列表
     */
    public static final String URL_COLLECT_COUNT=URL_BASE + "user/collectCount";

    /**
     * 获取我的收藏列表
     */
    public static final String URL_COLLECT_LIST=URL_BASE + "user/collectList";

    /**
     * 设备求职批量取消收藏
     */
    public static final String SCAR_JOB_CANCEL_COLLECT=URL_BASE + "scar/job/mulUncollect";
    /**
     * 设备招聘批量取消收藏
     */
    public static final String SCAR_ERCRUIT_CANCEL_COLLECT=URL_BASE + "scar/recruit/mulUncollect";
    /**
     * 板车招聘批量取消收藏
     */
    public static final String BCAR_ERCRUIT_CANCEL_COLLECT=URL_BASE + "bcar/recruit/mulUncollect";
    /**
     * 板车求职批量取消收藏
     */
    public static final String BCAR_JOB_CANCEL_COLLECT=URL_BASE + "bcar/job/mulUncollect";


    /**
     * 支付首页
     */
    public static final String URL_PAYMENT_GETPRICE= PAYMENT_URL_DOMAIN +"tytpc/tytpc/payment/getPrice";

    /**
     * 请求支付宝订单
     */
    public static final String URL_ZHIFUBAO_GETREQUESTPARAMS=PAYMENT_URL_DOMAIN+"tytpc/tytpc/payment/zhifubao/getRequestParams";
    /**
     * 支付结果查询
     */
    public static final String URL_PAYMENT_GETPAYMENTRESULT=PAYMENT_URL_DOMAIN+"tytpc/tytpc/payment/getPaymentResult";



    /**
     * 大板车求职收藏和取消收藏
     */
    public static final String URL_BCAR_JOB_COLLECT=URL_BASE+"bcar/job/collect";
    /**
     * 大板车招聘收藏和取消收藏
     */
    public static final String URL_BCAR_RECRUIT_COLLECT=URL_BASE+"bcar/recruit/collect";
    /**
     * 设备求职收藏和取消收藏
     */
    public static final String URL_SCAR_JOB_COLLECT=URL_BASE+"scar/job/collect";
    /**
     * 设备招聘收藏和取消收藏
     */
    public static final String URL_SCAR_RECRUIT_COLLECT=URL_BASE+"scar/recruit/collect";


    /**
     * 信息支付获取订单
     *
     */
    public static final String URL_WEIXINPAY_PLACEORDER= PAYMENT_URL_DOMAIN +"tytpc/tytpc/payment/weixin/savePlaceOrder";

    /**
     * 我的设备求职开放和关闭
     */
    public static final String URL_SCAR_JOB_CHANGESTATUS=URL_BASE+"scar/job/changeStatus";

    /**
     * 我的设备招聘开放和关闭
     */
    public static final String URL_SCAR_RECRUIT_CHANGESTATUS=URL_BASE+"scar/recruit/changeStatus";

    /**
     * 我的板车求职开放和关闭
     */
    public static final String URL_BCAR_JOB_CHANGESTATUS=URL_BASE+"bcar/job/changeStatus";

    /**
     * 我的板车招聘开放和关闭
     */
    public static final String URL_BCAR_RECRUIT_CHANGESTATUS=URL_BASE+"bcar/recruit/changeStatus";

    /**
     * 我的车辆删除
     */
    public static final String URL_CAR_IDENTIFY_DELETE=URL_BASE+"car/delete";
	/*
	 * 2016030消息相关 end
	 */

    /**
     * 检查货源进步进行提示
     */
    public static final String URL_USER_GOODSNOTIFY=URL_BASE+"user/goodsNotify";

    /**
     * 用户点击事件统计
     */
    public static final String URL_COLLECT_USER_CLICK=URL_BASE+"collect/user/click";


    /**
     * 获取货物通话记录列表
     */
    public static final String URL_TRANSPORT_ADDCALL=URL_BASE+"transport/addCall";

    /**
     * 获取货物通话记录列表
     */
    public static final String URL_TRANSPORT_QUERYCALLLIST=URL_BASE+"transport/queryCallList";


    /**
     * 获取货物相关的电话
     */
    public static final String URL_TRANSPORT_GETPHONE=URL_BASE+"transport/getPhone";





    /**
     * 21.3 车主支付信息费
     */
    public static final String URL_PAYMENT_BEFORE=URL_BASE+"infoFee/wayBill/saveWayBill";



    /**
     *APP自动定位
     */
    public static final String URL_RESOURCE_GETIPINFO=URL_BASE+"resource/getIpInfo";


    /*
	 * 20161124 货源和订单 start
	 */

    /**
     * 我的货源列表查询接口
     * 发布中,撤销，失效
     */
    public static final String URL_INFOFEE_TRANSPORT_GETMYPUBLISH=URL_BASE+"infoFee/transport/getMyPublish";
    /**
     * 我的货源 待同意 装货中 完成
     */
    public static final String URL_INFOFEE_WAYBILL_MYLIST=URL_BASE+"infoFee/wayBill/myList";
    /**
     * 异常列表
     */
    public static final String URL_INFOFEE_EX_LIST=URL_BASE+"infoFee/ex/list";
    /**
     * 接单列表
     */
    public static final String URL_INFOFEE_ORDERS_LIST=URL_BASE+"infoFee/orders/list";


    /**
     * 撤销货源/设置成交
     */
    public static final String URL_INFOFEE_TRANSPORT_SAVEGOODSSTATUS=URL_BASE+"infoFee/transport/saveGoodsStatus";


    /**
     * 货物详情接口
     */
    public static final String URL_INFOFEE_TRANSPORT_GETSINGLEDETAIL= URL_BASE+ "infoFee/transport/getSingleDetail";

    /**
     * 异常上报接口（车主/发货方共用）
     */
    public static final String URL_INFOFEE_EX_SAVE=URL_BASE+"infoFee/ex/save";

    /**
     * 装货完成接口
     */
    public static final String URL_INFOFEE_WAYBILL_FINISH=URL_BASE+"infoFee/wayBill/finish";

    /**
     *拒绝装货/同意装货
     */
    public static final String URL_INFOFEE_ORDERS_SAVEORDERSTATUS=URL_BASE+"infoFee/orders/saveOrderStatus";

    /**
     * 直接发布
     */
    public static final String URL_INFOFEE_TRANSPORT_SAVEDIRECT=URL_BASE+"infoFee/transport/saveDirect";


    /**
     *通知弹窗列表查询接口
     */
    public static final String URL_NOTICE_POPUP_LIST=URL_BASE+"notice/popup/list";


    public static final String URL_UPDATE_DISTANCE = URL_BASE + "transport/updateDistance";

	/*
	 * 20161124 货源和订单 end
	 */

    public static final String RESEND = "60";
    public static final int RESENDTIME = 60;
    public static final int DELAY_FOR_GET_DELAY = 10 * 1000;
    public static final int DELAY_FOR_GET_CHANGE = 60 * 1000;
    public static final int DELAY_FOR_CHECK_TICKET = 6 * 20 * 1000;// 5 * 60 *
    // 1000

    // public static final int CLIENT_TYPE =3;

    public static final String PLAT_ID = "2";
    public static final String PLAT_ID1 = "1";
    public static final String PRIVATEKEY = "1345~opo-4%";
    public static final String USERSIGN = "2"; // 用户身份标识 0 车主(注册不通过，服务器端问题) 1配货站
    // 2货主 3 销售 4 管理员

    public static final SparseIntArray Login_err = new SparseIntArray();
    static {
//        Login_err.put(-1, R.string.err_login_phone_not_exit);
//        Login_err.put(-2, R.string.err_login_password_err);
//        Login_err.put(-3, R.string.err_login_account_not_for_this_pc);
//        Login_err.put(-4, R.string.err_login_account_out_date);
//        Login_err.put(-5, R.string.err_login_soft_need_update);
//        Login_err.put(-6, R.string.err_login_account_not_actived);
//        Login_err.put(-7, R.string.err_login_account_not_permission);
//
//        Login_err.put(1004, R.string.login_other);
//        Login_err.put(1003, R.string.before_login_title);
//        Login_err.put(2001, R.string.err_regest_fail);
//        Login_err.put(2002, R.string.err_login_fail);
//        Login_err.put(2003, R.string.err_params_check_fail);
//        Login_err.put(2004, R.string.err_type_check_fail);
//        Login_err.put(2005, R.string.image_info);
//        Login_err.put(2006, R.string.force_update_info);
//        Login_err.put(2007, R.string.select_update_info);
    }


    public static final int ERR_NONE = 0;
    public static final int ERR_NET = ERR_NONE + 1;
    public static final int ERR_NONE_VERIFYCODE_OK = ERR_NET + 1;
    public static final int ERR_VERIFYCODE = ERR_NONE_VERIFYCODE_OK + 1;
    public static final int TIME_VERIFYCODE = ERR_VERIFYCODE + 1;
    public static final int TIME_VERIFYCODE_END = TIME_VERIFYCODE + 1;
    public static final int LOCATION_INIT_END = TIME_VERIFYCODE_END + 1;
    public static final int RELEASE_OVER = LOCATION_INIT_END + 1;
    public static final int SELECT_OVER = RELEASE_OVER + 1;
    public static final int LOCATION_SELEND_END = SELECT_OVER + 1;
    public static final int ENTER_HOME = LOCATION_SELEND_END + 1;
    public static final int SHOW_UPDATE_DIALOG = ENTER_HOME + 1;
    public static final int INIT_PERSON_INFO = SHOW_UPDATE_DIALOG + 1;
    public static final int LONGIN_INFO = INIT_PERSON_INFO + 1;
    public static final int ERR_NONE_SERIAL_OK = LONGIN_INFO + 1;

    public static final int ERR_SERVER_NONE = 200;
    public static final int ERR_SERVER = 500;

    public static final String URL_FOR_VERIFYCODE = "http://utf8.sms.webchinese.cn/";
    public static final String VERIFYCODE_UID = "teyuntong";
    public static final String VERIFYCODE_KEY = "f631e6e38de4549d1688";

    public static final int REQUESTCODE_REGISTER = 1000;
    public static final int RESULTCODE_REGISTER = REQUESTCODE_REGISTER + 1;

    public static final int ORDER_STATE_USEFULL = 1;
    public static final int ORDER_STATE_NO_USEFULL = 0;
    public static final int ORDER_STATE_COMPLETE = 4;
    public static final int USER_ACCEPT = 2;

    public static final String PRIVATEDATAKEY = "a3+@$@$!~!#222444";
    public static final String UNIONPAY = "unionpay";

    public static final String CLENT_SIGN = "2";// 1pc 2android 3ios 4apad 5ipad
    // 6web

    public static final String OS_VERSION = android.os.Build.VERSION.RELEASE;

    /**
     * 在application的oncreate中初始化
     */
    public static  String CLIENT_ID = android.os.Build.MODEL;
    public static final String PHONE_TYPE = android.os.Build.MODEL;
    public static final String IMAGE_FILE_NAME = "userIcon";



    /**
     * 第一次进个人中心
     */
    public static final String FIRST_INTER_CENTER ="first_inter_center";

    /**
     * SharedPreferences 的私有key 第一次查看服务界面
     */

    public static final String FIRSTCHECKSERVERPAGE = "firstCheckServerPage";


    /**
     * SharedPreferences 的私有key 第一次查看维修商
     */

    public static final String FIRSTCHECK_CAR_REPAIRS = "FIRSTCHECK_CAR_REPAIRS";
    /**
     * SharedPreferences 的私有key 第一次查看维修师
     */

    public static final String FIRSTCHECK_CAR_MAINTENANCE_DIVIDISON = "FIRSTCHECK_CAR_MAINTENANCE_DIVIDISON";
    /**
     * 用来记录哪些账号需要在当天提示一下到期想信息的
     */
    public static final String LOGINACCOUNTRECORD = "LoginACCOUNTRECORD";
    public static final String LOGINACCOUNTRECORDTIME = "LOGINACCOUNTRECORDTIME";
    /**
     * 第一次查看照片实名认证
     */
    public static final String FIRSTTIMECHECKOUTIDENPHOTO="FIRSTTIMECHECKOUTIDENPHOTO";
    /**
     * vip用户
     */
    public static final int USERTYPE_VIP=1;
    /**
     * 使用用户
     */
    public static final int  USERTYPE_Trial=0;

    /**
     * 保存发货联系电话的表
     */
    public static final String SAVESENDTELMAP="saveSendTelmap";
    public static final String SAVESENDTELMAP_TEL="SAVESENDTELMAP_TEL";
    public static final String SAVESENDTELMAP_TEL3="SAVESENDTELMAP_TEL3";
    public static final String SAVESENDTELMAP_TEL4="SAVESENDTELMAP_TEL4";

    /**
     * 是否从推送界面过来
     */
    public static final String TYTGTPUSHRECEIVER="TytGTPushReceiver";
    /**
     * 从推送界面过来，登录 成功后，需要显示的界面的URL
     */
    public static final String TYTGTPUSHRECEIVER_LINKURL="TytGTPushReceiver_linkUrl";
    /**
     * 推送的消息实体
     */
    public static final String TYTGTPUSHRECEIVER_PUSHMESSAGE="TYTGTPUSHRECEIVER_PushMessage";

    /**
     * 从消息列表往消息详情传递 的url
     */
    public static final String MESSAGEITEM_DETAILSURL="MESSAGEITEM_DETAILSURL";
    public static final String MESSAGEITEM_READSTATUS="MESSAGEITEM_READSTATUS";
    public static final String MESSAGEITEM_READSTATUS_ID="MESSAGEITEM_ID";

    /**
     * 板车招聘列表页面
     */
    public static final String RECRUITMENTANDJOBHUNTINGACTIVITY_SEARCH="RECRUITMENTANDJOBHUNTINGACTIVITY_SEARCH";
    /**
     * 设备招聘的地区字段
     */
    public static final String RECRUITMENTANDJOBHUNTINGACTIVITY_SEARCH_EQUIPMENT_RECRUITMENT_LOCATION="RECRUITMENTANDJOBHUNTINGACTIVITY_SEARCH_EQUIPMENT_RECRUITMENT_LOCATION";

    /**
     * 设备司机招聘的地区字段
     */
    public static final String RECRUITMENTANDJOBHUNTINGACTIVITY_SEARCH_EQUIPMENT_JOB_LOCATION="RECRUITMENTANDJOBHUNTINGACTIVITY_SEARCH_EQUIPMENT_JOB_LOCATION";

    /**
     * 设备司机求职的地区字段
     */
    public static final String RECRUITMENTANDJOBHUNTINGACTIVITY_SEARCH_RECRUITMENT_LOCATION="RECRUITMENTANDJOBHUNTINGACTIVITY_SEARCH_RECRUITMENT_LOCATION";

    /**
     * 板车招聘的属性字段
     */
    public static final String RECRUITMENTANDJOBHUNTINGACTIVITY_SEARCH_RECRUITMENT_DUTY="RECRUITMENTANDJOBHUNTINGACTIVITY_SEARCH_RECRUITMENT_DUTY";
    /**
     * 板车求职的属性字段
     */
    public static final String RECRUITMENTANDJOBHUNTINGACTIVITY_SEARCH_JOB_LOCATION="RECRUITMENTANDJOBHUNTINGACTIVITY_SEARCH_JOB_LOCATION";
    /**
     * 板车求职的属性字段
     */
    public static final String RECRUITMENTANDJOBHUNTINGACTIVITY_SEARCH_JOB_DUTY="RECRUITMENTANDJOBHUNTINGACTIVITY_SEARCH_JOB_DUTY";
    /**
     * 设备司机招聘规格的属性字段
     */
    public static final String RECRUITMENTANDJOBHUNTINGACTIVITY_SEARCH_EQUIPMENT_SPECIFICATIONS_RECRUITMENT="RECRUITMENTANDJOBHUNTINGACTIVITY_SEARCH_EQUIPMENT_SPECIFICATIONS_RECRUITMENT_LOCATION";
    /**
     * 设备司机求职的规格属性字段
     */
    public static final String RECRUITMENTANDJOBHUNTINGACTIVITY_SEARCH_EQUIPMENT_SPECIFICATIONS_JOB="RECRUITMENTANDJOBHUNTINGACTIVITY_SEARCH_EQUIPMENT_SPECIFICATIONS_JOB_LOCATION";

    /**
     * 设备招聘的设备选择字段
     */
    public static final String RECRUITMENTANDJOBHUNTINGACTIVITY_SEARCH_EQUIPMENT_RECRUITMENT_EQUIPMENT="RECRUITMENTANDJOBHUNTINGACTIVITY_SEARCH_EQUIPMENT_RECRUITMENT_EQUIPMENT_ONE";

    /**
     * 设备司机招聘的设备选择字段
     */
    public static final String RECRUITMENTANDJOBHUNTINGACTIVITY_SEARCH_EQUIPMENT_JOB_LOCATION_EQUIPMENT="RECRUITMENTANDJOBHUNTINGACTIVITY_SEARCH_EQUIPMENT_JOB_LOCATION_EQUIPMENT_ONE";


    /**
     * 维修师主页是否显示接活状态
     * 因为在主页会用到，所以就写在这个文件里了
     */
    public static final String RECRUITMENTANDJOBHUNTINGACTIVITY_SEARCH_MAINTENANCE_DIVISION_IS_SHOW_CHANGE="RECRUITMENTANDJOBHUNTINGACTIVITY_SEARCH_MAINTENANCE_DIVISION_IS_SHOW_CHANGE";


    /**
     * 添加过电话记录了
     */
    public static final String RECRUITMENTANDJOBHUNTINGACTIVITY_SEARCH_ADD_PHONE_CALL_LIST="RECRUITMENTANDJOBHUNTINGACTIVITY_SEARCH_ADD_PHONE_CALL_LIST";

    /**
     * 招聘新发布id
     */
    public static final  String FINAL_MAIN_FRAGMENT_RECRUITMENT_MAXID="MAIN_FRAGMENT_RECRUITMENT_COUNT";
    public static  final String FINAL_MAIN_FRAGMENT_RECRUITMENT_JOB_MAXID="MAIN_FRAGMENT_RECRUITMENT_JOB_MAXID";
    public static final String FINAL_MAIN_FRAGMENT_RECRUITMENT_EQUIPMENT_MAXID="MAIN_FRAGMENT_RECRUITMENT_EQUIPMENT_MAXID";
    public static final  String FINAL_MAIN_FRAGMENT_RECRUITMENT_EQUIPMENT_JOB_MAXID="MAIN_FRAGMENT_RECRUITMENT_EQUIPMENT_JOB_MAXID";

    public static  String MAIN_FRAGMENT_RECRUITMENT_MAXID="MAIN_FRAGMENT_RECRUITMENT_COUNT";
    public static  String MAIN_FRAGMENT_RECRUITMENT_JOB_MAXID="MAIN_FRAGMENT_RECRUITMENT_JOB_MAXID";
    public static  String MAIN_FRAGMENT_RECRUITMENT_EQUIPMENT_MAXID="MAIN_FRAGMENT_RECRUITMENT_EQUIPMENT_MAXID";
    public static  String MAIN_FRAGMENT_RECRUITMENT_EQUIPMENT_JOB_MAXID="MAIN_FRAGMENT_RECRUITMENT_EQUIPMENT_JOB_MAXID";


    /**
     * 新车资讯 保存条件
     */
    public static final String NEW_CAR_INFO="NEW_CAR_INFO";
    /**
     * 车辆类型
     */
    public static final String NEW_CAR_INFO_CAR_TYPE="NEW_CAR_INFO_CAR_TYPE";
    /**
     * 车辆品牌
     */
    public static final String NEW_CAR_INFO_CAR_BRAND="NEW_CAR_INFO_CAR_BRAND";

    /**
     * 车辆价格
     */
    public static final String NEW_CAR_INFO_PRICE="NEW_CAR_INFO_PRICE";

    /**
     * 地区
     */
    public static final String NEW_CAR_INFO_LOCATION="NEW_CAR_INFO_LOCATION";


    /**
     * 记录登录状态，当第一个activity加载时，重置其值
     */
    public static final String LOGIN_STATE="LOGIN_STATE";
    public static final String LOGIN_STATE_ISLOGIN="LOGIN_STATE_ISLOGIN";


    /**
     * 地区数据库的的版本
     */
    public static final String LOCATION_DATABASES_VERSION="databases_version";


    /**
     *
     * 程序启动时，首先加载所有的未登录时，需要的各种初始化数据或标识
     *
     *
     */
    public static final String  APP_START_DEFAULT="APP_START_DEFAULT";

    public static final String  COMMONRESOURCESENTITY="COMMONRESOURCES_ENTITY";
    /**
     * 公共资源 默认标识
     * 程序启动时，首先加载所有的未登录时，需要的各种初始化数据或标识
     *
     * 0是未获取或加载过  1是已经获取过，就是不用默认数据，也就是raw文件夹的数据
     */
    public static final String  APP_START_DEFAULT_COMMONRESOURCES="APP_START_DEFAULT_COMMONRESOURCES";
    /**
     * 数据字典
     * 程序启动时，首先加载所有的未登录时，需要的各种初始化数据或标识
     *
     * 0是未获取或加载过  1是已经获取过，就是不用默认数据，也就是raw文件夹的数据
     */
    public static final String  APP_START_DEFAULT_WORDBOOKLIST="APP_START_DEFAULT_WORDBOOKLIST";

    /**
     * 标签
     * 程序启动时，首先加载所有的未登录时，需要的各种初始化数据或标识
     *
     * 0是未获取或加载过  1是已经获取过，就是不用默认数据，也就是raw文件夹的数据
     */
    public static final String  APP_START_DEFAULT_IDENTITYLABELSLIST="APP_START_DEFAULT_IDENTITYLABELSLIST";


    /**
     *20161215 start
     * 这在里统一定义了 第一次查看的关键字，以后所有涉及到一次显示或记录的字段，都在这里定义和查找
     */

    /**
     * 这在里统一定义了 第一次查看的关键字，以后所有涉及到一次显示或记录的字段，都在这里定义和查找
     */
    public static final String  SP_KEY_ONE_TIME_CHECK="ONE_TIME_CHECK";
    /**
     * 货物发送界面的引导key
     */
    public static final String  ONE_TIME_SEND_CARGO="ONE_TIME_SEND_CARGO";

    /**
     * 货物发送界面的引导key
     */
    public static final String  ONE_TIME_CARGO_DETAIL="ONE_TIME_CARGO_DETAIL";
    /**
     * 我的货源界面的引导key
     */
    public static final String  ONE_TIME_MY_CARGO="ONE_TIME_MY_CARGO";

    /**
     * 钱包导key
     */
    public static final String  ONE_TIME_MY_WOLLET="ONE_TIME_MY_WOLLET";


    /**
     * 找货的引导key
     */
    public static final String  ONE_TIME_CARGO_SEARCH="ONE_TIME_CARGO_SEARCH";
    /**
     *20161215 end
     * 这在里统一定义了 第一次查看的关键字，以后所有涉及到一次显示或记录的字段，都在这里定义和查找
     */

}
