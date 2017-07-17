package com.tianniu.custom;

import android.Manifest;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.multidex.MultiDex;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;

import com.tianniu.custom.core.CommonDefine;
import com.tianniu.custom.core.CommonResources;
import com.tianniu.custom.model.IdentityInfo;
import com.tianniu.custom.model.OrderInfo;
import com.tianniu.custom.model.PersonInfo;
import com.tianniu.custom.model.PhoneNumber;
import com.tianniu.custom.utils.LLog;
import com.tianniu.custom.view.LoginActivity;
import com.tianniu.up.testprogect.BuildConfig;
import com.umeng.socialize.Config;
import com.umeng.socialize.UMShareAPI;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/5/4 0004.
 */

public class OpApplication extends Application {

    private static final long serialVersionUID = 1L;

    private static OpApplication mApp;


    /**
     * 记录服务器地址
     */
    public static String server_url = "";

    /**
     * 身份认证选择信息
     */
    public List<IdentityInfo> driverIdentityList;
    /**
     * 身份认证选择信息
     */
    public List<IdentityInfo> cargoOwnerIdentityList;


    private void clearIdentityList() {

        if (driverIdentityList != null) {
            driverIdentityList.clear();
        }
        if (cargoOwnerIdentityList != null) {
            cargoOwnerIdentityList.clear();
        }
    }

    /**
     * 用来区分发货和接单弹窗是否弹出过的存储ID
     */
    public static Map<String, Map<String, String>> cargoWindowMsgMaxId = new HashMap<String, Map<String, String>>(0);
    /**
     * 服务器升级信息
     */
    private static HashMap<String, String> properties;

    public static HashMap<String, String> getProperties() {
        return properties;
    }

    public static void setProperties(HashMap<String, String> properties) {
        OpApplication.properties = properties;
    }

    public static List<Object> windowShowList = new ArrayList<Object>(0);

    public static void addWindowShow(Object o) {
        if (!windowShowList.contains(o)) {
            windowShowList.add(o);
        }

    }

    public static void removeWindowShow(Object o) {

        windowShowList.remove(o);

    }

    public static boolean hasWindowShowed() {
        if (windowShowList.size() > 0) {
            return true;
        }
        return false;
    }

    @Override
    protected void attachBaseContext(final Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }

    private String currenNaviMode;


    public boolean isRecruitmentResourceGet() {
        return recruitmentResourceGet;
    }

    public void setRecruitmentResourceGet(boolean recruitmentResourceGet) {
        this.recruitmentResourceGet = recruitmentResourceGet;
    }

    public void setCurrenNaviMode(String currenNaviMode) {
        this.currenNaviMode = currenNaviMode;
    }

    public String getCurrenNaviMode() {
        return currenNaviMode;
    }

    public void removeProperties() {
        this.properties.clear();
        this.properties = null;
    }

    private static class TwoValues {
        public boolean isLoaded = false;
        public int count = 0;
    }


    public final Map<String, Integer> cargoMsgCount = new HashMap<String, Integer>(0);


    public void cargoMsgCountAdd(String key, int count) {

        Integer value = cargoMsgCount.get(key);
        if (value == null) {
            value = 0;
            cargoMsgCount.put(key, value);
        }
        value += count;

        cargoMsgCount.put(key, value);
    }

    public void cargoMsgCountFresh(String key, int count) {


        cargoMsgCount.put(key, count);
    }

    public int cargoMsgCountGet(String key) {
        Integer value = cargoMsgCount.get(key);
        if (value == null) {
            value = 0;
            cargoMsgCount.put(key, 0);
        }
        return value;
    }

    /**
     * 各种消息数
     * Pair<Boolean,Integer>  boolean 表示是否已经加载过了，Integer表示消息的数量
     */
    public static final int COUNTTYPE_BANCHE_ZHAOPIN = 1;
    public static final int COUNTTYPE_BANCHE_QIUZHI = 2;
    public static final int COUNTTYPE_SHEBEI_ZHAOPIN = 3;
    public static final int COUNTTYPE_SHEBEI_QIUZHI = 4;
    public static final int COUNTTYPE_WODEFABU = 5;
    public static final int COUNTTYPE_WODESHANGHU = 6;
    private Map<Integer, TwoValues> countMap = new HashMap<Integer, TwoValues>(0);

    public int getCount(int type) {
        if (countMap.containsKey(type)) {
            return countMap.get(type).count;
        }
        return 0;
    }

