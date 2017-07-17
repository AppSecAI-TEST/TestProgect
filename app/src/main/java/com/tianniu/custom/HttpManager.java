package com.tianniu.custom;

import android.text.TextUtils;

import com.google.gson.JsonObject;
import com.tianniu.custom.core.CommonDefine;
import com.tianniu.custom.core.JsonTag;
import com.tianniu.custom.utils.CommonUtil;
import com.tianniu.custom.utils.SignUtil;

import org.json.JSONObject;

import java.util.Map;
import java.util.TreeMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2017/6/7 0007.
 */

public class HttpManager {

    private static HttpManager httpManager;
    private Retrofit retrofit;

    private HttpManager() {
    }
    public static HttpManager getInstance(){
        if (httpManager == null){
            return new HttpManager();
        }
        return httpManager;
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

    public void test(){
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(CommonDefine.URL_BASE);
        builder.addConverterFactory(GsonConverterFactory.create());
        retrofit = builder.build();
        test test = retrofit.create(test.class);

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


        Call<JsonObject> login = test.login(tree);
        login.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                String s = response.toString();
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                String message = t.getMessage();
            }
        });
    }

    public interface test{
        @FormUrlEncoded
        @POST("user/login/")
        Call<JsonObject> login(@FieldMap Map<String,String> logMap);
    }
}
