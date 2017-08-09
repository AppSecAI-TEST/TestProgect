package com.tianniu.custom.api;

import com.tianniu.custom.HttpResponse;
import com.tianniu.custom.model.PersonInfo;

import java.util.Map;

import me.andydev.retrofit.lifecycle.common.RetrofitInterface;
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
    Call<HttpResponse<PersonInfo>> login(@FieldMap Map<String,String> logMap);


}