    public void setCount(int count, int type) {
        if (count < 0) {
            count = 0;
        }
        TwoValues tv = null;
        if (countMap.containsKey(type)) {
            tv = countMap.get(type);

        } else {
            tv = new TwoValues();
            countMap.put(type, tv);
        }
        tv.count = count;

    }


    public boolean isLoadedCount(int type) {
        TwoValues tv = null;
        if (countMap.containsKey(type)) {
            tv = countMap.get(type);

        } else {
            tv = new TwoValues();
            countMap.put(type, tv);
        }
        return tv.isLoaded;
    }

    public void setLoadedCount(boolean loaded, int type) {
        TwoValues tv = null;
        if (countMap.containsKey(type)) {
            tv = countMap.get(type);

        } else {
            tv = new TwoValues();
            countMap.put(type, tv);
        }
        tv.isLoaded = loaded;
    }


    /**
     * 判断用户是否登录了
     */
    private static boolean isLogin = false;

    public static void setLogin() {
        isLogin = true;
    }

    public static void setLogout() {
        isLogin = false;
    }

    public static boolean isLogin() {
        return isLogin;
    }


    public JSONObject getIpLocation() {
        return ipLocation;
    }

    public void setIpLocation(JSONObject ipLocation) {
        this.ipLocation = ipLocation;
    }

    private JSONObject ipLocation = null;
    /**
     * 板车招聘的资源信息获取完成
     * 已经没用了，永远返回true，找个机会完全去掉
     */
    @Deprecated
    private boolean recruitmentResourceGet = true;
    /*
     * APP设置的相关设置属性值 start
     */
    private boolean receiveMsgHint = true;
    private boolean soundHint = true;
    private boolean vibrateHint = true;
    private boolean searchCargoSoundHint = true;
    private String versionCheck = "";

    private String currentVersionName = "";

    public boolean isReceiveMsgHint() {
        return receiveMsgHint;
    }

    public void setReceiveMsgHint(boolean receiveMsgHint) {
        this.receiveMsgHint = receiveMsgHint;
    }

    public boolean isSoundHint() {
        return soundHint;
    }

    public void setSoundHint(boolean soundHint) {
        this.soundHint = soundHint;
    }

    public boolean isVibrateHint() {
        return vibrateHint;
    }

    public void setVibrateHint(boolean vibrateHint) {
        this.vibrateHint = vibrateHint;
    }

    public boolean isSearchCargoSoundHint() {
        return searchCargoSoundHint;
    }

    public void setSearchCargoSoundHint(boolean searchCargoSoundHint) {
        this.searchCargoSoundHint = searchCargoSoundHint;
    }

    public String getVersionCheck() {
        return versionCheck;
    }

    public void setVersionCheck(String versionCheck) {
        this.versionCheck = versionCheck;
    }

    public String getCurrentVersionName() {
        return currentVersionName;
    }

    public void setCurrentVersionName(String currentVersionName) {
        this.currentVersionName = currentVersionName;
    }

    /**
     * 现在其实没用，如果以后设置信息过多，导致读取过慢，从而需要确认标志时，它也许会起作用
     */
    private boolean isLoadSettingInfoOver = false;

    /**
     * 因为不是太重要，将其在线程中加载一次
     */
    private void loadSettingInfo() {
        new Thread() {
            public void run() {

                PackageManager manager = getPackageManager();
                PackageInfo info = null;
                try {
                    info = manager.getPackageInfo(getPackageName(), 0);
                    currentVersionName = info.versionName;
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }

                SharedPreferences sp = getSharedPreferences(CommonDefine.SETTING, Context.MODE_PRIVATE);
                receiveMsgHint = sp.getBoolean(CommonDefine.SETTING_RECEIVE_MSG_HINT, true);
                soundHint = sp.getBoolean(CommonDefine.SETTING_SOUND_HINT, true);
                vibrateHint = sp.getBoolean(CommonDefine.SETTING_VIBRATE_HINT, true);
                searchCargoSoundHint = sp.getBoolean(CommonDefine.SETTING_SEARCH_CARGO_SOUND_HINT, true);

                versionCheck = sp.getString(CommonDefine.SETTING_VERSION_CHECK, currentVersionName);
                isLoadSettingInfoOver = true;
                ;
            }

            ;
        }.start();
    }

	/*
     * APP设置的相关设置属性值end
	 */

    private int lastSendCargoCount = -1;
    private String cantSendMsg = "";

