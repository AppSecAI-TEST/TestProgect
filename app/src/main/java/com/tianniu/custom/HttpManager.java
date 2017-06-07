package com.tianniu.custom;

import com.tianniu.custom.core.CommonDefine;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2017/6/7 0007.
 */

public class HttpManager {

    private HttpManager httpManager;
    private Retrofit retrofit;

    private HttpManager() {
    }
    public HttpManager getInstance(){
        if (httpManager == null){
            return new HttpManager();
        }
        return httpManager;
    }

    private void test(){
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(CommonDefine.URL_BASE);
        builder.addConverterFactory(GsonConverterFactory.create());
        retrofit = builder.build();
        test test = retrofit.create(test.class);
        Call<ResponseBody> login = test.login(1);
        login.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    public interface test{
        @HTTP(method = "POST",path = "blog/{id}",hasBody = true)
        Call<ResponseBody> login(@Path("id") int id);
    }
}
