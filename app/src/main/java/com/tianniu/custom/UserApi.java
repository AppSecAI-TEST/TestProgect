package com.tianniu.custom;

import com.google.gson.JsonObject;

import java.util.Map;

import me.andydev.retrofit.lifecycle.common.RetrofitInterface;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2017/7/17 0017.
 */


@RetrofitInterface
public interface UserApi{
    @FormUrlEncoded
    @POST("user/login/")
    Call<HttpResponse<LoginResult>> login(@FieldMap Map<String,String> logMap);


}