    public String getCantSendMsg() {
        return cantSendMsg;
    }

    public void setCantSendMsg(String cantSendMsg) {
        this.cantSendMsg = cantSendMsg;
    }

    /**
     * 永远返回100 ,这样就不会起作用了
     *
     * @return
     */
    @Deprecated
    public int getLastSendCargoCount() {
        //   return lastSendCargoCount;
        return 100;//永远返回100 ,这样就不会起作用了
    }

    @Deprecated
    public void setLastSendCargoCount(int lastSendCargoCount) {
        this.lastSendCargoCount = lastSendCargoCount;
    }

    private long applicationCreateTime = 0;
    private long applicationRunTime = 0;

    public static OpApplication getmApp() {
        return mApp;
    }

    private void catchException() {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

            @Override
            public void uncaughtException(Thread arg0, Throwable arg1) {
                applicationRunTime = System.currentTimeMillis() - applicationCreateTime;

                arg1.printStackTrace();

                Intent ii = new Intent(OpApplication.this, LoginActivity.class);
                ii.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(ii);
                cleanActivity();
                android.os.Process.killProcess(android.os.Process.myPid()); // 结束进程之前可以把你程序的注销或者退出代码放在这段代码之前
            }
        });
    }

    /**
     * 个推的服务好像会引起错误并提示，添加这个检验一下
     */
    private void otherAppCatchException() {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

            @Override
            public void uncaughtException(Thread arg0, Throwable arg1) {
                applicationRunTime = System.currentTimeMillis() - applicationCreateTime;
                arg1.printStackTrace();
                android.os.Process.killProcess(android.os.Process.myPid()); // 结束进程之前可以把你程序的注销或者退出代码放在这段代码之前
            }
        });
    }

    private static final String TAG = "OpApplication";
    private ExecutorService mThreadPool;
    private ExecutorService feelThreadPool;
    private PersonInfo mPersonInfo;
    public static Context mContext;
    private Handler mHandler;
    private CommonResources mCommonResources;

    private List<Activity> activitys = new ArrayList<Activity>();
    /**
     * 用户添加的电话号码，可以通过单独的接口获取电话列表
     */
    private ArrayList<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();

    public boolean isPhoneNumberListLoadOver = false;
    /**
     * 收藏信息的列表
     */
    @Deprecated
    private ArrayList<OrderInfo> keepOrders = new ArrayList<OrderInfo>(0);
    @Deprecated
    public boolean needDownloadKeepOrders = true;

    @Deprecated
    public ArrayList<OrderInfo> getKeepOrders() {
        return keepOrders;
    }

    public void setKeepOrders(ArrayList<OrderInfo> keepOrders) {
        this.keepOrders = keepOrders;
    }

    /**
     * 已经查看过的信息的记录
     */
    private Map<Integer, Integer> readRecordMap = new HashMap<Integer, Integer>();

    public Map<Integer, Integer> getReadRecordMap() {
        return readRecordMap;
    }


    public int getCarInfoCount() {
        return carInfoCount;
    }

    public void setCarInfoCount(int carInfoCount) {
        this.carInfoCount = carInfoCount;
    }

    private int carInfoCount = 0;

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    private String getCurrentProcessName(Context context) {
        int pid = android.os.Process.myPid();
        ActivityManager mActivityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : mActivityManager.getRunningAppProcesses()) {
            if (appProcess.pid == pid) {
                return appProcess.processName;
            }
        }
        return "";
    }


    @Override
    public void onCreate() {
        super.onCreate();
        /**
         * umeng分享配置
         */
        UMShareAPI.get(this);
        Config.DEBUG = true;
        // if (!Debug.isDebuggerConnected()) {
        // // ACRA.init(this);
        // }
        String defaultProcessName = "com.tianniu.up.testprogect";// 默认的进程名，也就是主程序的进程名。  //TODO  注意注意注意注意注意注意注意注意注意注意注意注意注意
        String currentProcessName = getCurrentProcessName(this);
        if (!defaultProcessName.equals(currentProcessName)) {// 如果不是当前的主进程，那么直接返回，因为后面的代码对于其他进程来说完全没用
            otherAppCatchException();//拦截其他进程的崩溃
            return;
        }
        loadSettingInfo();

        applicationCreateTime = System.currentTimeMillis();
        if (BuildConfig.CATCHEXCEPTION) {
            catchException();
        }
        super.onCreate();
        mApp = this;
        mContext = getApplicationContext();
        PackageManager manager = getPackageManager();
        PackageInfo info = null;
        try {
            info = manager.getPackageInfo(this.getPackageName(), 0);
            CommonDefine.CLIENT_VERSION = info.versionCode + "";
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

    }

    public Handler getmHandler() {
        return mHandler;
    }

    public void clearTicket() {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(CommonDefine.SETTING, MODE_PRIVATE);
        sharedPreferences.edit().remove(CommonDefine.USER_ID).remove(CommonDefine.TICKET).commit();
        removePersonInfo();
    }

    public void setmHandler(Handler mHandler) {
        this.mHandler = mHandler;
    }

    public void cleanActivity() {
        // clearTicket();
        Iterator<Activity> it = activitys.iterator();
        while (it.hasNext()) {
            Activity at = it.next();
            at.finish();
            it.remove();
        }

    }


    /**
     * TODO 注意所有全局的变量都要在这里初始化
     * 每当程序退出或重新进入时，都调用这个方法，重新
     */
    public void resetApplicationConfigInfo() {
        cargoWindowMsgMaxId.clear();
        windowShowList.clear();
        cargoMsgCount.clear();
        countMap.clear();
        //   recruitmentResourceGet = false;
        lastSendCargoCount = -1;
        needDownloadKeepOrders = true;
        isPhoneNumberListLoadOver = false;
        phoneNumbers.clear();
        keepOrders.clear();
        readRecordMap.clear();
        clearIdentityList();
    }

    public Activity getCurrentTopActivity() {
        if (activitys.size() > 0) {
            return activitys.get(activitys.size() - 1);
        }

        return null;
    }

    public List<Activity> getMyActivitys() {
        return activitys;
    }


    public void addActivity(Activity activity) {
        if (!this.activitys.contains(activity)) {
            this.activitys.add(activity);
        }
    }

    public boolean noActivityStarted() {
        if (activitys.size() == 0) {
            return true;
        }
        return false;
    }

    public void removeActivity(Activity activity) {
        this.activitys.remove(activity);
    }

    public OpApplication() {

        mThreadPool = Executors.newFixedThreadPool(CommonDefine.NUMBER_FOR_BACKGROUND_THREAD);
        feelThreadPool = Executors.newCachedThreadPool();
    }

    public void doInFreeThread(Runnable task) {
        feelThreadPool.submit(task);
    }

    public void doInThread(Runnable task) {
        mThreadPool.submit(task);
    }

    public PersonInfo getPersonInfo() {
        return mPersonInfo;
    }

    public boolean hasPersonInfoEmpty() {
        if (mPersonInfo == null) {
            return true;
        }

        if (mPersonInfo.getId() > 0) {
            return false;
        }

        return true;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        mPersonInfo = personInfo;
    }

    public CommonResources getCommonResources() {
        if (mCommonResources == null) {
            return new CommonResources();
        }
        return mCommonResources;
    }

    public void setCommonResources(CommonResources mCommonResources) {
        this.mCommonResources = mCommonResources;
    }

    public void removePersonInfo() {
        mPersonInfo = null;
    }

    @Deprecated
    public void onAppReStoreInstanceState(Bundle outState) {

        if (mPersonInfo == null) {
            PersonInfo info = (PersonInfo) outState.getSerializable("mPersonInfo");

            if (info != null) {

                mPersonInfo = info;
            }
        }

        if (mCommonResources == null) {
            CommonResources url = (CommonResources) outState.getSerializable("mPublicUrl");
            if (url != null) {
                mCommonResources = url;
            }
        }

        if (phoneNumbers.size() == 0) {
            ArrayList<PhoneNumber> list = (ArrayList<PhoneNumber>) outState.getSerializable("phoneNumbers");
            if (list != null) {
                phoneNumbers.addAll(list);
            }
        }

    }

    @Deprecated
    public void onAppSaveInstanceState(Bundle outState) {

        if (mPersonInfo != null) {
            outState.putSerializable("mPersonInfo", mPersonInfo);
        }

        if (mCommonResources != null) {
            outState.putSerializable("mPublicUrl", mCommonResources);
        }

        if (phoneNumbers.size() > 0) {
            outState.putSerializable("phoneNumbers", phoneNumbers);
        }
    }

    /**
     * 这是一个全局的观察者，以后所有需要观察的逻辑都在这个地方写 所有的内部数据，理论上在页面销毁或退出时必须 =null其内部数据，否则会造成内存泄露
     * 针对每个模块单独的建立类
     *
     * @author ruan
     */
    public static class GlobalObserver {

        private GlobalObserver() {

        }

        private static GlobalObserver instance;

        public static synchronized GlobalObserver getObserver() {

            if (instance == null) {
                instance = new GlobalObserver();
            }

            return instance;
        }

        /**
         * 发货联系电话的观察者
         */
        public SavePhoneNumberObserver savePhoneNumberObserver;

        /**
         * 接收推送消息观察者
         */
        public NewMessageObserver newMessageObserver;

        /**
         * 用户发货模块，保存上次的发货电话的观察着。有可能在电话管理页面，将电话删除了
         *
         * @author ruan
         */
        public static class SavePhoneNumberObserver {

            private String tel;
            private String tel3;
            private String tel4;

            public String getTel() {
                return tel;
            }

            public String getTel3() {
                return tel3;
            }

            public String getTel4() {
                return tel4;
            }

            private SavePhoneNumberObserverListener listener;

            private boolean isDeletedPhoneNumber = false;

            public SavePhoneNumberObserver(String tel, String tel3, String tel4) {
                this.tel = tel;
                this.tel3 = tel3;
                this.tel4 = tel4;
            }

            public void reSetPhoneNumber(String tel, String tel3, String tel4) {
                this.tel = tel;
                this.tel3 = tel3;
                this.tel4 = tel4;
            }

            public void register(SavePhoneNumberObserverListener listener) {
                this.listener = listener;

                if (isDeletedPhoneNumber) {
                    isDeletedPhoneNumber = false;
                    fireListener();
                }

                // listener=null;
            }

            public void unregister() {
                this.listener = null;
            }

            public void fireListener() {
                if (listener != null) {

                    listener.onChange(this);
                }
                // l
            }

            public void deleteNumber(Context context, String number, String persionid) {
                isDeletedPhoneNumber = true;
                if (!TextUtils.isEmpty(tel) && tel.equals(number)) {

                    tel = "";
                } else if (!TextUtils.isEmpty(tel3) && tel3.equals(number)) {
                    tel3 = "";

                } else if (!TextUtils.isEmpty(tel4) && tel4.equals(number)) {

                    tel3 = "";
                }
                fireListener();// 调用监听
                if (isDeletedPhoneNumber) {// 如果判断到电话号码改变了，那么修改sharep
                    final SharedPreferences sp = context.getSharedPreferences(CommonDefine.SAVESENDTELMAP + persionid, Context.MODE_PRIVATE);

                    new Thread() {
                        public void run() {
                            sp.edit().putString(CommonDefine.SAVESENDTELMAP_TEL, tel).putString(CommonDefine.SAVESENDTELMAP_TEL3, tel3).putString(CommonDefine.SAVESENDTELMAP_TEL4, tel4).commit();
                        }

                        ;

                    }.start();
                }

                context = null;// 稍微优化一下，可能没什么用，但是还是写一下吧

            }

            public static interface SavePhoneNumberObserverListener {
                public void onChange(SavePhoneNumberObserver observer);
            }

        }

        /**
         * 监听推送消息的监视者。 现在的用途是，监听到小红点消息，去请求消息数，如果消息数大于0，显示小红点
         */
        public static class NewMessageObserver {

            private boolean hasNewMessage = false;

            /**
             * 当有新消息是单纯的将其设置为true
             */
            public void receiveNewMessage() {
                hasNewMessage = true;
                fireListener();
            }

            private NewMessageObserverListener listener;

            public void register(NewMessageObserverListener listener) {
                this.listener = listener;

                if (hasNewMessage) {
                    hasNewMessage = false;
                    fireListener();
                }

                // listener=null;
            }

            public void unregister() {
                if (listener != null) this.listener = null;
            }

            private void fireListener() {
                if (listener != null) {

                    listener.onChange();
                    hasNewMessage = false;
                }
                // l
            }

            /**
             * 这个接口的调用时机。当页面停留在主页面并且我的界面加载过一次之后，当有新消息时触发。
             * 如果切换到别的页面，或者切换回桌面，那么不会调用
             * 。但是如果切换期间，收到了新消息。那么当返回到主界面且我的界面加载过时，调用此接口，将调用此接口
             *
             * @author ruan
             */
            public static interface NewMessageObserverListener {
                public void onChange();
            }
        }

    }




}
