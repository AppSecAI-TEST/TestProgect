package com.tianniu.custom;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tianniu.custom.api.UserApi;
import com.tianniu.custom.core.CommonDefine;
import com.tianniu.custom.core.JsonTag;
import com.tianniu.custom.model.QueryInfo;
import com.tianniu.custom.utils.Bean2Map;
import com.tianniu.custom.utils.CommonUtil;
import com.tianniu.custom.utils.SignUtil;

import org.json.JSONObject;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import me.andydev.retrofit.lifecycle.RetrofitLifecycle;
import retrofit2.Call;

/**
 * Created by Administrator on 2017/6/7 0007.
 */

public class HttpManager {

    private static HttpManager HttpManager;

    private HttpManager() {
    }
    public static HttpManager getInstance(){
        if (HttpManager == null){
            HttpManager =  new HttpManager();
        }
        return HttpManager;
    }


    private static final Map<Class, Object> sInterfaceImplementCache = new ConcurrentHashMap<>();

    public <T> T get(Class<T> apiInterface) {
        T apiImplement;
        Object cacheApiImplement = sInterfaceImplementCache.get(apiInterface);
        if (cacheApiImplement != null) {
            apiImplement = apiInterface.cast(cacheApiImplement);
        } else {
            apiImplement = RetrofitService.getRetrofit().create(apiInterface);
            sInterfaceImplementCache.put(apiInterface, apiImplement);
        }

        return RetrofitLifecycle.getProxyInterface(apiInterface, apiImplement);

    }

    public static void cancel(Object retrofitAPI, Call... excludes) {
        RetrofitLifecycle.cancelAll(retrofitAPI, excludes);
    }


    /**
     * 通用参数
     * @return
     */
    protected TreeMap<String, String> initCustomParamsMap() {
        TreeMap<String, String> tree = new TreeMap<String, String>();
        tree.put("Accept", "application/json");
        tree.put("Content-Type", "application/json; charset=UTF-8");
        tree.put(JsonTag.CLIENT_SIGN, CommonDefine.CLENT_SIGN);
        tree.put(JsonTag.OS_VERSION, CommonDefine.OS_VERSION);
        tree.put(JsonTag.CLIENT_ID, CommonDefine.CLIENT_ID);
        tree.put(JsonTag.CLIENT_VERSION, CommonDefine.CLIENT_VERSION);
        tree.put(JsonTag.PHONE_TYPE,CommonDefine.PHONE_TYPE);
        return tree;
    }

    protected TreeMap<String, String> convertToTreeMap(QueryInfo query){
        Gson g=new Gson();
        String jsonString= g.toJson(query).toString();
        TreeMap<String, String> result= g.fromJson(jsonString,new TypeToken<TreeMap<String, String>>(){}.getType());
        return result;
    }



    /**
     * 登录 v
     */
    public TreeMap<String, String> login(String cellPhone, String password) {
        TreeMap<String, String> treeMap = initCustomParamsMap();
        treeMap.put(JsonTag.CELLPHONE, cellPhone);
        treeMap.put(JsonTag.CHANNEL_CODE,"991"); //TODO 测试数据
        treeMap.put(JsonTag.CID, "94d4de5bce31a9ce4554df971755d85e"); //测试数据
        treeMap.put(JsonTag.PASSWORD, CommonUtil.MD5(CommonUtil.MD5(password) + cellPhone));
        treeMap.put(JsonTag.SIGN, initSign(treeMap));
        return treeMap;
    }


    /**
     * 搜索 v
     */
    public TreeMap<String, String> searchCargo(QueryInfo queryInfo) {
        TreeMap<String, String> treeMap = initCustomParamsMap();
        treeMap = Bean2Map.getInstance().bean2Map(queryInfo, treeMap);
        treeMap.put(JsonTag.SIGN, initSign(treeMap));
        return treeMap;
    }

    /**
     *
     * @param channelCode
     * @param cid
     * @param cellPhone
     * @param password
     * @param userId
     * @param ticket
     * @return
     */
    protected TreeMap<String, String> initRequestMap(String channelCode, String cid, String cellPhone, String password, String userId, String ticket) {

        TreeMap<String, String> tree = new TreeMap<String, String>();
        tree.put("Accept", "application/json");
        tree.put("Content-Type", "application/json; charset=UTF-8");
        tree.put(JsonTag.CHANNEL_CODE,channelCode);
        tree.put(JsonTag.CLIENT_SIGN, CommonDefine.CLENT_SIGN);
        tree.put(JsonTag.OS_VERSION, CommonDefine.OS_VERSION);
        tree.put(JsonTag.CLIENT_VERSION, CommonDefine.CLIENT_VERSION);
        tree.put(JsonTag.CLIENT_ID, CommonDefine.CLIENT_ID);
        if (cellPhone !=null && password !=null) {
            tree.put(JsonTag.CELLPHONE, cellPhone);
            tree.put(JsonTag.PASSWORD, CommonUtil.MD5(CommonUtil.MD5(password) + cellPhone));
        }
        if (userId !=null &&ticket !=null){
            tree.put(JsonTag.USER_ID, userId);
            tree.put(JsonTag.TICKET, ticket);
        }
        if (cid != null)
            tree.put(JsonTag.CID, cid);

        tree.put(JsonTag.PHONE_TYPE,CommonDefine.PHONE_TYPE);

        tree.put(JsonTag.SIGN, initSign(tree));

        return tree;
    }



