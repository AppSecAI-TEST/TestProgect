package com.tianniu.custom.api;

import com.tianniu.custom.HttpResponse;
import com.tianniu.custom.model.OrderInfo;

import java.util.List;
import java.util.Map;

import me.andydev.retrofit.lifecycle.common.RetrofitInterface;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by liulong on 2017/8/9.
 */

@RetrofitInterface
public interface CargoApi {

    @FormUrlEncoded
    @POST("transport/search/")
    Call<HttpResponse<List<OrderInfo>>> searchCargo(@FieldMap Map<String,String> searchMap);
}