    protected String initSign(TreeMap<String, String> map) {
        return SignUtil.sign(map, CommonDefine.PRIVATEKEY);
    }




    protected TreeMap<String, String> initChannelRequestMap(String channelCode,String cid, String cellPhone, String password,String userId,String ticket) {

        TreeMap<String, String> tree = new TreeMap<String, String>();
        tree.put(JsonTag.CLIENT_SIGN, CommonDefine.CLENT_SIGN);
        tree.put(JsonTag.OS_VERSION, CommonDefine.OS_VERSION);
        tree.put(JsonTag.CLIENT_VERSION, CommonDefine.CLIENT_VERSION);
        tree.put(JsonTag.CLIENT_ID, CommonDefine.CLIENT_ID);



        if (!TextUtils.isEmpty(cellPhone) && !TextUtils.isEmpty(password)) {
            tree.put(JsonTag.CELLPHONE, cellPhone);
            tree.put(JsonTag.PASSWORD, CommonUtil.MD5(CommonUtil.MD5(password) + cellPhone));
        }
        if (!TextUtils.isEmpty(userId) &&!TextUtils.isEmpty(userId)){
            tree.put(JsonTag.USER_ID, userId);
            tree.put(JsonTag.TICKET, ticket);
        }
        if (!TextUtils.isEmpty(cid))
            tree.put(JsonTag.CID, cid);

        tree.put(JsonTag.PHONE_TYPE,CommonDefine.PHONE_TYPE);
        tree.put(JsonTag.CHANNEL_CODE,channelCode);
        tree.put(JsonTag.SIGN, initSign(tree));
        return tree;
    }



    public Map<String,String> getTree(){

        TreeMap<String, String> tree = new TreeMap<String, String>();
        tree.put("Accept", "application/json");
        tree.put("Content-Type", "application/json; charset=UTF-8");

        tree.put(JsonTag.CELLPHONE, "13641330091");
        tree.put(JsonTag.CHANNEL_CODE,"991");
        tree.put(JsonTag.CID, "94d4de5bce31a9ce4554df971755d85e");
        tree.put(JsonTag.CLIENT_ID, "ffffffff-9ac7-2775-9559-3f580033c587");
        tree.put(JsonTag.CLIENT_SIGN, CommonDefine.CLENT_SIGN);
        tree.put(JsonTag.CLIENT_VERSION, CommonDefine.CLIENT_VERSION);
        tree.put(JsonTag.OS_VERSION, CommonDefine.OS_VERSION);
        tree.put(JsonTag.PASSWORD, CommonUtil.MD5(CommonUtil.MD5("111111") + "13641330091"));
        tree.put(JsonTag.PHONE_TYPE,CommonDefine.PHONE_TYPE);
        tree.put(JsonTag.SIGN, initSign(tree));
        return tree;
    }

    private UserApi userApi;
    public void test(){

        userApi = get(UserApi.class);
        UserApi proxyInterface = RetrofitLifecycle.getProxyInterface(UserApi.class, userApi);



        TreeMap<String, String> tree = new TreeMap<String, String>();
        tree.put("Accept", "application/json");
        tree.put("Content-Type", "application/json; charset=UTF-8");

        tree.put(JsonTag.CELLPHONE, "13641330091");
        tree.put(JsonTag.CHANNEL_CODE,"991");
        tree.put(JsonTag.CID, "94d4de5bce31a9ce4554df971755d85e");
        tree.put(JsonTag.CLIENT_ID, "ffffffff-9ac7-2775-9559-3f580033c587");
        tree.put(JsonTag.CLIENT_SIGN, CommonDefine.CLENT_SIGN);
        tree.put(JsonTag.CLIENT_VERSION, CommonDefine.CLIENT_VERSION);
        tree.put(JsonTag.OS_VERSION, CommonDefine.OS_VERSION);
        tree.put(JsonTag.PASSWORD, CommonUtil.MD5(CommonUtil.MD5("111111") + "13641330091"));
        tree.put(JsonTag.PHONE_TYPE,CommonDefine.PHONE_TYPE);
        tree.put(JsonTag.SIGN, initSign(tree));




        RetrofitLifecycle.cancelAll(proxyInterface);

    }



//    public class UserApiInvokeProxy implements UserApi{
//
//        private UserApi mInterfaceImpl;
//
//        private List<Call> mCallList = Collections.synchronizedList(new ArrayList<Call>());
//
//        public UserApiInvokeProxy(UserApi mInterfaceImplByRetrofit) {
//            this.mInterfaceImpl = mInterfaceImplByRetrofit;
//        }
//
//        @Override
//        public Call<JsonObject> login(@FieldMap Map<String, String> logMap) {
//            Call<JsonObject> login = mInterfaceImpl.login(logMap);
//            mCallList.add(login);
//            return login;
//        }
//
//        public void cancelAll(Call... excludes){
//            if (excludes.length >  0 ){
//                mCallList.removeAll(Arrays.asList(excludes));
//            }
//            if (mCallList != null){
//
//            }
//        }
//    }
}
